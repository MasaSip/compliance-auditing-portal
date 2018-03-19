# compliance-auditing-portal
A web platform for Namibian energy Company Electricity Control Board


# add Testdata with curl
```
curl -i -X POST -H "Content-Type:application/json" -d \
  "{  \"name\" : \"Frodo\" }" \
  http://localhost:8080/api/reports
  
curl -i -X POST -H "Content-Type:application/json" -d \
  "{ \
    \"question\" : \"External Question 1\", \
    \"comment\"  : \"hello world\", \
    \"report\" : \"http://localhost:8080/api/reports/1\" \
  }" \
  http://localhost:8080/api/nonCompliances
  ```
# configure persistent db connection (Unix)

ENV:
```
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/db_example"
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