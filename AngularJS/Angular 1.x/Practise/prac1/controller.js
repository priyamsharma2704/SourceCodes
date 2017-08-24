

var app = angular.module('myApp',['ngRoute']);
app.controller('myController',['$scope',function($scope){
  $scope.msg ="priyam";
}]);

app.config(['$routeProvider',function($routeProvider){
  $routeProvider
  .when('/home',{
    templateUrl: "views/1.html"
  })
  .when('/directory',{
    templateUrl: "views/2.html"
  })
  .otherwise({
    redirectTo:"/home"
  });

}]);
