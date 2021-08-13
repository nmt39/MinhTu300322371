package com.example.MinhTu300322371;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(Savings sav) throws ClassNotFoundException, SQLException;
    public Savings edit(Savings sav, String customerNumber) throws SQLException, ClassNotFoundException;
    public void delete(String customerNumber) throws SQLException;
    public List<Savings> display() throws ClassNotFoundException, SQLException;
}
