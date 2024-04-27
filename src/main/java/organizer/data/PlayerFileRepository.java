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
        for(Player player : findAll()){
            if(player.getId() == playerId){
                return player;
            }
        }

        return null;
    }

    @Override
    public List<Player> findByRole(Role role) throws DataAccessException {
        ArrayList<Player> result = new ArrayList<>();
        for(Player player : findAll()){
            if(player.getPrimary() == role || player.getSecondary() == role) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public List<Player> findByRank(Rank rank) throws DataAccessException {
        ArrayList<Player> result = new ArrayList<>();
        for(Player player : findAll()){
            if(player.getRank() == rank) {
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public Player add(Player player) throws DataAccessException {
        List<Player> all = findAll();

        int nextId = 0;
        for(Player p: all){
            nextId = Math.max(nextId, p.getId());
        }

        nextId++;
        player.setId(nextId);

        all.add(player);

        writeAll(all);

        return player;
    }

    @Override
    public boolean update(Player player) throws DataAccessException {
        List<Player> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId() == player.getId()){
                all.set(i, player);
                writeAll(all);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteById(int playerId) throws DataAccessException {
        return false;
    }

    private void writeAll(List<Player> players) throws DataAccessException {
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println("id,name,ingame,rank,primary,secondary");
            for(Player p : players){
                writer.println(serialize(p));
            }
        } catch (IOException ex){
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

    private String serialize(Player player){
        return String.format("%s,%s,%s,%s,%s,%s",
                player.getId(),
                player.getName(),
                player.getIngame(),
                player.getRank(),
                player.getPrimary(),
                player.getSecondary());
    }
}
