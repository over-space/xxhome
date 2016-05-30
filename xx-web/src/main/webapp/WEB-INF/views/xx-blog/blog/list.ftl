<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="${xxbase_path}/icon/favicon.ico"/>
    <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic'>

    <@resources src="${xxblog_path}/css/bootstrap.min.css"/>
    <@resources src="${xxblog_path}/fonts/css/font-awesome.min.css"/>
    <@resources src="${xxbase_path}/css/bootstrap/bootstrap-markdown.min.css"/>
    <@resources src="${xxblog_path}/css/style.css"/>
    <@resources src="${xxblog_path}/css/blog/list.css"/>

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
                                <div class="box bottom-main">
                                    <div class="info float-container">
                                        <div class="col-sm-12 bottom-title">
                                            <h3 class="text-uppercase">[互联网]Spring核心技术IoC容器（六）</h3>
                                            <div class="blog-desc">
                                                <i class="fa fa-user fa-4x main-menu-link-icon"></i>
                                                <h5>前文已经描述了Bean的作用域，本文将描述Bean的一些生命周期作用，配置还有Bean的继承。定制Bean生命周期回调开发者通过实现Spring的InitializeingBean和DisposableBean接口，就可以让容器来管理Bean的生命周期。容器会调用afterPropertiesSet()前和destroy()后才会允许Bean在初始化和销毁Bean的时候执行一些操作。 JSR-2...</h5>
                                            </div>
                                        </div>
                                        <p class="bottom-desc" style="margin-left: 5px;">
                                            提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。
                                        </p>
                                        <hr/>
                                        <div class="col-sm-12 location-main">
                                            <div class="pull-right bottom-user">
                                                <a href="#"><i class="fa fa-caret-right"></i><span>READ MORE</span></a>
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
    <@resources src="${xxblog_path}/js/jquery-1.11.3.min.js"/>
    <@resources src="${xxblog_path}/js/bootstrap.min.js"/>
    <@resources src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"/>

</body>
</html>
