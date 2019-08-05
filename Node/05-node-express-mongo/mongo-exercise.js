const mongoose=require('mongoose');

async function run() {
    mongoose.connect('mongodb://localhost/mongo-exercises',{useNewUrlParser:true}).then(function (){
        console.log("connected with mongo...!")
    }).catch(reason => {
        console.log('problem connecting :'+reason);
    })
}


const  courseSchema=new mongoose.Schema({
    tags:[String],
    date:{type:Date,default:Date.now()},
    name:String,
    author:String,
    isPublished:Boolean,
    price:Number
})

const Course=mongoose.model('Course',courseSchema);

async  function  createCourse() {
    const course=new Course({
        author:'Bhuppi',
        tags:['mastering node js','backend'],
        isPublished:true,
        name:'Java Full Stack',
        price:1000
    });
    const result=await course.save();
    console.log(result);
}


async  function getCourse(){

    //const courses=await Course.find();

    /*const courses= await Course
        .find({tags:'backend',isPublished:true})
        .sort({name:1})
        .select({name:1,author:1,_id:0});
    */
    const courses= await Course
        .find({isPublished:true})
        .or([{tags:'backend'},{tags:'frontend'}])
        .sort('-price')
        .select('name author price')

    console.log(courses);
}

//function calling
run().then(function () {
    console.log("Called run method");

}).catch(reason => {
    console.log('problem in connecting:'+reason);
})

getCourse().then(function () {
    console.log('showing result');

}).catch(reason => {
    console.log('some error occured:'+reason);
})
