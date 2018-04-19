// This is a simple api to query the rest api.
// The fetch api is used. This is a async api.
// All functions here return an promise object.
// Please feel free to change and improve the code.


function check_login_request(apiUrl, username, password) {
    var url = apiUrl + "/api/users/search/findByUsername?username=" + username;

    return fetch(url, {
        method: 'GET',
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + window.btoa(username + ":" + password)
        })
    }).then(function (response) {
        if (response.status != 200) {
            console.error('Error: Http response is ' + response.status);
            return null;
        } else {
            return response.json();
        }
    }).catch(function (error) {
        console.error('Error:', error)
    });
}

// Rest is stateless. So username and password have to be part of every call to the api.
function add_report_request(apiUrl, username, password, userUri, reportName) {


    var url = apiUrl + "/api/reports";

    var data = {
        name: reportName,
        user: userUri
    };

    return fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + window.btoa(username + ":" + password)
        })
    }).then(function(response){
        if(response.status != 201) { // 201 == HTTP Status Created
            console.error('Error: Http response is ' + response.status);
            return null;
        } else {
            return response.json();
        }
    }).catch(function (error) {
        console.error('Error:', error)
    });
}

// Rest is stateless. So username and password have to be part of every call to the api.
function add_non_compliance_request(apiUrl, username, password, reportUri, comment) {
    var url = apiUrl + "/api/nonCompliances";

    var data = {
        comment: comment,
        report: reportUri
    };

    return fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + window.btoa(username + ":" + password)
        })
    }).then(function(response){
        if(response.status != 201) { // 201 == HTTP Status Created
            console.error('Error: Http response is ' + response.status);
            return null;
        } else {
            return response.json();
        }
    }).catch(function (error) {
        console.error('Error:', error)
    });
}