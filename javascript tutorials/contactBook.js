var friends = {
    bill:{
        firstName:"Bill",
        lastName: "Gates",
        number: 1234,
        address: ["121","aaa drive","USA"]
        
        },
    steve:{
        firstName:"Steve",
        lastName: "Jobs",
        number: 5678,
        address: ["534","zzz drive","UAE"]
        }
    
    };
    
function list(friends){
    for(var x in friends)
        console.log(x);
        
}

list(friends);

function search(name){
    for(var x in friends)
    {
        if(friends[x].firstName === name)    
            console.log(friends[x]);
            return friends[x];
    }
}


