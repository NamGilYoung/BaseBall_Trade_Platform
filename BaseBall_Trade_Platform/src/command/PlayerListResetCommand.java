package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HitterDao;
import dao.PitcherDao;
import dao.PlayerDao;
import dao.TeamDao;
import dto.PlayerDto;
import stage.Stage;

public class PlayerListResetCommand implements PlayerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		String section = Stage.player_position + Stage.player2_position;

		String abName = (String) session.getAttribute("tname");
		String abName2 = (String) session.getAttribute("tname2");

		TeamDao tdao = new TeamDao();

		int tname = tdao.getTeamIdx(abName);
		int tname2 = tdao.getTeamIdx(abName2);

		String StringIdx = String.valueOf(session.getAttribute("idx"));
		String StringIdx2 = String.valueOf(session.getAttribute("idx2"));

		int idx = Integer.parseInt(StringIdx);
		int idx2 = Integer.parseInt(StringIdx2);



		PitcherDao pdao = new PitcherDao();
		HitterDao hdao = new HitterDao();
		
		tdao.reset2019();
		
		pdao.reset2019();
		
		hdao.reset2019();


	}

}
