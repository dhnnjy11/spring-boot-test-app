FROM openjdk:11.0.1-jre-slim-stretch
COPY target/cacheable-data.jar /app/app.jar
CMD pwd
WORKDIR /app
EXPOSE 9095
ENTRYPOINT ["java","-jar", "app.jar"]