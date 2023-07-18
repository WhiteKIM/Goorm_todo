function deleteFunction(id) {
     let data = {
        id : id,
     };
     httpRequest = new XMLHttpRequest();
     httpRequest.open("DELETE","/api/delete", true);
     httpRequest.responseType = "json";
     httpRequest.setRequestHeader("Content-Type","application/json");
     httpRequest.send(JSON.stringify(data));
     setTimeout(function(){
           window.location.href="/";
     }, 300);
}