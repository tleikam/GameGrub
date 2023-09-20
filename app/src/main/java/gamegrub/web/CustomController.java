package gamegrub.web;

import gamegrub.data.Item;
import gamegrub.data.MenuFilter;
import gamegrub.data.combo.Combo;
import gamegrub.data.custom.CustomItem;
import gamegrub.data.custom.CustomItemList;
import gamegrub.data.menu.Menu;
import java.math.BigDecimal;
import java.util.LinkedList;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller for the springframework.
 */
@Controller
public class CustomController {

    /**
     * Mapping to route to the custom items of the website.
     */
    @GetMapping("/custom")
    public String index(Model model) {
        CustomItemList cil = CustomItemList.getInstance();
        model.addAttribute("items", cil);
        return "custom";
    }

    /**
     * Mapping to route to single custom item of website.
     */
    @GetMapping("/custom/{id}")
    public String single(@PathVariable int id, Model model) {
        CustomItemList cil = CustomItemList.getInstance();
        model.addAttribute("custom", cil.get(id));
        model.addAttribute("id", id);
        return "singlecustom";
    }

    /**
     * Mapping to edit single custom item in website.
     */
    @GetMapping("/custom/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        CustomItemList cil = CustomItemList.getInstance();
        model.addAttribute("custom", cil.get(id));
        model.addAttribute("id", id);
        return "editform";
    }

    /**
     * Post mapping to modify the edited single custom item.
     */
    @PostMapping("/custom/{id}")
    public String edit(@PathVariable int id,
            @Valid @ModelAttribute("custom") CustomItem custom,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editform";
        }
        CustomItemList cil = CustomItemList.getInstance();
        cil.set(id, custom);
        return "redirect:/custom";
    }

    /**
     * Mapping to destroy single custom item in website. 
     */
    @GetMapping("/custom/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model) {
        CustomItemList cil = CustomItemList.getInstance();
        model.addAttribute("custom", cil.get(id));
        model.addAttribute("id", id);
        return "deleteform";
    }

    /**
     * Post mapping to confirm deletion of single custom item.
     */
    @PostMapping("/custom/{id}/delete")
    public String delete(@PathVariable int id) {
        CustomItemList cil = CustomItemList.getInstance();
        cil.delete(id);
        return "redirect:/custom";
    }

    /**
     * Mapping to create a new custom item.
     */
    @GetMapping("/custom/new")
    public String newItem(Model model) {
        CustomItemList cil = CustomItemList.getInstance();
        CustomItem custom = new CustomItem("", new BigDecimal(0.0), 0);
        model.addAttribute("custom", custom);
        return "new";
    }

    /**
     * Post mapping of information to create new custom item.
     */
    @PostMapping("/custom")
    public String itemForm(
            @Valid @ModelAttribute("custom") CustomItem custom,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        CustomItemList cil = CustomItemList.getInstance();
        cil.add(custom);
        return "redirect:/custom";
    }

    /**
     * Post mapping to save current status of Custom List.
     */
    @PostMapping("/custom/save")
    public String save() {
        CustomItemList cil = CustomItemList.getInstance();
        cil.save();
        return "redirect:/custom";
    }
}