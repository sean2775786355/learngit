package json;
import java.util.HashMap;
import java.util.Map;


import org.json.*;

import bean.Diaosi;
public class JsonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         JSONObject();
         createJsonByMap();
         createJsonBean();
	}
	
	/*{
		   "name" : "王小二"，
		   "age" : 25.2,
		   "school" : "蓝翔"，
		   "major" : ["理发","挖掘机"]，
		   "has_girlfriend" : false,
		   "car": null,
		   "house":null


		}*/
	

	private static void JSONObject() {
		// TODO Auto-generated method stub
		JSONObject json1=new JSONObject();
		Object nullObj=null;
		try {
			json1.put("name", "王小二");
			json1.put("age",25.2);
			json1.put("birthday","1990-01-01");
			json1.put("school","蓝翔");
			json1.put("major",new String[]{"理发","挖掘机"});
			json1.putOnce("has_girlfriend",false);
			json1.putOnce("car",nullObj);
			json1.put("house",nullObj);
			json1.put("comment","这是一个注释");
			System.out.println("json1通过JsonObject产生json");
			System.out.println(json1.toString());
		} catch (JSONException e) {
			
			e.printStackTrace();      
		}
		
	}

	
	//通过hashmap生成json
	private static void createJsonByMap()
	{
		Map<String,Object> json2=new HashMap<String,Object>();
		json2.put("name", "王小二");
		json2.put("age",25.2);
		json2.put("birthday","1990-01-01");
		json2.put("school","蓝翔");
		json2.put("major",new String[]{"理发","挖掘机"});
		json2.put("has_girlfriend",false);
		json2.put("car",null);
		json2.put("house",null);
		json2.put("comment","这是一个注释");
		System.out.println("通过hashmap集合创建json2");
		System.out.println(new JSONObject(json2).toString());
	}
	
	
	//通过javaBean创建json
	private static void createJsonBean()
	{
		Diaosi json3=new Diaosi();
		json3.setName("王小二");
		json3.setAge(25.2);
		json3.setBirthday("1999-01-01");
		json3.setSchool("蓝翔");
		json3.setMajor(new String[] {"理发","挖掘机"});
		json3.setHas_girlfriend(false);
		json3.setCar(null);
		json3.setHouse(null);
		json3.setComment("这是一个注释");
		System.out.println("这是使用javabean 创建json");
		System.out.println(new JSONObject(json3).toString());
	}
	
	
}
