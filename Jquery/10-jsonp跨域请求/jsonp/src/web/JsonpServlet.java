package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsonp����
 */
@WebServlet("/JsonpServlet")
public class JsonpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��õ��õĺ�������
		String callback = request.getParameter("callback");
		
		//�����
		PrintWriter out = response.getWriter();
		
		//��̬��Ӧһ��js�������
		out.print(callback + "({name:'tom',age:27});");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}