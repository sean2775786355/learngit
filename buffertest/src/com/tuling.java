package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class tuling {

	public static void main(String[] args) throws IOException {
		
        
		 String APIKEY = "8c0f86c1e66845458c468d5b888f3ac7";
	        String INFO = URLEncoder.encode("你哈！", "utf-8");//这里可以输入问题
	        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
	        URL getUrl = new URL(getURL);
	        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
	        connection.connect();

	        // 取得输入流，并使用Reader读取
	        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
	        StringBuffer sb = new StringBuffer();
	        String line = "";
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        System.out.println(line);
	        reader.close();
	        // 断开连接
	        connection.disconnect();
	
	}

}
