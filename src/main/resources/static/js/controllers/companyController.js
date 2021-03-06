/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
app.controller('CompanyController', ['$scope', '$rootScope', 'companyFactory', '$location', function ($scope, $rootScope, companyFactory, $location) {

    $scope.saveNewCompany = function () {
        $scope.newCompany.id = 0;

        companyFactory.saveCompany($scope.newCompany, function (resp) {
            console.log(resp);
            $scope.companies.push(resp);
            $('#newCompanyName').val('');
            $('#newCompanyAddress').val('');
            $('#newCompanyPhone').val('');
            $('#newCompanyCity').val('');
            $("#success-alert").show();
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert").hide();
            });
        });
    };

    $scope.deselect = function(){
        $scope.selectedCompany.isSelected = false;
    };

    $scope.saveCompany = function () {
        companyFactory.saveCompany($scope.selectedCompany, function (resp) {
            console.log(resp);
            $("#success-alert2").show();
            $("#success-alert2").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert2").hide();
            });
        });
    };

    $scope.deleteCompany = function () {
        var id = $scope.selectedCompany.id;
        companyFactory.deleteCompany(id);
        var index = $scope.companies.indexOf($scope.selectedCompany);
        $scope.companies.splice(index, 1);
    };

    // fired when table rows are selected
    $scope.$watch('displayedCollection', function (row) {
        // get selected row
        var selectedCount = 0;
        row.filter(function (r) {
            if (r.isSelected) {
                console.log(r);
                $scope.selectedCompany = r;
                selectedCount++;
            }
        });
        if (selectedCount > 0) {
            $('#selectedCompanyForm').collapse("show")
        } else {
            $('#selectedCompanyForm').collapse("hide")
        }
    }, true);

    companyFactory.getCompanies(function (resp) {
        $scope.companies = resp;
        console.log(resp);
    });

    if (!$rootScope.authenticated || $rootScope.adminWew === false) {
        $location.path('/');    //redirect user to home.
    }
}]);