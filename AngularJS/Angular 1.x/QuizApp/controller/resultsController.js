(function(){
	angular
		.module('quizApp')
		.controller('resultsController', resultsController);

		resultsController.$inject = ['quizMetrics','dataService'];

		function resultsController(quizMetrics, dataService){
			var vm = this;
			vm.quizMetrics = quizMetrics;
			vm.dataService = dataService;
			vm.getAnswerClass = getAnswerClass;
			vm.setActiveQuestion = setActiveQuestion; 
			vm.reset = reset;
			vm.calculatePerc = calculatePerc;
			vm.activeQuestion = 0;
			

			function reset(){
				quizMetrics.changeState('results', false);
				quizMetrics.numCorrect = 0;

				for(var i = 0; i < dataService.quizQuestions.length;i++){
					var data = dataService.quizQuestions[i];
					data.selected = null;
					data.correct = null;   
				}
			}

			function calculatePerc(){
				return quizMetrics.numCorrect / dataService.quizQuestions.length * 100;
			}
			
			function setActiveQuestion(index){
				vm .activeQuestion = index;
			}
			
			function getAnswerClass(index){
				if(index === quizMetrics.correctAnswers[vm.activeQuestion]){
					return "bg-success";
				}
				else if(index === dataService.quizQuestions[vm.activeQuestion].selected){
					return 'bg-danger';
				}
			}
		}

})();