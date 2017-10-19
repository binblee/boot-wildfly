# Springboot application on Tomcat

## Java compile

In app directory
```
mvn clean package
```

## Start mysql

in mysql directory
```
docker build -t mysql:5.7-with-data .
docker-compose up -d
```

## Run tomcat
in wildfly-servet-10.1.0.Final/bin directory. Remember, first setup mysql server address in environment
```
export MYSQL_SERVER=localhost
target/demo-0.0.1-SNAPSHOT.jar
```

## Access the application
If you get this, then the app is up & running, it is healthy.

```
curl http://localhost:8080/healthy
ok
```



Visit following URL in web browser:

```
http://localhost:8080/display
```



Cached display

```
http://localhost:8080/cdisplay
```

