/*
 * 
 */
package demo6;
import java.io.*;
public class job1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Judge  judge=new Judge();
         System.out.println(judge.lastFen());
         System.out.println("最差的裁判是"+judge.getWorst());
	}

}
class Judge
{
	       //定义八个小数的数值
	      float fens[]=null;
	      int size=8;
	       //构造函数
	      public Judge()
	     {   BufferedReader br=new  
	         BufferedReader(new InputStreamReader(System.in));
		     fens=new float[size];
		
			try {
				for(int i=0;i<fens.length;i++)
				{
					System.out.println("请输入第"+(i+1)+"裁判成绩");
				    fens[i]=Float.parseFloat(br.readLine());
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}
	       //得到运动员最后得分
	
		   //去掉最低分（找到最低分下标）
		  public int getLowFenIndex()
		    {    
			 float min=fens[0];
	         int minIndex=0;
	         for(int j=0;j<fens.length;j++)
	         {
	        	 if(min>fens[j])
	        	 {
	        		 min=fens[j];
	        		 minIndex=j;
	        	 }
	         }
			
	         return minIndex ;
		}
		
		   //去掉最高分
		   public int getHighFenIndex()
		    {
			    float max=fens[0];
	            int maxIndex=0;
	             for(int i=0;i<fens.length;i++)
	              {
	        	 if(max<fens[i])
	        	 {
	        		 max=fens[i];
	        		 maxIndex=i;
	        	 }
	                }
	         return maxIndex;
		      }
		     //得到最后分
		
		   public float lastFen()
		     {    float tal=0;
		     int minIndex=this.getLowFenIndex();
		     int maxIndex=this.getHighFenIndex();
			for(int i=0;i<fens.length;i++)
			{
				if(i!=minIndex&&i!=maxIndex)
				{
					tal+=fens[i];
				}
				
			}
			return tal/(fens.length-2);
			
		}
	       //得到最菜评委
		   public int  getWorst()
		   {
			   float lastFen=this.lastFen();
			   //我认为第一个评委最差
			   int worstIndex=0;
			   float cai=Math.abs(fens[0]-lastFen);
			   float tempCai=0f;
			   for(int i=1;i<fens.length;i++)
			   {    tempCai=Math.abs(fens[i]-lastFen);
				   if(cai<tempCai)
				   {
					   worstIndex=i;
					   cai=tempCai;
				   }
			   }
			   return worstIndex;
		   }
}