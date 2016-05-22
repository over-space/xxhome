var accountViewApp = angular.module('accountViewApp', []);
accountViewApp.controller('accountController', function ($scope, $http) {

    $scope.isCheckRight = true;
    $scope.account = {
        email: '',
        username: '',
        password: '',
        password2: '',
        message: '',
        captcha: ''
    };


    //注册
    $scope.doSignUp = function () {
        $scope.isCheckRight = true;

        var flag = checkAccount();

        if (!flag) return false;

        if (!$scope.isCheckRight) return false;


        $http.post("../account/signup.xhtml", $scope.account).success(function (req) {
            if (req.code != 0) {
                $scope.isCheckRight = false;
                $scope.message = req.message;
            }
        });
    }


    //校验邮箱
    $scope.checkEmail = function () {
        if ($scope.account.email == "") {
            $scope.account.message = "邮箱不允许为空!";

            return false;
        }

        $http.post("../account/check.xhtml?email=" + $scope.account.email).success(function (req) {

            if (req.code == 0) return true;

            $scope.isCheckRight = false;
            $scope.account.message = req.message;
        });
    }


    var checkAccount = function () {

        if ($scope.account.email == "") {
            $scope.account.message = "邮箱不允许为空!";
            $scope.isCheckRight = false;
            return false;
        }

        if ($scope.account.username == "") {
            $scope.account.message = "用户名不允许为空!";
            $scope.isCheckRight = false;
            return false;
        }


        if ($scope.account.password2 == "") {
            $scope.account.message = "密码不允许为空!";
            $scope.isCheckRight = false;
            return false;
        }

        if ($scope.account.password.length < 6) {
            $scope.account.message = "密码过于简单，密码长度必须大于6位字符!";
            $scope.isCheckRight = false;
            return false;
        }

        if ($scope.account.password != $scope.account.password2) {
            $scope.account.message = "两次密码输入不一致!";
            $scope.isCheckRight = false;
            return false;
        }

        if ($scope.account.captcha == "") {
            $scope.account.message = "请输入验证码!";
            $scope.isCheckRight = false;
            return false;
        }

        return true;
    }


});