let data = ["ENSF 592", "ENSF 593", "ENSF 594", "ENSF 607"];
  
let list = document.getElementById("myList");

data.forEach((item) => {
    let li = document.createElement("li");
    let btn = document.createElement("button");
    btn.appendChild(document.createTextNode("Drop Course"));
    li.innerText = item;
    list.appendChild(li);
    li.appendChild(btn);
});