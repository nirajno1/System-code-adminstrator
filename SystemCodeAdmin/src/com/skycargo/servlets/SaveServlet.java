package com.skycargo.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skycargo.db.DBUtils;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveServlet");
		ServletContext servletContext=getServletContext();
		List<ControlDTO> controlDTOs=(List<ControlDTO>) servletContext.getAttribute("datalist");
		boolean isSaved;
		try {
			isSaved = DBUtils.saveControlDTOs(controlDTOs);
			
			request.setAttribute("success", isSaved?"Y":"N");
			
			if(isSaved){
				System.out.println("SAved successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		RequestDispatcher rd=request.getRequestDispatcher("operationResult.jsp");
		rd.forward(request, response);
		
		
	}

}
