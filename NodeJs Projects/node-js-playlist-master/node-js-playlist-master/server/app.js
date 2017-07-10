var http = require('http');
var fs = require('fs');


var server = http.createServer(function(req,res){
	res.writeHead(200,{'Content-Type':'text/plain'});
	var myReadStream = fs.createReadStream(__dirname+ '/readMe.txt','utf8');
	myReadStream.pipe(res);
	//res.end('Hey ninjas');
});

//---serving HTML pages
var server = http.createServer(function(req,res){
	res.writeHead(200,{'Content-Type':'text/html'});
	var myReadStream = fs.createReadStream(__dirname+ '/index.html','utf8');
	myReadStream.pipe(res);
	//res.end('Hey ninjas');
});

//---serving JSON
var server = http.createServer(function(req,res){
	res.writeHead(200,{'Content-Type':'application/json'});
	var myObj = {
		name:"priyam",
		age:27,
		address:"dayon, ohio"
	};
	res.end(JSON.stringify(myObj));
});


server.listen(3000,'127.0.0.1');
console.log('yooo');