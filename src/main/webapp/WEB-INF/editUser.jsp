<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${result}" var="data2">	
<div class="container d-flex justify-content-center">
<div class="card col-sm-5">
<div class="card-header">
<h5>Edit User</h5>
</div>

<div class="card-body">
<font color="red"></font>

	<form method="post" action="/mainapp/myUsers/edit/${data2.id}" >
		Name : <input type="text" name="name" value="${data2.name}" class="form-control col-sm-3" required/>
		Email : <input type="email" name="email" value="${data2.email}" class="form-control col-sm-3 mb-3" required/> 
		
		
		Address : <input type="text" name="address" value="${data2.address}" class="form-control col-sm-3" required/>
		Password : <input type="password" name="password" value="${data2.password}" class="form-control col-sm-3 mb-3" required/>
		
		
		Phone number : <input type="text" name="contact" value="${data2.contact}" class="form-control col-sm-3" required/>
		<input type="hidden" name="admin_id"  value="${data2.admin_id}" class="form-control col-sm-3 mb-3" required/>
		
		<div class="col-sm-3 mb-3">
		<input type="submit" class="btn btn-primary" value="Update"/></div>
		
	</form>
	</div></div>
	</div>
</c:forEach>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>