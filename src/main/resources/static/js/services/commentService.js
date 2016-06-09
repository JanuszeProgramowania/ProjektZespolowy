/**
 * Created by Tomasz Jodko on 2016-06-09.
 */
app.factory('commentFactory', ['$http', function ($http) {

    var urlBase = '/projektzespolowy/historia';
    var commentFactory = {};


    commentFactory.getComments = function (callback) {
        return $http.get(urlBase + '/getAll').then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                commentFactory.returnedData = response.data;
                callback(commentFactory.returnedData);
            }
        });
    };


    commentFactory.getCommentsByIssueId = function (id, callback) {
        return $http.get(urlBase + '/getByZgloszenieId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                commentFactory.returnedData = response.data;
                callback(commentFactory.returnedData);
            }
        });
    };

    commentFactory.getOuterCommentsByIssueId = function (id, callback) {
        return $http.get(urlBase + '/getZewnetrzneByZgloszenieId/' + id).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                commentFactory.returnedData = response.data;
                callback(commentFactory.returnedData);
            }
        });
    };


    commentFactory.saveComment = function (wrapper, callback) {
        return $http.post(urlBase + '/saveHistoria', wrapper).then(function (response) {
            if (response.data.error) {
                return null;
            } else {
                commentFactory.returnedData = response.data;
                callback(commentFactory.returnedData);
            }
        });
    };


    commentFactory.deleteComment = function (id) {
        return $http.put(urlBase + '/deleteById/' + id);
    };
    return commentFactory;
}]);
