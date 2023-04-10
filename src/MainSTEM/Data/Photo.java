package MainSTEM.Data;

public class Photo {
    private final String imageName;

    public Photo(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imageName;
    }

}