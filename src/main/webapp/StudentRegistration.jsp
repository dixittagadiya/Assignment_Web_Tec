<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration From</title>
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
	integrity="sha384-wfSDF2E50Y2D1uUdjx0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<script type="text/javascript">
	function validation()
	{
		var fname = document.getElementById("fname").value
		var lname = document.getElementById("lname").value
		var email = document.getElementById("email").value
		var mobile = document.getElementById("mobile").value
		var pass = document.getElementById("pass").value
		
		var fnameErr  = document.getElementById("fnameErr")
		var lnameErr  = document.getElementById("lnameErr")
		var emailErr  = document.getElementById("emailErr")
		var mobileErr = document.getElementById("mobileErr")
		var passErr   = document.getElementById("passErr")
		
		var fnameExp  = /^[a-zA-Z]+$/
		var lnameExp  = /^[a-zA-Z]+$/
		var emailExp  = /^[a-zA-z_0-9-]+@[a-z]+\.[a-z]{1,3}$/
		var mobileExp = /^\d{10}$/
		var passExp   = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[@!#$%&?"])[a-zA-Z0-9!@#$%&?]{8,20}$/
	
		if(fname==""||fname==null)
			{
				fnameErr.innerHTML = "fname can not be blank.!!"
			}
		else if(!fnameExp.test(fname))
			{
				fnameErr.innerHTML = "Use proper formate for fname(ALPHABATES ONLY)"
			}
		else
			{
				fnameErr.innerHTML = ""
			}
		if(lname==null||lname=="")
			{
				lnameErr.innerHTML = "lname can not be blank.!!"
			}
		else if(!lnameExp.test(lname))
			{
				lnameErr.innerHTML = "Use proper formate for lname(ALPHABATES ONLY)"
			}
		else
			{
				lnameErr.innerHTML = ""
			}
		if(email==""||email==null)
			{
				emailErr.innerHTML = "Email can not be blank.!!"
			}
		else if(!emailExp.test(email))
			{
				emailErr.innerHTML = "Use proper formate for email.!!"
			}
		else
			{
				emailErr.innerHTML = ""
			}
		if(mobile==""||mobile==null)
			{
				mobileErr.innerHTML = "mobile number can not be blank.!!"
			}
		else if(!mobileExp.test(mobile))
			{
				mobileErr.innerHTML = "mobile number must be 10 number.!!"
			}
		else
			{
				mobileErr.innerHTML = ""
			}
		if(pass==""||pass==null)
			{
				passErr.innerHTML = "Password can not be blank.!!"
			}
		else if(!passExp.test(pass))
			{
				passErr.innerHTML = "Use proper formate for password.!!"
			}
		else
			{
				passErr.innerHTML = ""
			}
		
		var submit = document.getElementbyId("submit")
	}
	
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 m-auto">
				<h1 class="text-success m-auto">Student Registration Form</h1>
				<b><span class="text-success">${registrationMsg}</span></b>
				<b><span class="text-success">${updateMsg}</span></b>
				<b><span class="text-danger">${emailErr}</span></b>
				<form action="rege" method="post">

					<div class="from-group">
						<input type="hidden" name="id" id="id" class="form-control" value="${sdata.getId()}">
					</div>

					<div class="form-group">
						<label>Fname</label> <input type="text" id="fname" name="fname"
							class="form-control" value="${sdata.getFname()}" onkeyup="validation()">
							<span id="fnameErr" class="text-danger"></span>
							<b class="text-danger" >${fnameErr}</b>
							<b class="text-danger">${fnameExpErr}</b>

					</div>

					<div class="form-group">
						<label>Lname</label> <input type="text"  id="lname" name="lname"
							class="form-control" value="${sdata.getLname()}" onkeyup="validation()">
							<span id="lnameErr" class="text-danger"></span>
							<b class="text-danger">${lnameErr}</b>
							<b class="text-danger">${lnameExpErr}</b>
					</div>

					<div class="form-group">
						<label>Email</label> <input type="text" id="email" name="email"
							class="form-control" value="${sdata.getEmail()}" onkeyup="validation()">
							<span id="emailErr" class="text-danger"></span>
							<b class="text-danger" >${emailErr}</b>
							<b class="text-danger" >${emailExpErr}</b>
					</div>

					<div class="form-group">
						<label>Mobile</label> <input type="text" id="mobile" name="mobile"
							class="form-control" value="${sdata.getMobile()}" onkeyup="validation()">
							<span id="mobileErr" class="text-danger"></span>
							<b class="text-danger" >${mobileErr}</b>
							<b class="text-danger" >${mobileExpErr}</b>
					</div>

					<div class="form-group">
						<label>Gender</label> <input type="radio" id="gender" name="gender"
							value="male" <c:if test="${sdata.getGender().equals('male')}"> checked = "/checked"/</c:if> >Male <input type="radio" name="gender"
							value="female" <c:if test="${sdata.getGender().equals('female')}"> checked = "/checked"/</c:if>>Female
					</div>

					<div div="form-group">
						<label>Password</label> <input type="text" name="pass" id="pass"
							class="form-control" value="${sdata.getPass()}" onkeyup="validation()">
						<span id="passErr" class="text-danger"></span>
						<b class="text-danger">${passErr}</b>
						<b class="text-danger" >${passExpErr}</b>
					</div>
					<br>
					<div>
						<input type="submit" id="submit" class="btn btn-success">
						<span><a href="StudentLogin.jsp">Already User Login here</a></span>
					</div>

				</form>

			</div>
		</div>
	</div>
</body>
</html>