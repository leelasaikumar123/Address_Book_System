package com.bridgelabz.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class AddressBookTest {

    @Test
    public void givenContact_WhenAdded_ShouldIncreaseSize() {

        AddressBook book = new AddressBook();

        Contacts contact = new Contacts();
        contact.setFirstName("Sai");
        contact.setLastName("Kumar");

        book.getContactList().add(contact);

        assertEquals(1, book.getContactList().size());
    }

    @Test
    public void givenDuplicateContact_ShouldNotBeAdded() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setFirstName("Sai");
        c1.setLastName("Kumar");

        Contacts c2 = new Contacts();
        c2.setFirstName("Sai");
        c2.setLastName("Kumar");

        book.getContactList().add(c1);

        if (!book.getContactList().contains(c2)) {
            book.getContactList().add(c2);
        }

        assertEquals(1, book.getContactList().size());
    }

    @Test
    public void givenContact_WhenDeleted_ShouldDecreaseSize() {

        AddressBook book = new AddressBook();

        Contacts c = new Contacts();
        c.setFirstName("Sai");
        c.setLastName("Kumar");

        book.getContactList().add(c);

        book.getContactList().remove(c);

        assertEquals(0, book.getContactList().size());
    }

    @Test
    public void givenContact_WhenEdited_ShouldUpdateAddress() {

        AddressBook book = new AddressBook();

        Contacts c = new Contacts();
        c.setFirstName("Sai");
        c.setAddress("Old Address");

        book.getContactList().add(c);

        c.setAddress("New Address");

        assertEquals("New Address", c.getAddress());
    }

    @Test
    public void givenContacts_WhenCountedByCity_ShouldReturnCorrectCount() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setCity("Guntur");

        Contacts c2 = new Contacts();
        c2.setCity("Guntur");

        Contacts c3 = new Contacts();
        c3.setCity("Hyderabad");

        book.getContactList().add(c1);
        book.getContactList().add(c2);
        book.getContactList().add(c3);

        assertEquals(2, book.countByCity("Guntur"));
    }

    @Test
    public void givenContacts_WhenCountedByState_ShouldReturnCorrectCount() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setState("AP");

        Contacts c2 = new Contacts();
        c2.setState("AP");

        Contacts c3 = new Contacts();
        c3.setState("TS");

        book.getContactList().add(c1);
        book.getContactList().add(c2);
        book.getContactList().add(c3);

        assertEquals(2, book.countByState("AP"));
    }

    @Test
    public void givenContacts_WhenSortedByName_ShouldReturnAlphabeticalOrder() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setFirstName("Ravi");

        Contacts c2 = new Contacts();
        c2.setFirstName("Akhil");

        Contacts c3 = new Contacts();
        c3.setFirstName("Sai");

        book.getContactList().add(c1);
        book.getContactList().add(c2);
        book.getContactList().add(c3);

        book.getContactList().sort(
                Comparator.comparing(Contacts::getFirstName));

        assertEquals("Akhil",
                book.getContactList().get(0).getFirstName());
    }

    @Test
    public void givenContacts_WhenSortedByCity_ShouldReturnCorrectOrder() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setCity("Hyderabad");

        Contacts c2 = new Contacts();
        c2.setCity("Guntur");

        book.getContactList().add(c1);
        book.getContactList().add(c2);

        book.getContactList().sort(
                Comparator.comparing(Contacts::getCity));

        assertEquals("Guntur",
                book.getContactList().get(0).getCity());
    }

    @Test
    public void givenContacts_WhenSortedByState_ShouldReturnCorrectOrder() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setState("TS");

        Contacts c2 = new Contacts();
        c2.setState("AP");

        book.getContactList().add(c1);
        book.getContactList().add(c2);

        book.getContactList().sort(
                Comparator.comparing(Contacts::getState));

        assertEquals("AP",
                book.getContactList().get(0).getState());
    }

    @Test
    public void givenContacts_WhenSortedByZip_ShouldReturnCorrectOrder() {

        AddressBook book = new AddressBook();

        Contacts c1 = new Contacts();
        c1.setZipCode(522006L);

        Contacts c2 = new Contacts();
        c2.setZipCode(500001L);

        book.getContactList().add(c1);
        book.getContactList().add(c2);

        book.getContactList().sort(
                Comparator.comparing(Contacts::getZipCode));

        assertEquals(500001L,
                book.getContactList().get(0).getZipCode());
    }

    @Test
    public void givenDatabase_WhenRead_ShouldReturnContacts() {

        AddressBookDBService service = new AddressBookDBService();

        assertNotNull(service.getAllContacts());
    }

}
