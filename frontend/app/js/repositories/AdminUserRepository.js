angular.module('Repositories')
    .factory('AdminUserRepository', ['$http', function ($http) {
        return {
            getUsers: function() {
                return $http.get('/api/admin/user');
            }
        };
    }]);