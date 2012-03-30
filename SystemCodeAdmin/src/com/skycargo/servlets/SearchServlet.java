package com.skycargo.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skycargo.db.DBUtils;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in search servlet.");
		String codetype=(String) request.getParameter("requestType");
		String airlinecode=(String) request.getParameter("airlineCode");
		String searchText=(String) request.getParameter("searchText");
		request.setAttribute("requestType", codetype);
		request.setAttribute("airlineCode", airlinecode);
		request.setAttribute("searchText", searchText);
		System.out.println(codetype+" "+airlinecode+" "+searchText);
		List returnList;
		try {
			returnList = DBUtils.getSearchResults(codetype, airlinecode, searchText);
		if(returnList != null){
			List returnHeaderList=(List) returnList.get(0);
			List returnDataList=(List) returnList.get(1);
			request.setAttribute("size", 100);
			request.setAttribute("returnDataList", returnDataList);
			request.setAttribute("returnHeaderList", returnHeaderList);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new ServletException(e.getMessage());
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("SearchPage.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
