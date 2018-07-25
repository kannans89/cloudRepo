angular.module('contact-spa-app')
.controller('initialController',['$scope','$rootScope',function($scope,$rootScope){
    $rootScope.contacts=[
        {
            id:101,
            name:"abc",
            contact:435435435
        },
        {
            id:102,
            name:"def",
            contact:87585685
        },
        {
            id:103,
            name:"ghi",
            contact:32132142
        }
    ];
    
}])
.controller('contactController',['$scope','$rootScope',function($scope,$rootScope){
   
    
}])
.controller('addController',['$scope','$rootScope','$window',function($scope,$rootScope,$window){
    $scope.id;
    $scope.name;
    $scope.contactno;

    $scope.addContact=function(){
        // alert("hi");
        var newContact={
            id:$scope.id,
            name:$scope.name,
            contact:$scope.contactno
        }
        $rootScope.contacts[$rootScope.contacts.length]=newContact;
        $window.location.href = '#/contact';
    }
    
}])
.controller('editController',['$scope','$rootScope','$window','$route','$routeParams',function($scope,$rootScope,$window,$route,$routeParams){
    $scope.id;
    $scope.name;
    $scope.contactno;
    var contactChangeIndex= $routeParams.cid;
    for(var i=0;i<$rootScope.contacts.length;i++){
        if($rootScope.contacts[i].id==contactChangeIndex){
            $scope.id=$rootScope.contacts[i].id;
            $scope.name=$rootScope.contacts[i].name;
            $scope.contactno=$rootScope.contacts[i].contact;      
            break;                  
        }
    }
    
    $scope.edit=function(){
        
        $rootScope.contacts[i].id=$scope.id;
        $rootScope.contacts[i].name=$scope.name;
        $rootScope.contacts[i].contact=$scope.contactno;
        $window.location.href = '#/contact';
    }
    
}])
.controller('deleteController',['$scope','$rootScope','$window','$route','$routeParams',function($scope,$rootScope,$window,$route,$routeParams){
    var contactTodelete= $routeParams.cid;
    for(var i=0;i<$rootScope.contacts.length;i++){
        if($rootScope.contacts[i].id==contactTodelete){
            break;
        }
    }   
    $rootScope.contacts.splice(i, 1);
    $window.location.href = '#/contact';
}]);