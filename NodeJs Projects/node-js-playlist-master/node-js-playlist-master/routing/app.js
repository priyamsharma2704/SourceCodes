var http = require('http');
var fs = require('fs');


var server = http.createServer(function(req,res){
	if(req.url === '/home' || req.url === '/'){
		res.writeHead(200,{'Content-Type':'text/html'});
		fs.createReadStream(__dirname+ '/index.html').pipe(res);
	}
	else if(req.url === '/contact'){
		res.writeHead(200,{'Content-Type':'text/html'});
		fs.createReadStream(__dirname+ '/contact.html').pipe(res);
	}
	else if(req.url === '/api/ninja'){
		var ninja = [{name:'priyam',age:27,address:'dayton, ohio'}];
		res.writeHead(200,{'Content-Type':'application/json'});
		res.end(JSON.stringify(ninja));
	}
	else{
		res.writeHead(404,{'Content-Type':'text/html'});
		fs.createReadStream(__dirname+ '/404NotFound.html').pipe(res);
	}
});

server.listen(3000,'127.0.0.1');
console.log('yooo');