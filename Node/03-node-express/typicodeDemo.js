var Request = require("request");
const express=require('express')
const app=express();
const url="https://jsonplaceholder.typicode.com/posts";

app.listen(5000);

app.get('/home',(request,response)=>{
    response.send("hello world home");
})


app.get('/posts',(request,res)=> {
    Request.get(url, (error, response, body) => {
        if (error) {
            return console.dir(error);
        }

        console.dir(JSON.parse(body));
        res.send(JSON.parse(body));
    });

});

