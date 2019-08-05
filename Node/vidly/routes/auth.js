const mongoose = require('mongoose');
const express = require('express');
const router = express.Router();
const {User, validate} = require('../models/user');

router.post('/',async (req,res)=>{

    const user=await User.findOne({$and:[{'email':req.body.email},{'password':req.body.password}]});

    console.log(user)
    if(user)
        return res.send('authorized');


        res.send('not Authorized');
})

module.exports=router;