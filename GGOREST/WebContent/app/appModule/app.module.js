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
	.when('/team', {
		template: '<team></team>'
	})
	.when('/inbox', {
		template: '<inbox></inbox>'
	})
	.when('/setting', {
		template: '<setting></setting>'
	})
	.when('/game', {
		template: '<game></game>'
	})
	
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
})
