# compliance-auditing-portal
A web platform for Namibian energy Company Electricity Control Board

# configure persistent db connection (Unix)

ENV:
```bash
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/db_example?autoReconnect=true&useSSL=false"
export SPRING_DATASOURCE_USERNAME="springuser"
export SPRING_DATASOURCE_PASSWORD="ThePassword"
```

# Requirements

- java jdk

optional:
- Mysql (only needed when persistent data storage is needed. For developement in memory h2 is used)


# Execution

Unix:
./gradlew bootRun

Windows:
gradlew.bat bootRun

# Api needs authentication by default 

Examples how to use these api can be found in (./src/main/resources/static/examples)