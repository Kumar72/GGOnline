angular.module('appModule',['ngRoute','authModule','ggoModule','navModule','gameListModule'])
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
	.when('/stats', {
		template: '<stats></stats>'
	})
	.when('/inbox', {
		template: '<inbox></inbox>'
	})
	.when('/setting', {
		template: '<setting></setting>'
	})
	.when('/test', {
		template: '<test></test>'
	})
	
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
})
