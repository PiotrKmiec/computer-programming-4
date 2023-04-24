let root = document.querySelector("#root");

let tc = textCounter();

setInterval(()=>{
    root.innerText = tc.next().value;
}, 1000);

function* textCounter() {
    let i = 0;
    while (true) {
        i++;
        yield(`Count: ${i}`);
    }
}