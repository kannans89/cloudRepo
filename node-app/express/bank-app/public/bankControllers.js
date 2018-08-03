angular.module('bank-spa-app')
.controller('loginController',['$scope','$http','$rootScope','$timeout',function($scope,$http,$rootScope,$timeout){
    $rootScope.signup=false;
    $rootScope.logout=true;
    $rootScope.currentUsername;
    $rootScope.isloggedin=false;
    $rootScope.id=1;
    var url="http://localhost:5556/api/bank/login";
    $scope.ustar="";
    $scope.pstar="";
    $scope.username="";
    $scope.password="";
    $scope.authenticate=function(){
     if($scope.validate($scope.username,$scope.password)){
        var authenticateUser={"username":$scope.username,"password":$scope.password};
        $http.post(url, authenticateUser)
        .success(function(response) {
            $scope.isloggedin=response;
            if(response==false){
                alert("Incorrect username or password");
            }
            else{
                $rootScope.signup=true;
                $rootScope.logout=false;
                $rootScope.currentUsername=$scope.username;
                $rootScope.isloggedin=true;
                    location.href="http://localhost:5556/main.html#/action";
            }
        });
        }
        else{
            alert("Enter all the details");
        }
    }
    $scope.validate=function(u,p){
    if(u!="" && p!="")
        return true;
    else{
        if(u==""){
            $scope.ustar="*";
            
        }
        else{
            $scope.ustar="";
        }
        if(p==""){
            $scope.pstar="*";
        }
        else{
            $scope.pstar="";
        }
        return false;
    }
    }
}])
.controller('registerController',['$scope','$rootScope','$http','$timeout',function($scope,$rootScope,$http,$timeout){
    var url="http://localhost:5556/api/bank/register";
    $rootScope.signup=true;
    $scope.registerMaster={
        username:"",
        password:"",
        retype:"",
        amount:""
    }
    $scope.register=function(){
        var url="http://localhost:5556/api/bank/register";
        
        var newMaster={"name":$scope.registerMaster.username,"balance":$scope.registerMaster.amount,"password":$scope.registerMaster.password};
        $http.post(url, newMaster);
        $rootScope.id++;
        alert("Register Successful! Please Login to continue");
        
        $timeout(function () {
            location.href="http://localhost:5556/main.html#/";
        }, 100);
    }
}])
.controller('actionController',['$scope','$rootScope','$window',function($scope,$rootScope,$window){
   $scope.user=$rootScope.currentUsername;
}])
.controller('transactionController',['$scope','$http','$rootScope','$timeout',function($scope,$http,$rootScope,$timeout){
    if($rootScope.isloggedin==true){
    var url="http://localhost:5556/api/bank/action";
    var redirecturl="http://localhost:5556/main.html#/action";
    $scope.type;
    $scope.amount;
    $scope.submit=function(){
         $rootScope.id++;
        var action={"id":$rootScope.id,"amount":$scope.amount,"type":$scope.type,"name":$rootScope.currentUsername};
        
        $http.post(url,action);
        alert("Transaction Complete");
        $timeout(function () {
            location.href="http://localhost:5556/main.html#/action";
        }, 100);
        
    }
    }
    else{
        alert("You need to log in first");
        location.href="http://localhost:5556/main.html#/";
    }
    
}])
.controller('passbookController',['$scope','$rootScope','$http',function($scope,$rootScope,$http){
    if($rootScope.isloggedin==true){
    $scope.passbook;    
    var url="http://localhost:5556/api/bank/passbook";
    $http.get(url)
    .success(function(response) {
        $scope.passbook=response;
    });
    }
    else{
        alert("You need to log in first");
        location.href="http://localhost:5556/main.html#/";
    }
}]);
