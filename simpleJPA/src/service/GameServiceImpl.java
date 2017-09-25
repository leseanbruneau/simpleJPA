package service;

import java.util.List;

import domain.Game;
import manager.GameManager;
import manager.GameManagerImpl;

public class GameServiceImpl implements GameService {

	@Override
	public List<Game> GameListService(String dbtype) {
		
		List<Game> gamesAll = null;
		
		GameManager gml = new GameManagerImpl();
		
		gamesAll = gml.GameListManager(dbtype);
		
		return gamesAll;
	}

}
