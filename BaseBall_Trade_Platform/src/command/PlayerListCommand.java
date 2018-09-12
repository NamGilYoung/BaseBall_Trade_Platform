package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDao;
import dao.TeamDao;
import dto.PlayerDto;

public class PlayerListCommand implements PlayerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String tname = request.getParameter("tname");

		PlayerDao pdao = new PlayerDao();
		TeamDao tdao = new TeamDao();

		int intTname = Integer.parseInt(tname);

		String teamName = tdao.getTeamName(intTname);
		ArrayList<PlayerDto> pdtos = pdao.playerList(intTname);

		session.setAttribute("tname", teamName);
		request.setAttribute("playerList", pdtos);
	}

}
