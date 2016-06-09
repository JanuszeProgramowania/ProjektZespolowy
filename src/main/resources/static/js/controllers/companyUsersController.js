/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
app.controller('CompanyUsersController', ['$scope', '$rootScope', 'userFactory', '$location', function ($scope, $rootScope, userFactory, $location) {

    $scope.newUser = {
        authority: "ROLE_USER",
        typUzytkownika: "ZEWNETRZNY",
        company: $rootScope.token.company
    };
    $scope.saveNewUser = function () {
        $scope.newUser.id = 0;
        $scope.newUser.aktywny = true;

        userFactory.saveUser($scope.newUser, function (resp) {
            console.log(resp);
            $scope.users.push(resp);
            $('#newUserEmail').val('');
            $('#newUserName').val('');
            $('#newUserLastName').val('');
            $('#newUserPassword').val('');
            $("#success-alert").show();
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert").hide();
            });
        });
    };


    $scope.deselect = function(){
        $scope.selectedUser.isSelected = false;
    };
    $scope.saveUser = function () {
        userFactory.saveUser($scope.selectedUser, function (resp) {
            console.log(resp);
            $("#success-alert").show();
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert").hide();
            });
        });
    };

    $scope.deleteUser = function () {
        var id = $scope.selectedUser.id;
        userFactory.deleteUser(id);
        var index = $scope.users.indexOf($scope.selectedUser);
        $scope.users.splice(index, 1);
    };

    // fired when table rows are selected
    $scope.$watch('displayedCollection', function (row) {
        // get selected row
        var selectedCount = 0;
        row.filter(function (r) {
            if (r.isSelected) {
                console.log(r);
                $scope.selectedUser = r;
                selectedCount++;
            }
        });
        if (selectedCount > 0) {
            $('#selectedUserForm').collapse("show")
        } else {
            $('#selectedUserForm').collapse("hide")
        }
    }, true);

    userFactory.getUsersByCompanyId($rootScope.token.company.id,function (resp) {
        $scope.users = resp;
        console.log(resp);
    });

    if (!$rootScope.authenticated || $rootScope.adminZew === false) {
        $location.path('/');    //redirect user to home.
    }
}]);