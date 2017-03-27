angular.module('ManamControllers', ['Repositories']);

angular.module('ManamWithoutRunApp', ['ManamCommon', 'ManamControllers'])
.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
    function($stateProvider, $urlRouterProvider, $locationProvider){
		$stateProvider
            .state('home', {
                url: '/home',
                templateUrl: 'base.html'
            });
        $urlRouterProvider.otherwise('/home');
}]);

angular.module('ManamApp', ['ManamWithoutRunApp'])
.run(['$rootScope', function($rootScope){
$rootScope.dateTime = new Date();
}]);



