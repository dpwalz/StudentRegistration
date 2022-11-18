let enrolled_courses = ["ENSF 592 01", "ENSF 593 02", "ENSF 594 03", "ENSF 607 01"];
let courses_view = ["ENSF 608 01", "ENSF 611 02", "ENSF 614 03", "ENSF 645 01"];
  
let list = document.getElementById("myList");
let courseList = document.getElementById("courseList");


displayEnrolled()

function displayEnrolled(){
        document.getElementById("myList").innerHTML = "";
        enrolled_courses.forEach((item) => {
        let li = document.createElement("li");
        let btn = dropButton(item)
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
        let dropItem = document.createElement("li");
        dropItem.innerText = item;
        list.removeChild(li);
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
        enrolled_courses.push(item)
        displayEnrolled()
        courseList.removeChild(li)
        }
    }
    return btn;

}

function addTOList(item){

    let li = document.createElement("li");
    li.innerText = item;
    dropList.appendChild(dropItem);
    list.removeChild(li);

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
