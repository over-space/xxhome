
var subjectViewApp = angular.module('subjectViewApp', []);


subjectViewApp.controller('subject-controller', ['$scope', '$http', function($scope, $http) {

    $scope.blog = {};

    $http.get("../blog/content/get.xhtml?id=30").success(function (req) {
        $scope.blog = req.data;
    });

}]);