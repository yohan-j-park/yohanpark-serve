package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
   public TcpServer() throws Exception {
      // 1) ServerSocket 생성
      ServerSocket server = new ServerSocket(4444);      //가끔은 unhandled exception에 주목해보자 고수의 향기를 낼 수 있다.이번엔 IOException
      
      // 2) client 접속 대기
      System.out.println("접속대기......");
      Socket socket = server.accept();   //blocking mode
      
      // 3) IOStream 생성
      OutputStream os = socket.getOutputStream();
      InputStream is = socket.getInputStream();      //교재는 여기까지만 나옴. byte가지고 전송할수는 있으나 귀찮다 한국사람은 byte단위보단 character 단위가 편하다
      
      OutputStreamWriter osw = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(osw);   //outputstream과 관련된 요소 모두 작성 완료
      
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);      
      
      while(true) {
         // 4) 수신된 메시지를 표시
         
         String msg = br.readLine();      //엔터키가 눌릴때까지 데이터를 기다리고있다
         System.out.println("수신 메시지 : " + msg);
         
         if(msg.equals("exit")) break;
         
         // 5) 클라이언트로 메시지 전송         --이렇게 만드는 서버를 eco server라 한다 서버-클라이언트 1대 多 ui를 만들면...그게 채팅프로그램(?)
      
         msg = "서버가 재전송함 : " + msg + "\n";
         bw.write(msg);
         bw.write("\n");
         bw.flush();
      }
      br.close();
      isr.close();
      is.close();
      
      bw.close();
      osw.close();
      os.close();
      
      socket.close();
      server.close();
   }
   public static void main(String[] args) throws Exception {
      new TcpServer();
   }
}
