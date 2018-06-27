## Attlas scraper

### Development environment
* copy **.env.template** to **.env**
* fill **.env** with actual parameters
```
COMPONENT_NAME=attlas-scraper
COMPONENT_KEY=attlas-scraper
COMPONENT_VERSION=18.6.0-SNAPSHOT

COMPONENT_PARAM_HOST=localhost
COMPONENT_PARAM_LSTN=0.0.0.0
COMPONENT_PARAM_PORT=8080
COMPONENT_PARAM_PORTS=8443
```
* **exec.sh** will build and launch service
* **docker.build.sh -> docker.run.sh -> docker.stop.sh** will run service inside docker container
