<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>

<div align="center">
  <table width="15%" border="1" align="center">
    <tr>
      <td height="26" align="center" bgcolor="#00FF66"><strong>��վ����</strong></td>
    </tr>
    <tr align="left">
      <td align="center" bgcolor="#FFCCCC"><img src="images/һ������ʹ��.jpg" width="240" height="390" /></td>
    </tr>
    <tr align="center">
      <td><table width="100%" border="1" align="center" height=420px>
        <tr>
          <td colspan="3" align="center" bgcolor="#00FF33"><strong>��վ���¹���</strong></td>
          </tr>
        <tr>
          <td width="25%" height="32" align="center">���а�</td>
          <td width="43%" align="center">��Ʒ����</td>
          <td width="32%" align="center">�������</td>
        </tr>
        <tr>
          <td align="center">1</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=1%>">һ������ʹ��</a></td>
          <td align="center">1000</td>
        </tr>
        <tr>
          <td align="center">2</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=2%>">���ߵ�����˹��</a></td>
          <td align="center">999</td>
        </tr>
        <tr>
          <td align="center">3</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=3%>">����֮��</a></td>
          <td align="center">465</td>
        </tr>
        <tr>
          <td align="center">4</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=4%>">��ʥ</a></td>
          <td align="center">264</td>
        </tr>
        <tr>
          <td align="center">5</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=5%>">�ӳ�������</a></td>
          <td align="center">100</td>
        </tr>
        <tr>
          <td align="center">6</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=6%>">��Ů��Ұ��</a></td>
          <td align="center">50</td>
        </tr>
        <tr>
          <td align="center">7</td>
          <td align="center"><a href="ShowGoodsClServlet?type=showDetail&id=<%=7%>">�¹��к�</a></td>
          <td align="center">10</td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
