angular.module('appModule',['ngRoute','authModule','ggoModule','navModule'])
.config(function($routeProvider){
	$routeProvider
	.when('/', {
		template: '<login></login>'
	})
	.when('/register', {
		template: '<register></register>'
	})
	.when('/login', {
		template: '<login></login>'
	})
	.when('/home', {
		template: '<home></home>'
	})
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
})
