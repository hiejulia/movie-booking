FROM openjdk:8-alpine

MAINTAINER Hien Nguyen <hienminhnguyen711@gmail.com>

# Required for starting application up.
# update alpine and instal bash
RUN apk update && apk add bash
# Create /opt/app for java application
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
# Copy compiled jar file into the project home folder /opt/app
COPY build/libs/movie-booking.jar $PROJECT_HOME/movie-booking.jar
# Mark folder as working for cmd
WORKDIR $PROJECT_HOME
# Specify the command which will be run when container is being started
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/movie","-Djava.security.egd=file:/dev/./urandom","-jar","./movie-booking.jar"]