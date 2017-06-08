var myApp = angular
				.module('myApp',['ngRoute','ngAnimate'])				
				.controller("myController",['$scope', '$http', function($scope, $http){
					
					$scope.removeNinja = function(ninja){
						var removeNinja = $scope.ninjas.indexOf(ninja);
						$scope.ninjas.splice(removeNinja,1);
					}
					$scope.addNinja = function(){
						$scope.ninjas.push({
							name: $scope.newninja.name,
							belt: $scope.newninja.belt,
							rate: parseInt($scope.newninja.rate),
							available:true
						});

						$scope.newninja.name = " ";
						$scope.newninja.belt = " ";
						$scope.newninja.rate = " ";
					};

					$scope.removeAll = function(){
						$scope.ninjas = [];
						console.log("reomve");
					};

					$http.get('data/ninja.json').then(function(success){
                                    $scope.ninjas = success.data;

                                },function(error){
                                    console.log(error);
                                });

				}]);
myApp.config(['$routeProvider',function($routeProvider) {
	$routeProvider
	.when('/home',{
		templateUrl:'views/home.html',
		controller: 'myController'
	})
	.when('/contact-success',{
		templateUrl:'views/contact-success.html',
		controller: 'ContactController'		
	})
	.when('/contact',{
		templateUrl:'views/contact.html',
		controller: 'ContactController'		
	})
	.when('/directory' ,{
		templateUrl:'views/directory.html',
		controller: 'myController'
	}).otherwise({
		redirectTo: '/home'
	});
}]);


myApp.directive('randomNinja',[function(){
	return {
		restrict: 'E',
		scope: {
			ninjas: '=',
			title: '='
		},
		templateUrl: 'views/random.html', 
		transclude: true,
		replace: true,
		controller : function($scope){
			$scope.random = Math.floor(Math.random( ) * 4);
		}
	};

}]);

myApp.controller('ContactController', ['$scope','$location', function($scope,$location){
	$scope.sendMessage = function(){
		$location.path('/contact-success');

	};


}]);