package com.contactmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactManagerTest {
    @Test
    @DisplayName("Shoud create a contact")
    public void should_create_a_contact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("John", "Doe", "01234567890123");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("John") &&
                        contact.getLastName().equals("Doe") &&
                        contact.getPhoneNumber().equals("01234567890123"))
                .findAny()
                .isPresent()
        );
    }
}
