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
in wildfly-servet-10.1.0.Final/bin directory. Remember, first setup mysql server address in environment
```
export MYSQL_SERVER=localhost
./standalone.sh
```

## Access the application
If you get this, then the app is up & running, it is healthy.

```
curl http://localhost:8080/demo/healthy
ok
```



Visit following URL in web browser:

```
http://localhost:8080/demo/display
```

