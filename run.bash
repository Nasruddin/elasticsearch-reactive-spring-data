#!/usr/bin/env bash

echo "Change dir to docker..."
# shellcheck disable=SC2164
cd docker


if [[ $@ == *"stop"* ]]
then
    echo "We are done, stopping the test environment..."
    echo "$ docker-compose down"
    docker-compose down
fi

if [[ $@ == *"start"* ]]
then
    echo "Building the application..."
    mvn clean install
    echo "Restarting the test environment..."
    echo "$ docker-compose down --remove-orphans"
    docker-compose down --remove-orphans
    echo "$ docker-compose up"
    docker-compose up --build
fi
