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
	.when('/setting', {
		template: '<setting></setting>'
	})
	.when('/home', {
		template: '<home></home>'
	})
	.when('/notification', {
		template: '<notification></notification>'
	})
	.when('/team', {
		template: '<team></team>'
	})
	.when('/game', {
		template: '<game></game>'
	})
	.when('/social', {
		template: '<social></social>'
	})
	.when('/player', {
		template: '<player></player>'
	})
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
})
