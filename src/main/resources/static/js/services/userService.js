/**
 * Created by Tomasz Jodko on 2016-06-02.
 */
app.factory('userFactory', ['$http', function ($http) {

    var urlBase = '/projektzespolowy/users';
    var userFactory = {};


    userFactory.getUsers = function (callback) {
        return $http.get(urlBase + '/getAll').then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                userFactory.returnedData = response.data;
                callback(userFactory.returnedData);
            }
        });
    };


    userFactory.getUser = function (id, callback) {
        return $http.get(urlBase + '/getById/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                userFactory.returnedData = response.data;
                callback(userFactory.returnedData);
            }
        });
    };

    userFactory.getUsersByCompanyId = function (id, callback) {
        return $http.get(urlBase + '/getByCompanyId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                userFactory.returnedData = response.data;
                callback(userFactory.returnedData);
            }
        });
    };

    userFactory.saveUser = function (wrapper, callback) {
        return $http.post(urlBase + '/saveUser', wrapper).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                userFactory.returnedData = response.data;
                callback(userFactory.returnedData);
            }
        });
    };


    userFactory.deleteUser = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return userFactory;
}]);