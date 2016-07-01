<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic'>
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/blog/subject.css">

    <title>XX博客首页</title>
</head>

<body>
    <div class="main-body" ng-app="subjectViewApp" ng-controller="subject-controller">
        <div class="container">
            <div class="row">
                <div class="main-page">

                    <aside class="main-navigation">
                        <#include "xx-blog/base/menu.ftl"/>
                    </aside> <!-- main-navigation -->

                    <div class="content-main">
                        <div class="row margin-b-30">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="banner-main-home">
                                    <div class="banner-main-home-text subject-title">
                                        <div class="heading">
                                            <h3>{{blog.name}}</h3>
                                            <p class="text-lowercase">
                                                阅读:472&nbsp;&nbsp;评论:7&nbsp;&nbsp;喜欢:19
                                            </p>
                                        </div>

                                        <div class="desc">
                                            {{blog.content}}
                                        </div>

                                        <div class="desc-footer">
                                            <hr/>
                                            <p class="text-lowercase">
                                                一直觉得自己写的不是技术，而是情怀，一篇篇文章是自己这一路走来的痕迹。靠专业技能的成功是最具可复制性的，希望我的这条路能让你少走弯路，希望我能帮你抹去知识的蒙尘，希望我能帮你理清知识的脉络，希望未来技术之巅上有你也有我。
                                            </p>
                                        </div>

                                    </div>
                                    <img src="${xxblog_path}/images/home-img-1.png" alt="Image" class="img-responsive">
                                </div>
                            </div>
                        </div>
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
    <script type="application/javascript" src="${xxblog_path}/js/layui/layui.js"></script>
    <script src="${xxblog_path}/js/subject-controller.js"></script>
    </body>
</html>
