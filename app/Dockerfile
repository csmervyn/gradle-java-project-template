FROM amazoncorretto:17-alpine3.18-jdk
LABEL maintainer=csmervyn@gmail.com
WORKDIR /app
COPY build/libs/app-all.jar .
ENTRYPOINT ["java", "-jar", "/app/app-all.jar"]
