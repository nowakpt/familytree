#!/bin/bash
# creates and launches docker container with MySQL database
# after the container is created, you can re-launch it with 'docker start mysql-familytree'


if [ -z "$1" ] || [ -z "$2" ] ; then
	echo 'Error: invalid arguments: passwords cannot be empty.' > /dev/stderr
	echo 'Usage:' > /dev/stderr
	echo "$0 USER_PASSWORD ROOT_PASSWORD" > /dev/stderr
	exit 1
fi


CONTAINER_NAME='mysql-familytree'
MYSQL_PORT=3306
MYSQL_ROOT_PASSWORD="$2"

MYSQL_USER_NAME='familytree'
MYSQL_USER_PASSWORD="$1"
MYSQL_DATABASE='familytree'


docker run \
	-d \
	--name "${CONTAINER_NAME}" \
	-e MYSQL_ROOT_PASSWORD="${MYSQL_ROOT_PASSWORD}" \
	-e MYSQL_DATABASE="${MYSQL_DATABASE}" \
	-e MYSQL_USER="${MYSQL_USER_NAME}" \
	-e MYSQL_PASSWORD="${MYSQL_USER_PASSWORD}" \
	-p ${MYSQL_PORT}:3306 \
	mysql \
	--character-set-server=utf8 \
	--collation-server=utf8_unicode_ci

echo 'Parameters:'
echo "container name: $CONTAINER_NAME"
echo "port:           $MYSQL_PORT"
echo "root password:  $MYSQL_ROOT_PASSWORD"
echo "user name:      $MYSQL_USER_NAME"
echo "user password:  $MYSQL_USER_PASSWORD"
echo "database name:  $MYSQL_DATABASE"

