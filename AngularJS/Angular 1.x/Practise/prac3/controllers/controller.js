

var app = angular
          .module('myApp',['ngRoute'])
          .controller("myController",['$scope',function($scope){
  $scope.msg = "priyam";
}])
.config(['$routeProvider',function($routeProvider){
  $routeProvider
  .when('/home',{
    templateUrl:"views/1.html"
  });
}])
