package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeamDao;

public class TeamContinueCommand implements TeamCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		TeamDao tdao = new TeamDao();

		String teamName = (String) session.getAttribute("teamName");

		int teamIdx = tdao.getTeamIdx(teamName);

		request.setAttribute("tname", teamIdx);

	}

}
