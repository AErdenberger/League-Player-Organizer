package organizer.data;

import organizer.models.Player;
import organizer.models.Rank;
import organizer.models.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerFileRepository implements PlayerRepository{

    private final String filePath;
    public PlayerFileRepository(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public List<Player> findAll() throws DataAccessException {
        ArrayList<Player> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            reader.readLine();

            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] fields = line.split(",", -1);
                if(fields.length == 6){
                    Player player = new Player();
                    //id,name,ingame,rank,primary,secondary
                    player.setId(Integer.parseInt(fields[0]));
                    player.setName(fields[1]);
                    player.setIngame(fields[2]);
                    player.setRank(Rank.valueOf(fields[3].toUpperCase()));
                    player.setPrimary(Role.valueOf(fields[4].toUpperCase()));
                    player.setSecondary(Role.valueOf(fields[5].toUpperCase()));
                    result.add(player);
                }
            }
        } catch(FileNotFoundException ex){

        } catch(IOException ex){
            throw new DataAccessException(ex.getMessage(), ex);
        }

        return result;
    }

    @Override
    public Player findById(int playerId) throws DataAccessException {
        return null;
    }

    @Override
    public List<Player> findByRole(Role role) throws DataAccessException {
        return null;
    }

    @Override
    public List<Player> findByRank(Rank rank) throws DataAccessException {
        return null;
    }

    @Override
    public Player add(Player player) throws DataAccessException {
        return null;
    }

    @Override
    public boolean update(Player player) throws DataAccessException {
        return false;
    }

    @Override
    public boolean deleteById(int playerId) throws DataAccessException {
        return false;
    }
}
