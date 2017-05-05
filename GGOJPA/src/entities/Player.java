package entities;

import java.sql.Timestamp;
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
@Table(name="user")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String email;
	private String password;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	private String fname;
	private String lname;
	private Boolean active;
	private Boolean	status;
	
	@JsonIgnore
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	  @JoinTable(name="user_team",
	    joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
	    inverseJoinColumns=@JoinColumn(name="team_id")
	  )
	  private List<Team>teams;
	
	@JsonIgnore
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	  @JoinTable(name="user_game",
	    joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
	    inverseJoinColumns=@JoinColumn(name="game_id")
	  )
	  private List<Game>games;
	
//	@JsonIgnore
//	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
//	  @JoinTable(name="message_recipient",
//	    joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
//	    inverseJoinColumns=@JoinColumn(name="message_id")
//	  )
//	  private List<Message>messages;
	
	@JsonIgnore
	@OneToMany(mappedBy="player")
	  private List<Rating> ratings;
	
//	private String picUrl;
//	
//	
//	public String getPicUrl() {
//		return picUrl;
//	}
//	public void setPicUrl(String picUrl) {
//		this.picUrl = picUrl;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
//	public List<Message> getMessages() {
//		return messages;
//	}
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", createTime=" + createTime + ", fname=" + fname + ", lname=" + lname + ", active=" + active
				+ ", status=" + status + "]";
	}
	  
	

}
