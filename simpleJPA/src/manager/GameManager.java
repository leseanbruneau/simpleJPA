package manager;

import java.util.List;

import domain.Game;

public interface GameManager {
	
	List<Game> GameListManager(String dbtype);
	
}
