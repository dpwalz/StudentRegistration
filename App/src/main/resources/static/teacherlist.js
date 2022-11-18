let data = ["Derek Walz 11234", "Brock Lesner 123456789", "Tina Turner 12345799"];
  
let list = document.getElementById("stuList");
let dropList = document.getElementById("dropList");


data.forEach((item) => {
    let li = document.createElement("li");
    let grade = makeGrades()
    li.innerText = item;
    list.appendChild(li);
    li.appendChild(grade);
});

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
        studentList += item.firstChild.innerText + 'grade:' + grade + '\n';
    });
    console.log(studentObj);
    console.log(studentList);
    alert('Dropping:\n' + studentList);
}


function makeGrades() {
    let options = document.createElement("select");
    options.name = 'studentsgrade';
    let myOptions = ['A+', 'A', 'A-', 'B+']
    myOptions.forEach((item) => {
        let new_option = document.createElement("option");
        new_option.value = item;
        new_option.innerText = item;
        options.appendChild(new_option);
    });
    return options;
}
