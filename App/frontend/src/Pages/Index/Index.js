//GET
fetch("http://localhost:8080/")
    .then(response => response.json())
    .then(data => {
        console.log("Messages: ", arrayOfMessages);
        messageOutput.innerHTML = '';
        arrayOfMessages.forEach(function(message) {
            console.log(message);
        });

    }).catch(error => console.error(error));



//POST
fetch("http://localhost:8080/create", {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
        'Content-type' : "application/json"
    }
}).then(response => {
return response.json();
}).then(data => {
    renderMessages();
    this.reset();
}).catch(error => console.log(error));


//PUT

fetch("http://localhost:8080/update?id=" + id.innerText, {
        method: "PUT",
        body:JSON.stringify({
            
        }),
        
        headers: {
            'Content-type' : "application/json"
        }
        }).then(response => {
            return response.json();
        }).then(json => {
            console.log(json);
        }).catch(error => console.log(error));
    

//DELETE    
    function deleteMessages(id) {
        fetch("http://localhost:8080/remove/" + id, {
            method: "DELETE"    
        }).then(response => {
            console.log(response);
        }).catch(error => console.error(error));
    }