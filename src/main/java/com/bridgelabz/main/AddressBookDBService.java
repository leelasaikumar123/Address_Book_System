package com.bridgelabz.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressBookDBService {
    DBConnection db = new DBConnection();
    public ArrayList<Contacts> getAllContacts() {
        ArrayList<Contacts> list = new ArrayList<>();
        String sql = "SELECT * FROM contact";
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Contacts contact = new Contacts();
                contact.setContactId(rs.getInt("contactId"));
                contact.setFirstName(rs.getString("firstName"));
                contact.setLastName(rs.getString("lastName"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setState(rs.getString("state"));
                contact.setZipCode(rs.getLong("zipCode"));
                contact.setPhoneNumber(rs.getLong("phoneNumber"));
                contact.setEmail(rs.getString("email"));
                contact.setAddressBookId(rs.getInt("addressBookId"));
                contact.setDateAdded(rs.getDate("date_added"));
                list.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateContact(String firstName, String newAddress) {
        String sql = "UPDATE contact SET address = ? WHERE firstName = ?";
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newAddress);
            ps.setString(2, firstName);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    } 
    
    public Contacts getContact(String firstName) {
        String sql = "SELECT * FROM contact WHERE firstName=?";
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contacts contact = new Contacts();
                contact.setFirstName(rs.getString("firstName"));
                contact.setLastName(rs.getString("lastName"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setState(rs.getString("state"));
                contact.setZipCode(rs.getLong("zipCode"));
                contact.setPhoneNumber(rs.getLong("phoneNumber"));
                contact.setEmail(rs.getString("email"));
                return contact;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<Contacts> getContactsByDate(Date startDate, Date endDate) {
    ArrayList<Contacts> list = new ArrayList<>();
    String sql = "SELECT * FROM contact WHERE date_added BETWEEN ? AND ?";
    try (
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setDate(1, startDate);
        ps.setDate(2, endDate);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Contacts contact = new Contacts();
            contact.setContactId(rs.getInt("contactId"));
            contact.setFirstName(rs.getString("firstName"));
            contact.setLastName(rs.getString("lastName"));
            contact.setAddress(rs.getString("address"));
            contact.setCity(rs.getString("city"));
            contact.setState(rs.getString("state"));
            contact.setZipCode(rs.getLong("zipCode"));
            contact.setPhoneNumber(rs.getLong("phoneNumber"));
            contact.setEmail(rs.getString("email"));
            contact.setAddressBookId(rs.getInt("addressBookId"));
            contact.setDateAdded(rs.getDate("date_added"));
            list.add(contact);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
public int countByCity(String city) {
    String sql = "SELECT COUNT(*) FROM contact WHERE city = ?";
    try (
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, city);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

public int countByState(String state) {
    String sql = "SELECT COUNT(*) FROM contact WHERE state = ?";
    try (
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, state);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
public boolean addContact(Contacts contact) {
    String sql = "INSERT INTO contact(firstName,lastName,address,city,state,zipCode,phoneNumber,email,addressBookId) VALUES(?,?,?,?,?,?,?,?,?)";
    Connection con = null;
    try {
        con = db.getConnection();
        con.setAutoCommit(false);      // Start Transaction
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, contact.getFirstName());
        ps.setString(2, contact.getLastName());
        ps.setString(3, contact.getAddress());
        ps.setString(4, contact.getCity());
        ps.setString(5, contact.getState());
        ps.setLong(6, contact.getZipCode());
        ps.setLong(7, contact.getPhoneNumber());
        ps.setString(8, contact.getEmail());
        ps.setInt(9, contact.getAddressBookId());
        int rows = ps.executeUpdate();
        con.commit();          
        return rows > 0;
    } catch (Exception e) {
       try {
            if (con != null)
                con.rollback();     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
    }

    return false;
}
}
