// Installed npm packages: jquery underscore request express
// jade shelljs passport http sys lodash async mocha chai sinon
// sinon-chai moment connect validator restify ejs ws co when
// helmet wrench brain mustache should backbone forever debug jsdom

//-----FIND TYPE OF ANY VARIABLE-----
// var a = {"a" : 1};
// console.log(toString.call(a));
// var b = "adadw";
// console.log(toString.call(b));
// var c = [21,23];
// console.log(toString.call(c));



//-------REVERSE A STRING/NUMBER--------------------

//var c = "abcde";
//console.log(c.split("").reverse().join(""));
// var n = 34567;
// n = "" + n;
// console.log(n.split("").reverse().join(""));


//-------LEAP YEAR----------------
// var y = 2000;
// var s = function(y){
//     if(y % 4 === 0 && y % 400 === 0){
//         return ("Leap");
//     }
//     else
//         return("Not Leap");    
//     }
// console.log(s(y));

//------------DELETE A CHAR FROM BETWEEN---------------------

// var s = "Pythnonasd";

// var p1 = s.substr(0,4);
// console.log(p1);
// var p2 = s.substr(5,s.length);
// console.log(p2);
    
// console.log(p1+p2);

//-----------------------JUST REPLACE 1ST AND LAST CHARS-------------------------
// var s = "asdasd";
// var len = s.length;

// if(s.length >=1){
//     //console.log(s[0]);
//     var mid = s.substr(1,len-2);
//     var f = s.substr(len-1);
//     var l = s[0];
// }
// console.log(f+mid+l);


//--------------------WHETHER A STRING CONTAINS JAVA IN STARTING --------------------------
// var s = "Javaasdasd";

// var se = s.substr(0,4);
// if(se === "Java")
//     console.log("Yes");
// else
//     console.log("No");


//---------------PALINDROME---------------------
 
// var s = "dalada";

// var se = s.split("").reverse().join("");
// if(s === se)
//     console.log("Palindrome");
// else
// console.log("Not");


//------------------generates all combinations of a string-----------------

// var s = "abc";
// var se = s;
// var r = [];
// s = s.split("");
// se = se.split("");

// for(var i = 0; i < s.length; i++){
//     r.push(s[i]);
// }

// for(var j = 0; j < s.length; j++){
//     var t = s[j];
//     for(var k =j+1;k <= s.length-1; k++){
//         //var t = s[j]+s[k];
//         t = t+s[k];
//         //console.log(t);
//         r.push(t);
//     }
// }
// console.log(r);


//-----------with letters in alphabetical order-----------------------
// var s = "zxcv";
// s=s.split("");
// s=s.sort();
// console.log(s.join(""));

//----------converts the first letter of each word of the string in upper case-------

// var c = "the cat";
// c = c.split("");
// for(var i =0; i< c.length;i++){
//     if(c[i] == " ")
//         c[i+1] = c[i+1].toUpperCase();
// }
// c[0] = (c[0].toUpperCase());
// c=c.join("");
// console.log(c);


//-------------LENGTH OF LONGEST WORD IN A STRING---------

// var s = "a abc abcd abcde";

// s = s.split(" ");
// console.log(s);
// var max = 0;
// for(var i in s){
//     var r = Math.max(max,s[i].length);
//     var index = i;
// }
// console.log(r);
// console.log(s[index]);


//-------counts the number of vowels within the string------

// var s = "a abc abcd abcde";

// s = s.split("");
// var c = 0;
// for(var i in s){
//     if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
//         c++;
// }
// console.log(c);


//------------------PRIME NUM---------

// var n = 7;
// var f = true;
// if(n % 2 === 0)
//     //console.log("Not Prime");
//     f = false;
// else if(n === 0 || n ===1)
//     ///console.log("Not Prime");
//     f = false;
// else{
//     for(var i = 3; i <n/2; i=i+2){
//         if(n % i == 0){
//             f = false;
//             break;
//         }        
//     }
// }

// if(f === false)
//     console.log("Not Prime");
// else
//     console.log("Prime");


//----------------function which accepts an argument and returns the type----
// var c = true;
// var type = function(c){
//     return typeof(c);
// }

// console.log(type(c));

//-------------find the second lowest and second greatest numbers----------
// var l = [4,6,3,13,64,84,29];

// l = l.sort(function(x,y)
//            {
//            return x-y;
//            });
// console.log(l);
// console.log(l[1]);
// console.log(l[l.length-2]);

//------------------ whether a number is perfect----------
// var number = 6;
// var temp = 0;
//    for(var i=1;i<=number/2;i++)
//      {
//          if(number%i === 0)
//           {
//             temp += i;
//           }
//      }
   
//      if(temp === number && temp !== 0)
//         {
//        console.log("It is a perfect number.");
//         } 
//      else
//         {
//        console.log("It is not a perfect number.");
//         }   



//--------extract unique characters from a string-----------
// var s = "abcda";

// var n = "";
// for(var i = 0; i< s.length; i++){
//     if(!n.includes(s.charAt(i))){
//         n += s.charAt(i);
//     }
// }

// console.log(n);


//------------occurrences of the specified letter within the string --------
// var s = "w3resource.com";
// var c = "e";
// var r = 0;
// for(var i = 0 ; i < s.length; i++){
//     if(s.charAt(i) === c){
//         r++;
//         //break;
//     }
// }

// console.log(r);

//------------- find the first not repeated character-------


// var str = 'abacddbec';
//     for (let ch of str) {
//         if (str.indexOf(ch) === str.lastIndexOf(ch))    
//             //return ch;
//             console.log(ch);
//     }


//------------------FACTORIAL---------
// var n = 3;

// var fact = function(n){
//     if(n == 0 || n ==1)
//         return 1;
//     else
//     {
//         return n * fact(n-1);
//     }
// }

// console.log(fact(5));


//------------- find the most frequent item of an array -------------

// var arr1=[3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
// var obj = {};
// var m = 0;

// for(var i in arr1){
//     if(!obj[arr1[i]])
//         obj[arr1[i]] = 0;
//     obj[arr1[i]] += 1; 
// }

// console.log(obj);

// for(var j in obj){
//     if(obj[j] > m){
//         m = obj[j];
//         var s = j;
//     }
// }

// console.log(m + " " + s);


//-------swap the case of each character----------
// var s = "The Quick Brown Fox";
// s =s.split("");
// //console.log(s);
// for(var i in s){
//     if( s[i].toUpperCase() === s[i])
//     {
//         //console.log(s[i]);
//         s[i] = s[i].toLowerCase();
//     }
//     else
//         s[i] = s[i].toUpperCase();
// }
// s = s.join("");
// console.log(s);

//-------------------remove duplicate items from an array----------

// var s = [1, 2, 2, 4, 5, 4, 7, 8, 7, 3, 6];
// s = s.sort(function(x,y){
//     return x-y;
// });
// var l = [];
// var o = {};
// for(var i in s){
//     if(!o[s[i]])
//         o[s[i]] = 0;
//     o[s[i]] += 1;
// }
// console.log(o);

// for(var j in o){
//     l.push(j);
// }

// console.log(l);


//-------------to merge two arrays and removes all duplicates elements-----
// var a1 = [1, 2, 3];     //    1 2 3
// var a2 = [2, 30, 1,6];  //    1 2 6 30

// a1 = a1.sort();
// a2 = a2.sort();

// var o = {};

// for(var i in a1){
//     if(!o[a1[i]])
//         o[a1[i]] = undefined;
// }

// for(var i in a2){
//     if(!o[a2[i]])
//         o[a2[i]] = undefined;
// }


// console.log(o);

// var r = [];

// for(var j in o){
//     r.push(j);
// }

// console.log(r);


//-------------------SKITTLES CHALLENGE: IFIT----------------------
                //4,1,9
// function skittles(s,b,g){
//     var c = 0;
//     while(b > 0 && g/5 >=1){
//         g = g - 5;
//         b = b -1;
//     }
//     if(g == 0)
//         return 0;
//     if( g < 1)
//         return -1;
    
//     while(s > 0 && g >=1){
//         g = g - 1;
//         s = s -1;
//         c++;
//     }
//     if(g == 0)
//         return c;
//     else 
//         return -1;
    
// }

// console.log(skittles(4,1,7));


//--------OBJECTS-------


// function employees(fname,lname,dept,eid){
//     this.eid = eid;
//     this.fname = fname;
//     this.lname = lname;
//     this.dept = dept;
// }

// var e1 = new employees("abc","def","IT",1);
// var e2 = new employees("sadsa","dfgf","ECE",2);
// var e3 = new employees("qwewq","btwe","CS",3);

// console.log(e1.fname,e2,e3);




// Cal goes from left to write
console.log(4+3+2+'1');
console.log(10 + '20');
console.log(2 + true);
var a = (2, 3, 5);
console.log(a);

















