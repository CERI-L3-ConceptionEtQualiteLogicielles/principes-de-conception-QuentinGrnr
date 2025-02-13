package exo1;

public class main {
    public static void main(String[] args) {
        Contact.ContactBuilder contact = new Contact.ContactBuilder("Garnier", "065028625632");
        contact = contact.addPrenom("Quentin").addCivilite("M.");
        Contact c = contact.build();
        System.out.println(c);
        Contact.ContactBuilder contact2 = new Contact.ContactBuilder("Garnier", "065028625632");
        Contact c2 = contact2.build();
        System.out.println(c2);
    }
}
