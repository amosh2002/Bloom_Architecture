package ComponentStems.PhotoTaker;

import MainStem.Data.Photo;

public class PhotoTaker {

    public Data takePhoto() {
        Photo photo = new Photo("initial_photo");
        return DataFactory.createData(photo);
    }
}