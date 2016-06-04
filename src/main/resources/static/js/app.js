/**
 * Created by Tomasz Jodko on 2016-06-01.
 */
var app = angular.module('app', ['ngRoute', 'smart-table', 'ui.bootstrap']);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'templates/home.html'
        })
        .when('/home', {
            templateUrl: 'templates/home.html'
        })
        .when('/users', {
            templateUrl: 'templates/users.html',
            controller: 'UserController'
        })
        .when('/account', {
            templateUrl: 'templates/account.html',
            controller: 'AccountController'
        })
        .when('/companies', {
            templateUrl: 'templates/companies.html',
            controller: 'CompanyController'
        })
        .when('/companyUsers', {
            templateUrl: 'templates/companyUsers.html',
            controller: 'CompanyUsersController'
        })
        .otherwise({redirectTo: '/'});
}]);