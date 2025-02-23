package exo1;

import java.util.ArrayList;
import java.util.List;

public class ContactManager implements ContactsService {

    private static ContactManager instance = null;

    private final List<Contact> lesContacts = new ArrayList<>();

    private ContactManager() {
    }

    public static ContactManager getInstance() {
        if (instance == null) {
            instance = new ContactManager();
        }
        return instance;
    }

    public void ajouteContact(Contact contact) {
        lesContacts.add(contact);
    }

    public void supprimeContact(Contact contact) {
        lesContacts.remove(contact);
    }

    public void afficheContacts() {
        for (Contact contact : lesContacts) {
            System.out.println(contact.toString());
        }
    }

    public void sauvegardeEnBD() {
        // Logique pour sauvegarder les contacts dans une base de données
    }

    public String getContacts() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : lesContacts) {
            sb.append(contact.toString());
        }
        return sb.toString();
    }
}
