/*jshint multistr:true */
var text =  "Blah blah blah blah blah blah priyam \
blah blah blah priyam blah blah priyam blah blah \
blah blah blah blah blah priyam";


var myName = "priyam";
hits = [];

for(var i =0;i < text.length; i++){
    if(text[i] === "p"){
        for(var j = i; j <(myName.length+i);j++ )
        {
            hits.push(text[j]);
        }
    }
}

if(hits.length === 0){
    console.log("Your name wasn't found!");
    
}
else
console.log(hits);