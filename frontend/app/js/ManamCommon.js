angular.module('Repositories', []);
angular.module('Third-party', [
	'ui.router'
]);

angular.module('ManamCommon', [
	'partials',
	'Repositories',
	'Third-party'
]);