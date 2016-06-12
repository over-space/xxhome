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
    <title>Accord - Contact</title>
</head>

<body class="contact-page">
<div class="main-body" ng-app="accountViewApp" ng-controller="account-controller">
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
                                    <h3>注册</h3>
                                    <h4><a href="login.xhtml">已经有账号了,直接去登录！</a></h4>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-12 col-md-6 contact_left">
                                <form class="form-horizontal" method="post" action="javascript:void(0)">

                                    <#--邮箱-->
                                    <div class="form-group has-success has-feedback" ng-class="{true:'has-success',false:'has-error'}[valid.isEmailValid]">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-envelope"></i>
                                            </span>
                                            <input type="text" class="form-control" id="email" name="email" aria-describedby="inputGroupSuccess1Status" placeholder="请输入邮箱..." ng-model="account.email" ng-blur="isEmailValid()">
                                        </div>
                                        <#--<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>-->
                                    </div>

                                    <#--用户名    -->
                                    <div class="form-group has-success has-feedback" ng-class="{true:'has-success',false:'has-error'}[valid.isUsernameValid]">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-user"></i>
                                            </span>
                                            <input type="text" class="form-control" id="username" name="username" aria-describedby="inputGroupSuccess1Status" placeholder="请输入用户名..." ng-model="account.username" ng-blur="isUsernameValid()">
                                        </div>
                                        <#--<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>-->
                                    </div>

                                    <#--密码-->
                                    <div class="form-group has-success has-feedback" ng-class="{true:'has-success',false:'has-error'}[valid.isPasswordValid]">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span>
                                            <input type="password" class="form-control" id="password" name="password" aria-describedby="inputGroupSuccess1Status" placeholder="请输入密码..." ng-model="account.password" ng-blur="isPasswordValid()">
                                        </div>
                                        <#--<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>-->
                                    </div>

                                    <#--确认密码    -->
                                    <div class="form-group has-success has-feedback" ng-class="{true:'has-success',false:'has-error'}[valid.isPassword2Valid]">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span>
                                            <input type="password" class="form-control" id="password2" name="password2" aria-describedby="inputGroupSuccess1Status" placeholder="请输入密码..." ng-model="account.password2" ng-blur="isPassword2Valid()">
                                        </div>
                                        <#--<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>-->
                                    </div>


                                    <#--验证码    -->
                                    <div class="form-group has-success has-feedback" ng-class="{true:'has-success',false:'has-error'}[valid.isCaptchaValid]">
                                        <div class="input-group col-xs-8" style="float: left">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-magnet"></i>
                                            </span>
                                            <input type="text" class="form-control" id="captcha" name="captcha" aria-describedby="inputGroupSuccess1Status" placeholder="请输入验证码..." ng-model="account.captcha" ng-blur="isCaptchaValid()">
                                        </div>
                                        <img id="captchaImage" class="captchaImage" style="margin-left:10px;float: left;vertical-align: middle; cursor: pointer;" src="${path}/xxbase/captcha/image.xhtml?captchaId=${sessionId}" title="验证码"/>
                                    </div>

                                    <div class="form-group">
                                        <input id="submit" name="submit" type="submit" value="确定"  class="btn view_more btn-submit" ng-click="doSignUp()">
                                        <a class="btn view_more btn-default" style="height: 48px;width: 106px;line-height: 20px;padding-top: 13px; float:right;" href="login.xhtml">登录</a>
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

    <script src="${xxbase_path}/js/jquery-1.11.3.min.js"></script>
    <script src="${xxblog_path}/js/bootstrap.min.js"></script>
    <script src="${xxbase_path}/js/angular.min.js"></script>
    <script src="${xxblog_path}/js/account-controller.js"></script>

    <script language="JavaScript">
        $(document).ready(function () {
            var $captchaImage = $("#captchaImage");
            $captchaImage.click(function (e) {
                $captchaImage.attr("src", "${path}/xxbase/captcha/image.xhtml?captchaId=${sessionId}&timestamp=" + e.timeStamp);
            });
        });
    </script>
</body>
</html>
