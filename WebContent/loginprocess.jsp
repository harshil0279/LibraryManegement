
<%@page import="com.bridgelab.dao.LoginDAO"%>
<jsp:useBean id="obj" class="com.bridgelab.model.LoginBean" />

<jsp:setProperty property="*" name="obj" />

<%
	int user_id = LoginDAO.validate(obj);
	if (user_id != -1) {
		out.println("You r successfully logged in");
		String site = new String("homePage.jsp");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("user_id", String.valueOf(user_id));
	} else {
		out.print("Sorry, email or password error");
%>
<jsp:include page="/index.jsp"></jsp:include>
<%
	}
%>
