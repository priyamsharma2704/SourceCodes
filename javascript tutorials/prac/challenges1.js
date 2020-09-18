// var a = "abcba";

// a = a.split("").reverse().join("");
// // console.log(a);


// var a = "bean";

// a1 = a.substring(0,2);
// a2 = a.substring(2, a.lengthj);

// // console.log(a1)
// // console.log(a2)


// a = "gmadb";
// l = a.length;

// if( l > 1)
// {
// 	mid = a.substring(1, a.length-1)
// 	f = a.substring(a.length-1)
// 	l = a[0]
// }

// // console.log(f + mid+l)

// a = "sasa";


// a2 = a.split("").reverse().join("");
// if(a ==a2)
//  console.log("Palin")
// else
// 	console.log("not")


// var s = "a abc abcd abcde";

// s = s.split(" ");
// m = 0;
// for(i in s)
// {
// 	max = Math.max(m, s[i].length)
// 	if(max > m)
// 		m = max;
// }

// // console.log(m);


// var s = "w3resource.com"
// console.log(s.indexOf("u"))
// console.log(s.lastIndexOf("u"))


// 	x = -321
//     x= x.toString();
    
//     x = x.split("").reverse().join("");
//     x = parseInt(x);
//     if(x < 0)
//         console.log("asd");
//     else
//        console.log(x);


// var c = "abcde";
// var x = c.split("").reverse().join("");
// console.log(x);

var str = "abcde";
// var char = "c";
// function delFromMiddle(str, char)
// {
//     var index = str.indexOf(char);

//     if (index)
//     {
//         var s1 = str.substr(0, index);
//         var s2 = str.substr(index+1, str.length);
//         console.log(s1+s2);
//         //console.log(s2);
//         }
// }

// delFromMiddle(str, char);


// var first = str.substr(0, 1);
// var last = str.substr(str.length - 1);
// var mid = str.substr(1, str.length - 2);
// console.log(last + mid + first);


// var palin = "daallaada";
// var flag = true;
// for (var i = 0; i < palin.length/2; i++)
// {
//     if (palin[i] != palin[palin.length - i - 1])
//     {
//         flag = false;
//     }
// }
// flag == true ? console.log("palin") : console.log("not palin");

function outer(name1)
{
     return function inner(name2)
    {
        console.log(name1);
        console.log(name2);
    }
}

var y = outer("abc");
y("xyz")