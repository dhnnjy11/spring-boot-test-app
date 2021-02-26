FROM openjdk:11.0.1-jre-slim-stretch
EXPOSE 9093
COPY target/cacheable-data.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar", "app.jar"]