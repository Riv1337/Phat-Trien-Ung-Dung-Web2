<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 2: Declare + code + Expressions</title>
</head>
<body>
<%! int x=10; int y; int z = 0; %>
<% y=200;
z=x+y;
out.append("Kết quả là :");
out.append(String.valueOf(z));
%>
<h1>Xuất kiểu expression: </h1>
<hr>
<%="Kết quả là: "%>
<%=z %>
</body>
</html>