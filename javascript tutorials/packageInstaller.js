//var input = ["Leetmeme: Cyberportal","Cyberportal: Leetmeme"];
var input = ["KittenService: ","Leetmeme: Cyberportal","Cyberportal: Ice","CamelCaser: KittenService","Fraudstream: Leetmeme","Ice: "];
var inputLines = new Map();
var installOrder = [];
var success = true;

processInput = function(){
  document.write(inputLines);
  //document.write(inputLines.size);
  inputLines.forEach(function (item, key, mapObj) {  
    document.write("key = "+key + ", Value = " + item);  
    if(!installOrder.includes(key))
    {
        //document.write("yaas");
        var temp = key;
        var currentDependancies = [];
        currentDependancies.push(temp);
        document.write("temp = "+temp);
        document.write("CD = " + currentDependancies);
        while(inputLines.get(temp) != null)
        {
          document.write("temp's value = "+inputLines.get(temp));
          var dependency = inputLines.get(temp);
          document.write("Dep = " + dependency);
          if(currentDependancies.includes(dependency))
          {
            //document.write("if");
            success = false;
            break;
          }else if(installOrder.includes(dependency)){
            break;
          }
          else
          {
            currentDependancies.push(dependency);
            temp = dependency;
            document.write("new temp = " + temp+ "\n");
          }
        }
        //document.write("cd "+currentDependancies);
        document.write(success);
        if(success){
          for(var i = currentDependancies.length-1; i >=0 ;i--)
          {
            //document.write(currentDependancies[i]);
            installOrder.push(currentDependancies[i]);
          }
          document.write("--------");
          
        }
    }
  }); 
}


packInstaller = function(input){
  for( var i in input){
    //document.write(input[i]);
    var colon = ": ";
    var temp = input[i].split(colon);
    //document.write(temp.length);
    //document.write(temp[0]);
    //document.write(temp[1]);
    //if(temp.length !== 1)
    //  inputLines.set(temp[0], temp[1]);
     if(temp[1] === "")
      inputLines.set(temp[0], null);
    else
      inputLines.set(temp[0], temp[1]);
  }
  //document.write(inputLines);
  processInput();
  //document.write(installOrder);
}
//document.write(inputLines);

packInstaller(input);
if(success)
  document.write(installOrder.toString());
else
  document.write("Install Order contains cyclic dependancy");