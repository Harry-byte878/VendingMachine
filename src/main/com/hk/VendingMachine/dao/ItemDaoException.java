package main.com.hk.VendingMachine.dao;

public class ItemDaoException extends Exception{

    public ItemDaoException(String message) {
        super(message);
    }

    public ItemDaoException(String message, Throwable cause){
        super(message, cause);
    }
}
