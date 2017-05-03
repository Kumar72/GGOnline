angular.module('appModule',['ggoModule','ngRoute','authModule'])
.config(function($routeProvider){
	$routeProvider
	.when('/', {
		template: ''
	})
	.when('/', {
		template: '<></>'
	})
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
})
