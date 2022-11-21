let data = ["Derek Walz 11234", "Brock Lesner 123456789", "Tina Turner 12345799"];
let course = ["ENSF 592 sec 1", "ENSF 593 sec 2"];
let coursedict = {
    "ENSF 592 sec 1": ["Derek Walz 11234", "Brock Lesner 123456789", "Tina Turner 12345799"],
    "ENSF 593 sec 2": ["Bob Bigelow 11234", "Brock Lesner 123456789", "Tina Turner 12345799"]
}

// add a div for the course and sections with radio button, 
// add a div for students that pops up when radio buttons are pressed. 
// get section from radio buttons and students and grades from other div. 

let sectionlist = document.getElementById("sectionList");
let list = document.getElementById("stuList");
let dropList = document.getElementById("dropList");
let dropList2 = document.getElementById("dropList");

course.forEach((item) => {

    let li = document.createElement("li");
    let section = makeSection(item);
    li.innerText = item;
    sectionlist.appendChild(li);
    li.appendChild(section);

});



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
        let li = document.createElement("li");
        let grade = makeGrades()
        li.innerText = item;
        list.appendChild(li);
        li.appendChild(grade);
    });
}

function addGrades(){
    
    let students = document.getElementById("stuList").querySelectorAll("li");
    let studentList = '';
    let studentObj = [];

    students.forEach((item) => {
        
        let grades = item.lastElementChild;
        let grade = grades.options[grades.options.selectedIndex].value;
        let courseParse = item.innerText.split(" ");
        let courseDict = {
            'StudentName': courseParse[0],
            'StudentID': courseParse[1],
            'Grade': grade
        };
        studentObj.push(courseDict);
        // studentList += name + 'grade:' + grade + '\n';
    });
    console.log(studentObj);
}


function makeGrades() {
    let options = document.createElement("select");
    options.name = 'studentsgrade';
    let myOptions = ['A+', 'A', 'A-', 'B+', 'B', 'B-', 'C+', 'C', 'C-', 'D+', 'D', 'D-', 'F'];
    myOptions.forEach((item) => {
        let new_option = document.createElement("option");
        new_option.value = item;
        new_option.innerText = item;
        options.appendChild(new_option);
    });
    return options;
}
