#Use existing image with maven and chrome
FROM markhobson/maven-chrome:latest as prueba

# copy src folder and pom file to docker image
COPY src /home/app/src
COPY pom.xml /home/app

RUN mkdir /home/.m2
WORKDIR /home/.m2
USER root

VOLUME .idea/.m2:/home/.m2

# run mvn command
RUN mvn -f /home/app/pom.xml clean test