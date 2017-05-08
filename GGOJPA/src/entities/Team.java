package entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="team")
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="created_time")
	private Timestamp createdTime;
	
	private boolean active;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String image;
	

	@ManyToMany(mappedBy="teams")
	@JsonIgnore
	  private List<Player> players;
	
	@JsonIgnore
	@ManyToOne
	  @JoinColumn(name="game_id")
	  private Game game;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", createdTime=" + createdTime + ", active=" + active + ", image="
				+ image + "]";
	}
	
	
	
}
