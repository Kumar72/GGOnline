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
      // TODO : Remove both the id and email cookies
    }


    service.login = function(user) {
    	return $http({
    		method: GET,
    		url: "rest/auth/login",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    		data: user
    	}).then(function(res){
    		saveToken(res.data);
    	})
      // TODO : Use the auth/login route to authenticate the user
      // On success, use saveToken to store the users id/email
    }

    service.register = function(user) {
    	return $http({
    		method: POST,
    		url: "rest/auth/register",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    	data: user
    	}).then(function(res){
    		saveToken(res.data);
    	})

      // TODO : Use the auth/register route to create and authenticate the user
      // On success, use saveToken to store the users id/email
    }

    service.logout = function() {
    	return $http({
    		method: PUT,
    		url: "rest/auth/logout",
    		headers: {
    			'Content-Type': 'application/json'
    		},
    		data: user
    	}).then(function(res){
    		removeToken(res.data);
    	})
      // TODO : Use the auth/logout route to remove the users session
      // On success, use removeToken to remove the id and email cookies
    }

    return service;
  })
