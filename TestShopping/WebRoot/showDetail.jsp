<%@ page language="java" import="java.util.*,com.sean.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 //ȡ��Ҫ��ʾ����Ϣ(GoodsBean)

 GoodsBean gb=(GoodsBean)request.getAttribute("goodsINfo");
 

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="cssfile/head.css">

     <script type="text/javascript">
     <!--
     //��Ӧ������ع�������¼�
      function returnHall()
      {
          //Ĭ��open�������Ǵ�һ������ҳ��
          //����ں������һ��_self
          window.open("index.jsp");
      }
      
     
     -->
     
     
     </script>
     
     

  </head>
  
  <body topmargin="0">
   <center>
   <table width="80%" border="1">
  <tr>
    <td align="center">
    <!-- ����ͷҳ�� -->
   <jsp:include flush="true" page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1">
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td width="22%" rowspan="8"><img src="images/<%=gb.getPhoto() %>"  width="240" height="320" /></td>
        <td width="78%" align="center"><%=gb.getGoodsName() %></td>
      </tr>
      <tr>
        <td>�۸�$<%=gb.getGoodsPrice() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>ISBN:<%=gb.getGoodsId() %></td>
      </tr>
      <tr>
        <td>����:<%=gb.getType() %></td>
      </tr>
      <tr>
        <td>������:<%=gb.getPulisher() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="123" valign="top"><%=gb.getGoodsIntro() %></td>
      </tr>
      <tr>
        <td height="34" colspan="2"><form id="form1" name="form1" method="post" action="">
          <input name="button" type="submit" id="button" value="����" />
          &nbsp; &nbsp;&nbsp;
          <input name="button2" type="submit" onclick="returnHall();" id="button2" value="���ع������" />
           
          
        </form></td>
        </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
    <!-- tail.jsp -->
    <jsp:include flush="true" page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
   </center>
  </body>
</html>
