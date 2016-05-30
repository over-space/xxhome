<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${xxbase_path}/icon/favicon.ico"/>

        <#--<link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic'>-->
        <#--<link rel="stylesheet" type="text/css" href="${xxblog_path}/css/bootstrap.min.css">-->
        <#--<link rel="stylesheet" type="text/css" href="${xxblog_path}/fonts/css/font-awesome.min.css">-->
        <#--<link rel="stylesheet" type="text/css" href="${xxblog_path}/css/style.css">-->

    </head>


    <body>
        <div class="main-menu">

            <div class="menu-container">
                <div class="block-keep-ratio block-keep-ratio-2-1 block-width-full home">
                    <a href="index.xhtml" class="block-keep-ratio__content  main-menu-link">
                        <span class="main-menu-link-text">
                            首页
                        </span>
                    </a>
                </div>
            </div>

            <div class="menu-container">
                <div class="block-keep-ratio  block-keep-ratio-1-1  block-width-half  pull-left  about-main"
                     ng-click="doAccountManager()">
                    <a href="sign.xhtml" class="main-menu-link about block-keep-ratio__content flexbox-center">
                        <i class="fa fa-user fa-4x main-menu-link-icon"></i>
                        登录/注册
                    </a>
                </div>

                <div class="block-keep-ratio  block-keep-ratio-1-1  block-width-half  pull-right  contact-main">
                    <a href="write.xhtml" class="main-menu-link contact block-keep-ratio__content flexbox-center">
                        <i class="fa fa-pencil-square-o fa-4x main-menu-link-icon"></i>
                        写博客
                    </a>
                </div>
            </div>

            <div class="menu-container">
                <div class="block-keep-ratio  block-keep-ratio-1-1  block-width-half  pull-left  about-main" id="xx-menu">
                    <a href="list.xhtml" class="main-menu-link about block-keep-ratio__content flexbox-center">
                        <i class="fa fa-bars fa-4x main-menu-link-icon"></i>
                        我的博客
                    </a>
                </div>

                <div class="block-keep-ratio  block-keep-ratio-1-1  block-width-half  pull-right  contact-main">
                    <a href="contact.xhtml" class="main-menu-link contact block-keep-ratio__content flexbox-center">
                        <i class="fa fa-comments fa-4x main-menu-link-icon"></i>
                        消息
                    </a>
                </div>
            </div>

            <div class="menu-container">
                <div class="block-keep-ratio block-keep-ratio-1-1 block-keep-ratio-md-2-1 block-width-full gallery">
                    <a href="gallery.xhtml" class="main-menu-link  block-keep-ratio__content">
                        <span class="main-menu-link-text">
                            相册
                        </span>
                    </a>
                </div>
            </div>

            <!-- sidebar carousel -->
            <div class="menu-container">
                <div class="mauris">
                    <div id="carousel-menu" class="carousel slide" data-ride="carousel">
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="${xxblog_path}/images/slider-img-1.png" alt="slider">
                                <div class="carousel-caption menu-caption">
                                    mauris vita
                                </div>
                            </div>
                            <div class="item">
                                <img src="${xxblog_path}/images/menu-bg-home.png" alt="slider">
                                <div class="carousel-caption menu-caption">
                                    lorem ipsum
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-menu" role="button" data-slide="prev">
                            <span class="fa fa-caret-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-menu" role="button" data-slide="next">
                            <span class="fa fa-caret-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div> <!-- .mauris -->
            </div>
        </div> <!-- main-menu -->


        <#--<script src="${xxblog_path}/js/jquery-1.11.3.min.js"></script>-->
        <#--<script src="${xxbase_path}/js/layer/layer.js"></script>-->

        <#--<script language="JavaScript">-->
            <#--$('#xx-menu').on('click', function(){-->
                <#--layer.open({-->
                    <#--type: 2,-->
                    <#--area: ['600px', '360px'],-->
                    <#--shadeClose: true, //点击遮罩关闭-->
                    <#--content: 'login.xhtml'-->
                <#--});-->
            <#--});-->
        <#--</script>-->

    </body>
</html>