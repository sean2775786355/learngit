<%@ page language="java" import="java.util.*,com.sean.model.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

  //使用GoodsBeanBO,完成分页（大家也可以走servlet）

   GoodsBeanBO gbb=new GoodsBeanBO();
   //接受pageNow
   String s_pageNow=(String)request.getAttribute("pageNow");
   int pageNow=1;
   if(s_pageNow!=null)
   {
   //String--->int
   pageNow=Integer.parseInt(s_pageNow);
   
   }
   
 ArrayList al=gbb.getGoodsByPage(6, pageNow);
   //得到共有多少页
   int pageCount=gbb.getPageCount(6);
%>


<table width="100%" border="1" class="abc">
  <tr>
    <td colspan="3" bgcolor="#99FF33"><strong><em>商品简介</em></strong></td>
  </tr>
  <%
      int times=(pageNow-1)*6;
      for(int i=0;i<2;i++)
      {
        //打印两大行（每行显示有三个【有可能不够显示！！】）
        %>
        <tr>
        
        <%
        
        //取出三个al.size=3 time<=2
         //取出三个
         for(int j=0;j<3;j++)
         {
         
          GoodsBean gb=new GoodsBean();
		         if(times>=al.size())
		         {
			            //不能再取
			            //默认各一个goodsBean[图片]
			           
			            gb.setGoodsId(0);
			            gb.setGoodsIntro("没有电影");
			            gb.setPhoto("-12.png");
			            gb.setGoodsPrice(0.0f);
			            gb.setGoodsName("球");
		            
		            
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
         <td height="186" align="left" valign="top">价格：￥<%=gb.getGoodsPrice() %>></td>
      </tr>
      <tr>
         <td height="26" colspan="2">简单介绍：<%=gb.getGoodsIntro() %>></td>
        
       </tr>
      </table></td>
            
            
            <%
        
         }
         %>
         </tr>
         <%
         //判断是否第一大行结束
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
    <a href="ShowGoodsClServlet?type=fenye&pageNow=<%=i%>">【<%=i %>】</a>
    
    <%
    
    
    
    }
    
     %>
    
    
    </td>
  </tr>
</table>
