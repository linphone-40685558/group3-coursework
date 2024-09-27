FROM openjdk:17-oracle
COPY ./target/group3-coursework-1.0.0-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "group3-coursework-1.0.0-jar-with-dependencies.jar"]