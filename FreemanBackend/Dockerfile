FROM gradle:8.4.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build jar

FROM openjdk:17
COPY --from=build /app/build/libs/FreemanBackend-0.0.1-SNAPSHOT.jar FreemanBackend-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/FreemanBackend-0.0.1-SNAPSHOT.jar"]
