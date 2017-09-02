
<%@page import="com.bridgelab.bean.LoginDAO"%>
<jsp:useBean id="obj" class="com.bridgelab.bean.LoginBean" />

<jsp:setProperty property="*" name="obj" />

<%  
    boolean status=LoginDAO.validate(obj);  
    if(status){  
    out.println("You r successfully logged in");  
    String site = new String("homePage.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site); 
    session.setAttribute("email",request.getParameter("email"));  
    }  
    else  
    {  
    out.print("Sorry, email or password error");  
    %>
<jsp:include page="/index.jsp"></jsp:include>
   <%  
    }  
    %>
