//Create module

var myApp = angular.module("myModule", []);

// Register controller with the module
myApp.controller("myController", function ($scope) {
    var technologies = [
    	{name:"C#",likes : 0, dislikes: 0},
    	{name:"AngularJs#",likes : 0, dislikes: 0},
    	{name:"JAVA",likes : 0, dislikes: 0},
    	{name:"SQL",likes : 0, dislikes: 0}
    ];

    $scope.technologies = technologies;
    $scope.incrementLikes = function(technology){
    	technology.likes++;
    };

    $scope.incrementDislikes = function(technology){
    	technology.dislikes++;
    };
});