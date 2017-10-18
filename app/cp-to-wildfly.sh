#!/usr/bin/env bash -v

./mvnw clean package
cp target/*.war wildfly-servlet-10.1.0.Final/standalone/deployments/demo.war