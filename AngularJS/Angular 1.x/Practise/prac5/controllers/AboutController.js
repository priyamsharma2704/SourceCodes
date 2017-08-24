angular.module('myApp')
.controller('aboutController',['$scope',function($scope){
    $scope.title = "AboutController";
    $scope.items = ['about1','about2','about3','about4'];
}]);
