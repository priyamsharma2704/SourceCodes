(function(){
	angular
		.module('quizApp')
		.controller('quizController', quizController);

		quizController.$inject = ['quizMetrics','dataService'];

		function quizController(quizMetrics,dataService){
			var vm = this;
			var numQuestionAnswered = 0;
			vm.quizMetrics = quizMetrics;
			vm.dataService = dataService;
			vm.activeQuestion = 0;
			vm.questionAnswered = questionAnswered;			
			vm.setActiveQuestion = setActiveQuestion;
			vm.selectAnswer = selectAnswer;
			vm.finaliseAnswers = finaliseAnswers;
			vm.error = false;
			vm.finalise = false;

			function finaliseAnswers(){
				vm.finalise = false;
				numQuestionAnswered = 0;
				vm.activeQuestion = 0;
				quizMetrics.markQuiz();
				quizMetrics.changeState('quiz', false);
				quizMetrics.changeState('results', true);
			}

			function selectAnswer(index){
				dataService.quizQuestions[vm.activeQuestion].selected = index;
			}

			function setActiveQuestion(index){
				if(index === undefined){
					var breakOut = false;
					var quizLength = dataService.quizQuestions.length - 1;
					//vm.activeQuestion++;
					while(!breakOut){
						vm.activeQuestion = vm.activeQuestion < quizLength? ++vm.activeQuestion : 0;
						if(vm.activeQuestion === 0){
							vm.error = true;
						}
						if(dataService.quizQuestions[vm.activeQuestion].selected === null){
							breakOut = true;
						}
					}

				}
				else{
					vm.activeQuestion = index;
				}
				
			}
			function questionAnswered(){
				var quizLength = dataService.quizQuestions.length;
				if(dataService.quizQuestions[vm.activeQuestion].selected !== null){
					numQuestionAnswered++;
					if(numQuestionAnswered >= quizLength){
						for (var i = 0; i >= quizLength; i++) {
							if(dataService.quizQuestions[i].selected ===null){
								setActiveQuestion(i);
								return;
							}
						}
						vm.error = false;
						vm.finalise = true;
						return;
					}
				}
				vm.setActiveQuestion();
			}
		}	
})();