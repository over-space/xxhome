<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <@link src="${xxbase_path}/icon/favicon.ico"/>
    <@link src="http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic" type="css"/>
    <@link src="${xxblog_path}/css/bootstrap.min.css"/>
    <@link src="${xxblog_path}/fonts/css/font-awesome.min.css"/>
    <@link src="${xxbase_path}/css/bootstrap/bootstrap-markdown.min.css"/>
    <@link src="${xxblog_path}/css/style.css"/>
    <@link src="${xxblog_path}/css/blog/list.css"/>

    <title>XX博客首页</title>
</head>

<body>
<div class="main-body" ng-app="listViewApp" ng-controller="list-controller">
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
                                <div class="box bottom-main" style="min-height: 900px;">

                                    <div class="info float-container" ng-repeat="blog in blogContentList">
                                        <div class="col-sm-12 bottom-title">
                                            <h3 class="text-area">[互联网]&nbsp;{{blog.name}}</h3>
                                            <div class="blog-desc">
                                                <img src="${xxbase_path}/images/photo.png" class="photo" style="width: 56px;">
                                                <span class="blog-content">
                                                    {{blog.summary}}
                                                </span>
                                            </div>
                                            <div class="col-sm-12 location-main">
                                                <span class="blog-public-time">Bruce Lee 5分钟前</span>
                                                <span class="blog-public blog-public-eye">
                                                    <a href="#"><i class="fa fa-eye" aria-hidden="true"></i>&nbsp;阅读（10）</a>
                                                </span>
                                                <span class="blog-public blog-public-comment">
                                                    <a href="#"><i class="fa fa-comment" aria-hidden="true"></i>&nbsp;评论（10）</a>
                                                </span>
                                                <span class="blog-public blog-public-collect">
                                                    <a href="#"><i class="fa fa-comment" aria-hidden="true"></i>&nbsp;收藏（10）</a>
                                                </span>
                                                <span class="blog-public blog-public-bury">
                                                    <a href="#"><i class="fa fa-hand-o-down" aria-hidden="true"></i>&nbsp;踩（0）</a>
                                                </span>
                                                <span class="blog-public blog-public-digger">
                                                    <a href="#"><i class="fa fa-hand-o-up" aria-hidden="true"></i>&nbsp;赞（8）</a>
                                                </span>
                                            </div>
                                        </div>
                                    </div>

                                    <#--<p class="bottom-desc" style="margin-left: 5px;">-->
                                        <#--提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。-->
                                    <#--</p>-->
                                    <#--<hr/>-->
                                    <#--<div class="col-sm-12 location-main">-->
                                        <#--<div class="pull-right bottom-user">-->
                                            <#--<a href="#"><i class="fa fa-caret-right"></i><span>阅读</span></a>-->
                                        <#--</div>-->
                                    <#--</div>-->
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
    <script src="${xxbase_path}/js/jquery-1.11.3.min.js"></script>
    <script src="${xxblog_path}/js/bootstrap.min.js"></script>
    <script src="${xxbase_path}/js/angular.min.js"></script>
    <script src="${xxblog_path}/js/list-controller.js"></script>
</body>
</html>
