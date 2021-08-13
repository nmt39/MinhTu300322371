package com.example.MinhTu300322371;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{

    Connection con;
    public DatabaseService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Savings sav) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO savingstable VALUES ( ?, ?,?,?,? )";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, sav.getCustomerNumber());
        query.setString(2, sav.getCustomerName());
        query.setDouble(3,sav.getCustomerDeposit());
        query.setInt(4,sav.getYear());
        query.setString(5, sav.getSavingType());
        query.executeUpdate();
    }

    @Override
    public Savings edit(Savings sav, String customerNumber) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update savingstable set custno=?, custname=?, cdep=?, nyears=?, savtype=? where custno = ?");
        query.setString(1, sav.getCustomerNumber());
        query.setString(2, sav.getCustomerName());
        query.setDouble(3,sav.getCustomerDeposit());
        query.setInt(4,sav.getYear());
        query.setString(5, sav.getSavingType());
        query.setString(6, customerNumber);
        query.executeUpdate();
        return sav;
    }

    @Override
    public void delete(String customerNumber) throws SQLException {
        String quer1 = "Delete from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, customerNumber);
        query.executeUpdate();
    }

    @Override
    public List<Savings> display() throws ClassNotFoundException, SQLException {
        List<Savings> Savlist = new ArrayList<>();
        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Savings obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Savings(rs.getString("custno"), rs.getString("custname"),
                    rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));
            Savlist.add(obj1);
        }
        return Savlist;
    }

    //search method
    public Savings search(String customerNumber) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, customerNumber);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }

            Savings obj1=null;
            obj1 = new Savings(rs.getString("custno"), rs.getString("custname"),
                    rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));


        return obj1;



    }
}
