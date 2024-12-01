## Why use Docker
Docker makes it very easy to install and run software on any environment. You do not have to manage dependencies or 
do some weird installation steps.

## What is Docker
Docker is ecosystem(Docker Hub, Docker Client, Docker Compose etc) that 
is used to run containers.

Image - is a single file that is downloaded from the Docker hub stored on hard drive and is used to 
create containers.

Container is instance of an image. Container is program with its own allocated resources.
Ressource allocation in a Linux OS is done by utilizing namespaces(isolation resources for a
particular process) and control groups(limiting amount of resources).

## Commands
1. Run container from image. If you do not have `hello-world` image installed locally, 
Docker CLI reaches out to Docker Hub and fetches image for you.
```
docker run hello-world
```
Note: there are also `docker create`(make container) and `docker start`(run start command of the image in the container) commands but the `docker run` does it all.
2. List running containers
```
docker ps
```
3. Logging
```
docker logs --follow --tail 100 <container_id>
```
4. Execute command in container
```
docker exec -it <container_id> <command>
```
Enter command line in container:
```
docker exec -it <container_id> sh
```
Command processors or shells(bash, powershell, zsh, sh) is something that allows for entry and execution of commands.
5. Build image from your local Docker file
```
docker build -t gitlab.os.dcso.net:4567/dev/go/vizor/mock-wb-psql-db .
```
Then do docker run to test it locally.
6. Docker push to Docker Hub.
```
docker push gitlab.os.dcso.net:4567/dev/go/vizor/mock-wb-psql-db
```

## Remove everything on machine:
docker container prune; docker image prune; docker volume prune
AND
docker system prune -a --volumes
