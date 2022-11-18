let data = ["Derek Walz 11234", "Brock Lesner 123456789", "Tina Turner 12345799"];
  
let list = document.getElementById("myList");
let dropList = document.getElementById("dropList");


data.forEach((item) => {
    let li = document.createElement("li");
    let grade = makeGrades()
    li.innerText = item;
    list.appendChild(li);
    li.appendChild(grade);
});

function submitGrades(){
    
    let students = document.getElementById("myList").querySelectorAll("li");
    let courseList = '';
    let courseObj = [];

    students.forEach((item) => {
        let theForm = new FormData()
        let courseParse = item.innerText.split(" ");
        let courseDict = {
            'StudentName': courseParse[0],
            'StudentID': courseParse[1],
            'Grade': theForm.get('studentsgrade')
        };
        courseObj.push(courseDict);
        courseList += item.innerText + '\n';
    });
    console.log(courseObj);
    console.log(courseList);
    alert('Dropping:\n' + courseList);
}


function makeGrades() {
    let dropdown = document.createElement("form");
    let options = document.createElement("select");
    options.name = 'studentsgrade';
    let myOptions = ['A+', 'A', 'A-', 'B+']
    myOptions.forEach((item) => {
        let new_option = document.createElement("option");
        new_option.value = item;
        new_option.innerText = item;
        options.appendChild(new_option);
    });
    dropdown.appendChild(options);
    return dropdown;
}
