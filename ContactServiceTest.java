import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("001", "Alice", "Smith", "1234567890", "100 Apple St");
        service.addContact(contact);
    }

    @Test
    public void testAddContactSuccessfully() {
        Contact newContact = new Contact("002", "Bob", "Jones", "0987654321", "200 Orange Ave");
        service.addContact(newContact);
        assertEquals("Bob", serviceUpdateHelper("002").getFirstName());
    }

    @Test
    public void testAddContactWithDuplicateIdThrowsException() {
        Contact duplicate = new Contact("001", "Charlie", "Brown", "1112223333", "300 Banana Blvd");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    @Test
    public void testDeleteContactSuccessfully() {
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("001", "NewName");
        });
    }

    @Test
    public void testDeleteNonexistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    public void testUpdateFirstNameSuccessfully() {
        service.updateFirstName("001", "Eve");
        assertEquals("Eve", serviceUpdateHelper("001").getFirstName());
    }

    @Test
    public void testUpdatePhoneWithInvalidDataThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("001", "12345");
        });
    }

    @Test
    public void testUpdateNonexistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("999", "New Address");
        });
    }

    // Helper to access contact directly for assertions
    private Contact serviceUpdateHelper(String contactId) {
        // This mirrors the internal logic of getContact() in ContactService
        // You could expose a public method or use reflection if needed
        return new ContactService().getContact(contactId); // Replace with actual access if needed
    }
}

