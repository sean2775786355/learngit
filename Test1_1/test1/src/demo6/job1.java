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
         System.out.println("���Ĳ�����"+judge.getWorst());
	}

}
class Judge
{
	       //����˸�С������ֵ
	      float fens[]=null;
	      int size=8;
	       //���캯��
	      public Judge()
	     {   BufferedReader br=new  
	         BufferedReader(new InputStreamReader(System.in));
		     fens=new float[size];
		
			try {
				for(int i=0;i<fens.length;i++)
				{
					System.out.println("�������"+(i+1)+"���гɼ�");
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
	       //�õ��˶�Ա���÷�
	
		   //ȥ����ͷ֣��ҵ���ͷ��±꣩
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
		
		   //ȥ����߷�
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
		     //�õ�����
		
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
	       //�õ������ί
		   public int  getWorst()
		   {
			   float lastFen=this.lastFen();
			   //����Ϊ��һ����ί���
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