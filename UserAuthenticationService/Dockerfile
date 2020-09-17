FROM openjdk:11-jre
WORKDIR usr/lib
ENV MYSQL_HOST=localhost
ENV MYSQL_DATABASE=news
ENV MYSQL_USER=approot
ENV MYSQL_PASSWORD=apppass
COPY ./target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /usr/lib/UserAuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "UserAuthenticationService-0.0.1-SNAPSHOT.jar"]

