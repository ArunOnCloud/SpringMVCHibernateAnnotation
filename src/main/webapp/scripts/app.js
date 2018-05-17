var app = angular.module("myapp", []);
app.controller('myCtrl', function($scope, $http) {
    /* $http.get("welcome.htm")
    .then(function(response) {
        $scope.myWelcome = response.data;
    }); */
    $scope.ticket={};
    $scope.createTicket=function(){
    	/* $http.post("welcome.htm",$scope.ticket)
        .then(function(response) {
            $scope.myWelcome = response.data;
        }); */
    }
    $scope.getEmployees=function(){
    	$http.get("department")
        .then(function(response) {
            $scope.myWelcome = response.data;
        });
    }
});