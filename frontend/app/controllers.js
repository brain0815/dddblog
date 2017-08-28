angular.module('app.controllers', [
	'app.directives'
])
	.controller('PostsController', ['$scope', '$http', function($scope, $http){
		$http.get('http://localhost:8080/blogpost/v1').success(function(data){
			$scope.posts = data;
		});
		$scope.deletePost = function(id) {
		    alert("deleting post now");
		    $http.delete('http://localhost:8080/blogpost/v1/'+id)
               .then(
                   function(response){
                        alert('success');
                   },
                   function(response){
                        alert('fail');
                    //add http stats to circuit breaker here
                   }
                );
		};
	}])
	.controller('NewPostController', ['$scope', '$http', function($scope, $http){
	    $scope.tags = new Array();
        $scope.addNewTag = function () {
            var tag = document.getElementById('tag').value.toUpperCase();
            if(tag != "") {
                if($scope.tags.indexOf(tag) == -1){
                    $scope.tags.push(tag); };
                }
            }
        $scope.submitForm = function () {
                alert('Saving Post: '+$scope.newPostForm.title);
            };
        }])
    .controller('EditPostController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams){
        var config = {}

        $http.get('http://localhost:8080/blogpost/v1/'+$routeParams.id).success(function(data){
        			$scope.post = data;
        		});
        $scope.addNewTag = function () {
            // tags are always uppercase
            var tag = document.getElementById('tag').value.toUpperCase();
            if(tag != "") {
                if($scope.post.tags.indexOf(tag) == -1){
                    $scope.post.tags.push(tag); };
                }
            }
            // wrap with circuit breaker
        $scope.submitForm = function () {
            var data = JSON.stringify($scope.post);
            $http.put('http://localhost:8080/blogpost/v1/'+$routeParams.id, data, config)
               .then(
                   function(response){
                        alert('success');
                   },
                   function(response){
                        alert('fail');
                    //add http stats to circuit breaker here
                   }
                );
        };
    }]);