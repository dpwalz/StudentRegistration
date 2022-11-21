//let enrolled_courses = ["ENSF 592 01", "ENSF 593 02", "ENSF 594 03", "ENSF 607 01"];
// let courses_view = ["ENSF 608 01", "ENSF 611 02", "ENSF 614 03", "ENSF 645 01"];



let courses_view = [];
let enrolled_courses = [];

//if (sessionStorage.token != ""){
//    window.location.href = "http://localhost:8080/"};
//currently enrolled
let list = document.getElementById("myList");
//course searcher
let courseList = document.getElementById("courseList");

populateMyCurrentCourses();
// console.log(enrolled_courses);
// displayEnrolled();
populateCata();

// console.log(courses_view);

function displayEnrolled(){
    document.getElementById("myList").innerHTML = "";
    enrolled_courses.forEach((item) => {
        let li = document.createElement("li");
        let btn = dropButton(item);
        li.innerText = item;
        list.appendChild(li);
        li.appendChild(btn);
    });
}

function dropButton(item){
    let btn = document.createElement("button");
    btn.appendChild(document.createTextNode("Drop Course"));
    btn.onclick = function(){
        result = confirm("Are you sure you want to remove the course?")
        if (result == true){
        //Put in fetch
        var index = enrolled_courses.indexOf(item);
        if (index > -1) {
        enrolled_courses.splice(index, 1);
        displayEnrolled()
      }
    }
    }
    return btn;
}

function addButton(item){

    let btn = document.createElement("button");
    btn.appendChild(document.createTextNode("Add Course"));
    btn.onclick = function(){
        result = confirm("Are you sure you want to add the course?")
        if (result == true){
             let courseParse = item.split(" ");
             let courseDict = {
                     'username': localStorage.token,
                     'CourseName': courseParse[0],
                     'CourseID': courseParse[1],
                     'Section': courseParse[2]
                 };

        console.log(courseDict);
        addCourse(courseDict);
        };
        }

    return btn;

}

function searchAll(){

        courses_view.forEach((item) => {
        let li = document.createElement("li");
        let btn = addButton(item)
        li.innerText = item;
        courseList.appendChild(li);
        li.appendChild(btn);
});
}

function addCourse(courseDict){
  fetch("http://localhost:8080/api/v1/course",
  {
    method: "PUT",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(courseDict),
  })
  .then((response) => response.json())
  .then((json) => {

  json.forEach((item) => {
      let course = '';
      course = item.cname + " " + item.cnumber +item.csection;
      enrolled_courses.push(course);
    }

)})
  .catch(error => console.log(error));
}






function populateMyCurrentCourses(){
  fetch("http://localhost:8080/api/v1/registration",
  {
//    method: "GET",
//    headers:{"Content-Type":"application/json"},
//    body: JSON.stringify(loginDict),
  })
  .then((response) => response.json())
  .then((json) => {

  json.forEach((item) => {
      let course = '';
      course = item.cname + " " + item.cnumber + item.csection;
      enrolled_courses.push(course);
  })}).then(() => {
          displayEnrolled()})
  .catch(error => console.log(error));
  }

function populateCata(){

  fetch("http://localhost:8080/api/v1/course",
  {
//    method: "GET",
//    headers:{"Content-Type":"application/json"},
//    body: JSON.stringify(loginDict),
  })
  .then((response) => response.json())
  .then((json) => {
      console.log("here")

    json.forEach((item) => {
        console.log(item)
        let course = '';
        course = item.cname + " " + item.cnumber;
        courses_view.push(course);
    }

    )})
  .catch(error => console.log(error));
}

//Dereks previous drop course
// function dropCourses(){

//     let courses = document.getElementById("dropList").querySelectorAll("li");
//     let courseList = '';
//     let courseObj = [];
//     courses.forEach((item) => {
//         let courseParse = item.innerText.split(" ");
//         let courseDict = {
//             'CourseName': courseParse[0],
//             'CourseID': courseParse[1],
//             'Section': courseParse[2]
//         };
//         courseObj.push(courseDict);
//         courseList += item.innerText + '\n';
//     });
//     console.log(courseObj);
//     console.log(courseList);
//     alert('Dropping:\n' + courseList);
// }
