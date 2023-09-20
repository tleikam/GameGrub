package gamegrub.gui;

import gamegrub.data.Item;

/**
 * ParentPanel interface.
 *
 *<p>This is an interface for panels to implement
 so they can be used for parents of other panels.
 *
 * @author Travis Leikam
 * @version v0.7
 */
public interface ParentPanel {

    void addItem(Item item);

    void loadMenuPanel();
}