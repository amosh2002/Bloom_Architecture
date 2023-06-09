package ComponentStems.Share;

import MainStem.Interfaces.IObserver;
import MainStem.Data.Photo;

public class ShareStem implements IObserver {
    @Override
    public void update(Object data) {
        if (data instanceof Photo && !((Photo) data).getImagePath().isEmpty()) {
            saveAndShare((Photo) data);
        }
    }

    public void saveAndShare(Photo editedPhoto) {
        System.out.println("It reached me!");
        // Save or share the edited photo
        // ...
    }
}