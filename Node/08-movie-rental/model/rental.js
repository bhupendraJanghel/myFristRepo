const Joi=require('joi');
const mongoose=require('mongoose');

const Rental=mongoose.model('Rental',new mongoose.Schema({
    customer:{
        type:new mongoose.Schema({
            name:{
                type:String,
                require:true,
                minLength:5,
                maxLength:50
            },
            isGold:{
                type: Boolean,
                default:false
            },
            phone:{
                type:String,
                required:true,
                minLength:5,
                maxLength: 50
            }

        }),
        required:true
    },
    dateOut:{
        type:Date,
        required:true,
        default:Date.now
    },
    dateReturned:{
        type:Date
    },
    rentalFee:{
        type:Number,
        min:0
    }
}));

function validateRental(rental){
    const schema={
        customerId:Joi.string().required(),
        movieId:Joi.string().required()
    };
    return Joi.validate(rental,schema);
}


exports.Rental=Rental;