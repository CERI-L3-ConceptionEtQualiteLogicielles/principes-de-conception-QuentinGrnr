package exo1;

public class Contact{
    private String nom;
    private String numero;
    private String prenom;
    private String civilite;


    private Contact () {}

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getInfosContact(ContactPrinter format) {
        return format.getInfoContact(this);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", numero='" + numero + '\'' +
                ", prenom='" + prenom + '\'' +
                ", civilite='" + civilite + '\'' +
                '}';
    }

    public static class ContactBuilder {
        private String nom;
        private String numero;
        private String prenom = "Undefined";
        private String civilite = "Undefined";

        public ContactBuilder(String nom, String numero) {
            this.nom = nom;
            this.numero = numero;
        }

        public ContactBuilder addPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public ContactBuilder addCivilite(String civilite) {
            this.civilite = civilite;
            return this;
        }

        public Contact build() {
            Contact contact =  new Contact();
            contact.nom = this.nom;
            contact.numero = this.numero;
            contact.prenom = this.prenom;
            contact.civilite = this.civilite;
            return contact;
        }
    }
}

