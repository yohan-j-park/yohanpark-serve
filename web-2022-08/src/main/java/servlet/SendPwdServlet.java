package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import crypto.AES;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.DBConn;

@WebServlet(urlPatterns = "/SendPwdServlet.do")
public class SendPwdServlet extends HttpServlet{
 // 메일과 연관된 변수
 String host = "smtp.naver.com"; 
 String pwd="";
 String sender = "p_yohan@naver.com";
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
  //RequestDispatcher rd = req.getRequestDispatcher("./member/findpwd.jsp");
 
  String mId = req.getParameter("mid");
  String email = req.getParameter("email");
  String rStr ="";
  String msg="";
  AES aes = new AES();
  pwd = checkPwd(mId,email);
  if(!pwd.equals("")) {      
      String pwd1 = aes.decrypt(pwd);
      rStr = "id: " + mId + "암호: " + pwd1 + "입니다.";
  }
  
  
  try{
   // 이메일과 관련된 자료를 캡슐화
   Properties prop = new Properties();
   prop.put("mail.smtp.starttls.enable", "true");
   prop.put("mail.smtp.host", host);
   prop.put("mail.smtp.auth","true");
   prop.put("mail.smtp.port","587");
   prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
   
   // 메일 서버 사용자의 권한 체크(보안상 필요)
   Session pass = Session.getInstance(prop, new Authenticator() {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
     return new PasswordAuthentication("이메일@naver.com","비밀번호");
    }

   });   
   
   // 보내는 메시지 켑슐화
   MimeMessage message = new MimeMessage(pass);
   message.setFrom(new InternetAddress(sender));
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
   message.setSentDate(new Date());
   message.setContent(mId, "text/html;charset=utf-8");
   message.setContent(rStr, "text/html;charset=utf-8");

   
   // 메일 전송
   Transport.send(message);
//   req.setAttribute("msg", email + "님에게 메일이 정상적으로 전송됨.");
   msg = email + "님에게 메일이 정상적으로 전송됨.";
  }catch(Exception ex){
   req.setAttribute("msg", "메일 전송중 오류 발생");
   System.out.println(ex);
   msg = "메일 전송중 오류 발생";
  }
//  rd.forward(req, resp);
   PrintWriter out = resp.getWriter();
   out.print(msg);
 }
 public String checkPwd(String mId, String email) {
     
     try {
     Connection conn = new DBConn("mydb").getConn();
     String sql = "select * from student where id = ? and email=?"; 
     PreparedStatement ps = conn.prepareStatement(sql);
     ps.setString(1, mId);
     ps.setString(2, email);
     ResultSet rs = ps.executeQuery();
     if(rs.next()) {
         pwd = rs.getString("pwd");

     }
     ps.close();
     conn.close();
     
     }catch(Exception e) {
         e.printStackTrace();
     }
     return pwd;
 }
 
}
