package main.com.hk.VendingMachine.dao;

import main.com.hk.VendingMachine.dto.Item;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ItemDaoFileImpl implements itemDao{
    static final String ITEMS_FILE = "C:/Users/user/Documents/Wiley Edge/VendingMachine/src/main/com/hk/VendingMachine/dao/items.txt";
    static final String DELIMITER = "::";
    private Map<String, Item> items = new HashMap<>();

    @Override
    public Item addItem(String name, Item item) throws ItemDaoException {
        loadItems();
        Item prevItem = items.put(name, item);
        writeItems();
        return prevItem;
    }

    @Override
    public List<Item> getAllItems() throws ItemDaoException {
        loadItems();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public void buyItem(String name, int quantity) throws ItemDaoException {
        loadItems();
        Item item = getItem(name);
        int newQuantity = item.getQuantity() - quantity;
        item.setQuantity(newQuantity);
        writeItems();
    }

    @Override
    public Item getItem(String name) throws ItemDaoException{
        loadItems();
        return items.get(name);
    }

    @Override
    public String getChange(BigDecimal cashAmount) {
        int dollars;
        int dimes

    }

    private Item unmarshallItem(String itemAsText){
        String[] itemTokens = itemAsText.split(DELIMITER);
        String name = itemTokens[0];
        Item itemFromFile = new Item(name);
        itemFromFile.setPrice(BigDecimal.valueOf(Double.parseDouble(itemTokens[1])));
        itemFromFile.setQuantity(Integer.parseInt(itemTokens[2]));
        return itemFromFile;
    }

    private void loadItems() throws ItemDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new ItemDaoException("-_- Could not load item data into memory.", e);
        }
        String currentLine;
        Item currentItem;
        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            items.put(currentItem.getName(), currentItem);
        }
        scanner.close();
    }

    private String marshallItem(Item anItem){
        String itemAsText = anItem.getName() + DELIMITER + anItem.getPrice() + DELIMITER + anItem.getQuantity();
        return itemAsText;
    }

    private void writeItems() throws ItemDaoException{
        PrintWriter pw;

        try{
            pw = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new ItemDaoException("Could not save item data.", e);
        }
        String itemAsText;
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            itemAsText = marshallItem(currentItem);
            pw.println(itemAsText);
            pw.flush();
        }
        pw.close();
    }


}
