package exo1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;
    private ContactPrinter contactPrinterXml;

    @BeforeEach
    public void setUp() {
        contact = new Contact.ContactBuilder("Doe", "123456789").addCivilite("M.").addPrenom("John").build();
        contactPrinterXml = new ContactToXml();
    }

    @Test
    public void testContactCreation() {
        Contact contact = new Contact.ContactBuilder("Doe", "123456789").build();
        assertEquals("Doe", contact.getNom());
        assertEquals("123456789", contact.getNumero());
    }

    @Test
    public void testSendPhoto() {
        Contact contact = new Contact.ContactBuilder("Doe", "123456789").build();
        ServiceEnvoiPhoto service = new ServiceEnvoiPhoto();
        service.envoiPhoto(contact, "image");
    }

    @Test
    public void testGetInfoContactFormats() {
        Contact contact = new Contact.ContactBuilder("Doe", "123456789").build();
        assertEquals("<contact><nom>Doe</nom><numero>123456789</numero><prenom>Undefined</prenom><civilite>Undefined</civilite></contact>", contactPrinterXml.getInfoContact(contact));
    }

    @Test
    public void testContactBuilder() {
        Contact contact = new Contact.ContactBuilder("Doe", "123456789").addCivilite("M.").addPrenom("John").build();
        assertEquals("Doe", contact.getNom());
        assertEquals("123456789", contact.getNumero());
        assertEquals("M.", contact.getCivilite());
        assertEquals("John", contact.getPrenom());
    }

    @Test
    public void testSingletonGestionnaireDeContacts() {
        ContactManager contactManager1 = ContactManager.getInstance();
        ContactManager contactManager2 = ContactManager.getInstance();
        assertEquals(contactManager1, contactManager2);
    }

    @Test
    public void testSendPhotoWithInvalidData() {
        ServiceEnvoiPhoto service = new ServiceEnvoiPhoto();
        assertThrows(IllegalArgumentException.class, () -> service.envoiPhoto(contact, null));
        assertThrows(IllegalArgumentException.class, () -> service.envoiPhoto(contact, ""));
    }

    @Test
    public void testContactManagerAddAndRemove() {
        ContactManager manager = ContactManager.getInstance();
        manager.ajouteContact(contact);
        assertTrue(manager.getContacts().contains(contact.getPrenom()));

        manager.supprimeContact(contact);
        assertFalse(manager.getContacts().contains(contact.getPrenom()));
    }

    @RepeatedTest(10)
    public void testContactManagerThreadSafety() {
        ContactManager manager = ContactManager.getInstance();
        Contact contactTest = new Contact.ContactBuilder("Smith", "555555555").build();
        manager.ajouteContact(contactTest);
        assertTrue(manager.getContacts().contains(contactTest.getPrenom()));
    }
}
