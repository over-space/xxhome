
var writeViewApp = angular.module('writeViewApp', []);

writeViewApp.controller('write-controller', function ($scope) {

    $scope.blogTypeList = [
        {type:0, text:"请选择"},
        {type:1, text:"原创"},
        {type:2, text:"转载"},
        {type:3, text:"翻译"}
    ];

    $scope.blogCategoryList = [
        {id:0, text:"移动开发"},
        {id:1, text:"Web前端"},
        {id:2, text:"架构设计"},
        {id:2, text:"编程语言"},
        {id:2, text:"互联网"},
        {id:2, text:"数据库"},
        {id:2, text:"系统运维"},
        {id:2, text:"云计算"},
        {id:2, text:"研发管理"},
        {id:2, text:"综合"}
    ];

    $scope.blog = {
        type:0,
        title:'',
        content:'',
        tag:''
    };

});