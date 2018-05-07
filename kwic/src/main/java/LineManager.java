import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;

public class LineManager {
    private ArrayList<String> allLines;

    public LineManager() {
        allLines = new ArrayList<String>();
    }

    public void addLine(String line) {
        allLines.add(line);
    }

    public String getLine(int lineNum) {
        return allLines.get(lineNum);
    }

    public void setLine(int lineNum, String line) {
        allLines.set(lineNum, line);
    }

    public void deleteLine(int lineNum) {
        allLines.remove(lineNum);
    }

    public int getNumLines() {
        return allLines.size();
    }

    public void addWordToLine(String word, int lineNum) {
        String line = allLines.get(lineNum);
        String newLine = line + word;
        allLines.set(lineNum, newLine);
    }

    public String getWordFromLine(int wordNum, int lineNum) {
        String line = allLines.get(lineNum);
        String[] words = line.split(" ");
        return words[wordNum];
    }

    public void deleteWordFromLine(int wordNum, int lineNum) {
        String line = allLines.get(lineNum);
        String[] words = line.split(" ");
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 0; i < words.length; i++) {
            if (i != wordNum) {
                sj.add(words[i]);
            }
        }

        allLines.set(lineNum, sj.toString());
    }

    public int getNumWordsInLine(int lineNum) {
        String line = allLines.get(lineNum);
        String[] words = line.split(" ");
        return words.length;
    }
}
