FROM maven:3-jdk-8 AS build-env

WORKDIR /app
COPY . /app
RUN mvn package


FROM jboss/wildfly
COPY --from=build-env /app/target/*.jar /opt/jboss/wildfly/standalone/deployments/demo.jar

ENV JAVA_OPTS=""
ENV SERVER_PORT 8080
ENV MYSQL_SERVER="mysql"

EXPOSE ${SERVER_PORT}
HEALTHCHECK --interval=10s --timeout=3s \
	CMD curl -v --fail http://localhost:${SERVER_PORT}/healthy || exit 1

CMD ["sh","-c","/opt/jboss/wildfly/bin/standalone.sh"]