package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsonp调用
 */
@WebServlet("/JsonpServlet")
public class JsonpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得调用的函数名称
		String callback = request.getParameter("callback");
		
		//输出流
		PrintWriter out = response.getWriter();
		
		//动态响应一个js调用语句
		out.print(callback + "({name:'tom',age:27});");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}