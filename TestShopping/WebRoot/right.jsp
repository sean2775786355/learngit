<%@ page language="java" import="java.util.*,com.sean.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

  //ʹ��GoodsBeanBO,��ɷ�ҳ�����Ҳ������servlet��

   GoodsBeanBO gbb=new GoodsBeanBO();
   //����pageNow
   String s_pageNow=(String)request.getAttribute("pageNow");
   int pageNow=1;
   if(s_pageNow!=null)
   {
   //String--->int
   pageNow=Integer.parseInt(s_pageNow);
   
   }
   
 ArrayList al=gbb.getGoodsByPage(6, pageNow);
   //�õ����ж���ҳ
   int pageCount=gbb.getPageCount(6);
%>


<table width="100%" border="1" class="abc">
  <tr>
    <td colspan="3" bgcolor="#99FF33"><strong><em>��Ʒ���</em></strong></td>
  </tr>
  <%
      int times=(pageNow-1)*6;
      for(int i=0;i<2;i++)
      {
        //��ӡ�����У�ÿ����ʾ���������п��ܲ�����ʾ��������
        %>
        <tr>
        
        <%
        
        //ȡ������al.size=3 time<=2
         //ȡ������
         for(int j=0;j<3;j++)
         {
         
          GoodsBean gb=new GoodsBean();
		         if(times>=al.size())
		         {
			            //������ȡ
			            //Ĭ�ϸ�һ��goodsBean[ͼƬ]
			           
			            gb.setGoodsId(0);
			            gb.setGoodsIntro("û�е�Ӱ");
			            gb.setPhoto("-12.png");
			            gb.setGoodsPrice(0.0f);
			            gb.setGoodsName("��");
		            
		            
		         }else{
				         gb=(GoodsBean)al.get(times);
				         times++;
		         }
		         request.setAttribute("id", gb.getGoodsId());
		         
            %>
            
      <td width="30%" height="362"><table width="100%" border="1">
      <tr>
         <td width="33%" rowspan="3"><img src="images/<%=gb.getPhoto() %>" width="240" height="320" /></td>
         <td width="67%" height="106">&nbsp;</td>
      </tr>
      <tr>
         <td height="28"><a href="ShowGoodsClServlet?type=showDetail&id=<%=gb.getGoodsId() %>"><%=gb.getGoodsName() %>></a></td>
      </tr>
      <tr>
         <td height="186" align="left" valign="top">�۸񣺣�<%=gb.getGoodsPrice() %>></td>
      </tr>
      <tr>
         <td height="26" colspan="2">�򵥽��ܣ�<%=gb.getGoodsIntro() %>></td>
        
       </tr>
      </table></td>
            
            
            <%
        
         }
         %>
         </tr>
         <%
         //�ж��Ƿ��һ���н���
         if(i==0)
         {
            %>
           <tr>
            <td colspan="3" bgcolor="#FFCCCC">&nbsp;</td>
           </tr>
           
            
            <%
         
         }
      
      }
  
  
   %>

  

    </table></td>
  </tr>
  <tr>
    <td colspan="3" align="center">
    <%
    
    for(int i=1;i<=pageCount;i++)
    {
    
    %>
    <a href="ShowGoodsClServlet?type=fenye&pageNow=<%=i%>">��<%=i %>��</a>
    
    <%
    
    
    
    }
    
     %>
    
    
    </td>
  </tr>
</table>
