
angular.module("ggoModule").component("social", {
	templateUrl : 'app/ggoModule/social/social.component.html',
	controller : function(ggoService, $location, $scope, authService) {
		var vm = this;
		vm.messages = [];
		vm.friends =[];
		vm.showMessageForm = false;
		

		vm.reload = function(){
			ggoService.messageIndex().then(function(res){
				vm.messages = res.data;				
			})
		}
		
		 vm.newMessage = function(message) {
				ggoService.createMessage(message).then(function(res){
					
		        		vm.messages = res.data;
		    	   
				})
			 }
		 
		 vm.newRecipient = function(friend){
			 ggoService.newRecipient(friend).then(function(res){
				 vm.friend = res.data;
				 console.log(friend)
			 })
		 }
		 
		 
		 vm.displayForm = function() {
	    		vm.showMessageForm = true;
	    	}
		 
		 vm.messageNotification = function() {
	    		return vm.messages.length;
	    	}
		 
	},
	controllerAs: 'vm'
});


