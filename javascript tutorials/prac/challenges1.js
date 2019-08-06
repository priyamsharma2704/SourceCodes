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


var s = "a abc abcd abcde";

s = s.split(" ");
m = 0;
for(i in s)
{
	max = Math.max(m, s[i].length)
	if(max > m)
		m = max;
}

// console.log(m);


var s = "w3resource.com"
console.log(s.indexOf("u"))
console.log(s.lastIndexOf("u"))


	x = -321
    x= x.toString();
    
    x = x.split("").reverse().join("");
    x = parseInt(x);
    if(x < 0)
        console.log("asd");
    else
       console.log(x);
