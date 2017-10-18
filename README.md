# Springboot application on Wildfly

## Java compile

In app directory
```
mvn clean package
# copy war file to wildfly
./cp-to-wildfly.sh
```

## Start mysql

in mysql directory
```
docker build -t mysql:5.7-with-data .
docker-compose up -d
```

## Run wildfly
in wildfly-servet-10.1.0.Final/bin directory
```
./standalone.sh
```

## Access the application
Visit following URL in web browser:
```
http://localhost:8080/demo/display
```

