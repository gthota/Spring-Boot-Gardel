
<html>
<style>
#listPageTable{
	width: 100% !important;
	margin-left: 0% !important;
}
</style>
<body>

	<div data-ng-init="showListPage()">
		<div>
			<h1>Employee(s) List page</h1>
			<h2>${message}</h2>

			<h3>
				Below is the list of employee's details saved in the Database <img
					src="https://cdn4.iconfinder.com/data/icons/arrows-29/96/Arrows1_down-512.png"
					height="30px" width="30px" style="vertical-align: -10px;" />
			</h3>
			<table id="listPageTable">

				<tr id="header">

					<td>Employee Id</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Phone Number</td>
					<td>Email Id</td>
					<td>Actions</td>

				</tr>
				
					<tr data-ng-repeat="employee in employeeList">
						<td>{{employee.employeeId}}</td>
						<td>{{employee.firstName}}</td>
						<td>{{employee.lastName}}</td>
						<td>{{employee.phoneNumber}}</td>
						<td>{{employee.emailId}}</td>
						<td><a href="#" data-ng-click="viewEmployee(employee.employeeId)"> <img
								src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/edit-notes.png"
								title="View/Edit" height="40px" width="40px" />
						</a> <a href="#" data-ng-click="deleteEmployee(employee.employeeId)"
							> <img
								src="https://cdn2.iconfinder.com/data/icons/round-interface-1/217/50-512.png"
								title="Delete" height="40px" width="40px" />
						</a></td>
					</tr>

			</table>

		</div>
	</div>
</body>

</html>