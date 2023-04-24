const root = document.querySelector("#root");

const res = axios.get('/api/products');

res.then((productsJson) => {
    if(productsJson.data){
        root.innerText = JSON.stringify(productsJson.data[0], null, 2);
    }else{
        console.error("Error GET-ting products");
    }
});