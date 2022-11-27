// Storage arrays for holding temporary instances of course details
let courses_view = [];
let enrolled_courses = [];
let enrolled_sections_dict = {};
let search_view = [];
let sections_dict = {};

// currently enrolled
// this html tag displays the currently enrolled courses
let list = document.getElementById("myList");
//course searcher
// this html tag display the courses searched or the entire catalogue
let courseList = document.getElementById("courseList");

// Initially fetches to populate the site with the current
// students courses and the course catalogue
populateMyCurrentCourses();
populateCata();

// ***** FUNCTIONS FOR DISPLAYING COURSES ON SITE: *****

// displayEnrolled displays the currently enrolled classes
// in the html tag with ID "myList"
function displayEnrolled(){
  document.getElementById("myList").innerHTML = "";
  enrolled_courses.forEach((course) => {
      let acc_element = makeAccordion(course, enrolled_sections_dict, 'drop');
      list.appendChild(acc_element[0]);
      list.appendChild(acc_element[1]);
  });
}

// searchAll displays all of the course catalogue
// in the HTML tag with ID "courseList".
// Function clears the search bar when clicked.
// Event listener for the Search All Button. 
function searchAll(){
document.getElementById("searchname").value = "";
document.getElementById("courseList").innerHTML = "";
courses_view.forEach((course) => {
  let acc_element = makeAccordion(course, sections_dict, 'add'); 
  courseList.appendChild(acc_element[0]);
  courseList.appendChild(acc_element[1]);
  });
}

// searchClasses clears the current cache of
// courses in search_view and then repopulates
// the array with only courses matching the substring
// existing in the searchbar, it then calls searchSome to 
// display those courses. 
// Event listener for the Search bar input tag.  
function searchClasses(searchBar){
  let substring = searchBar.value;
  search_view = [];
  courses_view.find(element => {
    if (element.includes(substring)) {
      search_view.push(element);
    }
  });
  searchSome();
}

// searchSome displays only the courses that match the substring currently typed in the searchbar
// and displays those courses in the HTML tag with ID "courseList".
// This is done with every keystroke typed in the search bar. 
function searchSome(){
document.getElementById("courseList").innerHTML = "";
search_view.forEach((course) => {
let acc_element = makeAccordion(course, sections_dict, 'add'); 
courseList.appendChild(acc_element[0]);
courseList.appendChild(acc_element[1]);
});
}

// *****FUNCTIONS FOR DYNAMICALLY CREATING HTML ELEMENTS:*****

// Drop button creates and returns a button that will 
// send a DELETE api request to the server when clicked.
// Will result in a particular course being removed from the
// students course list. 
function dropButton(course, section){
  let btn = document.createElement("button");
  btn.appendChild(document.createTextNode("Drop Course"));
  btn.onclick = function(){
      result = confirm("Are you sure you want to remove the course?")
      if (result == true){
        let courseParse = course.split(" ");
           let courseDict = {
               "course" : {
                   'name': courseParse[0],
                   'number': courseParse[1],
               },
               'sectionnumber': section,
               'sectionyear': "2022",
           };
      console.log(courseDict)
      dropCourse(courseDict);
    }
  }
  return btn;
}

// Add button creates and returns a button that will 
// send a POST api request to the server when clicked.
// Will result in a course being added to a students enrolled courses.
function addButton(course, section){
  let btn = document.createElement("button");
  btn.appendChild(document.createTextNode("Add Course"));
  btn.onclick = function(){
      result = confirm("Are you sure you want to add the course?")
      if (result == true){
           let courseParse = course.split(" ");
           let courseDict = {
               "course" : {
                   'name': courseParse[0],
                   'number': courseParse[1],
               },
               'sectionnumber': section,
               'sectionyear': "2022",
           };
      console.log(courseDict);
      addCourse(courseDict);
      };
  }
  return btn;
}

// makeAccordion creates an accordion type element. This funciton 
// returns an array containing a Button tag and a div tag, the div tag is hidden by CSS 
// until the Button tag is clicked. 
function makeAccordion(course, sect_dict, button_type){
  let acc_and_panel = []
  let acc = document.createElement("Button");
  let panel = document.createElement("ul");
  panel.classList.add("panel");
  let sections = sect_dict[course];
  sections.forEach((section) => {
    let section_element = document.createElement("li");
    section_element.innerText = `Section Number: ${section}`
    let btn;
    if(button_type === 'add'){
      btn = addButton(course, section);
    } else {
      btn = dropButton(course, section);
    }
    section_element.appendChild(btn);
    panel.appendChild(section_element);
  })
  acc.classList.add("accordion");
  acc.innerText = `${course}`
  acc.onclick = (() => {
    acc.classList.toggle("active");
    let course_details = panel;
    if (course_details.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
  acc_and_panel.push(acc);
  acc_and_panel.push(panel);
  
  return acc_and_panel;
}

// *****FUNCTIONS FOR API REQUESTS:*****

// addCourse creates and handles a POST API request. 
// request is to add a course from the catalogue to a Students enrolled courses
function addCourse(courseDict){
  fetch("http://localhost:8080/api/v1/registration/STUDENT/" + sessionStorage.token,
  {
    method: "POST",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(courseDict),
  })
  .then((response) => response.json())
  .then((json) => {
      if (json.status == "OK"){
          let enrolledStudents = json.message
          if (parseInt(enrolledStudents) < 8) {
              alert("There are " + enrolledStudents + "students enrolled in this section.\n" +
                  "If 8 students do not enroll this section will be canceled")
          }
          populateMyCurrentCourses()
      } else {
          alert(json.message)
      }
})
  .catch(error => console.log(error));
}

// dropCourse creates and handles a DELETE API request.
// request is to drop a particular course from a students 
// enrolled courses
function dropCourse(courseDict){
  fetch("http://localhost:8080/api/v1/registration/STUDENT/" + sessionStorage.token,
  {
    method: "DELETE",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(courseDict),
  })
  .then((response) => response.json())
  .then((json) => {
      populateMyCurrentCourses();
    }

)
  .catch(error => console.log(error));
}

// populateMyCurrentCourses creates and handles a GET API request. 
// request is to return a students list of enrolled courses.
function populateMyCurrentCourses(){
  enrolled_courses = []
  fetch("http://localhost:8080/api/v1/registration/USER" +
      "/" + sessionStorage.token + "/YEAR/2022", {})
  .then((response) => response.json())
  .then((json) => {
  json.forEach((item) => {
      let course = '';
      course = item.cname + " " + item.cnumber;
      enrolled_courses.push(course);
      enrolled_sections_dict[course] = [item.sectionID];
  })}).then(() => {
          displayEnrolled()})
  .catch(error => console.log(error));
  }

// populateCata creates and handles a GET API request
// request is to get all of the courses in the catalogue.
function populateCata(){
//need to capture section here
  fetch("http://localhost:8080/api/v1/course",{})
  .then((response) => response.json())
  .then((json) => {
    json.forEach((item) => {
        let course = '';
        course = item.cname + " " + item.cnumber;
        courses_view.push(course);
        sections_dict[course] = item.sections;
  })})
  .catch((error) => console.log("hello"));
}





// **** Depricated Function, will delete ***


// addButton and makeSection are here as legacy 
// code. Sections no longer shown in drop down list. 

// function addButton(item, sections){

//   let btn = document.createElement("button");
//   btn.appendChild(document.createTextNode("Add Course"));
//   btn.onclick = function(){
//       result = confirm("Are you sure you want to add the course?")
//       if (result == true){
//            let courseParse = item.split(" ");
//            let courseDict = {
//                "course" : {
//                    'name': courseParse[0],
//                    'number': courseParse[1],
//                },
//                'sectionnumber': sections.options[sections.options.selectedIndex].value,
//                'sectionyear': "2022",
//            };

//       console.log(courseDict);
//       addCourse(courseDict);
//       };
//   }

//   return btn;
// }

// makeSection makes a section drop down list
// for a particular course
// function makeSections(sections) {
//   let options = document.createElement("select");
//   options.name = 'coursesections';
//   sections.forEach((item) => {
//       let new_option = document.createElement("option");
//       new_option.value = item;
//       new_option.innerText = item;
//       options.appendChild(new_option);
//   });
//   return options;
// }

// function populateMyCurrentCourses(){

//   enrolled_courses = []
// fetch("http://localhost:8080/api/v1/registration/USER" +
//     "/" + sessionStorage.token + "/YEAR/2022", {})
// .then((response) => response.json())
// .then((json) => {
// json.forEach((item) => {
//     let course = '';
//     course = item.cname + " " + item.cnumber+ "  Section Num: " + item.sectionID + "  ";
//     enrolled_courses.push(course);
// })}).then(() => {
//         displayEnrolled()})
// .catch(error => console.log(error));
// }

// function displayEnrolled(){
//   document.getElementById("myList").innerHTML = "";
//   enrolled_courses.forEach((item) => {
//       let li = document.createElement("li");
//       let btn = dropButton(item);
//       li.innerText = item;
//       list.appendChild(li);
//       li.appendChild(btn);
//   });
// }