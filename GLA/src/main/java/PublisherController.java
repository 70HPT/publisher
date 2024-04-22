
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class PublisherController {
    @Controller
    @RequestMapping("/publisher")
    public class ProductController {

        @Autowired
        PublisherController publisherController;

        @GetMapping({"/all", "/", ""})
        public String getAllgames(Model model) {
            model.addAttribute("gameList",
                    PublisherService.getAllGames());
            return "publisher/game-list";
        }

        @GetMapping("/id={gameId}")
        public String getGameById(@PathVariable int gameId, Model model) {
            model.addAttribute("game",
                    PublisherService.getGamesById(gameId));
            return "Publisher/game-details";
        }

        @PostMapping("/create")
        public String createGame(Publisher game) {
            PublisherService.createGame(game);
            return "redirect:/publisher/all";

        }

        @GetMapping("/delete/id={gameId}")
        public String deleteGame(@PathVariable int gameId) {
            PublisherService.deleteGame(gameId);
            return "redirect:/publisher/all";
        }
    }
}
