
var listViewApp = angular.module('listViewApp', []);

listViewApp.controller('list-controller', function ($scope, $http) {

    $scope.blogContentList = [];
    

    //初始化页面
    var initView = function () {
        //初始化博客分类
        var initBlogContentList = function () {
            $http.get("../blog/content/list.xhtml").success(function (req) {
                $scope.blogContentList = req.data;
            });
        };
        initBlogContentList();
    };
    initView();

});