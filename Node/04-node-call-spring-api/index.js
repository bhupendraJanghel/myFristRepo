const apirequest=require('request')
const express=require('express');
const app=express();

const port=5000;
app.listen(port,()=>{
    console.log("server is running on port:"+port);
});

const url="http://localhost:8080/spring-rest-demo-crud/api/customers"
app.get('/customers',(req,res)=> {
    apirequest.get(url, (error, response, body) => {
        if (error)
            return console.dir(error)
        console.dir(JSON.parse(body));
        res.send(JSON.parse(body));
    });
});
app.get('/customers/:id',(req,res)=> {
    apirequest.get(url, (error, response, body) => {
        if (error)
            return console.dir(error)

        const customer=co
        console.dir(JSON.parse(body));
        res.send(JSON.parse(body));
    });
});
