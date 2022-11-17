let data = ["ENSF 592", "ENSF 593", "ENSF 594", "ENSF 607"];
  
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
        dropForm.nodeValue += item + "\n";
        
    };
    li.innerText = item;
    list.appendChild(li);
    li.appendChild(btn);
});

function dropCourses(){




    let courses = document.getElementById("dropList").querySelectorAll("li");
    let courseList = '';
    courses.forEach((item) => {
        courseList += item.innerText + '\n';
    });
    alert('Dropping:\n' + courseList);
}
