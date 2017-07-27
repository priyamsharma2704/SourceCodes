var express = require('express');
var mongoose = require('mongoose');
var bodyparser = require('body-parser');
var cors = require('cors');
var path = require('path');

var app = express();

const port = 3000;
const route = require("./routes/route");

//connect to mongoDB
mongoose.connect('mongodb://localhost:27017/contactlist');
mongoose.connection.on('connected',()=>{
	console.log('connected to database @ 27017');
})
mongoose.connection.on('error',(err)=>{
	if(err){
		console.log('error in connection:' + err);
	}
})

//cors
app.use(cors());
//body-parser
app.use(bodyparser.json());
//add routs
app.use('/api',route); 
//static files
app.use(express.static(path.join(__dirname,'public')));
//testing server
app.get('/',(req,res)=>{
	res.send('foobar');
});

app.listen(port,function(){
	console.log('server started at port : ' + port);
});