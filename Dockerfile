FROM openjdk:8
ADD target/Importer-0.0.1.jar Importer-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Importer-0.0.1.jar"]
