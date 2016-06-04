
var writeViewApp = angular.module('writeViewApp', []);

writeViewApp.controller('write-controller', function ($scope, $http) {

    //博客分类列表
    $scope.blogCategoryList = [];
    $scope.blogTypeList = [{type:0, text:"原创"}, {type:1, text:"转载"}, {type:2, text:"翻译"}];
    $scope.blogGroupList = [{id:0, name:"Java"}, {id:1, name:"MySQL"}, {id:2, name:"Android"}];
    $scope.blog = {type:0, title:'', content:'', tags:'', group:'', category:''};

    //初始化博客分类
    var initBlogCategoryList = function () {
        $http.post("../blog/category/list.xhtml", $scope.account).success(function (req) {
            $scope.blogCategoryList = req.data;
        });
    };
    initBlogCategoryList()


    //保存博客
    $scope.doSave = function () {
        
        if($scope.blog.title == ""){
            return;
        }
        
        $http.post("../blog/")

    };

    //立即发布博客
    $scope.doPublic = function () {

    };

    //放弃
    $scope.doGiveUp = function () {

    };

});