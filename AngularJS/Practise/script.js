var myApp = angular
				.module('myApp', [])
				.controller('myController', ['$scope','$http', function($scope,$http){
					$scope.message = "hello";
					$scope.sortList ='name';
					$scope.people = [
						{
							name: "aaa",
							city: "delhi",
							age:50
						},
						{
							name: "ggg",
							city: "bombay",
							age:34
						},
						{
							name: "pwe",
							city: "bangalore",
							age:45
						},
						{
							name: "www",
							city: "pune",
							age:23
						},

					];
					$scope.countries = [
						{
							name:"USA",
							cities:[
								{name: "New York"},
								{name: "Cali"},
								{name: "Florida"},
							]
						},
						{
							name:"EU",
							cities:[
								{name: "London"},
								{name: "Birmingham"},
								{name: "Switz"},
							]
						},
						{
							name:"India",
							cities:[
								{name: "New delhi"},
								{name: "Pune"},
								{name: "Punjab"},
							]
						}
					];
					
					$http.get('people.json').then(function(success){
						$scope.personData = success.data;
					});

				}])