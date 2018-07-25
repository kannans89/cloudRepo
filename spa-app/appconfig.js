angular.module('spa-app',['ngRoute'])
.config(function($routeProvider){
    $routeProvider
    .when("/", {
        controller:"homeController",
        templateUrl : "partials/home.html"
    })
    .when("/home", {
        controller:"homeController",
        templateUrl : "partials/home.html"
    })
    .when("/about", {
        controller:"aboutController",
        templateUrl : "partials/about.html"
    })
    .when("/career", {
        controller:"careerController",
        templateUrl : "partials/career.html"
    });
})