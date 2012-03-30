package com.skycargo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skycargo.db.DBUtils;

/**
 * Servlet implementation class IndexSevlet
 */
public class IndexSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String BUSINESS_SELECTOR="BUSINESS_SELECTOR";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestType=(request.getParameter("requestType")).trim();
		System.out.println("I got request: "+requestType);
		List<ControlDTO> list=DBUtils.getControls(requestType);
		//Context initContext = null;
			ServletContext servletContext=getServletContext();
			servletContext.setAttribute("datalist", list);
			request.setAttribute("requestType", requestType);
			RequestDispatcher rd=request.getRequestDispatcher("input.jsp");
			
			rd.forward(request, response);
			
		
		
	}

}
