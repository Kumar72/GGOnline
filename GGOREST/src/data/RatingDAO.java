package data;

import java.util.List;

import entities.Rating;

public interface RatingDAO {
	public List<Rating> index(int playerId);

}
