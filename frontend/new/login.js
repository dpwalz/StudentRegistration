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

  fetch("https://nocodeform.io/f/{your-form-id}",
  {
    method: "POST",
    body: formData,
  })
  .then(response => console.log(response))
  .catch(error => console.log(error))
}