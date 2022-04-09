# Elasticsearch Engine
:trophy: Sample Elasticsearch engine using Reactive Spring Data.

## Feature
* Read CSV and persist data in your elasticsearch cluster
* Add, search and filter data
* Basic operation to play around with elastic cluster
* Application fully reactive and non blocking

### For High Level REST Client refer this repository ### : https://github.com/Nasruddin/spring-elasticsearch-rest-high-level-client

## Requirement
* Java 8+ 
* Docker Compose
* ElasticVue: Elasticsearch Firefox Extension

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
cd docker 
docker compose -f docker-compose-elastic.yml up
```
* Build the project and create an Image out of it
```
mvn clean install
docker compose up
```
* Open browser and hit localhost:9200 and you should see below response
```
{
    name: "elasticsearch",
    cluster_name: "docker-cluster",
    cluster_uuid: "49K60TXkQ0CW7utAmS8RFg",
    version: {
        number: "7.12.1",
        build_flavor: "default",
        build_type: "docker",
        build_hash: "3186837139b9c6b6d23c3200870651f10d3343b7",
        build_date: "2021-04-20T20:56:39.040728659Z",
        build_snapshot: false,
        lucene_version: "8.8.0",
        minimum_wire_compatibility_version: "6.8.0",
        minimum_index_compatibility_version: "6.0.0-beta1"
    },
    tagline: "You Know, for Search"
}
```

* You can access cluster info using curl cmd in your terminal
```
curl localhost:8888/elastic-cluster/info
```

* Below output should be seen post your curl cmd

  ![Alt text](https://github.com/Nasruddin/elasticsearch-spring-boot-spring-data/blob/master/instruction/index-info.png?raw=true "Optional Title")



* Once elasticsearch server and application starts successfully, open swagger UI using http://localhost:8888/swagger-ui/index.html



  ![Alt text](https://github.com/Nasruddin/elasticsearch-spring-boot-spring-data/blob/master/instruction/swagger.png?raw=true "Optional Title")

* Execute /movie/generate under movie-resource to populate your elasticsearch engine. As soon as you execute the resource; you should be able to see data in GUI for elasticsearch, in my ElasticVue for firefox. 
Refer below image:

![Alt text](https://github.com/Nasruddin/elasticsearch-spring-boot-spring-data/blob/master/instruction/data.png?raw=true "Optional Title")

* Now you should have enough data to play around with. Also, you can persist you own data.


## Extra Points
Additional endpoints exposed to get elastic details and clearing indices.
* http://localhost:8888/elastic-cluster/clear-indices
* http://localhost:8888/elastic-cluster/info

### WIP 
* More APIs to be added
* Test containers 
