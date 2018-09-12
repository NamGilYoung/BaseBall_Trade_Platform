package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import dao.PlayerDao;
import dao.TeamDao;
import dto.PlayerDto;

public class PlayerListDetailCommand implements PlayerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		PlayerDao pdao = new PlayerDao();
		TeamDao tdao = new TeamDao();

		int backNum = Integer.parseInt(request.getParameter("back"));
		String teamName = (String) session.getAttribute("tname");

		int teamIdx = tdao.getTeamIdx(teamName);
		System.out.println(teamIdx);

		ArrayList<PlayerDto> alpdto = pdao.getPlayerDetailInfo(teamIdx, backNum);
		System.out.println(alpdto.get(0).getPlayerName());
		request.setAttribute("playerDetail", alpdto);

	}

}
