let data = ["ENSF 592 01", "ENSF 593 02", "ENSF 594 03", "ENSF 607 01"];
  
let list = document.getElementById("myList");
let dropList = document.getElementById("dropList");


data.forEach((item) => {
    let li = document.createElement("li");
    let btn = document.createElement("button");
    btn.appendChild(document.createTextNode("Drop Course"));
    btn.onclick = function(){
        let dropItem = document.createElement("li");
        dropItem.innerText = item;
        dropList.appendChild(dropItem);
        list.removeChild(li);
        
    };
    li.innerText = item;
    list.appendChild(li);
    li.appendChild(btn);
});

function dropCourses(){
    
    let courses = document.getElementById("dropList").querySelectorAll("li");
    let courseList = '';
    let courseObj = [];
    courses.forEach((item) => {
        let courseParse = item.innerText.split(" ");
        let courseDict = {
            'CourseName': courseParse[0],
            'CourseID': courseParse[1],
            'Section': courseParse[2]
        };
        courseObj.push(courseDict);
        courseList += item.innerText + '\n';
    });
    console.log(courseObj);
    console.log(courseList);
    alert('Dropping:\n' + courseList);
}
