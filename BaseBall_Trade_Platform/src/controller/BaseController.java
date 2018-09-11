package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.PlayerCommand;
import command.PlayerListCommand;

/**
 * Servlet implementation class BaseController
 */
@WebServlet("/BaseController")
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseController() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		String viewPage = null;

		// Command 객체 추가 부분
		PlayerCommand pCommand = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		// http://localhost:3030/mvc까지의 영역
		String com = uri.substring(conPath.length());

		switch (com) {
		case ("/PListView.nam"):
			// command 사용
			pCommand = new PlayerListCommand();
			pCommand.execute(request, response);
			viewPage = "PlayerSelect.jsp";
			break;

		case ("2"):
			break;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
