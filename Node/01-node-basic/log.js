//another way of event emitter

const  EventEmitter=require('events');
class Logger  extends EventEmitter{

    log(message)
    {
        console.log(message);
        console.log('emitting event')
        this.emit('messageLogged')
    }
}
module.exports=Logger;
