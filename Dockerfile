FROM openjdk:17-oracle
COPY ./target/classes/com /tmp/com
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.gp3.App"]