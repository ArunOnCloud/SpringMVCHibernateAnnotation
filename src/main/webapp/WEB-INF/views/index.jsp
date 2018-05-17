<!DOCTYPE html>
<html  >



<meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Angular Material style sheet -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Angular Material requires Angular.js Libraries -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-messages.min.js"></script>

  <!-- Angular Material Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.js"></script>
  
  <!-- Your application bootstrap  -->




<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

<body ng-app="mui" ng-controller="myCtrl">

<form>
  Select a topic:
  <select ng-model="myVar">
    <option value="">
    <option value="createTicket">create ticket</option>
    <option value="ticket">tickets</option>
    <option value="department">department</option>
    <option value="employee">Employee</option>
  </select>
</form>



<div ng-switch="myVar">
<div ng-switch-when="createTicket">
    <form class="form-horizontal">

       
        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label">Summery</label>
            <div class="col-sm-6">
                <input type="text" id="firstName" class="form-control" ng-model="ticketModel.summary" />
            </div>
            <div class="col-sm-3"></div>

        </div>
        <div class="form-group">
            <label for="lastName" class="col-sm-3 control-label">description</label>
            <div class="col-sm-6">
                <input type="text" id="lastName" class="form-control" ng-model="ticketModel.description" />
            </div>
            <div class="col-sm-3"></div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-3 control-label">created by</label>
            <div class="col-sm-6">
                <md-autocomplete md-selected-item="ticketModel.createdBy" md-search-text="searchText1"  md-items="item in getEmployeesByName(searchText1)" md-item-text="item.employeeName">
				  <md-item-template>
				    <span md-highlight-text="searchText1">{{item.employeeName}}</span>
				  </md-item-template>
				  <md-not-found>
				    No matches found.
				  </md-not-found>
				</md-autocomplete>
            </div>
            <div class="col-sm-7"></div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-3 control-label">assigned to</label>
            <div class="col-sm-6">
                <md-autocomplete md-selected-item="ticketModel.assignedTo" md-search-text="searchText2"  md-items="item in getEmployeesByName(searchText2)" md-item-text="item.employeeName">
				  <md-item-template>
				    <span md-highlight-text="searchText2">{{item.employeeName}}</span>
				  </md-item-template>
				  <md-not-found>
				    No matches found.
				  </md-not-found>
				</md-autocomplete>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-3 control-label">close by</label>
            <div class="col-sm-6">
                <md-autocomplete md-selected-item="ticketModel.closeBy" md-search-text="searchText3"  md-items="item in getEmployeesByName(searchText3)" md-item-text="item.employeeName">
				  <md-item-template>
				    <span md-highlight-text="searchText3">{{item.employeeName}}</span>
				  </md-item-template>
				  <md-not-found>
				    No matches found.
				  </md-not-found>
				</md-autocomplete>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <input type="submit" value="Save" class="btn btn-primary col-sm-offset-3" ng-click="createTicket()"/> 
        
    </form>

</div>
  <div ng-switch-when="ticket">
     <h1>Ticket </h1>
     <table>
		  <tr>
		    <th>Description</th>
		    <th>Summery</th>
		    <th>Created by</th>
		    <th>Assigned TO</th>
		    <th>Close By</th>
		  </tr>
		  <tr  ng-repeat="ticket in tickets track by $index">
		    <td>{{ticket.description}}</td>
		    <td>{{ticket.summery}}</td>
		    <td>{{ticket.createdBy}}</td>
		    <td>{{ticket.assignedTo}}</td>
		    <td>{{ticket.closeBy}}</td>
		  </tr>
  
     </table>
  </div>
  <div ng-switch-when="department">
     <h1>Departments</h1>
    <table>
	  <tr>
	    <th>#Serial Number</th>
	    <th>Deaprtment Name</th>
	    
	  </tr>
	  <tr ng-repeat="department in departments track by $index">
	    <td>{{$index}}</td>
	    <td>{{department.departmentName}}</td>
	    
	  </tr>
  
  
    </table>
    <h1>Pending Tickets of Departments</h1>
    Select a topic:
	  <select ng-change="getDepartmentsPendingTickets(dept)" ng-model="dept">
	    <option value={{item.departmentId}} ng-repeat="item in departments track by $index"> {{item.departmentName}}</option>
	   <!--  <option value="createTicket">create ticket</option>
	    <option value="ticket">tickets</option>
	    <option value="department">department</option>
	    <option value="employee">Employee</option> -->
	  </select>
     
     <table>
		  <tr>
		    <th>Description</th>
		    <th>Summery</th>
		    <th>Created by</th>
		    <th>Assigned TO</th>
		    <th>Close By</th>
		  </tr>
		  <tr  ng-repeat="ticket in departmentsPendingTickets track by $index">
		    <td>{{ticket.description}}</td>
		    <td>{{ticket.summery}}</td>
		    <td>{{ticket.createdBy}}</td>
		    <td>{{ticket.assignedTo}}</td>
		    <td>{{ticket.closeBy}}</td>
		  </tr>
  
     </table>
  </div>
  <div ng-switch-when="employee">
     <h1>Employee</h1>
     <table>
	  <tr>
	    <th>#Serial Number</th>
	    <th>Employee Name</th>
	    <th>Department Name</th>
	    <th>Manager Id</th>
	    
	  </tr>
	     <tr ng-repeat="employee in employees track by $index">
	    <td>{{$index}}</td>
	    <td>{{employee.employeeName}}</td>
	    <td>{{employee.department.departmentName}}</td>
	    <td>{{employee.managerEmployeeId}}</td>
	   </tr>
     </table>
 
  </div>
</div>


</body>
<script>
var app = angular.module("mui", ['ngMaterial']);
app.controller('myCtrl', function($scope, $http) {
    
    $scope.ticketModel={};
    $scope.departments=[];
    $scope.departmentsPendingTickets=[];
    $scope.employees=[];
    $scope.employeesSearch=[];
    $scope.tickets=[];
    $scope.createTicket=function(){
    	
    };
    $scope.getTickets=function(){
    	$http.get("tickets")
        .then(function(response) {
            $scope.tickets = response.data;
        });
    };
    $scope.getDepartmentsPendingTickets=function(id){
    	if(id){
    		$http.get("tickets/pending/department/"+id)
            .then(function(response) {
                $scope.departmentsPendingTickets = response.data;
            });
    	}
    	
    };
    
    $scope.getDepartment=function(){
    	$http.get("departments")
        .then(function(response) {
            $scope.departments = response.data;
        });
    };
   
    $scope.getEmployees=function(){
    	$http.get("employees?data=")
        .then(function(response) {
            $scope.employees = response.data;
        });
    };
    $scope.getEmployeesByName=function(text){
    	return $http.get("employees?data="+text)
        .then(function(response) {
            $scope.employeesSearch = response.data; 
            return $scope.employeesSearch;
        });
    };
    $scope.init=function(){
    	$scope.getDepartment();
    	$scope.getEmployees();
    	$scope.getTickets();
    	
    };
    $scope.validateTicket=function(){
    	
    };
    $scope.createTicket=function(){
    	
    	var ticket={};
    	angular.copy($scope.ticketModel, ticket);
    	if($scope.ticketModel.createdBy){
    		ticket.createdBy=$scope.ticketModel.createdBy.employeeId;
    	}
    	
    	if($scope.ticketModel.assignedTo){
    		ticket.assignedTo=$scope.ticketModel.assignedTo.employeeId;
    	}
    	if($scope.ticketModel.closeBy){
    		ticket.closeBy=$scope.ticketModel.closeBy.employeeId;
    	}
    	ticket.creationTime=null;
    	ticket.assignmentTime=null;
    	ticket.closingTime=null;
    	//ticket.summary=$scope.ticketModel.summary;
    	$http.post("ticket",ticket)
        .then(function(response) {
            //alert( response.data);
            $scope.myVar="ticket";
            $scope.getTickets();
            
        });
    	
    }
    
    $scope.init();
   
    
});
</script>
</html>
