/**
 * Created by Tomasz Jodko on 2016-06-05.
 */
app.factory('projectFactory', ['$http', function ($http) {

    var urlBase = '/projektzespolowy/projekty';
    var projectFactory = {};


    projectFactory.getProjects = function (callback) {
        return $http.get(urlBase + '/getAll').then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                projectFactory.returnedData = response.data;
                callback(projectFactory.returnedData);
            }
        });
    };


    projectFactory.getProject = function (id, callback) {
        return $http.get(urlBase + '/getById/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                projectFactory.returnedData = response.data;
                callback(projectFactory.returnedData);
            }
        });
    };

    projectFactory.getProjectsByCompanyId = function (id, callback) {
        return $http.get(urlBase + '/getByCompanyId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                projectFactory.returnedData = response.data;
                callback(projectFactory.returnedData);
            }
        });
    };

    projectFactory.getProjectsByUserId = function (id, callback) {
        return $http.get(urlBase + '/getByUserId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                projectFactory.returnedData = response.data;
                callback(projectFactory.returnedData);
            }
        });
    };

    projectFactory.saveProject = function (wrapper, callback) {
        return $http.post(urlBase + '/saveProjekt', wrapper).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                projectFactory.returnedData = response.data;
                callback(projectFactory.returnedData);
            }
        });
    };

    projectFactory.setUsers = function (wrapper) {
        return $http.put(urlBase + '/setUsers',wrapper);
    };

    projectFactory.setCompanies = function (wrapper) {
        return $http.put(urlBase + '/setCompanies',wrapper);
    };

    projectFactory.deleteProject = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return projectFactory;
}]);