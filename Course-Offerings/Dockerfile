FROM openjdk:17
WORKDIR /app
EXPOSE 8080
ADD target/course-offering.jar course-offering.jar
COPY target/course-offering.jar /app/course-offering.jar
ENTRYPOINT ["java","-jar","/course-offering.jar"]

