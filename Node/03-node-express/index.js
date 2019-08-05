const Joi=require('joi')
const express = require('express');
const app=express();
// const morgan=require('morgan')//http request logger middleware for node.js
const pug=require('pug');
const router=require('./router/courses')
app.use(express.json())
app.use(express.static('public'));
app.set('view engine','pug');


app.use('/api/course',router)

const port = process.env.PORT || 3000;      //in console :set PORT=5000

app.get('/',(request,response)=>{
    response.render('hello',{title:'welcome to node!',message:'we will implement pub'});
})
app.listen(port,function () {
    console.log('server listening on  port:'+port);

});

