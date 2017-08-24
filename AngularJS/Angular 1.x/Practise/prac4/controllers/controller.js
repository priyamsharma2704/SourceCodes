var app = angular
          .module('Demo',['ngRoute'])
          .config(function($routeProvider,$locationProvider){
             $locationProvider.hashPrefix('');
            $routeProvider
            .when('/home',{
              templateUrl:"views/home.html"
            })
            .when('/courses',{
              templateUrl:"views/courses.html"
            })
            .when('/students',{
              templateUrl:"views/students.html"
            })
            
          })
          .controller("myController",function($scope){
            $scope.message = "Home Page";
            $scope.courses = ['c#','java','c++','php'];
          })
