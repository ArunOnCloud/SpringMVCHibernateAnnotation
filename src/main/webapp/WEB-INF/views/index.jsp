<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body ng-app="myapp" ng-controller="myCtrl">

<form>
  Select a topic:
  <select ng-model="myVar">
    <option value="">
    <option value="dogs">create ticket
    <option value="tuts">Tutorials
    <option value="cars">Cars
  </select>
</form>

<div ng-switch="myVar">
  <div ng-switch-when="dogs">
     <h1>Dogs</h1>
     <p>Welcome to a world of dogs.</p>
  </div>
  <div ng-switch-when="tuts">
     <h1>Tutorials</h1>
     <p>Learn from examples.</p>
  </div>
  <div ng-switch-when="cars">
     <h1>Cars</h1>
     <p>Read about cars.</p>
  </div>
</div>

<p>The ng-switch directive hides and shows HTML sections depending on the value of the dropdown list.</p>

</body>
<script>
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
</script>
</html>
