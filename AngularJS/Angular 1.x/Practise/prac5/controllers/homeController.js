angular.module('myApp')
.controller('homeController',['$scope','friends',function($scope,friends){
    $scope.title = "HOME";
    $scope.friends = friends;
    $scope.items = ['item1','item2','item3','item4'];
    $scope.selectedValue = "item1";
}]);
