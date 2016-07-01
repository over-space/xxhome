
var writeViewApp = angular.module('writeViewApp', []);

writeViewApp.controller('write-controller', function ($scope, $http) {

    //博客分类列表
    $scope.blogCategoryList = [];
    $scope.blogGroupList = [];
    $scope.blogTypeList = [{type:0, text:"原创"}, {type:1, text:"转载"}, {type:2, text:"翻译"}];
    $scope.blog = {type:0, name:'', content:'', tags:'', group:'', category:'', status:'DRAFT'};

    //保存博客
    $scope.doSave = function () {
        $scope.blog.status = 'DRAFT';
        if(!$scope.blog.name){
            layer.msg('博客标题不允许为空，这很重要哦!', {icon: 2});
            return;
        }
        if(!$scope.blog.content){
            layer.msg('博客内容不允许为空，这很重要哦!', {icon: 2});
            return;
        }
        if(!$scope.blog.tags){
            layer.msg('博客标签不允许为空，可以方便检索哦!', {icon: 2});
            return;
        }
        
        $http.post("../blog/content/save.xhtml", $scope.blog).success(function (req) {
            layer.msg('保存成功!', {icon: 1});
            window.location.href = "../../xxblog/view/list.xhtml";
        });
    };

    //立即发布博客
    $scope.doPublic = function () {
        $scope.blog.status = 'PUBLIC';
        $http.post("../blog/content/public.xhtml", $scope.blog).success(function (req) {

        });
    };

    //放弃
    $scope.doGiveUp = function () {
        layer.confirm('确定放弃编辑吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            window.location.href = "../../xxblog/view/list.xhtml";
        },function(){
            //取消
        });
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