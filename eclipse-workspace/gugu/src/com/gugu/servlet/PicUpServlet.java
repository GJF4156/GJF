package com.gugu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gugu.dao.WisUploadDao;
import com.gugu.pojo.GgNote;
import com.gugu.util.Upload;

//管理员界面 上传微语，接受post表单包含文字和图片
public class PicUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "D:\\eclipse-workspace\\gugu\\WebContent\\";
       

    public PicUpServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String path = UPLOAD_DIRECTORY+"images"+File.separator ;

		Map<String, String> map = Upload.upload(request, 1024 * 1024 * 10, path);
		String newFileName ="images"+File.separator+ map.get("uploadFile");
		//images\1542769642957wy_img3.jpg
		GgNote note = new GgNote();
		note.setNoteContent(map.get("content"));
		note.setNotePhoto(newFileName);
		
		System.out.println(newFileName);
		System.out.println(map.get("content"));
		
		WisUploadDao add = new WisUploadDao();
		add.addwis(note);
		response.sendRedirect("page/whisper/manage.jsp");
		
		
		
			
	}

}
