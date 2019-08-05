const mongoose=require('mongoose');

async function run(){
    mongoose.connect('mongodb://localhost/playground',
        {useNewUrlParser:true}).then(function () {
        console.log('connected with mongo...!');

    }).catch(reason =>{
        console.log('problem Connecting:'+reason);
    })

}
//step-2 create schema            //schema is a blueprint
const coursesSchema=new mongoose.Schema({
    author:String,
    tags:[String],
    date:{type:Date,default:Date.now()},
    isPublished:Boolean
});
//step-3 create model
const Course=mongoose.model('Course',coursesSchema)

//step-4 save it to database
async function  getCourse() {
    const courses=await Course.find({author:'Bhuppi'}).limit(10).sort({author:1});
    console.log(courses)
}

async  function  createCourse() {
    const course=new Course({
        author:'Bhuppi',
        tags:['mastering node js','backend'],
        isPublished:true
    });
    const result=await course.save();
    console.log(result);
}

//step-5

run().then(function () {
    console.log('called run Successfully');
}).catch(reason => {
    console.error(reason);
});

getCourse().then(function () {
    console.log('Courses:')
}).catch(reason => {
    console.error(reason);
});

