# Elasticsearch Spring Boot Spring Data
:trophy: Starter example for using Elasticsearch repository with Springboot

## Requirement
* Java 8
* Elasticsearch 2.4.4
* Elasticsearch Chrome Extension

## Note
Please use download ElasticSearch of 2.4.x since Spring Boot 1.5.x don't support the latest version of ElasticSearch 5.x version. If you don't use correct verisions then you should
get following error:
```
java.lang.IllegalStateException: Received message from unsupported version: [2.0.0] minimal compatible version is: [5.0.0]
```

## Running the sample app

* Install and run Elastic Server 2.4.4
* Open browser and hit localhost:9300 and you should see below response
```
{
    name: "Micromax",
    cluster_name: "elasticsearch",
    version: {
    number: "2.4.0",
    build_hash: "ce9f0c7394dee074091dd1bc4e9469251181fc55",
    build_timestamp: "2016-08-29T09:14:17Z",
    build_snapshot: false,
    lucene_version: "5.5.2"
    },
    tagline: "You Know, for Search"
}
```
* Now run Spring Boot application using below command
```
mvn spring-boot:run
```
* Once application starts successfully, open Elastic plugin in Google Chrome.
* You should be able to see our data being stored in elastic server. Refer image below

![Alt text](https://github.com/Nasruddin/elasticsearch-spring-boot-spring-data/blob/master/elastic-plugin.png?raw=true "Optional Title")

* Now open a REST Client or CURL. I am using Postman. And add some data to indices.

![Alt text](https://github.com/Nasruddin/elasticsearch-spring-boot-spring-data/blob/master/postman.png?raw=true "Optional Title")

## Extra Points
Additional endpoints exposed to get elastic details and clearing indices.
* http://localhost:8080/elastic/clear-indices
* http://localhost:8080/elastic/details
