/**
 * Created by Tomasz Jodko on 2016-05-31.
 */
app.controller('AccountController', ['$scope', '$http', '$rootScope', '$location', function ($scope, $http, $rootScope, $location) {

    $scope.cpSuccess = false;

    $scope.changePassword = function () {
        $http.put('projektzespolowy/users/changePassword/', $scope.newPassword).success(function () {
            $('#newPassword').val('');
            $('#confPassword').val('');
            $("#success-alert").show();
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert").hide();
            });
        });

    };


    if (!$rootScope.authenticated) {
        $location.path('/');    //redirect user to home.
    }
}]);
