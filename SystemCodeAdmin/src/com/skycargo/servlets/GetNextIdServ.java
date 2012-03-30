package com.skycargo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skycargo.db.AjaxUtil;

/**
 * Servlet implementation class GetNextIdServ
 */
public class GetNextIdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNextIdServ() {
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
		//set the content type
		response.setContentType("text/xml");
        
		response.setHeader("Cache-Control", "no-cache");
        String moduleCode=request.getParameter("module");
        String airlineCode=request.getParameter("airlineCode");
        String transactionType=request.getParameter("transactionType");
        //System.out.println(moduleCode +" "+airlineCode+" "+transactionType);
        //get the PrintWriter object to write the html page
        PrintWriter writer = response.getWriter(); 
        String nextId=AjaxUtil.getNextTransactionID(moduleCode, airlineCode, transactionType);
      //get the author profile by quering the AuthorsBean by passing author name
        writer.println("<nextId><![CDATA["+nextId+"]]></nextId>");
       
       //close the write
       writer.close();     
	}

}
