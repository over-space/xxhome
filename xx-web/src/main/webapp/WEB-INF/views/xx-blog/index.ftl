<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic'>
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/font/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/style.css">
    <link rel="shortcut icon" href="${xxbase_path}/icon/favicon.ico" />

    <title>XX博客首页</title>
</head>

<body>
    <div class="main-body" ng-app="mainViewApp" ng-controller="mainViewController">
        <div class="container">
            <div class="row">               
                <div class="main-page">

                    <aside class="main-navigation">
                        <#include "xx-blog/base/menu.ftl"/>
                    </aside> <!-- main-navigation -->
                    
                    <div class="copyrights">Collect from <a href="http://www.17sucai.com/" >企业网站模板</a></div>

                    <div class="content-main">
                        <div class="row margin-b-30">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="banner-main-home">                                
                                    <div class="banner-main-home-text">
                                        <div class="heading">
                                            <h1>ACCORD</h1>
                                            <p class="text-uppercase">Proin gravida nibhISI</p>
                                        </div>
                                        <div class="desc">
                                            <p>This is free Bootstrap v3.3.6 website theme brought to you by templatemo. Feel free to use it. Please tell your friends about it. Images are provided by <a rel="nofollow" href="http://unsplash.com" target="_parent">Unsplash</a> (free photo website). Icons are from Smashing Magazine.</p>
                                            <button type="button" class="">SAGITIS SELIT</button>
                                        </div>
                                    </div>
                                    <img src="${xxblog_path}/images/home-img-1.png" alt="Image" class="img-responsive">
                                </div>                        
                            </div>    
                        </div>
                        <div class="row margin-b-30">
                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="box london">
                                    <div class="box-icon">
                                        <img src="${xxblog_path}/images/home-img-2.jpg" alt="Image" class="img-responsive">
                                    </div>
                                    <div class="info float-container">
                                        <div class="col-sm-12 london-title">
                                            <h3 class="text-uppercase">Proin gravida nibhvel</h3>
                                            <h4 class="text-uppercase">mauris vitae erat</h4>
                                        </div>
                                        <p>Sean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. </p><hr />
                                        <div class="col-sm-12 location-main"> 
                                            <div class="pull-left location">
                                                <i class="fa fa-map-marker fa-2x"></i><span>LONDON</span>
                                            </div>
                                            <div class="pull-right user-icons">
                                                <a href="#"><i class="fa fa-star fa-2x"></i></a>
                                                <a href="#"><i class="fa fa-user fa-2x"></i></a>
                                                <a href="#"><i class="fa fa-twitter fa-2x"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="box paris">
                                    <div class="box-icon">
                                        <img src="${xxblog_path}/images/home-img-3.jpg" alt="Image" class="img-responsive">
                                    </div>
                                    <div class="info float-container">
                                        <div class="col-sm-12 london-title paris-title">
                                            <h3 class="text-uppercase">Proin gravida nibhvel</h3>
                                            <h4 class="text-uppercase">mauris vitae erat</h4>
                                        </div>
                                        <p>Sean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. </p><hr />
                                        <div class="col-sm-12 location-main"> 
                                            <div class="pull-left location location2">
                                                <i class="fa fa-map-marker fa-2x"></i><span>PARIS</span>
                                            </div>
                                            <div class="pull-right user-icons">
                                                <a href="#"><i class="fa fa-star fa-2x"></i></a>
                                                <a href="#"><i class="fa fa-user fa-2x"></i></a>
                                                <a href="#"><i class="fa fa-twitter fa-2x"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- row -->
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="box bottom-main">
                                    <div class="info float-container">
                                        <div class="col-sm-12 bottom-title">
                                            <h3 class="text-uppercase">Proin gravida nibhvel</h3>
                                            <h4 class="text-uppercase">mauris vitae erat</h4>
                                        </div>
                                        <div class="row">
                                            <div class="col-xxs-12 col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                                <div class="bottom-img">
                                                    <img src="${xxblog_path}/images/home-img-4.jpg" alt="Image">
                                                    <p class="first">Sollicitudin nibh</p>    
                                                </div>                                      
                                            </div>
                                            <div class="col-xxs-12 col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                                <div class="bottom-img">
                                                    <img src="${xxblog_path}/images/home-img-5.jpg" alt="Image">
                                                    <p class="second">duis sedio amiet</p>    
                                                </div>                                      
                                            </div>
                                            <div class="col-xxs-12 col-xs-6 col-sm-6 col-md-4 col-lg-4">
                                                <div class="bottom-img">
                                                    <img src="${xxblog_path}/images/home-img-6.jpg" alt="Image">
                                                    <p class="third">Nec sagittis seim</p>    
                                                </div>                                      
                                            </div>
                                        </div>
                                        <p class="bottom-desc">Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo. </p><hr />
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
    <script src="${xxblog_path}/js/jquery-1.11.3.min.js"></script>
    <script src="${xxblog_path}/js/bootstrap.min.js"></script>
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script type="application/javascript" src="${xxblog_path}/js/mainViewController.js"></script>
    <script type="application/javascript" src="${xxblog_path}/js/layui/layui.js"></script>
</body>
</html>
