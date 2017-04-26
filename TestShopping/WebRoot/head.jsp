<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--  只把table引入即可-->
<table width="100%" border="1" class="abc">
  <tr>
    <td height="10" colspan="3" bgcolor="#FFCCCC" ></td>
  </tr>
  <tr>
    <td width="17%" height="126"><img src="images/logo.png" width="150" height="120" /></td>
    <td width="60%"><img src="images/sale.jpg" width="626" height="120" /></td>
    <td width="23%" valign="middle"><p><img src="images/登录.jpg" width="25" height="25" /><a href="Login.jsp">【我的账号】</a></p>
    <p class="abc"><img src="images/购物车.jpg" width="25" height="25" />【我的购物车】</p></td>
  </tr>
  <tr>
    <td height="10" colspan="3" bgcolor="#FFCCCC" ></td>
  </tr>
  <tr>
    <td height="36" colspan="3"><table width="100%" border="1">
      <tr>
        <td width="11%" height="33">&nbsp;</td>
        <td width="11%" class="navi">首页</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">香港电影</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">大陆电影</td>
        <td width="11%">&nbsp;</td>
        <td width="11%" class="navi">关于我们</td>
        <td width="11%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
