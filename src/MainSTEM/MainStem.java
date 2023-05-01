package MainStem;

import ComponentStems.Editor.EditorStem;
import ComponentStems.PhotoTaker.Handler.PhotoTakerHandler;
import ComponentStems.Share.ShareStem;

public class MainStem {
    public static void main(String[] args) {
        PhotoTakerHandler photoTakerHandler = new PhotoTakerHandler();
        EditorStem editorStem = new EditorStem();
        ShareStem shareStem = new ShareStem();

        photoTakerHandler.registerObserver(editorStem);
        editorStem.registerObserver(shareStem);

        photoTakerHandler.startApp();
    }
}
