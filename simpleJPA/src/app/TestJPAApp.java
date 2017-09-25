package app;

import java.text.SimpleDateFormat;
import java.util.List;

import domain.Game;
import service.GameService;
import service.GameServiceImpl;

public class TestJPAApp {

	public static void main(String[] args) {
		
		System.out.println("Beginning TestJPAApp Program...");
		
		if (args.length != 1) {
			System.err.println("Need one parameter for database....");
			System.err.println("\tValid values are hsqldb, mysql and oracle");
			System.exit(0);
		}
		
		// Validate database input parameter
		if (!("HSQLDB".equals(args[0].toUpperCase())) && !("MYSQL".equals(args[0].toUpperCase())) && !("ORACLE".equals(args[0].toUpperCase()))) {
			System.err.println("Need one parameter for database....");
			System.err.println("\tValid values are hsqldb, mysql and oracle");
			System.exit(0);
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MM-dd-yyyy");
		
		GameService gameService = new GameServiceImpl();
		
		List<Game> gamesAll = gameService.GameListService(args[0].toUpperCase());
		
		// Print Header Lines
		System.out.println( " Game_ID\t|" + " NFL_WEEK\t|" + " GAME_DATE     \t|" + " ROAD_TEAM\t|" + " HOME_TEAM\t|" + " OUTDOOR_GAME");
		System.out.println( " -------\t|" + " --------\t|" + " ---------     \t|" + " ---------\t|" + " ---------\t|" + " ------------");
		// Print Games
		for (Game game : gamesAll) {
			System.out.println( " " + game.getGameId() + "\t\t| " + game.getNflWeek() + "\t\t| " + dateFormat.format(game.getGameDate())
					+ "\t| " + String.format("%1$-"+ 10 +"s", game.getRoadTeam()) + "\t| " + 
					String.format("%1$-"+ 10 +"s", game.getHomeTeam()) + "\t| " + game.isOutdoorGame());
		}
		
		System.out.println("End of TestJPAApp Program...");	

	}

}
