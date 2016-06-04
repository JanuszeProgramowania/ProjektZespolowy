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


    projectFactory.deleteProject = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return projectFactory;
}]);