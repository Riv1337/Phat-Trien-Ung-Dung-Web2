<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Processing</title>
</head>
<body>
	<%// code java o day
	//lay du lieu
	String tenDangNhap;
	String matKhau;
	tenDangNhap= request.getParameter("loginName");
	matKhau= request.getParameter("loginPass");
	//In thu ra xem du lieu nhan duoc co dung k
	/* out.append(tenDangNhap + "<br>");
	out.append(matKhau + "<br>"); */
	if (tenDangNhap.equals("ABC") && matKhau.equals("MNK"))
	{
		//chuyen den trang UserProfile
		response.sendRedirect("/Chuong2_3/UserProfile.html");
	}
	else
	{
		//chuyem den trang Login.htm
		response.sendRedirect("/Chuong2_3/Login.html");
	}
	
	%>
</body>
</html>