const form = document.getElementById("login-form");

form.addEventListener("submit", formSubmit);

function formSubmit(e) {
  e.preventDefault();
  loginDict = {
    username: document.getElementById('username').value,
    password: document.getElementById('password').value
  }


//   const formData = new FormData();
//   formData.append(
//     'username',
//     document.querySelector('input[name="username"]').value
//   )
//   formData.append(
//     'password',
//     document.querySelector('input[name="pass"]').value
//   )

  fetch("http://localhost:8080/api/v1/user",
  {
    method: "PUT",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(loginDict),
  })
  .then((response) => response.text())
  // .then((text) => {console.log(text)})
  .then((text) => {window.location.href = "http://localhost:8080/" + text})

  // .then(response => window.location.href = "http://localhost:8080/" + response)
  .catch(error => console.log(error));


}

function login(response){


}

