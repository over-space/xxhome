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
    <title>Accord - Contact</title>
</head>

<body class="contact-page">
<div class="main-body">
    <div class="container">
        <div class="row">

            <div class="main-page">
                <aside class="main-navigation">
                <#include "xx-blog/base/menu.ftl"/>
                </aside> <!-- main-navigation -->

                <div class="content-main contact-content">
                    <div class="contact-content-upper">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="gallery_title">
                                    <h3>登录</h3>
                                    <h4><a href="signup.xhtml">未注册过用户可以点击直接登录哦！</a></h4>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-12 col-md-6 contact_left">
                                <form class="form-horizontal" method="post" action="">

                                    <div class="form-group">
                                        <input type="text" class="form-control" id="name" name="name"
                                               placeholder="请输入邮箱..." value="">
                                    </div>

                                    <div class="form-group">
                                        <input type="password" class="form-control" id="email" name="password"
                                               placeholder="请输入密码..." value="">
                                    </div>

                                    <div class="form-group">
                                        <input type="text" class="form-control" style="width: 180px; float: left"
                                               id="captcha" name="captcha" placeholder="验证码..." value="">
                                        <img id="captchaImage" class="captchaImage"
                                             style="margin-left:10px;float: left;vertical-align: middle; cursor: pointer;"
                                             src="${path}/xxbase/captcha/image.xhtml?captchaId=${sessionId}"
                                             title="验证码"/>
                                    </div>

                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" id="remember" name="remember"> 记住密码
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <input id="submit" name="submit" type="submit" value="登录"
                                               class="btn view_more btn-submit">
                                        <a class="btn view_more btn-default"
                                           style="height: 48px;width: 106px;line-height: 20px;padding-top: 13px; float:right;"
                                           href="signup.xhtml">注册</a>
                                    </div>

                                </form>
                            </div> <!-- .contact-left -->

                            <div class="col-sm-12 col-md-6 contact_right">


                                <div class="col-md-12 contact_info">
                                    <a href="mailto:info@company.com" class="contact-info-link">
                                        <i class="fa fa-envelope contact-fa"></i>xxplus@outlook.com
                                    </a><br/>
                                    <a href="+15618757547" class="contact-info-link">
                                        <i class="fa fa-mobile contact-fa"></i>156-1875-7547
                                    </a><br/>
                                    <a href="+297177122" class="contact-info-link">
                                        <i class="fa fa-phone contact-fa"></i>297177122
                                    </a><br/>
                                </div>

                                <div class="col-md-12">
                                    <span><i class="fa fa-rss social-icon rss_icon"></i></span>
                                    <span><i class="fa fa-twitter social-icon twitter_icon"></i></span>
                                    <span><i class="fa fa-facebook social-icon facebook_icon"></i></span>
                                </div>

                            </div> <!-- .contact_right -->

                        </div> <!-- .row -->
                    </div>

                </div> <!-- .contact-content -->
            </div> <!-- .main-page -->
        </div> <!-- .row -->

        <footer class="row">
        <#include "xx-blog/base/footer.ftl"/>
        </footer>  <!-- .row -->

    </div> <!-- .container -->
</div> <!-- .main-body -->

<script src="${xxblog_path}/js/jquery-1.11.3.min.js"></script>
<script src="${xxblog_path}/js/bootstrap.min.js"></script>

<script language="JavaScript">
    $().ready(function () {
        var $captchaImage = $("#captchaImage");
        $captchaImage.click(function (e) {
            $captchaImage.attr("src", "${path}/xxbase/captcha/image.xhtml?captchaId=${sessionId}&timestamp=" + e.timeStamp);
        });
    });
</script>
</body>
</html>
