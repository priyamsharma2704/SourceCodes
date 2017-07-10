var express = require('express');
var app = express();

app.get('/',function(req,res){
	//res.send("this is response on home");
	res.sendFile(__dirname+'/index.html');
});

app.get('/contact',function(req,res){
	//res.send("this is contact page");
	res.sendFile(__dirname + '/contact.html');
});


app.get('/profile/:id',function(req,res){
	res.send("id = " + req.params.id);
});


app.listen(3000);

