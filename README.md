# attlas-scraper
Collect information about vacancies from public sources

## Start
* create local dev .env file, copying **.env.template** to **.env file**
* execute **./build.sh** to build demon service
* execute **./up.sh -d** to start service
* execure **./down.sh** to stop service & remove all images

## Dev environment
* apt-get -y install php-curl php-mbstring php7.0-mbstring php-gettext
### Tor server
* docker run -it -p 8118:8118 -p 9050:9050 -d dperson/torproxy
* docker run -it -p 9050:9050 -d dperson/torproxy

## End points
```
curl -X POST http://localhost/docs/vacancies/dou.ua
curl -X POST http://localhost/docs/vacancies/dou.ua/20171216
```
