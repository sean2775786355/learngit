package demo5;
import java.util.*;
public class testa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /*  LinkedList ll=new LinkedList();
      Emp emp1=new Emp("sa01","aa",1.2f);
      Emp emp2=new Emp("sa01","bb",1.2f);
      //������ǰ��
      ll.addFirst(emp1);
      ll.addFirst(emp2);
      for(int i=0;i<ll.size();i++)
      {
    	 System.out.println(((Emp)ll.get(i)).getName()); 
      }*/
		
		
		//����һ��hashmap
		/*HashMap hm=new HashMap();
		Emp emp1=new Emp("s001","aaa",3.4f);
		Emp emp2=new Emp("s002","bbb",5.6f);
		hm.put("s001", emp1);
		hm.put("s002", emp2);
		//�����Ҫ���ұ��S002
		if(hm.containsKey("s002"))
		{
			System.out.println("�и�Ա��");
			//���ȡ������   ֵ
			Emp emp=(Emp)hm.get("s002");
			System.out.println("������"+emp.getName());
		}else{
			System.out.println("û�и�Ա��");
		}
		//����hashmap�е�key��value
		Iterator it=hm.keySet().iterator();
		//hasNext ����һ������ֵ
		while(it.hasNext())
		{
			//ȡ��key
			String key=it.next().toString();
			//ͨ��keyȡ��value
			Emp emp=(Emp)hm.get(key);
			System.out.println("���֣�"+emp.getName());
		}*/
		/*Hashtable ht=new Hashtable();
		ht.put(null, null);
		System.out.println("���ԣ�"+ht.get(null));*/
	}

}



