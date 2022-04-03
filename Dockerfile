FROM openjdk:11-oracle
COPY target/booking-system-1.0-SNAPSHOT.jar booking-system-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","booking-system-1.0-SNAPSHOT.jar"]