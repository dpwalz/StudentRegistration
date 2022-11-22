//let enrolled_courses = ["ENSF 592 01", "ENSF 593 02", "ENSF 594 03", "ENSF 607 01"];
// let courses_view = ["ENSF 608 01", "ENSF 611 02", "ENSF 614 03", "ENSF 645 01"];



let courses_view = [];
let enrolled_courses = [];
let search_view = [];
let sections_dict = {};

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

function addButton(item, sections){

    let btn = document.createElement("button");
    btn.appendChild(document.createTextNode("Add Course"));
    btn.onclick = function(){
        result = confirm("Are you sure you want to add the course?")
        if (result == true){
             let courseParse = item.split(" ");
             console.log(courseParse)
             let courseDict = {
                 "course" : {
                     'name': courseParse[0],
                     'number': courseParse[1],
                 },
                 'section_number': sections.options[sections.options.selectedIndex].value,
                 'section_year': "2022"
             };

        console.log(courseDict);
        addCourse(courseDict);
        };
        }

    return btn;

}

function searchAll(){
        document.getElementById("courseList").innerHTML = "";
        courses_view.forEach((item) => {
        let li = document.createElement("li");
        let section = makeSections(sections_dict[item]);
        let btn = addButton(item, section)
        li.innerText = `${item} Section Num: `;
        courseList.appendChild(li);
        li.appendChild(section);
        li.appendChild(btn);
});
}

function searchSome(){
  document.getElementById("courseList").innerHTML = "";
  search_view.forEach((item) => {
  let li = document.createElement("li");
  let section = makeSections(sections_dict[item]);
  let btn = addButton(item, section)
  li.innerText = `${item} Section Num: `;
  courseList.appendChild(li);
  li.appendChild(section);
  li.appendChild(btn);
});
}

function addCourse(courseDict){
  fetch("http://localhost:8080/api/v1/student/" + localStorage.token,
  {
    method: "POST",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(courseDict),
  })
  .then((response) => response.json())
  .then((json) => {

  json.forEach((item) => {
      let course = '';
      course = item.cname + " " + item.cnumber + item.csection;
      enrolled_courses.push(course);
    }

)})
  .catch(error => console.log(error));
}


function populateMyCurrentCourses(){
  fetch("http://localhost:8080/api/v1/registration/USER/" + sessionStorage.token + "/YEAR/2022",
  {
//    method: "GET",
//    headers:{"Content-Type":"application/json"},
//    body: JSON.stringify(sessionStorage.token),
  })
  .then((response) => response.json())
  .then((json) => {

  json.forEach((item) => {
      let course = '';
      course = item.cname + " " + item.cnumber+ "  Section Num: " + item.sectionID + "  ";
      enrolled_courses.push(course);
  })}).then(() => {
          displayEnrolled()})
  .catch(error => console.log(error));
  }

function populateCata(){
//need to capture section here
  fetch("http://localhost:8080/api/v1/course",
  {
//    method: "GET",
//    headers:{"Content-Type":"application/json"},
//    body: JSON.stringify(loginDict),
  })
  .then((response) => response.json())
  .then((json) => {
    json.forEach((item) => {
        console.log(item)
        let course = '';
        course = item.cname + " " + item.cnumber;
        courses_view.push(course);
        sections_dict[course] = item.sections;
    }

    )})
  .catch((error) => console.log("hello"));
}

function searchClasses(searchBar){
  
  let substring = searchBar.value;
  search_view = [];

  courses_view.find(element => {
    if (element.includes(substring)) {
      console.log();
      search_view.push(element);
    }
  });
  // console.log(search_view);
  searchSome();

}

function makeSections(sections) {
  let options = document.createElement("select");
  options.name = 'coursesections';
  sections.forEach((item) => {
      let new_option = document.createElement("option");
      new_option.value = item;
      new_option.innerText = item;
      options.appendChild(new_option);
  });
  return options;
}

