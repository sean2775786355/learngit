package gson;

import java.io.File;
import java.io.IOException;

import json.ReadJsonDemo;

import org.apache.commons.io.FileUtils;

import bean.DaisoWithBirthday;
import bean.Diaosi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		
		File file=
				new File(ReadJsonDemo.class.getResource("/jsontxt.json").getFile());
        try {
			String content=FileUtils.readFileToString(file);
			Gson gson=new GsonBuilder().setDateFormat("yyyy-mm-dd").create();
			//在java bean 中要产生toString方法
			DaisoWithBirthday json2=gson.fromJson(content,DaisoWithBirthday.class);
			
			
			System.out.println(json2.getBirthday().toLocaleString());
			//
			
			System.out.println(json2.getMajor());
			System.out.println(json2.getMajor().getClass());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
