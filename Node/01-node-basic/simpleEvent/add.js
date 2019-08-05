const EventEmitter=require('events')

const event=new EventEmitter();

function add(a,b){
    event.emit('add');
}

module.exports=add;