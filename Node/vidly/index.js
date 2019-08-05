const Joi = require('joi');
Joi.objectId = require('joi-objectid')(Joi);
const mongoose = require('mongoose');
const genres = require('./routes/genres');
const customers = require('./routes/customers');
const movies = require('./routes/movies');
const rentals = require('./routes/rentals');
const users=require('./routes/users');
const auth=require('./routes/auth')
const config=require('config')
const bcrypt=require('bcrypt')
const express = require('express');
const app = express();
const cors = require('cors')

if(!config.get('PORT'))
{
    console.log('FATAL ERROR SET PORT FIRST');
    process.exit(1);
}
mongoose.connect('mongodb://localhost/vidly')
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...'));

var corsOptions = {
    origin: 'http://localhost:4200/',
    optionsSuccessStatus: 200 // some legacy browsers (IE11, various SmartTVs) choke on 204
}
app.use(express.json())

app.use('/api/genres', genres);
app.use('/api/customers', customers);
app.use('/api/movies', movies);
app.use('/api/rentals', rentals);
app.use('/api/users',users);
app.use('/api/auth',auth)
app.use(cors(corsOptions));
const PORT = config.get('PORT') || 3000;
app.listen(PORT, () => console.log(`Listening on port ${PORT}...`));