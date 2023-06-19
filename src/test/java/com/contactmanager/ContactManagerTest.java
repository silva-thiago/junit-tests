package com.contactmanager;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    ContactManager contactManager;

    @BeforeAll
    void setupAll() {
        System.out.println("All tests have been started");
    }

    @BeforeEach
    void setup() {
        System.out.println("The test has been started");
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Shoud be able to create a contact")
    void should_create_a_contact() {
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

    @Test
    @DisplayName("Should not be able to create a contact when first name is null")
    void should_not_create_a_contact_when_first_name_is_null() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "01234567890123");
        });
    }

    @Test
    @DisplayName("Should not be able to create a contact when last name is null")
    void should_not_create_a_contact_when_last_name_is_null() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", null, "01234567890123");
        });
    }

    @Test
    @DisplayName("Should not be able to create a contact when phone number is null")
    void should_not_create_a_contact_when_phone_number_is_null() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Doe", null);
        });
    }

    @AfterEach
    void tearDown() {
        System.out.println("The test has been finished");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println("All tests have been finished");
    }
}
