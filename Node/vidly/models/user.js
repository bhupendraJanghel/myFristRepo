const Joi = require('joi');
const mongoose = require('mongoose');
const jwt=require('jsonwebtoken');
const userSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: 5,
        maxlength: 50
    },
    email:{
        type:String,
        required: true,
        minlength: 5,
        maxLength:255
    },
    password:{
        type:String,
        required: true,
        minlength: 5,
        maxLength:1024
    }
});

userSchema.methods.generateAuthToken=function(){
    const token=jwt.sign({_id:this._id},'jwtPrivateKey');
    return token;
}

const User = mongoose.model('User',userSchema);

function validateUser(user) {
    const schema = {
        name: Joi.string().min(3).max(50).required(),
        email:Joi.string().min(3).max(50).required().email(),
        password:Joi.string().min(3).max(255).required()
    };

    return Joi.validate(user, schema);
}

exports.userSchema = userSchema;
exports.User = User;
exports.validate = validateUser;