<%@page import="com.bridgelab.bean.LoginDAO"%>
<jsp:useBean id="obj" class="com.bridgelab.bean.LoginBean" />

<jsp:setProperty property="*" name="obj" />

<%  
    boolean status=LoginDAO.validate(obj);  
    if(status){  
    out.println("You r successfully logged in");  
    session.setAttribute("session","TRUE");  
    }  
    else  
    {  
    out.print("Sorry, email or password error");  
    %>
<jsp:include page="/index.jsp"></jsp:include>
   <%  
    }  
    %>
