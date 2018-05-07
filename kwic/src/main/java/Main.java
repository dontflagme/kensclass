import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        System.out.println("KWIK Index Production System - Version 1");

        ArrayList<String> allLines = readLines();
        circularShift(allLines);
        alphabetize(allLines);
        writeLines(allLines);
    }

    public static ArrayList<String> readLines() {
        ArrayList<String> result = new ArrayList<String>();
        // open file, read it in, add lines to result
        try {
            FileReader reader = new FileReader("file/data.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String currentLineBeingRead;

            while((currentLineBeingRead = bufferedReader.readLine()) != null){
                System.out.println(currentLineBeingRead);
                result.add(currentLineBeingRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void circularShift(ArrayList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, circularShiftLine(lines.get(i)));
        }
    }

    public static String circularShiftLine(String line) {
        String[] words = line.split(" ");
        String firstWord = words[0];

        StringJoiner sj = new StringJoiner(" ");

        for (int i = 1; i < words.length; i++) {
            sj.add(words[i]);
        }

        sj.add(firstWord);
        return sj.toString();
    }

    public static void alphabetize(ArrayList<String> lines) {
        Collections.sort(lines);
    }

    public static void writeLines(ArrayList<String> lines) {
        // send output to console
        for (String line : lines)
        {
            System.out.println(line);
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("file/dataWrite.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        for (String line : lines)
        {
            writer.println(line);
        }

        writer.close();
        // send output to file
    }
}
