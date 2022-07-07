package main.com.hk.VendingMachine.dao;

import main.com.hk.VendingMachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

public interface itemDao {

    Item addItem(String  name, Item item) throws ItemDaoException;
    List<Item> getAllItems() throws ItemDaoException ;
    void buyItem(String name, int quantity) throws ItemDaoException;
    Item getItem(String name) throws ItemDaoException;
    String getChange(BigDecimal cashAmount);
}
