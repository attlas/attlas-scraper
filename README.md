# Attlas scraper
Collect information about vacancies from public sources

## Start
* create local dev .env file, copying **.env.template** to **.env file**
```
COMPOSE_PROJECT_NAME=attlas_scraper
PROJECT_VERSION=18.6.0-SNAPSHOT

# scraper api
SERVICE_API_KEY=com.attlas.scraper.api
SERVICE_API_HOST=localhost
SERVICE_API_LSTN=0.0.0.0
SERVICE_API_PORT=8080
SERVICE_API_PORTS=8443

# tor
SERVICE_TOR_KEY=com.attlas.scraper.tor
SERVICE_TOR_HOST=tor
SERVICE_TOR_SOCKS_PORT=905
```
* execute **./build.sh** to build api service
* execute **./up.sh -d** to start service
* execure **./down.sh** to stop service & remove all images
