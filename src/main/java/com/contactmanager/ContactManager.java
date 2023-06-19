package com.contactmanager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {
    Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();

    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.put(generateKey(contact), contact);
    }

    private String generateKey(Contact contact) {
        return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
    }
}
