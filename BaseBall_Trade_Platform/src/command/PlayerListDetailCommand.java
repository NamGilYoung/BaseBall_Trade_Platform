package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HitterDao;
import dao.PitcherDao;
import dao.TeamDao;
import dto.HitterDto;
import dto.PitcherDto;
import stage.Stage;

public class PlayerListDetailCommand implements PlayerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		//PlayerDao pdao = new PlayerDao();
		TeamDao tdao = new TeamDao();
		PitcherDao pdao = null;
		HitterDao hdao = null;
		
		String position = (String) request.getAttribute("position");
		System.out.println(position);

		String abName = "";		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		if(Stage.stage == 0) {
			abName = (String) session.getAttribute("tname");
		}else {
			abName = (String) session.getAttribute("tname2");
		}
		
		int teamIdx = tdao.getTeamIdx(abName);
		System.out.println(teamIdx);
		
		System.out.println(position);
		System.out.println(position);
		switch (position) {
		
		case  ("pitcher") :
			
			pdao = new PitcherDao();
			
			ArrayList<PitcherDto> alpdto = pdao.getPitcherDetailInfo(teamIdx, idx);
		request.setAttribute("playerDetail", alpdto);
		
		if(Stage.stage == 0) {
			Stage.player_position = "0";
		}else {
			Stage.player2_position ="0";
		}
		
			break;
		
		case  ("hitter") :
			
			hdao = new HitterDao();
		
			ArrayList<HitterDto> alhdto = hdao.getHitterDetailInfo(teamIdx, idx);
		request.setAttribute("playerDetail", alhdto);
		
		if(Stage.stage == 0) {
			Stage.player_position = "1";
		}else {
			Stage.player2_position ="1";
		}
		
			break;
		}



		
		
		
		if(Stage.stage == 0) {
			session.setAttribute("idx", idx);
			
		}else {
			session.setAttribute("idx2", idx);
		}
		
		System.out.println("스테이지 i ="+Stage.i);
		Stage.i ++;
		System.out.println("playListDetail에서의 stage 값 :"+Stage.stage);

	}

	

}
