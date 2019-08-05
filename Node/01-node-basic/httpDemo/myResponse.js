const http=require('http');

//----------------------------------------------------------
/*const server=http.createServer();
server.on("connection", function (){
    console.log("server created and ready");
});
server.listen(3000);
*/
//-----------------------------------------------------------



const student={
    id:10,
    name:"bhuppi",
    address:"bangalore"
};
const event={
    name:"BirthDAy Event",
    personInvited:['hems','arindam','sayan'],
    greetInvite(){
        this.personInvited.forEach((guest)=>{
            console.log(guest+" is attending "+this.name);
        })
    }
}

const server=http.createServer(function (request,response) {

    server.on("connection", function (socket) {
        console.log("some event fired...");
    })
    if(request.url===('/')){

     event.greetInvite()
        response.write("hello world");
        response.end();

    }
});
server.listen(3000);

