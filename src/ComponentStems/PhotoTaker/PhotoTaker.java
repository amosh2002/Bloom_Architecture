package ComponentStems.PhotoTaker;

import ComponentStems.PhotoTaker.Data.Data;
import ComponentStems.PhotoTaker.Data.DataFactory;
import MainStem.Data.Photo;

public class PhotoTaker {

    public Data takePhoto() {
        Photo photo = new Photo("initial_photo");
        return DataFactory.createData(photo);
    }
}