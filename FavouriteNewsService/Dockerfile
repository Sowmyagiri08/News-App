FROM openjdk:11-jre
WORKDIR usr/lib
ENV MONGO_DATABASE=news
ENV MONGO_PORT=27017
ENV MONGO_HOST=localhost
COPY ./target/FavouriteNewsService-0.0.1-SNAPSHOT.jar /usr/lib/FavouriteNewsService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "FavouriteNewsService-0.0.1-SNAPSHOT.jar"]
