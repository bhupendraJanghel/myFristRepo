const _=require('lodash');
const {User, validate} = require('../models/user');
const mongoose = require('mongoose');
const express = require('express');
const bcrypt=require('bcrypt');
const router = express.Router();

router.get('/', async (req, res) => {
    const user = await User.find().sort('name');
    res.send(user);
});

router.post('/', async (req, res) => {
    const { error } = validate(req.body);
    if (error)
        return res.status(400).send(error.details[0].message);

     let user= await User.findOne({'email':req.body.email});
        if(user)
            return  res.status(400).send('user already exist');
    const salt = await bcrypt.genSalt(10);
    req.body.password=await bcrypt.hash(req.body.password,salt);
    /*let user = new User({
        name: req.body.name,
        email:req.body.email,
        password:req.body.password
    });*/

    user=new User(_.pick(req.body,['name','email','password']))

    user = await user.save();

    const token=user.generateAuthToken();

    res.header('x-auth-token',token).send(_.pick(user,['_id','name','email']));   //it will avoid sending password
});

module.exports = router;