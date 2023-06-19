package com.contactmanager;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void validateFirstName() {
        if (this.firstName.isBlank()) {
            throw new RuntimeException("First name cannot be null or empty.");
        }
    }

    public void validateLastName() {
        if (this.lastName.isBlank()) {
            throw new RuntimeException("Last name cannot be null or empty.");
        }
    }

    public void validatePhoneNumber() {
        if (this.phoneNumber.isBlank()) {
            throw new RuntimeException("Phone number cannot be null or empty.");
        }

        if (this.phoneNumber.length() != 14) {
            throw new RuntimeException("Phone number must be 14 digits long.");
        }

        if (!this.phoneNumber.matches("\\d+")) {
            throw new RuntimeException("Phone number must contain only digits.");
        }

        if (!this.phoneNumber.startsWith("0")) {
            throw new RuntimeException("Phone number must start with 0.");
        }
    }
}
