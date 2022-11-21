const form = document.getElementById("login-form");

form.addEventListener("submit", formSubmit);

function formSubmit(e) {
  e.preventDefault();
  loginDict = {
    username: document.getElementById('username').value,
    password: document.getElementById('password').value
  }
  fetch("http://localhost:8080/api/v1/user",
  {
    method: "PUT",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(loginDict),
  })
  .then((response) => response.json())
  .then((json) => {
       console.log(json)
      sessionStorage.setItem("token", json.username);
      window.location.href = "http://localhost:8080/" + json.endpoint; 
   })
  .catch(error => alert('Username or Password is incorrect.'));
}

function login(response){


}

