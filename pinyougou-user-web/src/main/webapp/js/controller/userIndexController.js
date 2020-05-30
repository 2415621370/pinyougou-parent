//控制层
app.controller('userIndexController' ,function($scope,$controller   ,loginService){
    $scope.showName = function () {
        loginService.showName().success(
            function (res) {
                $scope.loginName =  res.loginName;
            }
        )
    }

});
