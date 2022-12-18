package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
        location = "c:/temp",
        maxFileSize = -1,       //1024*1024*50 : 50mb
        maxRequestSize = -1,
        fileSizeThreshold = 1024*1024*1 //1mb
      )
@WebServlet("/ajaxFileUpload.do")
public class AjaxFileUploadServlet extends HttpServlet {
    String path = "C:\\Users\\p_yoh\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        // 일반태그의 값
        String id = req.getParameter("id");
        
        // 파일업로드
        Collection<Part> parts = req.getParts();
        for(Part p : parts) {
            if(p.getHeader("Content-Disposition").contains("filename=")) {
                String sysFile = new Date().getTime() + "-" + p.getSubmittedFileName();
                String oriFile = p.getSubmittedFileName();
                p.write(path+oriFile);
                p.delete();
                array.add(oriFile);
            }
        }
        
        
        // 결과물을 JSON타입으로 반환
        obj.put("att", array);      //첨부파일명
        obj.put("id", id);     
        obj.put("msg", "서버가 잘 작동되고 있음");
        out.print(obj.toJSONString());
        
//        {
//            att: [a.png, b.png],
//            id : 홍길자,        
//            msg : 서버가 잘 작동되고 있음
//        }
    }
    
}
