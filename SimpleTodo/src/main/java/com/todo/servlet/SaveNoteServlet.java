package com.todo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.todo.config.FactoryProvider;
import com.todo.main.Note;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("Inputtitle");
		String content = request.getParameter("Inputcontent");

		Note note = new Note(title, content, new Date());

		Session session = FactoryProvider.getFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.save(note);
		tx.commit();

		session.close();
		// FactoryProvider.closeFactory();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		pw.println("<h1> Note Sucessfully Added...");
		request.setAttribute("Message", "Note Sucessfully Added");
		request.getRequestDispatcher("/Add_note.jsp").forward(request, response);

	}

}
