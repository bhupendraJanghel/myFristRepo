const express=require('express');
const router=express.Router();
const mongoose=require('mongoose');

const  courseSchema=new mongoose.Schema({
    tags:[String],
    date:{type:Date,default:Date.now()},
    name:String,
    author:String,
    isPublished:Boolean,
    price:Number
})

const Course=mongoose.model('Course',courseSchema);

router.get('/',async (req,res)=>{

    const course=await Course.find();
    res.send(course);
})
router.post('/', async (req, res) => {
    /*const { error } = validateGenre(req.body);
    if (error) return res.status(400).send(error.details[0].message);
*/
    let course = new Course({ name: req.body.name ,
        tags:req.body.tags,
        author:req.body.author,
        isPublished:req.body.isPublished,
        price:req.body.price
    });
    course = await course.save();

    res.send(course);
});

router.put('/:id', async (req, res) => {
  /*  const { error } = validateGenre(req.body);
    if (error) return res.status(400).send(error.details[0].message);*/

    const course = await Course.findByIdAndUpdate(req.params._id, { name: req.body.name,
        tags:[String],
        author:req.body.author,
        isPublished:req.body.isPublished,
        price:req.body.price }, {
        new: true
    });

    if (!course) return res.status(404).send('The Course with the given ID was not found.');

    res.send(course);
});

router.delete('/:id', async (req, res) => {
    const course = await Course.findByIdAndRemove(req.params.id);

    if (!course)
        return res.status(404).send('The course with the given ID was not found..not deleted');
    res.send(course);
});

router.get('/:id', async (req, res) => {
    const course = await Course.findById({_id: req.params.id});

    if (!course) return res.status(404).send('The course with the given ID was not found.');

    res.send(course);
});

module.exports=router;