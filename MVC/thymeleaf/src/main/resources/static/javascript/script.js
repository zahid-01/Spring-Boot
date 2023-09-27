const para = document.querySelector(".para");

let counter = 0;

para.addEventListener("click", () => {
    console.log("Count " + counter++);
})