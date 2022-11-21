let data = ["Derek Walz 11234", "Brock Lesner 123456789", "Tina Turner 12345799"];
let course = ["ENSF 592 1", "ENSF 593 2"];
let coursedict = {
    "ENSF 592 1": ["Derek.Walz 11234 A", "Brock.Lesner 123456789 ", "Tina.Turner 12345799 F"],
    "ENSF 593 2": ["Bob.Bigelow 11234 ", "Brock.Lesner 123456789 C", "Tina.Turner 12345799"]
}

let sectionlist = document.getElementById("sectionList");
let list = document.getElementById("stuList");
let dropList = document.getElementById("dropList");
let dropList2 = document.getElementById("dropList");

// TODO: When the api is available remove update view and use populate view.
// populateView();
updateView();

function updateView() {
    course.forEach((item) => {

        let li = document.createElement("li");
        let section = makeSection(item);
        li.innerText = item;
        sectionlist.appendChild(li);
        li.appendChild(section);
    
    });
}




function makeSection(item){
    let section = document.createElement("input");
    section.type = 'radio';
    section.name = 'courses';
    section.value = item;
    section.onclick = () => {
        if (section.checked) {
          getStudents(section.value);
        }
    };
    return section;
}

function getStudents(item){
    
    let students = coursedict[item];
    list.innerHTML = "";
    students.forEach((item) => {
        let details = item.split(" ");
        let li = document.createElement("li");
        let grade = makeGrades(details[2]);
        li.innerText = details[0] + " " + details[1];
        list.appendChild(li);
        li.appendChild(grade);
    });
}

function addGrades(){
    
    let students = document.getElementById("stuList").querySelectorAll("li");
    let courses = document.querySelectorAll("input[name=courses]");
    let studentObj = [];
    let current_course = [];
    let re = /.*/;

    courses.forEach((course) => {
        if(course.checked){
            current_course = course.value.split(" "); 
        }
    });

    students.forEach((item) => {
        
        let grades = item.lastElementChild;
        let grade = grades.options[grades.options.selectedIndex].value;
        let courseParse = item.innerText.split(" ");
        let courseDict = {
            'username': localStorage.token,
            'coursename': current_course[0],
            'courseid': current_course[1],
            'coursesection': current_course[2],
            'studentname': courseParse[0],
            'studentid': courseParse[1].match(re)[0],
            'grade': grade
        };
        studentObj.push(courseDict);
    });
    // TODO: Use fetch function to get and update the teacher view. 
    // submitAndUpdate(studentObj);
    console.log(studentObj);
}


function makeGrades(grade) {
    let options = document.createElement("select");
    options.name = 'studentsgrade';
    let myOptions = [' ', 'A+', 'A', 'A-', 'B+', 'B', 'B-', 'C+', 'C', 'C-', 'D+', 'D', 'D-', 'F'];
    myOptions.forEach((item) => {
        let new_option = document.createElement("option");
        new_option.value = item;
        new_option.innerText = item;
        if(item === grade){
            new_option.selected = true;
        }
        options.appendChild(new_option);
    });
    return options;
}

function populateView(){

    fetch("")
    .then((response) => response.json())
    .then((json) => {
        //TODO: This must be updated to add the data to the list. 
        // Depends on the format of the API payload. 
        json.forEach((item) => {
        let course = '';
        course = item.cname + " " + item.cnumber;
        courses_view.push(course);
    }

    )})
    .then(() => {
        updateView();
    })
    .catch(error => console.log(error));
}

function submitAndUpdate(studentObj){

    fetch("", {
        method: "PUT",
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify(studentObj),
    })
    .then((response) => response.json())
    .then((json) => {
        //TODO: This must be updated to add the data to the list. 
        // Depends on the format of the API payload. 
        json.forEach((item) => {
        let course = '';
        course = item.cname + " " + item.cnumber;
        courses_view.push(course);
    }

    )})
    .then(() => {
        updateView();
    })
    .catch(error => console.log(error));
}