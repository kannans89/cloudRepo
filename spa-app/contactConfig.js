angular.module('contact-spa-app',['ngRoute'])
.config(function($routeProvider){
    $routeProvider
    .when("/", {
        controller:"initialController",
        templateUrl : "partials/contact.html"
    })
    .when("/contact", {
        controller:"editController",
        templateUrl : "partials/contact.html"
    })
    .when("/add", {
        controller:"addController",
        templateUrl : "partials/add.html"
    })
    .when("/edit/:cid", {
        controller:"editController",
        templateUrl : "partials/edit.html"
    })
    .when("/delete/:cid", {
        controller:"deleteController",
        templateUrl : "partials/delete.html"
    });
})