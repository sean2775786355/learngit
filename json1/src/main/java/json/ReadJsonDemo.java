package json;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.*;

public class ReadJsonDemo {

	public static void main(String[] args) throws IOException, JSONException {
		
		File file=
				new File(ReadJsonDemo.class.getResource("/jsontxt.json").getFile());
        String content=FileUtils.readFileToString(file);
	    //content文件中的内容
        JSONObject json4=new JSONObject(content);
        if(!json4.isNull("name")){
        	System.out.println("姓名是："+json4.getString("name"));
        }
        if(!json4.isNull("nickname")){
        	System.out.println("姓名是："+json4.getString("nickname"));
        }
        
        System.out.println("年龄："+json4.getDouble("age"));
	    System.out.println("有没有女朋友？"+json4.getBoolean("has_girlfriend"));
	    JSONArray majorArray=json4.getJSONArray("major");
	    for(int i=0;i<majorArray.length();i++)
	    {
	    	 String m=(String)majorArray.get(i);
	    	 System.out.println("专业-"+(i+1)+m);
	    	 
	    }
	
	}

}
