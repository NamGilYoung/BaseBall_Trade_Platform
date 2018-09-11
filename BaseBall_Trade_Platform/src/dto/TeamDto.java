package dto;

public class TeamDto {
	int idx;
	String teamName;

	//생성자
	public TeamDto(int idx, String teamName) {
		super();
		this.idx = idx;
		this.teamName = teamName;
	}

	public TeamDto() {
		super();
	}
	
	//Getter and Setter
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
