#pierwszy obraz ustawiony jako builder aplikacji
FROM ubuntu:latest as builder
#folder roboczy
WORKDIR /app
#skopiowanie całej aplikacji
COPY spr1/.mvn/ .mvn
COPY spr1/mvnw spr1/pom.xml ./
COPY spr1/src ./src
#ustawienie uprawnień
RUN chmod 777 mvnw
#aktualizacja narzędzia zarządzania pakietami oraz instalowanie openJDK dla Jaby 17, w której napisana została aplikacja
RUN apt update
RUN apt install -y openjdk-17-jre-headless
#stworzenie pakietu w aplikacji
RUN ./mvnw clean package

#drugi obraz ustawiony jako runner aplikacji
FROM openjdk:17-jdk-alpine as runner
#ustawienie właściciela aplikacji
MAINTAINER Pasztelan_Alicja
COPY --from=builder /app/target/spr1-0.0.1-SNAPSHOT.jar /app/spr1-0.0.1-SNAPSHOT.jar 
WORKDIR /app
RUN chmod 777 spr1-0.0.1-SNAPSHOT.jar 

ENTRYPOINT ["java","-jar","spr1-0.0.1-SNAPSHOT.jar"]