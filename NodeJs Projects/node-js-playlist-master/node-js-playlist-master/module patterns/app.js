var greet = function(arr){
	return ("length = " + arr.length);
}

var add = function(a,b){
	return (a+b);
}

var pi = function(){
	return (3.14);
}

module.exports.greet = greet;
module.exports.add = add;
module.exports.pi = pi;