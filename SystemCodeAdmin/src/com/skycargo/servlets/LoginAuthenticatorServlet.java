package com.skycargo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAuthenticatorServlet
 */
public class LoginAuthenticatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAuthenticatorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		System.out.println();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String auth = request.getHeader("Authorization");
		if (auth == null)
		{
			response.setStatus(response.SC_UNAUTHORIZED);
			response.setHeader("WWW-Authenticate", "NTLM");
			response.flushBuffer();
			return;
		}
		if (auth.startsWith("NTLM "))
		{
			byte[] msg = new sun.misc.BASE64Decoder().decodeBuffer(auth.substring(5));
			int off = 0, length, offset;
			if (msg[8] == 1)
			{
				byte z = 0;
				byte[] msg1 = {(byte)'N', (byte)'T', (byte)'L', (byte)'M', (byte)'S', (byte)'S', (byte)'P', 
						z,(byte)2, z, z, z, z, z, z, z,(byte)40, z, z, z, 
						(byte)1, (byte)130, z, z,z, (byte)2, (byte)2,
						(byte)2, z, z, z, z, z, z, z, z, z, z, z, z};
				response.setHeader("WWW-Authenticate", "NTLM " + 
						new sun.misc.BASE64Encoder().encodeBuffer(msg1));
				response.sendError(response.SC_UNAUTHORIZED);
				return;
			}
			else if (msg[8] == 3)
			{
				off = 30;

				length = msg[off+17]*256 + msg[off+16];
				offset = msg[off+19]*256 + msg[off+18];
				String remoteHost = new String(msg, offset, length);

				length = msg[off+1]*256 + msg[off];
				offset = msg[off+3]*256 + msg[off+2];
				String domain = new String(msg, offset, length);

				length = msg[off+9]*256 + msg[off+8];
				offset = msg[off+11]*256 + msg[off+10];
				String username = new String(msg, offset, length);

				out.println("Username:"+username+"<BR>");
				out.println("RemoteHost:"+remoteHost+"<BR>");
				out.println("Domain:"+domain+"<BR>");
			}
		}
	}
}
