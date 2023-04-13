package MainSTEM;

import Components.Editor.EditorStem;
import Components.Growth.GrowthStem;
import Components.Share.ShareStem;

public class MainStem {
    public static void main(String[] args) {
        GrowthStem growthStem = new GrowthStem();
        EditorStem editorStem = new EditorStem();
        ShareStem shareStem = new ShareStem();

        growthStem.registerObserver(editorStem);
        editorStem.registerObserver(shareStem);
    }
}
