const jwt=require('jsonwebtoken');
const config=require('config');

module.exports=function(req,res,next){
    const token=req.header('x-auth-token');
    if(!token)
        return res.status(401).send('access denied. No token provided');
    try{
        const decoded=jwt.verify(token,'jwtPrivateKey');
        console.log(decoded);
        req.user=decoded;
        next();

    }catch(ex){
        res.status(400).send('invalid token');
    }
}