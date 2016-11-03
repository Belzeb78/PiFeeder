"use strict";

/*
 * License CC-BY-NC-4.0 PiFeeder by Loic Vaugeois
 */

var app = angular.module('pifeeder.app', [ 'ngResource', 'ngRoute' ]);

// ============================== APPLICATION ==============================

app.config(function($routeProvider, $locationProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'view/home.html',
		controller : 'HomeController'
	});
	$routeProvider.otherwise({
		redirectTo : '/'
	});

}).run(function($rootScope) {

	/* Reset error when a new view is loaded */
	$rootScope.$on('$viewContentLoaded', function() {
		delete $rootScope.error;
	});

	$rootScope.deleteError = function() {
		delete $rootScope.error;
	}

	$rootScope.initialized = true;
});

// ============================== RESOURCES ==============================

app.factory('FeedRest', [ '$resource', function($resource) {
	return $resource('rest/feed/:action', {}, {
		process : {
			method : 'POST',
			headers: [{'Content-Type': 'application/json'}], 
			params : {
				'action' : 'process'
			}
		}
	})
} ]);

// ============================== CONTROLLERS ==============================
app.controller('HomeController', [ '$scope', 'FeedRest',
		function($scope, FeedRest) {
			console.log('HomeController!!');
						
			$scope.feeding ={
					nbRepetitions:3,
					tempsPause:400,
					angleMinimum:75,
					angleMaximum:195			
			}
			
			$scope.feed = function() {
				console.log('FEED!!');
				FeedRest.process($scope.feeding);
			}
		} ]);

app.directive('correctNumber', function() {
	return {
		require : 'ngModel',
		link : function(scope, elem, attrs, ctrl) {
			elem.on('blur', function() {
				var value = elem.val();
				if (value < attrs.min) {
					value = attrs.min;
				}
				if (value > attrs.max) {
					value = attrs.max;
				}
				elem.val(value);
			});
		}
	};
});

$(function() {
	$('.ui.dropdown').dropdown();
});
