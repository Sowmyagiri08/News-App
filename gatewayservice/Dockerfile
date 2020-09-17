FROM openjdk:11-jre
WORKDIR usr/lib
COPY ./target/gatewayservice-0.0.1-SNAPSHOT.jar /usr/lib/gatewayservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "gatewayservice-0.0.1-SNAPSHOT.jar"]
