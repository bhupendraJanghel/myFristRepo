//1. look for in the same folder
//2. look into for global/default modules
//3. node_modules directory
const _=require('underscore');

let result=_.contains([1,2,3,4],3);
console.log(result)

let even=_.filter([1,2,3,4,5,6],function (num) {
    return num%2==0;

})
console.log(even)


//-------------------------------------------------------------------------



const http=require('http')
const app=http.createServer((req,res)=>{
    if(req.url==='/')
    {
        res.write("hello world");
        res.end();
    }
});
const port=process.env.port || 3000;

app.listen(port);
app.on("connection", function (){
    console.log('server started on port:',port);
})