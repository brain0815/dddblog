angular.module('app', [
	'ngRoute',
	'app.controllers'
]).config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl: 'views/posts.html',
		controller: 'PostsController'
	}).when('/post/:id', {
		templateUrl: 'views/post.html',
		controller: 'SinglePostController'
	}).when('/new', {
		templateUrl: 'views/newpost.html',
		controller: 'NewPostController'
	}).when('/edit/:id', {
		templateUrl: 'views/editpost.html',
		controller: 'EditPostController'
	}).otherwise({
		redirectTo: '/'
	});
}]);