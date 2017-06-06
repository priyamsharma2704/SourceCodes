confirm("I am totally ready to play! =)");

var age = prompt("How old are you?");

if (age < 13) {
    console.log("Uh wow. Too young to play this game! However, you may continue - but our company takes no responsibility, under no circumstances.");
} else {
    console.log("Well well well! Get ready to ruuumbleee!");
};

console.log("You are at a Justin Bieber concert, and you hear this lyric 'Lace my shoes off, start racing.'");
var userAnswer = prompt("do you want to race?");
if(userAnswer === 'yes')
{
    console.log("You and Bieber start racing. It's neck and neck! You win by a shoelace!");    
}
else{
    console.log("Oh no! Bieber shakes his head and sings 'I set a pace, so I can race without pacing.");
}

var feedback = prompt("Please give feedback");
if(feedback.length > 8){
    console.log("Thank you! We should race at the next concert!");
}

else{
    console.log("I'll keep practicing coding and racing.");
}

