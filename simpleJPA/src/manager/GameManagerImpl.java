package manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Game;
import domain.GameORA;

public class GameManagerImpl implements GameManager {

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> GameListManager(String dbtype) {
		
		String jpa_pu = "jpa-hsqldb-ex";

		if ("HSQLDB".equals(dbtype.toUpperCase())) {
			jpa_pu = "jpa-hsqldb-ex";
		} else if ("MYSQL".equals(dbtype.toUpperCase())) {
			jpa_pu = "jpa-mysqldb-ex";
		} else if ("ORACLE".equals(dbtype.toUpperCase())) {
			jpa_pu = "jpa-oracledb-ex";
		} else {
			return null;			
		}
		
		List<Game> gamesAll = new ArrayList<Game>();
		List<GameORA> gamesOraAll = new ArrayList<GameORA>();
		
		EntityManagerFactory emFactory = null;		
		
		emFactory = Persistence.createEntityManagerFactory(jpa_pu);
		
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		if (("HSQLDB".equals(dbtype.toUpperCase())) || ("MYSQL".equals(dbtype.toUpperCase()))) {
			Query q = em.createQuery("select g from Game g ORDER BY g.nflWeek ASC" );	
			gamesAll = q.getResultList();			
		} else {
			Query qOra = em.createQuery("select gOra from GameORA gOra ORDER BY gOra.nflWeek ASC" );
			gamesOraAll = qOra.getResultList();
			for(GameORA gOracle : gamesOraAll) {
				Game tempGame = new Game();
				tempGame.setGameId(gOracle.getGameId());
				tempGame.setNflWeek(gOracle.getNflWeek());
				tempGame.setGameDate(gOracle.getGameDate());
				tempGame.setRoadTeam(gOracle.getRoadTeam());
				tempGame.setHomeTeam(gOracle.getHomeTeam());
				if("T".equals(gOracle.getOutdoorGame().toUpperCase())) {
					tempGame.setOutdoorGame(true);
				} else {
					tempGame.setOutdoorGame(false);
				}
				gamesAll.add(tempGame);
			}
		}
		
		em.getTransaction().commit();
		em.close();
		emFactory.close();
		
		return gamesAll;
		
	}
	

}
