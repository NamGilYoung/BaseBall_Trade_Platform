package dto;

public class TeamDto {
   int idx;
   String ab;        //팀약어
   String name;      //팀이름
   double stat;      //팀스탯

   // 생성자
   public TeamDto(int idx, String ab) {
      super();
      this.idx = idx;
      this.ab = ab;
   }

   public TeamDto() {
      super();
   }

   // Getter and Setter
   public int getIdx() {
      return idx;
   }

   public void setIdx(int idx) {
      this.idx = idx;
   }

   public String getAb() {
      return ab;
   }

   public void setAb(String ab) {
      this.ab = ab;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getStat() {
      return stat;
   }

   public void setStat(double stat) {
      this.stat = stat;
   }
   
   
}