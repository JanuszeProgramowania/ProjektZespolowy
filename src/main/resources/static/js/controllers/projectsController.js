/**
 * Created by Tomasz Jodko on 2016-06-05.
 */
app.controller('ProjectController', ['$scope', '$rootScope', 'projectFactory', '$location', function ($scope, $rootScope, projectFactory, $location) {

    $scope.saveNewProject = function () {
        $scope.newProject.id = 0;

        projectFactory.saveProject($scope.newProject, function (resp) {
            console.log(resp);
            $scope.projects.push(resp);
        });
    };

    $scope.saveProject = function () {
        projectFactory.saveProject($scope.selectedProject, function (resp) {
            console.log(resp);
        });
    };

    $scope.deleteProject = function () {
        var id = $scope.selectedProject.id;
        projectFactory.deleteProject(id);
        var index = $scope.projects.indexOf($scope.selectedProject);
        $scope.projects.splice(index, 1);
    };

    // fired when table rows are selected
    $scope.$watch('displayedCollection', function (row) {
        // get selected row
        var selectedCount = 0;
        row.filter(function (r) {
            if (r.isSelected) {
                console.log(r);
                $scope.selectedProject = r;
                selectedCount++;
            }
        });
        if (selectedCount > 0) {
            $('#selectedProjectForm').collapse("show")
        } else {
            $('#selectedProjectForm').collapse("hide")
        }
    }, true);

    projectFactory.getProjects(function (resp) {
        $scope.projects = resp;
        console.log(resp);
    });

    if (!$rootScope.authenticated || $rootScope.adminWew === false) {
        $location.path('/');    //redirect user to home.
    }
}]);