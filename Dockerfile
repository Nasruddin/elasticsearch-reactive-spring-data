#stage 1
#Start with a base image containing Java runtime
FROM openjdk:17-slim as builder

# Add Maintainer Info
LABEL maintainer="Nasruddin <nasruddin.java@gmail.com>"

WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# the second stage of our build will copy the extracted layers
FROM openjdk:17-slim
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

EXPOSE 8888

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]