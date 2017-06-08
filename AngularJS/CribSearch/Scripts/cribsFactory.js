angular
	.module('ngCribs')
	.factory('cribsFactory',function($http){		

        function getCribs(){
        	return $http.get('Data/data.json');
        }

        return{
        	getCribs: getCribs
        }
	});