angular.module('bank-spa-app',['ngRoute'])
.config(function($routeProvider){
    $routeProvider
    .when("/", {
        controller:"loginController",
        templateUrl : "partials/login.html"
    })
    .when("/register", {
        controller:"registerController",
        templateUrl : "partials/register.html"
    })
    .when("/action", {
        controller:"actionController",
        templateUrl : "partials/action.html"
    })
    .when("/transaction", {
        controller:"transactionController",
        templateUrl : "partials/transaction.html"
    })
    .when("/passbook", {
        controller:"passbookController",
        templateUrl : "partials/passbook.html"
    });
})