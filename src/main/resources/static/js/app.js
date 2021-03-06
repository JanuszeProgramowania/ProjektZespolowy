/**
 * Created by Tomasz Jodko on 2016-06-01.
 */
var app = angular.module('app', [ angularDragula(angular) ,'textAngular','ngRoute','ui.numeric', 'smart-table', 'ui.bootstrap']);

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
        .when('/projects', {
            templateUrl: 'templates/projects.html',
            controller: 'ProjectController'
        })
        .when('/priorities', {
            templateUrl: 'templates/priorities.html',
            controller: 'PriorityController'
        })
        .when('/myIssues', {
            templateUrl: 'templates/myIssues.html',
            controller: 'MyIssuesController'
        })
        .when('/issues', {
            templateUrl: 'templates/issues.html',
            controller: 'IssuesController'
        })
        .when('/internalIssues', {
            templateUrl: 'templates/InternalIssues.html',
            controller: 'InternalIssuesController'
        })
        .otherwise({redirectTo: '/'});
}]);