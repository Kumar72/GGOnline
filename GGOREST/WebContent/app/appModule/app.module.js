angular.module('appModule',['ggoModule','ngRoute','authModule'])
.config(function($routeProvider){
	$routeProvider
	.when('/', {
		template: ''
	})
	.when('/register', {
		template: '<register></register>'
	})
	.when('/login', {
		template: '<login></login>'
	})
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
})
