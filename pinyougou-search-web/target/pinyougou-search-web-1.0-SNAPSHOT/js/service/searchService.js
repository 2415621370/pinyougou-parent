//服务层
app.service('serachService',function($http){


    //搜索
    this.search=function(searchMap){
        return $http.post('itemsearch/search.do', searchMap);
    }

});
