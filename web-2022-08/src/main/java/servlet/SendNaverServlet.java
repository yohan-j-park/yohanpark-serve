package servlet;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/SendNaverServlet.do")
public class SendNaverServlet extends HttpServlet{
 // 메일과 연관된 변수
 String host = "smtp.naver.com"; 
 
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  RequestDispatcher rd = req.getRequestDispatcher("./mail/mail_form.jsp");
 
  String sender = req.getParameter("sender");
  String receiver = req.getParameter("receiver");
  String subject = req.getParameter("subject");
  String content = req.getParameter("content");
  
  
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
     return new PasswordAuthentication("p_yohan@naver.com","계정암호");
    }

   });   
   
   // 보내는 메시지 켑슐화
   MimeMessage message = new MimeMessage(pass);
   message.setFrom(new InternetAddress(sender));
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
   message.setSubject(subject);
   message.setSentDate(new Date());
   message.setContent(content, "text/html;charset=utf-8");
   
   
   // 메일 전송
   Transport.send(message);
   req.setAttribute("msg", receiver + "님에게 메일이 정상적으로 전송됨.");
   
  }catch(Exception ex){
   req.setAttribute("msg", "메일 전송중 오류 발생");
   System.out.println(ex);
  }
  rd.forward(req, resp);
 }
}
