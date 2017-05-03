package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import entities.Game;
import entities.Message;
import entities.Player;
import entities.Rating;
import entities.Team;

public class GGOTest {

	private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private Player player;
    private Game game;
    private Message message;
    private Team team;
    private Rating rating;

@Before
      public void setUp() throws Exception {
         emf = Persistence.createEntityManagerFactory("GGO");
         em = emf.createEntityManager();
         player = em.find(Player.class, 1);
         
     }
     @After
      public void tearDown() throws Exception {
         em.close();
         emf.close();    
     }
    

     @Test
     public void test_player_mapping() {
        assertEquals("Stefan", player.getFname());
     }
     
}
