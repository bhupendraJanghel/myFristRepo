const mongoose=require('mongoose');

mongoose.connect('mongodb://localhost/playground')
.then(()=>console.log('connected to mongodb...'))
.catch(err=>console.error('could not connect to mongodb...'));

const authorSchema=new mongoose.Schema({
  name:String,
  bio:String,
  website:String
});

const Author=mongoose.model('Author',authorSchema);

const Course=mongoose.model('course',new mongoose.Schema({
    name:String
}));

async function createCourse(name,author) {
    const course = new Course({
        name,
        author
    });
    const result = await course.save();
    console.log('inserted');
}

async  function  listCourse() {
    const  courses=await Course.find();
    console.log(courses);

}

createCourse('bhupii','{}')