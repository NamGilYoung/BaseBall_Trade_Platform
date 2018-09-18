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
import command.PlayerListDetailCommand;
import command.PlayerListResetCommand;
import command.ResultCommand;
import command.TeamCommand;
import stage.Stage;

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

		// Command 媛앹껜 異붽� 遺�遺�
		PlayerCommand pCommand = null;
		TeamCommand tCommand = null;
		String position = "";

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		// http://localhost:3030/mvc源뚯��쓽 �쁺�뿭
		String com = uri.substring(conPath.length());

		switch (com) {
		
		case("/reset.nam"):
			
			viewPage ="TeamSelect.jsp";
		
		case ("/PListView.nam"):
			// command �궗�슜
			pCommand = new PlayerListCommand();
			pCommand.execute(request, response);

//			if (Stage.stage == 0) {
//				
//				viewPage = "PlayerSelect.jsp";
//			}else {
//				viewPage = "PlayerSelect2.jsp";
//			}
			viewPage = "PlayerSelect.jsp";
			break;

		case ("/PListViewDetail.nam"):

			position = "pitcher";

			request.setAttribute("position", position);
			pCommand = new PlayerListDetailCommand();
			pCommand.execute(request, response);

			viewPage = "PlayerSelectDetail.jsp";

			break;

		case ("/HListViewDetail.nam"):

			position = "hitter";

			request.setAttribute("position", position);
			pCommand = new PlayerListDetailCommand();
			pCommand.execute(request, response);

			viewPage = "PlayerSelectDetail.jsp";

			break;

		case ("/Result.nam"):

			break;

		case ("/main.nam"):

			Stage.stage = 0;
			System.out.println("초기화면으로 가는중  :stage =" + Stage.stage);
			pCommand = new PlayerListResetCommand();
			pCommand.execute(request, response);
			viewPage = "Main.jsp";

			break;

		case ("/TeamSelect.nam"):

			if (Stage.stage == 0) {
				Stage.stage = 1;
				System.out.println("첫팀 선택후 다시 팀선택으로 가는중 : stage =" + Stage.stage);
				viewPage = "TeamSelect.jsp";
				break;
			} else if (Stage.stage == 1) {
				pCommand = new ResultCommand();
				pCommand.execute(request, response);
				viewPage = "Result.jsp";
				break;
			}
		}
			

	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);dispatcher.forward(request,response);
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
