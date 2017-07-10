var http = require('http');
var fs = require('fs');

//---writable stream to write data to file.
var myWriteStream = fs.createWriteStream(__dirname + '/writeMe.txt');

//---Readable streams to read data from file
var myReadStream = fs.createReadStream(__dirname+ '/readMe.txt','utf8');
/*myReadStream.on('data',function(chunk){
	console.log('new chunk');
	console.log(chunk);
	myWriteStream.write(chunk);//write the read data in chunk into 'WriteMe.txt'
});*/

//---using pipe stream concept
myReadStream.pipe(myWriteStream);


