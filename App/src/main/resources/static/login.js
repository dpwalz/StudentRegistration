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
      // console.log(json);
      if(json.status === 27){
        alert('Username or Password not Found!');
      } else {
        sessionStorage.setItem("token", json.username);
        window.location.href = "http://localhost:8080/" + json.endpoint;
      }

    })
    .catch(error => {
    test = new FetchError(error);
    console.log(test.message);
    });
}

class FetchError extends Error {
  constructor(orig) {
      super();
      this.message = "fetch error";
      this.details = orig;
  }
}


