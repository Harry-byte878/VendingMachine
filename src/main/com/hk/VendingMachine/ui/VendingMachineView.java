package main.com.hk.VendingMachine.ui;

import main.com.hk.VendingMachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Insert Money");
        io.print("2. Display Amount");
        io.print("3. List Items");
        io.print("4. Create New Item");
        io.print("5. Buy an Item");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Item getNewItemInfo() {
        String name = io.readString("Please enter item name");
        BigDecimal price = new BigDecimal(io.readDouble("Please enter the price"));
        int quantity = io.readInt("Please enter the quantity");
        Item currentItem = new Item(name);
        currentItem.setPrice(price);
        currentItem.setQuantity(quantity);
        return currentItem;
    }

    public void displayCreateItemBanner() {
        io.print("=== Create Item ===");
    }

    public void displayCreateItemSuccessBanner() {
        io.readString("Item successfully created. Please hit enter to continue");
    }

    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            String itemInfo = String.format("%s : %s %s",
                    currentItem.getName(),
                    currentItem.getPrice(),
                    currentItem.getQuantity());
            io.print(itemInfo);
        }
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===");
    }

    public void displayBuyItemSuccessBanner() {
        io.readString("Item bought successfully. Hit enter to continue.");
    }

    public void displayBuyItemBanner() {
        io.print("=== Buy Item ===");
    }

    public int getItemQuantity(){
        return io.readInt("How many would you like to buy?");
    }

    public String getItemName() {
        return io.readString("Which item do you want to buy?");
    }

    public void displayInsertCashBanner(){
        io.print("=== Insert Cash ===");
    }

    public String getCashAmount(){
        return io.readString("Please enter how much cash you want to insert.");
    }



    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ====");
        io.print(errorMsg
        );
    }

    public VendingMachineView(UserIO io){
        this.io = io;
    }
}
