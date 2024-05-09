<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-5 m-auto">
				<form action="reg" method="post">
					<div class="form-group">
						<label>Fname</label>
						<span class="text-danger">${fnameerr}</span> <input type="text" placeholder="Enter Fname"
							class="form-control" name="fname" >
					</div>
					<div class="form-group">
						<label>Lname</label>
						<span class="text-danger">${lnameerr}</span> <input type="text" placeholder="Enter Lname"
							class="form-control" name="lname" >
					</div>
					<div class="form-group">
						<label>Email</label> 
						<span class="text-danger">${Emailerr}</span><input type="text" placeholder="Enter Email"
							class="form-control" name="email" >
					</div>
					<div class="form-group">
						<label>Mobile</label>
						 <span class="text-danger">${mobileerr}</span><input type="text"
							placeholder="Enter Mobile" class="form-control" name="mobile" >
					</div>
					<div class="form-group">
						<label>Gender</label> <input type="radio" name="gender"
							value="male">Gender<input type="radio" name="gender"
							value="female">Female
					</div>
					<div class="form-group">
						<label>Password</label>
						<span class="text-danger">${passErr}</span> <input type="text"
							placeholder="Enter Passoword" class="form-control" name="password">
					</div>
					<input type="submit" class="btn btn-success">

				</form>

			</div>
		</div>
	</div>
</body>
</html>