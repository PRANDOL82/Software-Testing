import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testPhoneInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "This address is way too long to be accepted by the system");
        });
    }

    @Test
    public void testSettersWithValidData() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsTooLong");
        });
    }

    @Test
    public void testContactIdIsImmutable() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        // No setter for contactId, so we just confirm it's unchanged
        assertEquals("123", contact.getContactId());
    }
}

