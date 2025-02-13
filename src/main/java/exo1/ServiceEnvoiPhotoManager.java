package exo1;

public class ServiceEnvoiPhotoManager implements Sender{

    private final ServiceEnvoiPhoto serviceEnvoiPhoto;

    public ServiceEnvoiPhotoManager(ServiceEnvoiPhoto serviceEnvoiPhoto) {
        this.serviceEnvoiPhoto = serviceEnvoiPhoto;
    }

    @Override
    public void envoi(Contact contact, String message) {
        this.serviceEnvoiPhoto.envoiPhoto(contact, message);
    }
}
