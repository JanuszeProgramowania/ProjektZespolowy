/**
 * Created by Tomasz Jodko on 2016-06-07.
 */
app.factory('issueFactory', ['$http', function ($http) {

    var urlBase = '/projektzespolowy/zgloszenia';
    var companyFactory = {};


    companyFactory.getCompanies = function (callback) {
        return $http.get(urlBase + '/getAll').then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                companyFactory.returnedData = response.data;
                callback(companyFactory.returnedData);
            }
        });
    };


    companyFactory.getCompany = function (id, callback) {
        return $http.get(urlBase + '/getById/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                companyFactory.returnedData = response.data;
                callback(companyFactory.returnedData);
            }
        });
    };

    companyFactory.getCompaniesInProject= function (id, callback) {
        return $http.get(urlBase + '/getCompaniesInProject/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                companyFactory.returnedData = response.data;
                callback(companyFactory.returnedData);
            }
        });
    };

    companyFactory.getCompaniesNotInProject= function (id, callback) {
        return $http.get(urlBase + '/getCompaniesNotInProject/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                companyFactory.returnedData = response.data;
                callback(companyFactory.returnedData);
            }
        });
    };

    companyFactory.saveCompany = function (wrapper, callback) {
        return $http.post(urlBase + '/saveCompany', wrapper).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                companyFactory.returnedData = response.data;
                callback(companyFactory.returnedData);
            }
        });
    };


    companyFactory.deleteCompany = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return companyFactory;
}]);
