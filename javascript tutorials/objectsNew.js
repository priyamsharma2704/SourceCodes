students = [];
function student(fname,lname,age){
	this.fname = fname;
	this.lname = lname;
	this.age = age;

	 this.greeting = function(){
		console.log("Welcome " + this.fname + " " + this.lname + ".");
	}
}

students.push(new student("priyam","sharma",27));
students.push(new student("shubham","sharma",23));
students.push(new student("ravi","sharma",25));


for(var i = 0; i < students.length; i++){
	console.log(students[i].greeting());
}

