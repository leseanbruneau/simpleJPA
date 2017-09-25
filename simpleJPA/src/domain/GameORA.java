package domain;

import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the OT_CRAFT database table.
 * 
 */
@Entity
@Table(name="GAME")
public class GameORA {
	
	@Id
	@SequenceGenerator(name="GAME_GAMEID_GENERATOR", sequenceName="SEQ_NAME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GAME_GAME_ID_GENERATOR")
	@Column(name="GAME_ID")
	private int gameId;
	
	@Column(name="NFL_WEEK")
	private int nflWeek;
	
	@Column(name="GAME_DATE")
	private Date gameDate;
	
	@Column(name="ROAD_TEAM")
	String roadTeam;
	
	@Column(name="HOME_TEAM")
	String homeTeam;
	
	@Column(name="OUTDOOR_GAME")
	String outdoorGame;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getNflWeek() {
		return nflWeek;
	}

	public void setNflWeek(int nflWeek) {
		this.nflWeek = nflWeek;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public String getRoadTeam() {
		return roadTeam;
	}

	public void setRoadTeam(String roadTeam) {
		this.roadTeam = roadTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getOutdoorGame() {
		return outdoorGame;
	}

	public void setOutdoorGame(String outdoorGame) {
		this.outdoorGame = outdoorGame;
	}


}

