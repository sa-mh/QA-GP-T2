
FROM maven as buildstage
COPY . /build
WORKDIR /build
RUN mvn clean package


FROM openjdk:11 as containerstage

COPY --from=buildstage /build/target/Spring-TDL-0.0.1-SNAPSHOT.jar Spring-TDL.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "Spring-TDL.jar"]

