package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��˹���
 */
@WebServlet("/RequestServlet2")
public class RequestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��Ӧ�����
		PrintWriter out = response.getWriter();
		
		//����������
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		
		//ģ���½��֤
		if ("tom".equals(username) && "123456".equals(userpwd)) {
			out.print("��½�ɹ�");			
		} else {
			out.print("��½ʧ��");
		}
		
		//�߳����ߣ�ģ�������ӳ�
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