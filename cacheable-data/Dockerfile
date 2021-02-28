FROM openjdk:11.0.1-jre-slim-stretch
USER jenkins
RUN mvn --version && mvn -f cacheable-data clean package
COPY target/cacheable-data.jar /app/app.jar
WORKDIR /app
EXPOSE 9095
ENTRYPOINT ["java","-jar", "app.jar"]