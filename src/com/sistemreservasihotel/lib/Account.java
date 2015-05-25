/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemreservasihotel.lib;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.sistemreservasihotel.etc.*;

/**
 *
 * @author user
 */
public class Account extends SqlDML {

    private static String accountType;
    private static String employeeNo;
    private static String userID;

    // Method used for authentification user
    public boolean authentication(String userName, String password) {
        boolean result = false;
        makeConnection();
        String str = "select * from account where  username=" + "'" + userName + "'" + " and pass=" + "'" + Utility.MD5Hashing(password) + "'" + ";";
        queryDataBase(str);
        try {
            if (resultSet.next()) {
                result = true;
                accountType = resultSet.getString("account_types");
                employeeNo = resultSet.getString("employee_no");
                userID = resultSet.getString("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        terminateConnection();
        return result;
    }

    // Get account type
    public String getAccountType() {
        return accountType;
    }

    // Get user ID
    public String getUserID() {
        return userID;
    }

    // Get employee no
    public String getEmployeeNo() {
        return employeeNo;
    }

    // This method used for generating data for listing user list (for userListTbl data in Menu Class)
    public DefaultTableModel updateAccountList() throws SQLException {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<String> columnNames = new Vector<String>();
        makeConnection();
        String str = "select account.username as 'User Name', employee.employee_name as 'Employee Name', account.employee_no as 'Employee No.', account.account_types as 'Account Type' from account join employee on account.employee_no = employee.employee_no";
        queryDataBase(str);
        ResultSetMetaData resultMetaData = resultSet.getMetaData();
        int columnCount = resultMetaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(resultMetaData.getColumnName(column));
        }
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }
        terminateConnection();
        return new DefaultTableModel(data, columnNames);
    }

    // Delete account from database
    public void deleteAccount(String userName) {
        makeConnection();
        String str = "delete from account where username = " + "'" + userName + "'" + ";";
        deleteDatabase(str);
        terminateConnection();
    }

    // Empty password for username
    public void emptyAccountPassword(String userName) {
        makeConnection();
        String str = "update account set password='' where username = " + "'" + userName + "'" + ";";
        updateDatabase(str);
        terminateConnection();
    }

    // Adding username to table accoung 
    public void addAccount(String employeeNo, String username, String password, String accountType) {
        makeConnection();
        String str = "insert into account(employee_no, username, pass, account_types) values(" + employeeNo + "," + "'" + username + "'," + "'" + Utility.MD5Hashing(password) + "'," + "'" + accountType + "');";
        insertDataBase(str);
        terminateConnection();
    }

    // Check employee exist
    public boolean checkEmployeeNo(String employeeNo) {
        boolean result = false;
        makeConnection();
        String str = "select * from employee where  employee_no=" + employeeNo + ";";
        queryDataBase(str);
        try {
            if (resultSet.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        terminateConnection();
        return result;
    }

    // update new password 
    public void updateAccountPassword(String newPassword) {
        makeConnection();
        String str = "update account set pass='" + Utility.MD5Hashing(newPassword) + "' where user_id=" + userID + ";";
        updateDatabase(str);
        terminateConnection();
    }
}
