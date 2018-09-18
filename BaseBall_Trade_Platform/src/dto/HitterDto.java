package dto;

public class HitterDto {
   int idx;
   String name;
   String position;
   int team;
   int g; // 경기수
   int ab; // 타석
   int an; // 타수
   int h; // 안타 (단타 + 2루타 + 3루타 + 홈런)
   int b1; // 단타
   int b2; // 2루타
   int b3; // 3루타
   int hr; // 홈런
   int score; // 득점
   int rbi; // 타점
   int bb; // 볼넷
   int ibb; // 고의4구
   int hbp; // 사구
   int so; // 삼진아웃
   int sf; // 희생플라이
   int sh; // 번트
   int dp; // 병살타
   int sb; // 도루
   int war;
   double result;

   // Constructor#1 (defualt)
   public HitterDto() {
      // TODO Auto-generated constructor stub
   }

   // Constructor#2 (idx, name, position,result) in PlayerSelect.jsp
   public HitterDto(int idx, String name, String position, double result) {
      this.idx = idx;
      this.name = name;
      this.position = position;
      this.result = result;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPosition() {
      return position;
   }

   public void setPosition(String position) {
      this.position = position;
   }

   public int getTeam() {
      return team;
   }

   public void setTeam(int team) {
      this.team = team;
   }

   public int getG() {
      return g;
   }

   public void setG(int g) {
      this.g = g;
   }

   public int getAb() {
      return ab;
   }

   public void setAb(int ab) {
      this.ab = ab;
   }

   public int getAn() {
      return an;
   }

   public void setAn(int an) {
      this.an = an;
   }

   public int getH() {
      return h;
   }

   public void setH(int h) {
      this.h = h;
   }

   public int getB1() {
      return b1;
   }

   public void setB1(int b1) {
      this.b1 = b1;
   }

   public int getB2() {
      return b2;
   }

   public void setB2(int b2) {
      this.b2 = b2;
   }

   public int getB3() {
      return b3;
   }

   public void setB3(int b3) {
      this.b3 = b3;
   }

   public int getHr() {
      return hr;
   }

   public void setHr(int hr) {
      this.hr = hr;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   public int getRbi() {
      return rbi;
   }

   public void setRbi(int rbi) {
      this.rbi = rbi;
   }

   public int getBb() {
      return bb;
   }

   public void setBb(int bb) {
      this.bb = bb;
   }

   public int getIbb() {
      return ibb;
   }

   public void setIbb(int ibb) {
      this.ibb = ibb;
   }

   public int getHbp() {
      return hbp;
   }

   public void setHbp(int hbp) {
      this.hbp = hbp;
   }

   public int getSo() {
      return so;
   }

   public void setSo(int so) {
      this.so = so;
   }

   public int getSf() {
      return sf;
   }

   public void setSf(int sf) {
      this.sf = sf;
   }

   public int getSh() {
      return sh;
   }

   public void setSh(int sh) {
      this.sh = sh;
   }

   public int getDp() {
      return dp;
   }

   public void setDp(int dp) {
      this.dp = dp;
   }

   public int getSb() {
      return sb;
   }

   public void setSb(int sb) {
      this.sb = sb;
   }

   public int getWar() {
      return war;
   }

   public void setWar(int war) {
      this.war = war;
   }

   public double getResult() {
      return result;
   }

   public void setResult(double result) {
      this.result = result;
   }

   public int getIdx() {
      return idx;
   }

   public void setIdx(int idx) {
      this.idx = idx;
   }

}