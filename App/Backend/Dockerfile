
FROM maven as buildstage
COPY . /build
WORKDIR /build
RUN mvn clean package


FROM java:8 as containerstage

COPY --from=buildstage /build/target/Spring-TDL-0.0.1-SNAPSHOT.jar Spring-TDL.jar

EXPOSE 8001

ENTRYPOINT ["/usr/bin/java", "-jar", "Spring-TDL.jar"]

