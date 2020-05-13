FROM gradle:6.4-jdk11
COPY . /app
WORKDIR /app
RUN SPRING_PROFILES_ACTIVE=dev gradle bootJar
CMD ["java", "-jar", "./build/libs/voting-0.0.1-SNAPSHOT.jar"]
