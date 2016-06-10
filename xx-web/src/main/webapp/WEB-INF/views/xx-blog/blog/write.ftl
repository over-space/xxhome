<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic'>
        <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${xxblog_path}/fonts/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${xxbase_path}/css/bootstrap/bootstrap-markdown.min.css">
        <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/style.css">
        <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/blog/write.css">
        <link rel="shortcut icon" href="${xxbase_path}/icon/favicon.ico"/>

        <title>XX博客首页</title>
    </head>

    <body>
        <div class="main-body" ng-app="writeViewApp" ng-controller="write-controller">
            <div class="container">
                <div class="row">
                    <div class="main-page">

                        <aside class="main-navigation">
                            <#include "xx-blog/base/menu.ftl"/>
                        </aside> <!-- main-navigation -->

                        <div class="content-main">

                            <div class="row margin-b-30">

                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <div class="box bottom-main">
                                        <div class="info float-container">
                                            <div class="col-sm-12 bottom-title">
                                                <#--<h3 class="text-uppercase">Proin gravida nibhvel</h3>-->
                                                <h4 class="text-uppercase">文章标题</h4>
                                                <div class="blog-title">
                                                    <input type="text" class="form-control" id="title" name="title" ng-model="blog.name">
                                                    <select class="form-control col-xs-2"
                                                            ng-model="blog.type"
                                                            ng-options="opt.type as opt.text for opt in blogTypeList"
                                                            ng-init="1"></select>
                                                </div>
                                            </div>
                                            <div class="row blog-content">
                                                <div>
                                                    <h4 class="text-uppercase">文章内容</h4>
                                                    <textarea id="blog-textarea" data-width="880" data-height="500" name="content" data-provide="markdown" rows="10" ng-model="blog.content"></textarea>
                                                </div>
                                                <div>
                                                    <h4 class="text-uppercase">文章标签(添加Tag，你的内容能被更多人看到)</h4>
                                                    <input type="text" class="form-control" id="tags" name="tags" ng-model="blog.tags">
                                                </div>
                                                <div>
                                                    <h4 class="text-uppercase">个人分类[编辑分类]</h4>
                                                    <div ng-repeat="group in blogGroupList">
                                                        <label class="blog-category-group-radio">
                                                            <input type="radio" name="blogGroup" id="blogGroup" ng-value="{{group.id}}" >
                                                            <span>{{group.name}}</span>
                                                        </label style="float: left;">
                                                    </div>
                                                </div>
                                                <div>
                                                    <br/>
                                                    <h4 class="text-uppercase">文章分类</h4>
                                                    <div ng-repeat="category in blogCategoryList">
                                                        <label class="blog-category-group-radio">
                                                            <input type="radio" name="blogCategory" id="blogCategory" ng-value="{{category.id}}" >
                                                            <span>{{category.name}}</span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <p class="bottom-desc" style="margin-left: 5px;">
                                                提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。
                                            </p>
                                            <hr/>
                                            <div class="col-sm-12 location-main">
                                                <div class="pull-right bottom-user">
                                                    <#--<a href="#"><i class="fa fa-caret-right"></i><span>READ MORE</span></a>-->
                                                   <input id="btn-submit" name="btn-submit" og-click="doPublic()" type="submit" value="发表文章" class="btn view_more btn-submit">
                                                   <input id="btn-save" name="btn-save" ng-click="doSave()" type="submit" value="立即保存" class="btn view_more btn-submit">
                                                   <input id="btn-give-up" name="btn-give-up" ng-click="doGiveUp" type="submit" value="舍弃" class="btn view_more btn-submit">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> <!-- row -->
                        </div> <!-- .content-main -->
                    </div> <!-- .main-page -->
                </div> <!-- .row -->
                <footer class="row">
                    <#include "xx-blog/base/footer.ftl"/>
                </footer>  <!-- .row -->
            </div> <!-- .container -->
        </div> <!-- .main-body -->

        <!-- JavaScript -->
        <script src="${xxblog_path}/js/jquery-1.11.3.min.js"></script>
        <script src="${xxblog_path}/js/bootstrap.min.js"></script>
        <script src="${xxbase_path}/js/bootstrap/bootstrap-markdown.js"></script>
        <script src="${xxbase_path}/js/angular.min.js"></script>
        <script type="application/javascript" src="${xxblog_path}/js/write-controller.js"></script>

        <script language="javascript">
            $("#blog-textarea").markdown({
                    autofocus:true,
                    savable:false
            });
        </script>
    </body>
</html>
