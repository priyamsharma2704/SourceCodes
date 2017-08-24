module.exports = {
	
	packageInstaller:function(input){
		var inputLines = new Map();
		var installOrder = [];
		var success = true;

		/*
	 	* Function to find dependencies and check for any loops.
	 	*/
		processInput = function(){
		  	inputLines.forEach(function (item, key, mapObj) {  
		    if(!installOrder.includes(key))
		    {
		        var temp = key;
		        var currentDependancies = [];
		        currentDependancies.push(temp);
		        while(inputLines.get(temp) != null)
		        {
		          	var dependancy = inputLines.get(temp);
		          	if(currentDependancies.includes(dependancy))
		          	{
		            	success = false;
		            	break;
		          	}else if(installOrder.includes(dependancy)){
		            	break;
		          	}
		          	else
		          	{
		            	currentDependancies.push(dependancy);
		            	temp = dependancy;
		          	}
		        }
		        if(success){
		          	for(var i = currentDependancies.length-1; i >=0 ;i--)
		          	{
		            	installOrder.push(currentDependancies[i]);
		          	}
		        }
		    }
		  }); 
		}

		/*
	 	* Function to store the given string array into a key value pair mapping.
	 	*/
		packInstaller = function(input){
		  	for( var i in input)
		  	{
		    	var colon = ": ";
		    	var temp = input[i].split(colon);
		    	if(temp[0].length === 0)
      				success = false;
		    	else if(temp[1] === "")
		      		inputLines.set(temp[0], null);
		    	else
		      		inputLines.set(temp[0], temp[1]);
		    }
		  	processInput();
		}

		packInstaller(input);
		if(success)
		{
		  	return installOrder.toString();
		}
		else{
		  	return ("Install Order contains cyclic dependancy");
		}
		
	}
}