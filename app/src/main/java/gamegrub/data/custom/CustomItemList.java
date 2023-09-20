package gamegrub.data.custom;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import gamegrub.data.custom.CustomItem;
import java.io.File;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Custom Item List Class.
 *
 *<p>This class is a container for the CustomItem class
 and works as a singleton so the application only has one instance.
 *
 * @author Travis Leikam
 * @version v0.12
 */
public class CustomItemList implements Iterable<CustomItem> {

    private List<CustomItem> items;
    private static CustomItemList instance = null;

    /**
     * Constructor for the Custom Item List.
     */
    private CustomItemList() {
        

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.items = mapper.readValue(new File("customs.json"),
                                          new TypeReference<List<CustomItem>>(){});
            System.out.println("Successfully loaded file");
        } catch (Exception e) {
            System.err.println("Unable to parse Custom Item file!");
            e.printStackTrace();
            this.items = new LinkedList<>();
        }
        

        /* Tried to Serialize, unable to serialize object
        try {
           File file = new File("customs.ser");

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            this.items = (List<CustomItem>) in.readObject();

            System.out.println("Successfully Loaded List"); 
        } catch (Exception e) {
            System.err.println("Unable to successfully parse Item List");
            e.printStackTrace();
            this.items = new LinkedList<>();
        }
        */
        
    }

    /**
     * Static getter for singleton instance.
     *
     * @return CustomItemList singleton instance
     */
    public static CustomItemList getInstance() {
        if (CustomItemList.instance == null) {
            CustomItemList.instance = new CustomItemList();
        }
        return CustomItemList.instance;
    }

    /**
     * Method to iterate over items.
     *
     * @return an iterator of items
     */
    @Override
    public Iterator<CustomItem> iterator() {
        return items.iterator();
    }

    /**
     * The number of items.
     *
     * @return the number of items
     */
    public int size() {
        return items.size();
    }

    /**
     * Get a single item.
     *
     * @param i the index of the item
     * @return the item
     */
    public CustomItem get(int i) {
        return items.get(i);
    }

    /**
     * Update a single item.
     *
     * @param i the index of the item
     */
    public void set(int i, CustomItem customitem) {
        items.set(i, customitem);
    }

    /**
     * Add a item to the list.
     *
     * @param customitem Item to add
     */
    public void add(CustomItem customitem) {
        items.add(customitem);
    }
    
    /**
     * Delete a single item.
     *
     * @param i the index of the item
     */
    public void delete(int i) {
        items.remove(i);
    }

    /**
     * Save method.
     *
     *<p>This class saves the current created list of custom items to 
     a JSON file for serialization
     */ 
    public void save() {
        

        try {
            File file = new File("customs.json");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Saving Items List");
            mapper.writeValue(file, this.items);
            System.out.println("Saved item list");
        } catch (Exception e) {
            System.err.println("Not Saved: Unable to write to 'customs.json'");
            e.printStackTrace();
        }

        

        /* Attempted to write Binary, unable to serialize object
        try {
            File file = new File("customs.ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(this.items);
            System.out.println("Saving Items List");
            System.out.println("Saved item list");
        } catch (Exception e) {
            System.err.println("Not Saved: Unable to write to 'customs.ser'");
            e.printStackTrace();
        }
        */
    }
}