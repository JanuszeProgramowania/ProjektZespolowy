/**
 * Created by Tomasz Jodko on 2016-06-07.
 */
app.controller('PriorityController', ['$scope', '$rootScope', 'priorityFactory', '$location', function ($scope, $rootScope, priorityFactory, $location) {


    $scope.saveNewPriority = function () {
        $scope.newPriority.id = 0;

        priorityFactory.savePriority($scope.newPriority, function (resp) {
            console.log(resp);
            $scope.priorities.push(resp);
            $('#newPriorityType').val('');
            $('#newPriorityTimeUnit').val('');
            $scope.newPriority.ilosc = 1;
            $("#success-alert").show();
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert").hide();
            });
        });
    };

    $scope.deselect = function(){
        $scope.selectedPriority.isSelected = false;
    };

    $scope.savePriority = function () {
        priorityFactory.savePriority($scope.selectedPriority, function (resp) {
            console.log(resp);
            $("#success-alert2").show();
            $("#success-alert2").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert2").hide();
            });
        });
    };

    $scope.deletePriority = function () {
        var id = $scope.selectedPriority.id;
        priorityFactory.deletePriority(id);
        var index = $scope.priorities.indexOf($scope.selectedPriority);
        $scope.priorities.splice(index, 1);
    };

    // fired when table rows are selected
    $scope.$watch('displayedCollection', function (row) {
        // get selected row
        var selectedCount = 0;
        row.filter(function (r) {
            if (r.isSelected) {
                console.log(r);
                $scope.selectedPriority = r;
                selectedCount++;
            }
        });
        if (selectedCount > 0) {
            $('#selectedPriorityForm').collapse("show")
        } else {
            $('#selectedPriorityForm').collapse("hide")
        }
    }, true);

    priorityFactory.getPriorities(function (resp) {
        $scope.priorities = resp;
        console.log(resp);
    });

    if (!$rootScope.authenticated || $rootScope.adminWew === false) {
        $location.path('/');    //redirect user to home.
    }
}]);
