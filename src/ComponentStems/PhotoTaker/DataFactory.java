package ComponentStems.PhotoTaker;

import MainStem.Data.Photo;

public class DataFactory {
    public static Data createData(Photo photo) {
        return new Data(photo);
    }
}