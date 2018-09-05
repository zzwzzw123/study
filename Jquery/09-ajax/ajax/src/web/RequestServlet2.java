package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后端功能
 */
@WebServlet("/RequestServlet2")
public class RequestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//响应输出流
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		
		//模拟登陆验证
		if ("tom".equals(username) && "123456".equals(userpwd)) {
			out.print("登陆成功");			
		} else {
			out.print("登陆失败");
		}
		
		//线程休眠，模拟网络延迟
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}