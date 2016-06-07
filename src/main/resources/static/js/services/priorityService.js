/**
 * Created by Tomasz Jodko on 2016-06-07.
 */
app.factory('priorityFactory', ['$http', function ($http) {

    var urlBase = '/projektzespolowy/priorytety';
    var priorityFactory = {};


    priorityFactory.getPriorities = function (callback) {
        return $http.get(urlBase + '/getAll').then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                priorityFactory.returnedData = response.data;
                callback(priorityFactory.returnedData);
            }
        });
    };


    priorityFactory.getPriority = function (id, callback) {
        return $http.get(urlBase + '/getById/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                priorityFactory.returnedData = response.data;
                callback(priorityFactory.returnedData);
            }
        });
    };

    priorityFactory.savePriority = function (wrapper, callback) {
        return $http.post(urlBase + '/savePriorytet', wrapper).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                priorityFactory.returnedData = response.data;
                callback(priorityFactory.returnedData);
            }
        });
    };


    priorityFactory.deletePriority = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return priorityFactory;
}]);
