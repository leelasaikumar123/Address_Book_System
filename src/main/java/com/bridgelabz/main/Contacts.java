package com.bridgelabz.main;

import java.sql.Date;

public class Contacts {
	String firstName;
	String lastName;
	String address;
	String City;
	String state;
	Long zipCode;
	Long phoneNumber;
	String email;
	int contactId;
	int addressBookId;
	private java.sql.Date dateAdded;
	public Contacts() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactId() {
	    return contactId;
	}

	public void setContactId(int contactId) {
	    this.contactId = contactId;
	}

	public int getAddressBookId() {
	    return addressBookId;
	}

	public void setAddressBookId(int addressBookId) {
	    this.addressBookId = addressBookId;
	}
	public Date getDateAdded() {
    return dateAdded;
   }

    public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
   }
	@Override
	public String toString() {
		return firstName+","+lastName+","+address+","+City+","+state+","+zipCode+","+phoneNumber+","+email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null || getClass()!=obj.getClass())
			return false;
		Contacts contact=(Contacts)obj;
		return firstName.equalsIgnoreCase(contact.firstName)
				&& lastName.equalsIgnoreCase(contact.lastName);
	}
	
}
