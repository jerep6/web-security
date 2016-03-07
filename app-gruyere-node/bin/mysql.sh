#!/bin/bash

CONTAINER_NAME="mysql-secu"
MYSQL_PORT=3307

if [ $1 = "start" ]; then
  running=$(docker inspect -f {{.State.Running}} $CONTAINER_NAME)
  echo "Response for docker inspect : $running"

  if [ "$running" = "true" ]; then
    echo "Container $CONTAINER_NAME is already running"

  elif [ "$running" = "false" ]; then
    echo "Container $CONTAINER_NAME exists. Start it !"
    docker start $CONTAINER_NAME
    sleep 10

  else
    echo "Container $CONTAINER_NAME exist. Run it !"
	  docker run --name $CONTAINER_NAME -p $MYSQL_PORT:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=secu -e MYSQL_USER=secu -e MYSQL_PASSWORD=secu -d mysql:5.5
	  sleep 10
  fi

elif [ $1 = "stop" ]; then
  docker stop $CONTAINER_NAME
fi

