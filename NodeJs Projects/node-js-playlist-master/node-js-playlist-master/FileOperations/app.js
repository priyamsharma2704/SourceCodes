var fs = require('fs');


//---Synchronos Read
var readData = fs.readFileSync('file.txt','utf8');
console.log(readData);

//---Synchronos Read
fs.writeFileSync("writeMe.txt",readData);




//---Asynchronos read will carry out the next operation while reading the content of the file.

//---Asynchronos read
fs.readFile('file.txt','utf8',function(err,data){
	console.log(data);
	//---Asynchronos write
	fs.writeFile("write Async.txt",data);
});

console.log("After async read operation, but excuted before. ")


//-----To delete any file
//fs.unlink("writeMe.txt");
