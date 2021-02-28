FROM openjdk:11.0.1-jre-slim-stretch
RUN sudo apt-get update
COPY target/cacheable-data.jar /app/app.jar
WORKDIR /app
EXPOSE 9095
ENTRYPOINT ["java","-jar", "app.jar"]