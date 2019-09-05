FROM openjdk:8-jdk

ADD target/Importer-0.0.2.jar Importer-0.0.2.jar
EXPOSE 8080
RUN sh -c 'touch /Importer-0.0.2.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://spring-demo-mongo/product","-Djava.security.egd=file:/dev/./urandom","-jar","/Importer-0.0.2.jar"]

