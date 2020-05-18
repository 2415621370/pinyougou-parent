//控制层
app.controller('contentController', function($scope, $controller,
                                             contentService) {


    $scope.findByCategoryId = function(categoryId) {
    	console.log("=====")
        contentService.findByCategoryId(categoryId).success(function(res) {
            console.log(res)
            $scope.contentList = res;
        })
    }

});
