FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

MAINTAINER hungthanhnguyen

COPY pom.xml /build/
COPY src /build/src/


WORKDIR /build/
RUN mvn package


FROM openjdk:8-jre-alpine
WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/werewolf-be-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["sh", "-c", "java -Dserver.port=$PORT $JAVA_OPTS -jar -Dspring.profiles.active=prod werewolf-be-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
