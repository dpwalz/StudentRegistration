
if (sessionStorage.token === undefined){
    // console.log(sessionStorage.token);
    window.location.href = "http://localhost:8080/";
  }

function logOut(){
    sessionStorage.clear();
    window.location.href = "http://localhost:8080/";
}