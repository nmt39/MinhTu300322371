package com.example.MinhTu300322371;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class DatabaseServiceTest {


    @InjectMocks
    private DatabaseService daoImplements;

    @Mock
    private Connection123 connection1;

    @Mock
    private ResultSet resultSet;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private Connection connection;

    Savings savings;


    @BeforeEach
    public void Setup() throws SQLException, ClassNotFoundException {
        MockitoAnnotations.openMocks(this);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(connection1.connect()).thenReturn(connection);
        savings=new Savings("200","Wendy",9000.0,
                            3,"Savings-Deluxe");
    }


    @Test
    void add()throws SQLException, ClassNotFoundException {
        when(connection.prepareStatement("INSERT INTO savingstable VALUES ( ?, ?, ?,?,? )")).thenReturn(preparedStatement);
        daoImplements.add(savings);
        verify(preparedStatement).executeUpdate();

    }

   /* @Test
    void edit() throws SQLException, ClassNotFoundException{
        savings=new Savings("200","Wendy",10000.0,
                3,"Savings-Deluxe");
        Savings sav1=daoImplements.edit(savings,"200");
        assertEquals(10000.0,sav1.getCustomerDeposit());
    }*/

    @Test
    void delete() throws SQLException {
        when(connection.prepareStatement("Delete from savingstable where custno = ?")).thenReturn(preparedStatement);
        daoImplements.delete("200");
        verify(preparedStatement).executeUpdate();

    }

    @Test
    void display() throws SQLException, ClassNotFoundException  {
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("custno")).thenReturn("200");
        when(resultSet.getString("custname")).thenReturn("Wendy");
        when(resultSet.getDouble("cdep")).thenReturn(9000.0);
        when(resultSet.getInt("nyears")).thenReturn(3);
        when(resultSet.getString("savtype")).thenReturn("Savings-Deluxe");
        when(resultSet.first()).thenReturn(true);

        doReturn(resultSet).when(preparedStatement).executeQuery();
        daoImplements.display();
        verify(preparedStatement).executeQuery();
    }
}