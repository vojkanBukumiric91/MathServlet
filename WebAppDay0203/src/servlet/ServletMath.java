package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletMath
 */
@WebServlet("/math")
public class ServletMath extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
    public ServletMath() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=0;
		int b=0;
		int c =0;
		boolean signal = true;
		String aParam = request.getParameter("a");
		try {
			if(aParam.isEmpty()) throw new Exception("Insert number...");
			a=Integer.parseInt(aParam);
		}catch(Exception e) {
			signal=false;
			e.printStackTrace();
			request.setAttribute("errorA", "A is not a number!");
		}
		String bParam = request.getParameter("b");
		try {
			if(bParam.isEmpty()) throw new Exception("Insert number...");
			b=Integer.parseInt(bParam);
		}catch(Exception e) {
			signal=false;
			e.printStackTrace();
			request.setAttribute("errorB", "B is not a number!");
		}
		
		request.setAttribute("a", aParam);
		request.setAttribute("b", bParam);
		

		if(signal) {
			if(request.getParameter("plus")!=null) {
				c=a+b;
			}
			else if(request.getParameter("minus")!=null) {
				c=a-b;
			}
			request.setAttribute("c", c);
		}else {
			request.setAttribute("errorC", "A and B aren't numbers!");
		}
		
    	
    	RequestDispatcher rd = request.getRequestDispatcher("input.jsp");
    	rd.forward(request, response);
    	
	}

}
