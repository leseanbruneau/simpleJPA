package service;

import java.util.List;

import domain.Game;

public interface GameService {

	List<Game> GameListService(String dbtype);
	
}
