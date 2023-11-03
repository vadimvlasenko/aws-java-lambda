const express = require('express');
const app = express();
const sponsorsController = require('./controllers/sponsorsController');
const sponsorController = require('./controllers/sponsorController');

app.use('/sponsors', sponsorsController);
app.use('/sponsors/:id', sponsorController);

module.exports = app;
