package dto;

public class TradedPlayers {
	
	String playerName;
	String playerName2;
	public TradedPlayers(String playerName, String playerName2) {
		super();
		this.playerName = playerName;
		this.playerName2 = playerName2;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerName2() {
		return playerName2;
	}

	public void setPlayerName2(String playerName2) {
		this.playerName2 = playerName2;
	}
	
	
	

}
