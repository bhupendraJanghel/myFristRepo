const express = require('express');
const courses=require('../courses')
const router=express.Router();


module.exports=router;
//display all the courses...

router.get('/',function (request,response) {
    response.send(courses);
})


//display courses by id
router.get('/:id',function (request,response) {

    const course=courses.find((value => value.id===parseInt(request.params.id)));
    if(!course){
        response.status(400).send('no course found');
    }


    response.send(course);
});
router.get('/readme',(request,response)=>{

})


//this will add course
router.post('/',function (request,response) {

    const schema=Joi.object().keys({
        name:Joi.string().min(3).required(),
        amount:Joi.number().integer().min(500).required(),
        email: Joi.string().email({ minDomainSegments: 2 })
    });
    const result=Joi.validate(request.body,schema)

    if(result.error)
    {
        response.status(400).send("Invalid name...!!!")
    }
    else {
        const course = {
            id: courses.length + 1,
            name: request.body.name,
            amount:request.body.amount,
            email:request.body.email
        }

        courses.push(course)
        response.send(course);
    }
})


router.delete('/:id',function (request,response) {

    var course=courses.find(value => value.id==parseInt(request.params.id));

    if(!course) {
        response.status(400).send("not found");
    }
    const  index=courses.indexOf(course);
    courses.splice(index,1);
    response.send("deleted successfully");


})


//it will update the course
router.put('/:id',function (request,response) {
    const course=courses.find((value => value.id===parseInt(request.params.id)))
    if(!course)
    {
        response.status(404).send("no course found with th given id");
    }
    const schema={
        name:Joi.string().min(3).required()
    };
    const result=Joi.validate(request.body.name,schema);
    if(result.error)
    {
        response.status(400).send('invalid name');
    }
    course.name=request.body.name;
    response.send(course);
});
