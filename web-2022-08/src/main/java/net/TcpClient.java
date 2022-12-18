package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
   public TcpClient() throws Exception{
      // 1) 서버에 접속(서버의 ip, port필요)
      InetAddress ia = InetAddress.getLocalHost();
      String ip = "192.168.35.63";//ia.getHostAddress();
      System.out.println("IP : " + ip);
      Socket socket = new Socket(ip, 1111);   //접속을 해서 로그인정보만 전달하면 정보를 체크했다가 상태변화를 통해보여줌(ex/네이트온)
      
      // 2) IOStream 생성
      OutputStream os = socket.getOutputStream();
      InputStream is = socket.getInputStream();
      
      OutputStreamWriter osw = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(osw);
      
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);   //이렇게 만드는것은 송수신 ㅡ가 문자열일때만 가능
      
      // 3) message를 전송
      String msg = "";
      for(int i=1; i<=10; i++) {
          msg = "하이~ 방가루..\n";
          bw.write(msg);
          bw.flush();
          
      }
      
      // 4) message를 수신
      String receiveMsg = br.readLine();
      System.out.println("수신된 메시지 : " + receiveMsg);
      
      msg = "exit\n";
      bw.write(msg);
      bw.flush();
      
      br.close();
      isr.close();
      is.close();
      
      bw.close();
      osw.close();
      os.close();
      
      socket.close();
   }
   
   public static void main(String[] args) throws Exception{
      new TcpClient();
   }
}

