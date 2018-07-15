def sendEmailNotification(subj, recepients) {
    emailext body: "${BUILD_URL}",
    recipientProviders: [
      [$class: 'CulpritsRecipientProvider'],
      [$class: 'DevelopersRecipientProvider'],
      [$class: 'RequesterRecipientProvider']
    ],
    subject: subj,
    to: "${recepients}"
}
def printTopic(topic) {
  println("[*] ${topic} ".padRight(80, '-'))
}

node {
  //
  def pullRequest = false
  def commitSha = ''
  def buildBranch = ''
  def pullId = ''
  def lastCommitAuthorEmail = ''
  def repo = ''
  def org = ''
  //
  stage('Clone sources') {
    //
    def scmVars = checkout scm
    printTopic('Job input parameters');
    println(params)
    printTopic('SCM variables')
    println(scmVars)
    //
    commitSha = scmVars.GIT_COMMIT
    buildBranch = scmVars.GIT_BRANCH
    if (buildBranch.contains('PR-')) {
      pullRequest = true
      pullId = CHANGE_ID
    } else if (params.containsKey('sha1')){
      pullRequest = true
      pullId = ghprbPullId
    } else {
    }
    //
    printTopic('Configs')
    sh 'envsubst < .env.template > .env';
    sh 'envsubst < sonar-project.properties.template > sonar-project.properties';
    sh 'cat ./.env'
    sh 'cat ./sonar-project.properties'
    //
    printTopic('Build info')
    echo "[PR:${pullRequest}] [BRANCH:${scmVars.GIT_BRANCH}] [COMMIT: ${scmVars.GIT_COMMIT}]"
    printTopic('Environment variables')
    echo sh(returnStdout: true, script: 'env')
    //
    repo = sh(returnStdout: true, script:'''git config --get remote.origin.url | rev | awk -F'[./:]' '{print $2}' | rev''').trim()
    org = sh(returnStdout: true, script:'''git config --get remote.origin.url | rev | awk -F'[./:]' '{print $3}' | rev''').trim()
    //
    printTopic('Repo parameters')
    echo "[org:${org}] [repo:${repo}]"
    //
    lastCommitAuthorEmail = sh(returnStdout: true, script:'''git log --format="%ae" HEAD^!''').trim()
    if (!pullRequest){
      lastCommitAuthorEmail = sh(returnStdout: true, script:'''git log -2 --format="%ae" | paste -s -d ",\n"''').trim()
    }
    printTopic('Author(s)')
    echo "[lastCommitAuthorEmail:${lastCommitAuthorEmail}]"
  }
  stage('Build') {
    sh './build.sh';
  }
  stage('Test') {
    sh './test.sh';
  }
  stage('SonarQube analysis') {
    //
    def scannerHome = tool 'SonarQube Scanner';
    withSonarQubeEnv('SonarQube') {
      if (pullRequest){
        sh "${scannerHome}/bin/sonar-scanner -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=${pullId} -Dsonar.github.repository=${org}/${repo} -Dsonar.github.oauth=${GITHUB_ACCESS_TOKEN} -Dsonar.login=${SONARQUBE_ACCESS_TOKEN}"
      } else {
        sh "${scannerHome}/bin/sonar-scanner"
        // check SonarQube Quality Gates
        //// Pipeline Utility Steps
        def props = readProperties  file: '.scannerwork/report-task.txt'
        echo "properties=${props}"
        def sonarServerUrl=props['serverUrl']
        def ceTaskUrl= props['ceTaskUrl']
        def ceTask
        //// HTTP Request Plugin
        timeout(time: 1, unit: 'MINUTES') {
        waitUntil {
          def response = httpRequest "${ceTaskUrl}"
          println('Status: '+response.status)
          println('Response: '+response.content)
          ceTask = readJSON text: response.content
          return (response.status == 200) && ("SUCCESS".equals(ceTask['task']['status']))
        }
        //
        def qgResponse = httpRequest sonarServerUrl + "/api/qualitygates/project_status?analysisId=" + ceTask['task']['analysisId']
        def qualitygate = readJSON text: qgResponse.content
        echo qualitygate.toString()
          if ("ERROR".equals(qualitygate["projectStatus"]["status"])) {
            currentBuild.description = "Quality Gate failure"
            //sendEmailNotification(currentBuild.description, lastCommitAuthorEmail)
            currentBuild.result = 'UNSTABLE'
            //error currentBuild.description
          }
        }
      }
    }
  }
  stage('Package') {
  }
  stage('Upload') {
  }
}