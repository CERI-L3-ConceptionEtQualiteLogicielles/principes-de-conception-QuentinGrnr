package exo1;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String nom;
    private String numero;

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

    public String getInfosContact (){
        return this.toString();
    }

    @Override
    public String toString() {
        return "Nom: " + getNom() + ", Numéro: " + getNumero();
    }
}

