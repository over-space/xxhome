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

                                    <div class="form-group has-success has-feedback">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-envelope"></i>
                                            </span>
                                            <input type="text" class="form-control" id="username" name="username" aria-describedby="inputGroupSuccess1Status" placeholder="请输入邮箱..." ng-model="account.email">
                                        </div>
                                    </div>

                                    <#--确认密码    -->
                                    <div class="form-group has-success has-feedback">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span>
                                            <input type="text" class="form-control" id="password" name="password" aria-describedby="inputGroupSuccess1Status" placeholder="请输入密码..." ng-model="account.password">
                                        </div>
                                    </div>

                                    <#--验证码    -->
                                    <div class="form-group has-success has-feedback">
                                        <div class="input-group col-xs-8" style="float: left">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-magnet"></i>
                                            </span>
                                            <input type="text" class="form-control" id="captcha" name="captcha" aria-describedby="inputGroupSuccess1Status" placeholder="请输入验证码..." ng-model="account.captcha">
                                        </div>
                                        <img id="captchaImage" class="captchaImage" style="margin-left:10px;float: left;vertical-align: middle; cursor: pointer;" src="${path}/xxbase/captcha/image.xhtml?captchaId=${sessionId}" title="验证码"/>
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
