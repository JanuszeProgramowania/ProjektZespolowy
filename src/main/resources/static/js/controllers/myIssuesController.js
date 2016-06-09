/**
 * Created by Tomasz Jodko on 2016-06-07.
 */
app.controller('MyIssuesController', ['$scope', '$rootScope','commentFactory','priorityFactory', 'issueFactory','projectFactory', '$location','$timeout', function ($scope, $rootScope,commentFactory,priorityFactory, issueFactory,projectFactory, $location,$timeout) {

    $scope.newCommentWrapper ={
        historia:{
            id: 0,
            typ: "ZEWNETRZNY"
        },
        user:{
            id: $rootScope.token.id
        },
        zgloszenie:{
            id:''
        }
    };


    $scope.newWrapper ={
        zgloszenie:{
            id: 0,
            zgloszenieWewZew: "ZEWNETRZNE",
            status: "OCZEKUJE",
            typZgloszenia: "BLAD"
        },
        user:{
            id: $rootScope.token.id
        },
        projekt:{
            id: ''
        },
        priorytet:{
            id:''
        }
    };


    $scope.selectedProjectChanged = function(){
        console.log($scope.selectedProject);
        issueFactory.getIssuesByUserAndProjektId($rootScope.token.id, $scope.selectedProject.id,function (resp) {
            $scope.issues = resp;
            console.log(resp);
        });
    };

    $scope.saveNewIssue = function () {
        $scope.newWrapper.priorytet.id = $scope.selectedPriority.id;
        $scope.newWrapper.projekt.id = $scope.selectedProject.id;

        issueFactory.saveIssue($scope.newWrapper, function (resp) {
            console.log(resp);
            $scope.issues.push(resp);
        });

    };

    $scope.saveNewComment = function () {

        $scope.newCommentWrapper.zgloszenie.id = $scope.selectedIssue.id;
        console.log($scope.newCommentWrapper);
        commentFactory.saveComment($scope.newCommentWrapper, function (resp) {
            console.log(resp);
            $scope.comments.push(resp);
        });

    };

    priorityFactory.getPriorities(function(resp){
       $scope.priorities = resp;
        $scope.selectedPriority = resp[0];
    });


    projectFactory.getProjectsByCompanyId($rootScope.token.company.id,function (resp) {
        $scope.companyProjects = resp;
        $scope.selectedProject = resp[0];
        issueFactory.getIssuesByUserAndProjektId($rootScope.token.id, $scope.selectedProject.id,function (resp) {
            $scope.issues = resp;
            console.log(resp);
        });
        console.log($scope.selectedProject);
    });


    $scope.saveIssue = function () {
        issueFactory.saveIssue($scope.selectedIssue, function (resp) {
            console.log(resp);
        });
    };

    $scope.deleteIssue = function () {
        var id = $scope.selectedIssue.id;
        issueFactory.deleteIssue(id);
        var index = $scope.issues.indexOf($scope.selectedIssue);
        $scope.issues.splice(index, 1);
    };

    // fired when table rows are selected
    $scope.$watch('displayedCollection', function (row) {
        // get selected row
        var selectedCount = 0;
        row.filter(function (r) {
            if (r.isSelected) {
                console.log(r);
                $scope.selectedIssue = r;
                commentFactory.getOuterCommentsByIssueId(r.id,function(resp){
                    $scope.comments = resp;
                });
                selectedCount++;
            }
        });
        if (selectedCount > 0) {
            $('#selectedIssueForm').modal("show")
        } else {
            $('#selectedIssueForm').modal("hide")
        }
    }, true);





    if (!$rootScope.authenticated || $rootScope.userZew === false) {
        $location.path('/');    //redirect user to home.
    }
}]);
