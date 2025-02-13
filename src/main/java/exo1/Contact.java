package exo1;

import java.util.ArrayList;
import java.util.List;

public class Contact{
    private final String nom;
    private final String numero;

    public Contact(String nom, String numero) {
        this.nom = nom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    public String getInfosContact(ContactPrinter format) {
        return format.getInfoContact(this);
    }

    @Override
    public String toString() {
        return "Nom: " + getNom() + ", Numéro: " + getNumero();
    }
}

