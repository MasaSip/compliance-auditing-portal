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

# Api needs authentication by default (javascript react example)

```javascript
componentDidMount() {
    var username = "User";
    var password = "password";
    var url = this.props.apiUrl + "/api/reports";
    fetch(url, {
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + window.btoa(username + ":" + password)
        })
    }).then(res => res.json())
        .then(
            (result) => {
                this.setState({
                    isLoaded: true,
                    items: result._embedded.reports,
                    page: result.page
                });
            },
            // Note: it's important to handle errors here
            // instead of a catch() block so that we don't swallow
            // exceptions from actual bugs in components.
            (error) => {
                this.setState({
                    isLoaded: true,
                    error
                });
            }
        )
}
```
Examples how to use these api can be found in (./src/main/resources/static/examples)