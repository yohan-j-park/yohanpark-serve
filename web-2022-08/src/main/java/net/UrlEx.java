package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlEx {
    public static void main(String[] args) {
        String domain = "http://192.168.219.140:8888/web-2022-08/index.jsp";
        try{
            URL url = new URL(domain);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);  //byte stream에서 char stream으로 변환
            BufferedReader br = new BufferedReader(isr);    // buffer: data를 끊어서 읽을 수 있음
            String data="";
            while((data=br.readLine()) != null) {
                /*
                 while(true){
                     data = br.readLine();
                     if(data == null) break;
                 }
                  */
                System.out.println(data);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
