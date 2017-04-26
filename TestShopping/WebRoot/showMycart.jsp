<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMycart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<body>
<table width="80%" border="1" align="center" class="abc">
  <tr align="center">
    <td>
    <jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1">
      <tr>
        <td colspan="4">&nbsp;</td>
        </tr>
      <tr align="center" class="navi">
        <td width="14%" height="27">编号</td>
        <td width="30%">名称</td>
        <td width="19%">单价</td>
        <td width="37%">数量</td>
      </tr>
      <tr align="center">
        <td height="36">1</td>
        <td>一条狗的使命</td>
        <td>29.9￥</td>
        <td><table width="100%" border="1">
          <tr>
            <td width="23%" height="26"><form id="form2" name="form2" method="post" action="">
              <label for="textfield"></label>
              123
            </form></td>
            <td width="47%" align="center">删除</td>
            <td width="30%" align="center">查看</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center"><form id="form1" name="form1" method="post" action="">
          <input type="submit" name="button" id="button" value="删除全部电影" />
        </td>
        <td align="center"><input type="submit" name="button2" id="button2" value="修改数量" /></td>
        </form>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4">&nbsp;</td>
        </tr>
      <tr align="center">
        <td colspan="4"><table width="100%" border="1">
          <tr>
            <td width="47%">你共选择了价值19.9￥的商品，<a href="index.html">点击</a>此处 继续购物。</td>
            <td width="53%" align="right"><a href="index.html">下一步</a></td>
          </tr>
        </table></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <jsp:include page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>
