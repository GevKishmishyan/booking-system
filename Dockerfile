FROM openjdk:11-oracle
MAINTAINER booking-system
COPY target/booking-system-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]