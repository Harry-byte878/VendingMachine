package main.com.hk.VendingMachine.controller;
import main.com.hk.VendingMachine.dao.ItemDaoException;
import main.com.hk.VendingMachine.dao.ItemDaoFileImpl;
import main.com.hk.VendingMachine.dao.itemDao;
import main.com.hk.VendingMachine.dto.Item;
import main.com.hk.VendingMachine.ui.UserIO;
import main.com.hk.VendingMachine.ui.UserIOConsoleImpl;
import main.com.hk.VendingMachine.ui.VendingMachineView;


import java.math.BigDecimal;
import java.util.List;

public class VendingMachineController {

    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();
    private itemDao dao;


    public void run() throws ItemDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        String cashAmount = view.getCashAmount();
        BigDecimal cashAmountBigDecimal = new BigDecimal(cashAmount);
        System.out.println("You entered $" + cashAmountBigDecimal);
        try {
            while (keepGoing) {


                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        io.print("INSERT CASH");
                        break;
                    case 2:
                        System.out.println("$" + cashAmountBigDecimal + " remaining");
                        break;
                    case 3:
                        listItems();
                        break;
                    case 4:
                        createItem();
                        break;
                    case 5:
                        BigDecimal cost = buyItem();
                        cashAmountBigDecimal = cashAmountBigDecimal.subtract(cost);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");
                        break;
                }

            }
        } catch (ItemDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        io.print("GOOD BYE");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createItem() throws ItemDaoException {
        view.displayCreateItemBanner();
        Item newItem = view.getNewItemInfo();
        dao.addItem(newItem.getName(), newItem);
        view.displayCreateItemSuccessBanner();
    }

    private void listItems() throws ItemDaoException {
        view.displayDisplayAllBanner();
        List<Item> itemList = dao.getAllItems();
        view.displayItemList(itemList);
    }

    private BigDecimal buyItem() throws ItemDaoException {
        view.displayBuyItemBanner();
        String itemName = view.getItemName();
        int quantity = view.getItemQuantity();
        Item item = dao.getItem(itemName);
        dao.buyItem(itemName, quantity);
        BigDecimal quantityBigDecimal = new BigDecimal(quantity);
        BigDecimal priceBigDecimal = item.getPrice();
        return quantityBigDecimal.multiply(priceBigDecimal);
    }

    public VendingMachineController(itemDao dao, VendingMachineView view){
        this.dao = dao;
        this.view = view;
    };
}
