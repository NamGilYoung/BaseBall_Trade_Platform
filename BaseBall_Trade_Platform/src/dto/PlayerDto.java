package dto;

public class PlayerDto {

	int team;
	int backNum;
	String playerName;
	String position;

	public PlayerDto(int backNum, String playerName, String position) {
		super();
		this.backNum = backNum;
		this.playerName = playerName;
		this.position = position;
	}

	public PlayerDto(int team, int backNum, String playerName, String position) {
		super();
		this.team = team;
		this.backNum = backNum;
		this.playerName = playerName;
		this.position = position;
	}

	public PlayerDto() {
		super();
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getBackNum() {
		return backNum;
	}

	public void setBackNum(int backNum) {
		this.backNum = backNum;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
