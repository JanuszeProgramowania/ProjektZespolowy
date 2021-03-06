/**
 * Created by Tomasz Jodko on 2016-06-05.
 */
app.controller('ProjectController', ['$scope', '$rootScope', 'dragulaService','companyFactory','projectFactory', 'userFactory', '$location', function ($scope, $rootScope,dragulaService,companyFactory, projectFactory,userFactory, $location) {



    $scope.saveNewProject = function () {
        $scope.newProject.id = 0;

        projectFactory.saveProject($scope.newProject, function (resp) {
            console.log(resp);
            $scope.projects.push(resp);
            $('#newProjectName').val('');
            $('#newProjectDescription').val('');
            $('#newProjectVersion').val('');
            $("#success-alert").show();
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert").hide();
            });
        });
    };

    $scope.deselect = function(){
        $scope.selectedProject.isSelected = false;
    };

    $scope.saveProject = function () {
        projectFactory.saveProject($scope.selectedProject, function (resp) {
            console.log(resp);
            $("#success-alert2").show();
            $("#success-alert2").fadeTo(2000, 500).slideUp(500, function(){
                $("#success-alert2").hide();
            });
        });
    };

    $scope.setUsers = function(){
        var wrapper = {
            projekt: $scope.selectedProject,
            users: $scope.usersInProject
        };
        projectFactory.setUsers(wrapper);
        $("#success-alert3").show();
        $("#success-alert3").fadeTo(2000, 500).slideUp(500, function(){
            $("#success-alert3").hide();
        });
    };

    $scope.setCompanies = function(){
        var wrapper = {
            projekt: $scope.selectedProject,
            companies: $scope.companiesInProject
        };
        projectFactory.setCompanies(wrapper);
        $("#success-alert4").show();
        $("#success-alert4").fadeTo(2000, 500).slideUp(500, function(){
            $("#success-alert4").hide();
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
                userFactory.getUsersInProject(r.id, function(resp){
                   $scope.usersInProject = resp;
                    console.log(resp);
                });

                userFactory.getUsersNotInProject(r.id, function(resp){
                    $scope.usersNotInProject = resp;
                    console.log(resp);
                });
                companyFactory.getCompaniesInProject(r.id, function(resp){
                    $scope.companiesInProject = resp;
                    console.log(resp);
                });
                companyFactory.getCompaniesNotInProject(r.id, function(resp){
                    $scope.companiesNotInProject = resp;
                    console.log(resp);
                });

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