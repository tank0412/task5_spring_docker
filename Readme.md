# Set up
* docker swarm init
* docker service create --name registry --publish 10000:10000 registry:2

* docker-compose build spring-boot-docker
* docker-compose push spring-boot-docker
* docker stack deploy --compose-file docker-compose.yml docker-spring-boot-task9

## Check status
* docker stack services docker-spring-boot-task9