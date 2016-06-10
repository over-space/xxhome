
var writeViewApp = angular.module('writeViewApp', []);

writeViewApp.controller('write-controller', function ($scope, $http) {

    //博客分类列表
    $scope.blogCategoryList = [];
    $scope.blogGroupList = [];
    $scope.blogTypeList = [{type:0, text:"原创"}, {type:1, text:"转载"}, {type:2, text:"翻译"}];
    $scope.blog = {type:0, name:'', content:'', tags:'', group:'', category:''};




    //保存博客
    $scope.doSave = function () {
        if($scope.blog.title == ""){
            return;
        }
        
        $http.post("../blog/content/save.xhtml", $scope.blog).success(function (req) {

        });
    };

    //立即发布博客
    $scope.doPublic = function () {
        $http.post("../blog/content/public.xhtml", $scope.blog).success(function (req) {

        });
    };

    //放弃
    $scope.doGiveUp = function () {
    };

    //初始化页面
    var initView = function () {
        //初始化博客分类
        var initBlogCategoryList = function () {
            $http.post("../blog/category/list.xhtml", $scope.account).success(function (req) {
                $scope.blogCategoryList = req.data;
            });
        };
        initBlogCategoryList();

        //初始化个人博客分组
        var initBlogGroupList = function () {
            $http.post("../blog/group/list.xhtml", $scope.account).success(function (req) {
                $scope.blogGroupList = req.data;
            });
        };
        initBlogGroupList();
    };
    initView();

});