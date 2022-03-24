FROM openjdk:11
ADD /target/booking-system-1.0-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]