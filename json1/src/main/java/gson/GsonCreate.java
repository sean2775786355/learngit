package gson;

import java.lang.reflect.Field;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.Diaosi;
import com.google.gson.*;
public class GsonCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		json3.setIgnore("不要看见我");
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
	/*	Gson gson=gsonBuilder.create();
//		 Gson gson=new Gson();
	     System.out.println(gson.toJson(json3));
		*/
		gsonBuilder.setFieldNamingStrategy(new fieldNamingStrategy(){
			
			public String translateName(Field f){
				if(f.getName().equals("name")){
					return "NAME";
				}
				return f.getName();
				
			}
			
		});
		Gson gson=gsonBuilder.create();
		System.out.println(gson.toJson(json3));
	
		
	}

}
