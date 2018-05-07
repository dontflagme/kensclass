import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTwoExample {

    public static void main(String[] args) {
        System.out.println("KWIC Index Processing System - Version 2");

        LineManager lineManager = new LineManager();

        LineIO lineIO = new LineIO(lineManager);
        lineIO.readLines();

        circularShift(lineManager);
        alphabetize(lineManager);
        lineIO.writeLines();

        // console output
        for (int i = 0; i < lineManager.getNumLines(); i++) {
            System.out.println(lineManager.getLine(i));
        }
    }

    public static void circularShift(LineManager manager) {
        for (int i = 0; i < manager.getNumLines(); i++) {
            String firstWord = manager.getWordFromLine(0, i);
            manager.deleteWordFromLine(0, i);
            manager.addWordToLine(firstWord, i);
        }
    }

    public static void alphabetize(LineManager manager) {
        List<String> tempLines = new ArrayList<String>();

        for (int i = 0; i < manager.getNumLines(); i++) {
            String line = manager.getLine(i);
            tempLines.add(line);
        }

        Collections.sort(tempLines);

        for (int i = 0; i < tempLines.size(); i++) {
            manager.setLine(i, tempLines.get(i));
        }
    }
}
