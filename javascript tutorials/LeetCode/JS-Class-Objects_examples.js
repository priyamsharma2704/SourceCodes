//Literal Object - object created using 'var'
var human = {
    name: "priyam",
    place:"pittsburgh",
    country:"USA",
    getDetails: function()
    {
        console.log(this.name, this.place, this.country);
    }
}
    
var h = human;
h.getDetails();
//console.log(h.name);
human.getDetails();

//constructor function -object created using a function.
function Car(make, model, year)
{
    this.make = make;
    this.model = model;
    this.year = year;

    this.details = function()
    {
        console.log(this.make, this.model, this.year);
    }
    this.sample = sampleFunc;
}

function sampleFunc()
{
    console.log("this is sample function");
}
var c1 = new Car("honda", "civic", 2017);
c1.details();
c1.sample();


//-------------------------------------------------------------------
function Student(name, className, score)
{
    this.name = name;
    this.className = className;
    this.score = score;
    this.perc;

    this.percentage = calcPerc;
    this.details = showDetails;
}

function calcPerc()
{
    this.perc = (this.score/600)*100;
}

function showDetails()
{
    console.log(this.name, this.className, this.perc);
}

var st = new Student("Priyam", "12th", 599);
st.percentage();
st.details();

var st2 = new Student("Akhilesh", "11th", 300);
st2.percentage();
st2.details();

//Add another property to an object
Student.prototype.home = "";
st.home = "USA";
//console.log(st);
//console.log(st2);

//-----------------------------------------------------------
function student(name,sclass,rollno)
{
    this.name = name;
    this.sclass = sclass;
    this.rollno = rollno;
    this.changeName = changeName;
};

function changeName(newName)
{
    this.name = newName;
}

var s = new student("Priyam", "Computer Science", 123);
console.log(s);
delete s.rollno;
console.log(s);
s.changeName("Salman Khan");
console.log(s);

//--------------------------------------------------

let temp = function() {
    this.a=1;
    this.b=2;
}

let t = new temp();

temp.prototype.c = 3;
temp.prototype.d = 4;
console.log(t.c)
console.log(t.d);


//-------------------------------------------

function emp(name, score)
{
    this.name = name;
    this.score = score;

    this.print = printDetails;
}

function printDetails()
{
    console.log(this.name , this.score);
}

var s1 = new emp("priyam", 324);
s1.print();

emp.prototype.country = "USA";

console.log(s1.country);

s1.country = "India";
console.log(s1);







