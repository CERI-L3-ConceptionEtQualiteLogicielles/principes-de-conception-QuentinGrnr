package exo1;

public class ServiceEnvoiPhoto{

    public ServiceEnvoiPhoto() {
    }
    public void envoiPhoto(Contact contact, String image) {
        if (image == null || image.isEmpty()) {
            throw new IllegalArgumentException("Image cannot be null");
        }
    }
}
