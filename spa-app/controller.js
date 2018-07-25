angular.module('spa-app')
.controller('homeController',['$scope','$rootScope',function($scope,$rootScope){
    $rootScope.hi="dadas";
    $scope.home={
        data:"hello world! this is home data"
    }
}])
.controller('aboutController',['$scope',function($scope){
    $scope.about={
        data:"hello world! this is about data"
    }
}])
.controller('careerController',['$scope',function($scope){
    $scope.career={
        data:"hello world! this is career data"
    }
}]);