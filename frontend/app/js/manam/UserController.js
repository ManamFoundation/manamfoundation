angular.module('ManamControllers').controller('UserController',
	function ($scope, $state, AdminUserRepository) {
	$scope.init = function () {
            AdminUserRepository.getUsers().then(function (response) {
                $scope.users = response.data;
            })
	}
	});