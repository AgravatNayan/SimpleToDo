<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@include file="Component/Header.jsp"%>
<body>
	<%@include file="Component/Navbar.jsp"%>
	<div id="Main_Contain" style="margin: 50px 50px 50px 50px;">
		<form method="post" action="SaveNoteServlet">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Add Title</label>
				<input type="text" .="Enter note title"
					class="form-control" name="Inputtitle" id="Inputtitle"
					aria-describedby="emailHelp" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Add
					Content</label>
				<textarea id="content" name="Inputcontent" class="form-control"
					placeholder="Enter your content here" required></textarea>

			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
			<%
				if (request.getAttribute("Message") != null) {
					PrintWriter pw = response.getWriter();
					pw.println("<h6> Note Sucessfully Added...</h6>");
					pw.println("<h6> kindly Check Show Note Menu to show all menu.</h6>F");
				}
			%>
		</form>
	</div>
	<%@include file="Component/Resource.jsp"%>

</body>
</html>