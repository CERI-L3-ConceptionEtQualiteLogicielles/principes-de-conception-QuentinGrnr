package exo1;

public class ContactToXml implements ContactPrinter {
    @Override
    public String getInfoContact(Contact contact) {
        return "<contact><nom>" + contact.getNom() + "</nom>" +
                "<numero>" + contact.getNumero() + "</numero>" +
                "<prenom>" + contact.getPrenom() + "</prenom>" +
                "<civilite>" + contact.getCivilite() + "</civilite></contact>";
    }
}
