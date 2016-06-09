/**
 * Created by Tomasz Jodko on 2016-06-07.
 */
app.factory('issueFactory', ['$http', function ($http) {

    var urlBase = '/projektzespolowy/zgloszenia';
    var issueFactory = {};


    issueFactory.getIssues = function (callback) {
        return $http.get(urlBase + '/getAll').then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };


    issueFactory.getIssue = function (id, callback) {
        return $http.get(urlBase + '/getById/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };

    issueFactory.getIssuesByProjectId = function (id, callback) {
        return $http.get(urlBase + '/getByProjektId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };

    issueFactory.getExternalIssuesByProjectId = function (id, callback) {
        return $http.get(urlBase + '/getExternalByProjektId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };


    issueFactory.getInternalIssuesByProjectId = function (id, callback) {
        return $http.get(urlBase + '/getInternalByProjektId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };


    issueFactory.getIssuesByUserAndProjektId = function (userId,projektId, callback) {
        return $http.get(urlBase + '/getByUserAndProjektId/' + userId +','+projektId).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };

    issueFactory.saveIssue = function (wrapper, callback) {
        return $http.post(urlBase + '/saveZgloszenie', wrapper).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                issueFactory.returnedData = response.data;
                callback(issueFactory.returnedData);
            }
        });
    };


    issueFactory.deleteIssue = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return issueFactory;
}]);
