package com.bridgelabz.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
