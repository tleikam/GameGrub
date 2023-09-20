package gamegrub.web;

import gamegrub.data.Item;
import gamegrub.data.MenuFilter;
import gamegrub.data.combo.Combo;
import gamegrub.data.menu.Menu;
import java.util.LinkedList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller for the springframework.
 */
@Controller
public class MenuController {

    /**
     * Mapping to route to the homepage of the website.
     */
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    /**
     * Mapping to route to the about page of the website.
     */
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    /**
     * Route for the search button.
     */
    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }

    /**
     * Post mapping for search form data.
     */
    @PostMapping("/search")
    public String searchResults(
            @RequestParam(name = "text", required = true, defaultValue = "") String text,
            Model model) {
        model.addAttribute("text", text);
        LinkedList<Item> items = new Menu().getFullMenu();
        items = MenuFilter.filterKeywords(items, text);
        LinkedList<Item> combos = new LinkedList<>();
        combos = MenuFilter.filterCombos(items);
        items = MenuFilter.removeCombos(items);
        model.addAttribute("items", items);
        model.addAttribute("combos", combos);
        return "search";    
    }

    /**
     * Mapping to route to the menu page of the website.
     */
    @GetMapping("/menu")
    public String menu(Model model) {
        Menu menu = new Menu();
        Combo discountHolder = new Combo();
        model.addAttribute("entrees", menu.getEntrees());
        model.addAttribute("sides", menu.getSides());
        model.addAttribute("drinks", menu.getDrinks());
        model.addAttribute("combos", menu.getCombos());
        model.addAttribute("discount", discountHolder);
        return "menu";
    }

    /**
     * Mapping for the advanced search.
     */
    @GetMapping("/advancedsearch")
    public String advancedSearch(Model model) {
        model.addAttribute("entree", true);
        model.addAttribute("side", true);
        model.addAttribute("drink", true);
        model.addAttribute("combo", true);
        return "advanced_search";
    }

    /**
     * Post mapping for the form data.
     */
    @PostMapping("/advancedsearch")
    public String advancedSearchResults(
            @RequestParam(name = "text", required = true, defaultValue = "") String text,
            @RequestParam(name = "entree", defaultValue = "false") boolean entree,
            @RequestParam(name = "side", defaultValue = "false") boolean side,
            @RequestParam(name = "drink", defaultValue = "false") boolean drink,
            @RequestParam(name = "combo", defaultValue = "false") boolean combo,
            @RequestParam(name = "pricemin", required = true, defaultValue = "-1") double pricemin,
            @RequestParam(name = "pricemax", required = true, defaultValue = "-1") double pricemax,
            @RequestParam(name = "calmin", required = true, defaultValue = "-1") int calmin,
            @RequestParam(name = "calmax", required = true, defaultValue = "-1") int calmax,
            Model model) {
        model.addAttribute("text", text);
        model.addAttribute("entree", entree);
        model.addAttribute("side", side);
        model.addAttribute("drink", drink);
        model.addAttribute("combo", combo);
        if (pricemin >= 0) {
            model.addAttribute("pricemin", pricemin);
        }
        if (pricemax >= 0) {
            model.addAttribute("pricemax", pricemax);
        }
        if (calmin >= 0) {
            model.addAttribute("calmin", calmin);
        }
        if (calmax >= 0) {
            model.addAttribute("calmax", calmax);
        }
        LinkedList<Item> items = new Menu().getFullMenu();
        items = MenuFilter.filterKeywords(items, text);
        items = MenuFilter.filterType(items, entree, side, drink, combo);
        items = MenuFilter.filterPrice(items, pricemin, pricemax);
        items = MenuFilter.filterCalories(items, calmin, calmax);
        LinkedList<Item> combos = new LinkedList<>();
        combos = MenuFilter.filterCombos(items);
        items = MenuFilter.removeCombos(items);
        model.addAttribute("items", items);
        model.addAttribute("combos", combos);
        return "advanced_search";    
    }
}