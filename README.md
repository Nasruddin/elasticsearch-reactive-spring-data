# Elasticsearch Engine
:trophy: Sample Elasticsearch engine using Reactive Spring Data.

## Feature
* Read CSV and persist data in your elasticsearch cluster
* Add, search and filter data
* Basic operation to play around with elastic cluster
* Application fully reactive and non blocking

### For High Level REST Client; please refer [this repository - Elasticsearch High Level Client](https://github.com/Nasruddin/spring-elasticsearch-rest-high-level-client)

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
Also, if you update Spring Boot to 2.x.x please download/run elasticsearch 6.8.3 version. If not you might face following issue:
```
failed to load elasticsearch nodes : org.elasticsearch.client.transport.NoNodeAvailableException: 
None of the configured nodes are available: [{#transport#-1}{uWHhZacNR9mbfojQOayyAg}{127.0.0.1}{127.0.0.1:9300}]
```

###### Be careful! If you are migrating to elasticsearch to 8.5.0 or higher version. You will run into different kind of issue. Make sure you 
migrate first to elastic 7.17.0 and then elastic 8.5.0 [Official Documentation](https://www.elastic.co/guide/en/elasticsearch/reference/current/setup-upgrade.html)

## Running the application using docker-compose

* Make the run.bash file executable for the current user
```
chmod u+x run.bash
```

* Run/start the application using run.bash
```
./run.bash start
```

## Running the application outside docker

* Install and run Elasticsearch Server 8.5.0

Refer the official [link](https://www.elastic.co/guide/en/elasticsearch/reference/current/install-elasticsearch.html) to download and install elastic stack on your machine.

* You can also use docker-compose to install elasticsearch,
```
cd docker 
docker compose -f docker-compose-elastic.yml up
```
* Build the project and create an Image out of it
```
mvn spring-boot:run
```

* Open browser and hit localhost:9200, and you should see below response
```
{
    name: "elasticsearch",
    cluster_name: "docker-cluster",
    cluster_uuid: "3yvjtNl7TaWuSMK7qWB79g",
    version: {
    number: "8.5.0",
    build_flavor: "default",
    build_type: "docker",
    build_hash: "c94b4700cda13820dad5aa74fae6db185ca5c304",
    build_date: "2022-10-24T16:54:16.433628434Z",
    build_snapshot: false,
    lucene_version: "9.4.1",
    minimum_wire_compatibility_version: "7.17.0",
    minimum_index_compatibility_version: "7.0.0"
    },
    tagline: "You Know, for Search"
}
```


* Once elasticsearch server and application starts successfully, open swagger UI using http://localhost:8888/swagger-ui/index.html



![Alt text](https://github.com/Nasruddin/elasticsearch-spring-boot-spring-data/blob/master/instruction/swagger1.png?raw=true "Optional Title")

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
