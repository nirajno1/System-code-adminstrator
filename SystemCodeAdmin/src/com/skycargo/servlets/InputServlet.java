package com.skycargo.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration attributes=request.getParameterNames();
		System.out.println("Hello");
		ServletContext servletContext=getServletContext();
		List<ControlDTO> controlDTOs=(List<ControlDTO>) servletContext.getAttribute("datalist");
		Map<String,String> paramValueMap=new HashMap<String,String>();
		while (attributes.hasMoreElements()) {
			String attStr = (String) attributes.nextElement();
			String value = request.getParameter(attStr);
		//	System.out.println("Name :" + attStr + " Value:" + value);
			paramValueMap.put(attStr, value);
		}
		Iterator<ControlDTO> i = controlDTOs.iterator();
		while (i.hasNext()) {
			ControlDTO controlDTO = i.next();
			String paramValue=paramValueMap.get(controlDTO.getControlName());
			controlDTO.setValue(paramValue);
		}
		String requestType=(String) request.getParameter("requestType");
		request.setAttribute("requestType", requestType);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("confirmation.jsp");
		requestDispatcher.forward(request, response);
	}

}
