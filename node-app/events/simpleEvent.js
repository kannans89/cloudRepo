var EventEmitter=require('events');
let emitter=new EventEmitter();
emitter.on('log',function(obj){
    console.log("on 1: "+obj.id+" "+obj.msg);
});
emitter.on('log',function(obj){
    console.log("on 2: "+obj.id+" "+obj.msg);
});
emitter.emit('log',{id:101,msg:'hello'});