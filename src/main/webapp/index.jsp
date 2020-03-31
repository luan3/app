<%@ page import="com.ljy.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page isELIgnored="false" %>
<html>
<body>
<%
        //从session作用域中将name值取出来
        User user=(User)session.getAttribute("user");
        //从cookie集合中取出name值  如果存在name值  直接跳转页面
    Cookie [] cookies =request.getCookies();
  if(cookies!=null&&user!=null){
      for(Cookie ck:cookies){
          if(ck.getValue().equals(user.getName())){
                //重定向到登陆成功页面
              response.sendRedirect(request.getContextPath()+"/toSuccess");
          }
      }
  }

%>
<%--<%=user.getName()%>--%>



<form action="<%=request.getContextPath()%>/login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" id="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>

</html>
