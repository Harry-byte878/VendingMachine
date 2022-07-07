package main.com.hk.VendingMachine;

import main.com.hk.VendingMachine.controller.VendingMachineController;
import main.com.hk.VendingMachine.dao.ItemDaoException;
import main.com.hk.VendingMachine.dao.ItemDaoFileImpl;
import main.com.hk.VendingMachine.dao.itemDao;
import main.com.hk.VendingMachine.ui.UserIO;
import main.com.hk.VendingMachine.ui.UserIOConsoleImpl;
import main.com.hk.VendingMachine.ui.VendingMachineView;

public class App {
    public static void main(String[] args) throws ItemDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        itemDao myDao = new ItemDaoFileImpl();
        VendingMachineController controller = new VendingMachineController(myDao, myView);
        controller.run();

    }
}
