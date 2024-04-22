
import java.util.Collection;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    static NavigableMap<Integer, Publisher> games = new TreeMap<>();

    /**
     * Get entire list of games.
     *
     * @return the product list.
     */
    public static Collection getAllGames() {
        if (games.isEmpty()) {
            games.put(0, new Publisher(0, "sample", 1.25));
        }
        return games.values();
    }

    /**
     * Get a specific product using id.
     *
     * @param gameId
     * @return the product.
     */
    public static Publisher getGamesById(int gameId) {

        return games.get(gameId);
    }

    /**
     * Add a new game to the list.
     *
     * @param game
     */
    public static void createGame(Publisher game) {
        Entry<Integer, Publisher> lastEntry = games.lastEntry();
        int index = lastEntry.getKey() + 1;
        game.setGameId(index);
        games.put(game.getGameId(), game);

    }

    /**
     * Delete a specific game using id.
     *
     * @param gameId
     */
    public static void deleteGame(Integer gameId) {
        games.remove(gameId);
    }
}
