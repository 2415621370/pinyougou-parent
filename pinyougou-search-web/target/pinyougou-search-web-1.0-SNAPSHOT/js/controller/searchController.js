//控制层
app.controller('searchController', function($scope, $controller,
                                             searchService) {


    $scope.search = function() {
        console.log("=====")
        searchService.search($scope.searchMap).success(function(res) {
            console.log(res)
            $scope.resultMap = res;
        })
    }

});
