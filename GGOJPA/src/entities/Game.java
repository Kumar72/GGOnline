package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="game")
public class Game {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="genera")
	private String genre;
	
	private String rating;
	
	private String description;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String image;

	@JsonIgnore
    @ManyToMany(mappedBy="games")
    private List<Player> players;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="game")
	  private List<Team> teams;
	
//	private boolean isFollowed;
//	
//	public boolean isFollowed() {
//		return isFollowed;
//	}
//
//	public void setFollowed(boolean isFollowed) {
//		this.isFollowed = isFollowed;
//	}
//

	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", genre=" + genre + ", rating=" + rating + ", description="
				+ description + ", image=" + image + ", players=" + players + ", teams=" + teams + "]";
	}

	
	

}
