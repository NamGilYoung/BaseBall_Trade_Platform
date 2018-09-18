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



      PitcherDao pdao = new PitcherDao();
      TeamDao tdao = new TeamDao();
      HitterDao hdao = new HitterDao();
      
      int intTname = Integer.parseInt(tname);
      
      String abName = tdao.getTeamName(intTname);
      System.out.println(intTname);
      System.out.println(abName);
      ArrayList<PitcherDto> pdtos = pdao.getPitcherList(intTname);
      ArrayList<HitterDto> hdtos = hdao.getHitterList(intTname);
      System.out.println();

      if(Stage.stage == 0) {
			session.setAttribute("tname", abName);
		}else {
			session.setAttribute("tname2", abName);
		}
      
      request.setAttribute("pitcherList", pdtos);
      request.setAttribute("hitterList", hdtos);
      
   }

}