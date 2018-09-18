package dto;

public class PitcherDto {

   // Columns
   int idx;
   String name;
   String position;
   int team;
   int qs; // 퀄리티스타트
   int hi; // 타자
   int h; // 피안타
   int b2; // 피2루타
   int b3; // 피3루타
   int hr; // 피홈런
   int rr; // 실점
   int er; // 자책점
   int so; // 삼진
   int bb; // 볼넷
   int ibb; // 고의4구
   int hbp; // 사구
   int wp; // 폭투
   int blk; // 보크
   int pk; // 견제사
   int sb; // 도루허용
   int nsb; // 도루저지
   double war;
   double result;

   // constructor#1 (default)
   public PitcherDto() {
   }

   // Constructor#2 (idx, name, position,result) in PlayerSelect.jsp
   public PitcherDto(int idx, String name, String position, double result) {
      super();
      this.idx = idx;
      this.name = name;
      this.position = position;
      this.result = result;
   }

   public int getIdx() {
      return idx;
   }

   public void setIdx(int idx) {
      this.idx = idx;
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

   public int getQs() {
      return qs;
   }

   public void setQs(int qs) {
      this.qs = qs;
   }

   public int getHi() {
      return hi;
   }

   public void setHi(int hi) {
      this.hi = hi;
   }

   public int getH() {
      return h;
   }

   public void setH(int h) {
      this.h = h;
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

   public int getRr() {
      return rr;
   }

   public void setRr(int rr) {
      this.rr = rr;
   }

   public int getEr() {
      return er;
   }

   public void setEr(int er) {
      this.er = er;
   }

   public int getSo() {
      return so;
   }

   public void setSo(int so) {
      this.so = so;
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

   public int getWp() {
      return wp;
   }

   public void setWp(int wp) {
      this.wp = wp;
   }

   public int getBlk() {
      return blk;
   }

   public void setBlk(int blk) {
      this.blk = blk;
   }

   public int getPk() {
      return pk;
   }

   public void setPk(int pk) {
      this.pk = pk;
   }

   public int getSb() {
      return sb;
   }

   public void setSb(int sb) {
      this.sb = sb;
   }

   public int getNsb() {
      return nsb;
   }

   public void setNsb(int nsb) {
      this.nsb = nsb;
   }

   public double getWar() {
      return war;
   }

   public void setWar(double war) {
      this.war = war;
   }

   public double getResult() {
      return result;
   }

   public void setResult(double result) {
      this.result = result;
   }

}