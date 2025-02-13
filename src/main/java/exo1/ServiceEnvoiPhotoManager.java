package exo1;

public class ServiceEnvoiPhotoManager implements Sender{

    private final ServiceEnvoiPhoto serviceEnvoiPhoto = new ServiceEnvoiPhoto();

    @Override
    public void envoi(Contact contact, String message) {
        this.serviceEnvoiPhoto.envoiPhoto(contact, message);
    }
}
