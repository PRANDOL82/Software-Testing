
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(newFirstName);
    }

    // Update last name
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(newLastName);
    }

    // Update phone number
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContact(contactId);
        contact.setPhone(newPhone);
    }

    // Update address
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContact(contactId);
        contact.setAddress(newAddress);
    }

    // Helper method to retrieve contact
    Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contact;
    }
}

