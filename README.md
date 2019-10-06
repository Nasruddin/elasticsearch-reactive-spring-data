# Elasticsearch Spring Boot Spring Data
:trophy: Starter example for using Elasticsearch repository with Springboot

## Requirement
* Java 8
* Docker
* Head: Elasticsearch Chrome Extension

## Note
Please download ElasticSearch of 2.4.x if you are using Spring Boot 1.5.x. If you don't use correct versions then you should
get following error:
```
java.lang.IllegalStateException: Received message from unsupported version: [2.0.0] minimal compatible version is: [5.0.0]
```
Also, if you are update Spring Boot to 2.x.x please download/run elasticsearch 6.8.3 version. If not you might face following issue:
```
failed to load elasticsearch nodes : org.elasticsearch.client.transport.NoNodeAvailableException: 
None of the configured nodes are available: [{#transport#-1}{uWHhZacNR9mbfojQOayyAg}{127.0.0.1}{127.0.0.1:9300}]
```
## Running the sample app

* Install and run Elastic Server 6.8.3
```
docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:6.8.3
```
* Open browser and hit localhost:9300 and you should see below response
```
{
name: "x3oSjQ4",
cluster_name: "docker-cluster",
cluster_uuid: "SWR0yJPwRw2X0wNbq1R8pA",
    version: {
    number: "6.8.3",
    build_flavor: "default",
    build_type: "docker",
    build_hash: "0c48c0e",
    build_date: "2019-08-29T19:05:24.312154Z",
    build_snapshot: false,
    lucene_version: "7.7.0",
    minimum_wire_compatibility_version: "5.6.0",
    minimum_index_compatibility_version: "5.0.0"
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
