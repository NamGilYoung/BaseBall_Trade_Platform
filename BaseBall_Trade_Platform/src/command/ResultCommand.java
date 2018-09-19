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
import dto.TradedPlayers;
import stage.Stage;

public class ResultCommand implements PlayerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		Stage.COUNT++; // 웹사이트의 사이클 완료 횟수

		String section = Stage.PLAYER_POSITION + Stage.PLAYER_POSITION2; // 투투 ,타타 , 투타 , 타투 교환 구분

		String stringResult = "";

		String abName = (String) session.getAttribute("tname");
		String abName2 = (String) session.getAttribute("tname2");
		
		String playerName ="";
		String playerName2 ="";
		
		
		

		TeamDao tdao = new TeamDao();

		int tname = tdao.getTeamIdx(abName);
		int tname2 = tdao.getTeamIdx(abName2);

		String StringIdx = String.valueOf(session.getAttribute("idx"));
		String StringIdx2 = String.valueOf(session.getAttribute("idx2"));

		int idx = Integer.parseInt(StringIdx);
		int idx2 = Integer.parseInt(StringIdx2);

		PitcherDao pdao = new PitcherDao();
		HitterDao hdao = new HitterDao();

		// 트레이드전 2019 db 불러오기
		ArrayList<PitcherDto> before_pdtos = pdao.getPitcherList_2019(tname);
		ArrayList<HitterDto> before_hdtos = hdao.getHitterList_2019(tname);
		//

		ArrayList<PitcherDto> after_pdtos = null;
		ArrayList<HitterDto> after_hdtos = null;

		double statSum_team = 0;
		double statSum_team2 = 0;
		double result = 0; // 선수2 의 result
		double result2 = 0;
		double result3 = 0;

		String before_rate = tdao.getWinrate_2018(tname);

		// 트레이드전 2019 투타선수목록, 팀승률 리퀘스트객체에 세팅
		request.setAttribute("before_pdtos", before_pdtos);
		request.setAttribute("before_hdtos", before_hdtos);
		request.setAttribute("before_rate", before_rate);

		switch (section) { // 섹션에 따른 알맞은 트레이드 찾기

		case ("00"):

			pdao.tradePitcherToPitcher(tname, tname2, idx, idx2);
		
			playerName = pdao.getPlayerName(idx);
			playerName2 = pdao.getPlayerName(idx2);

			break;

		case ("01"):

			pdao.tradePitcher(tname, tname2, idx);
			hdao.tradeHitter(tname2, tname, idx2);
			
			playerName = pdao.getPlayerName(idx);
			playerName2 = hdao.getPlayerName(idx2);

			break;

		case ("10"):

			hdao.tradeHitter(tname, tname2, idx);
			pdao.tradePitcher(tname2, tname, idx2);
			
			playerName = hdao.getPlayerName(idx);
			playerName2 = pdao.getPlayerName(idx2);

			break;

		case ("11"):

			hdao.tradeHitterToHitter(tname, tname2, idx, idx2);
		
			playerName = hdao.getPlayerName(idx);
			playerName2 = hdao.getPlayerName(idx2);

			break;
		}

		switch (section) { // 섹션에 따른 winrate변화 계산 시작

		case ("00"):
		case ("10"):

			statSum_team = pdao.get2018TeamPitcherStat(tname);
			statSum_team2 = pdao.get2018TeamPitcherStat(tname2);

			result = pdao.getResult_2018(idx2);
			result2 = (result * statSum_team) / statSum_team2;

			stringResult = String.format("%.2f", result2);
			result3 = Double.parseDouble(stringResult);
			pdao.updateResult_2019(idx2, result3);

			break;

		case ("01"):
		case ("11"):

			statSum_team = hdao.get2018TeamHitterStat(tname);
			statSum_team2 = hdao.get2018TeamHitterStat(tname2);

			result = hdao.getResult_2018(idx2);
			result2 = (result * statSum_team) / statSum_team2;

			stringResult = String.format("%.2f", result2);
			result3 = Double.parseDouble(stringResult);
			hdao.updateResult_2019(idx2, result3);

			break;
		}

		System.out.println(result);
		System.out.println(result2);
		System.out.println(statSum_team);
		System.out.println(statSum_team2);

		// 트레이드 이후의 2019 db 가져오기
		after_pdtos = pdao.getPitcherList_2019(tname);
		after_hdtos = hdao.getHitterList_2019(tname);

		// 투수, 타자끼리의 계산으로 새팀에 들어갈 맞는 result값 계산후 업데이트
		double statSum_2019 = pdao.get2019TeamPitcherStat(tname) + hdao.get2019TeamHitterStat(tname);

		tdao.updateStat(tname, statSum_2019);
		// 

		String after_rate = tdao.getWinrate_2019(tname);

		//트레이드후 2019 투타선수목록, 팀승률 리퀘스트객체에 세팅
		request.setAttribute("after_pdtos", after_pdtos);
		request.setAttribute("after_hdtos", after_hdtos);
		request.setAttribute("after_rate", after_rate);

		System.out.println(before_pdtos.get(0).getPosition());
		System.out.println(after_pdtos.get(0).getPosition());
		
		
		// 트레이드된 선수의 정보를 따로 저장하고 원하는 팀의 영입,방출 정보만 jsp에 보내준다.
		
		
		String teamName = tdao.getTeamName2(tname);
		String teamName2 = tdao.getTeamName2(tname2);
		
		
		TradedPlayers tradedPlayer = new TradedPlayers(playerName,playerName2);
		//TradedPlayers tradedPlayer2 = new TradedPlayers(playerName2,teamName2,teamName);
		
		ArrayList<TradedPlayers> tArrayList = new ArrayList<TradedPlayers> ();
		
		try {
			tArrayList = (ArrayList<TradedPlayers>) session.getAttribute("tradedPlayers");
			
			tArrayList.add(tradedPlayer);
			//tArrayList.add(tradedPlayer2);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			tArrayList = new ArrayList<TradedPlayers> ();
			
			tArrayList.add(tradedPlayer);
			//tArrayList.add(tradedPlayer2);
		}
		
		session.setAttribute("tradedPlayers", tArrayList);
		
//		for(int i=0; i< tArrayList.size();i++) {
//			
//			if(!tArrayList.get(i).getBerforeTeam().equals(teamName) && !tArrayList.get(i).getAfterTeam().equals(teamName)) {
//				tArrayList.remove(i);
//			}
//		}
		
		request.setAttribute("tpal", tArrayList);
		request.setAttribute("tname", abName);
		 
		
		
		

	}

}
