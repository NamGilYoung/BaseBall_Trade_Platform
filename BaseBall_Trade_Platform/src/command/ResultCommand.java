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

public class ResultCommand implements PlayerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		String section = Stage.player_position + Stage.player2_position;
		
		String stringResult ="";

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

		ArrayList<PitcherDto> before_pdtos = pdao.getPitcherList_2019(tname);
		ArrayList<HitterDto> before_hdtos = hdao.getHitterList_2019(tname);

		ArrayList<PitcherDto> after_pdtos = null;
		ArrayList<HitterDto> after_hdtos = null;
		
		double statSum_team =  0;
		double statSum_team2 = 0;
		double result =0 ; //선수2 의 result
		double result2 =0 ;
		double result3 =0 ;
		
		String before_rate = tdao.getWinrate_2018(tname);

		request.setAttribute("before_pdtos", before_pdtos);
		request.setAttribute("before_hdtos", before_hdtos);
		request.setAttribute("before_rate", before_rate);
		
		

		switch (section) {

		case ("00"):

			pdao.tradePitcherToPitcher(tname, tname2, idx, idx2);

			break;

		case ("01"):

			pdao.tradePitcher(tname, tname2, idx);
			hdao.tradeHitter(tname2, tname, idx2);

			break;

		case ("10"):

			hdao.tradeHitter(tname, tname2, idx);
			pdao.tradePitcher(tname2, tname, idx2);

			break;

		case ("11"):

			hdao.tradeHitterToHitter(tname, tname2, idx, idx2);

			break;
		}
		
		
		

		switch (section) {

		case ("00"):
		case ("10"):
			
			statSum_team =  pdao.get2018TeamPitcherStat(tname);
			statSum_team2 = pdao.get2018TeamPitcherStat(tname2);
			
			result = pdao.getResult_2018(idx2);
			result2 = (result*statSum_team)/statSum_team2;
			
			stringResult = String.format("%.2f",result2);
			result3 =  Double.parseDouble(stringResult);
		  	pdao.updateResult_2019(idx2, result3);


			break;

		case ("01"):
		case ("11"):
			
			statSum_team = hdao.get2018TeamHitterStat(tname);
			statSum_team2 = hdao.get2018TeamHitterStat(tname2);
			
			result = hdao.getResult_2018(idx2);
			result2 = (result*statSum_team)/statSum_team2;
			
			stringResult = String.format("%.2f",result2);
			result3 = Double.parseDouble(stringResult);
			hdao.updateResult_2019(idx2, result3);


			break;
		}
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(statSum_team);
		System.out.println(statSum_team2);
		
		after_pdtos = pdao.getPitcherList_2019(tname);
		after_hdtos = hdao.getHitterList_2019(tname);
		
		
		

		

		double statSum_2019 = pdao.get2019TeamPitcherStat(tname) + hdao.get2019TeamHitterStat(tname);

		tdao.updateStat(tname, statSum_2019);


		String after_rate = tdao.getWinrate_2019(tname);

		// pdao.tradePlayer(tname, tname2, idx, idx2);
	

		request.setAttribute("after_pdtos", after_pdtos);
		request.setAttribute("after_hdtos", after_hdtos);
		request.setAttribute("after_rate", after_rate);

		System.out.println(before_pdtos.get(0).getPosition());
		System.out.println(after_pdtos.get(0).getPosition());

	}

}
