package organizer.data;

import organizer.models.Role;
import organizer.models.Rank;
import organizer.models.Player;

import java.util.List;

public interface PlayerRepository {

    List<Player> findAll() throws DataAccessException;

    Player findById(int playerId) throws DataAccessException;

    List<Player> findByRole(Role role) throws DataAccessException;

    List<Player> findByRank(Rank rank) throws DataAccessException;

    Player add(Player player) throws DataAccessException;

    boolean update(Player player) throws DataAccessException;

    boolean deleteById(int playerId) throws DataAccessException;
}
