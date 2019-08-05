// const logger=require('./log')
//
// logger("ibmer");


//some os funciton
// const os=require('os');
// console.log("total memory :",os.totalmem());
// console.log("free memory",os.freemem());
// console.log("host name",os.hostname);
// console.log("directory",os.homedir());



//creating events


const EventEmitter=require('events')

const Logger=require('./log');
const  event =new Logger();

event.addListener('messageLogged',()=>{
    console.log("hey i have listen you");
});
// console.log('emitting an event:messageLogged');
// event.emit("messageLogged");

event.log('a');

