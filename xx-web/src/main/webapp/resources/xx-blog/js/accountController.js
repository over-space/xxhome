var accountViewApp = angular.module('accountViewApp', []);
accountViewApp.controller('accountController', function ($scope, $http) {



    $scope.valid = {isEmailValid:true,
        isUsernameValid:true,
        isPasswordValid:true,
        isPassword2Valid:true,
        isCaptchaValid:true,
        message:''};

    $scope.account = {
        email: '',
        username: '',
        password: '',
        password2: '',
        captcha: ''
    };


    //注册
    $scope.doSignUp = function () {
        var flag = isAccountValid();

        if (!flag) return false;

        $http.post("../account/signup.xhtml", $scope.account).success(function (req) {
            if (req.code != 0) {
                $scope.valid.message = req.message;
            }
        });
    }


    $scope.isEmailValid = function () {
        $scope.valid.isEmailValid = true;
        if ($scope.account.email == "") {
            $scope.valid.isEmailValid = false;
            $scope.valid.message = "邮箱不允许为空!";
            return false;
        }

        $http.post("../account/check/email.xhtml?value=" + $scope.account.email).success(function (req) {
            if (req.errorCode == 0) return true;
            $scope.valid.isEmailValid = false;
            $scope.valid.message = req.message;
            return false;
        });
        return false;
    }

    $scope.isUsernameValid = function () {
        $scope.valid.isUsernameValid = true;
        if ($scope.account.username == "") {
            $scope.valid.isUsernameValid = false;
            $scope.valid.message = "用户名不允许为空!";
            return false;
        }
        return true;
    }

    $scope.isPasswordValid = function () {
        $scope.valid.isPasswordValid = true;
        if ($scope.account.password == "") {
            $scope.valid.isPasswordValid = false;
            $scope.valid.message = "密码不允许为空!";
            return false;
        }
        else if ($scope.account.password.length < 6) {
            $scope.valid.isPasswordValid = false;
            $scope.valid.message = "密码过于简单，密码长度必须大于6位字符!";
            return false;
        }
        return true;
    }

    $scope.isPassword2Valid = function () {
        $scope.valid.isPassword2Valid = true;
        if ($scope.account.password != $scope.account.password2) {
            $scope.valid.isPassword2Valid = false;
            $scope.valid.message = "两次密码输入不一致!";
            return false;
        }
        return true;
    }

    $scope.isCaptchaValid = function () {
        $scope.valid.isCaptchaValid = true;
        if ($scope.account.captcha == "") {
            $scope.valid.isCaptchaValid = false;
            $scope.valid.message = "请输入验证码!";
            return false;
        }
        else if ($scope.account.captcha.length != 4) {
            $scope.valid.isCaptchaValid = false;
            $scope.valid.message = "验证码输入错误!";
            return false;
        }

        $http.post("../account/check/captcha.xhtml?value=" + $scope.account.captcha).success(function (req) {
            if (req.errorCode == 0) return true;
            $scope.valid.isCaptchaValid = false;
            $scope.valid.message = req.message;
            return false;
        });

        return true;
    }


    var isAccountValid = function () {
        var flag = true;

        if(flag) flag = $scope.isEmailValid();
        if(flag) flag = $scope.isUsernameValid();
        if(flag) flag = $scope.isPasswordValid();
        if(flag) flag = $scope.isPassword2Valid();
        if(flag) flag = $scope.isCaptchaValid();

        return flag;
    }


});