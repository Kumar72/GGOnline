angular.module('authModule')
  .factory('authService', function($http, $cookies) {
    var service = {};

    var saveToken = function(user) {
    	$cookies.put('userId', user.id);
    	$cookies.put('userEmail', user.email);
    }

    service.getToken = function() {
    	return {
    		id: $cookies.get('userId'),
    		email: $cookies.get('userEmail')
    	}
    }

    var removeToken = function() {
    	$cookies.remove('userId');
    	$cookies.remove('userEmail');
    }


    service.login = function(user) {
    	console.log(user);
    	return $http({
    		method: 'POST',
    		url: "api/auth/login",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    		data: user
    	}).then(function(res){
    		saveToken(res.data);
    	})
    }

    service.register = function(user) {
    	console.log(user)
    	return $http({
    		method: 'POST',
    		url: "api/auth/register",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    	data: user
    	}).then(function(res){
    		saveToken(res.data);
    	})
    }

    service.logout = function() {
    	return $http({
    		method: 'PUT',
    		url: "api/auth/logout",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    		data: user
    	}).then(function(res){
    		removeToken(res.data);
    	})
    }

    return service;
  })
