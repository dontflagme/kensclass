import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class myVersion {

    public static void main(String[] args){
        ArrayList<String> dataOfStrings = new ArrayList<String>();
        ArrayList<String> dataAppendedArray = new ArrayList<String>();
        System.out.println("**************Original Data*************************");
        try {
            FileReader reader = new FileReader("file/data.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String currentLineBeingRead;

            while((currentLineBeingRead = bufferedReader.readLine()) != null){
                System.out.println(currentLineBeingRead);
                dataOfStrings.add(currentLineBeingRead);
            }

            System.out.println("*****************Swapped Data**********************");
            int dataOfStringsIndex = 0;
            while (dataOfStringsIndex < dataOfStrings.size()) {
                String firstLetter = String.valueOf(dataOfStrings.get(dataOfStringsIndex).charAt(0));
                String stringWithoutFirstChar = dataOfStrings.get(dataOfStringsIndex).substring(dataOfStrings.get(dataOfStringsIndex).length() - (dataOfStrings.get(dataOfStringsIndex).length() -1));
                String appendToLast = stringWithoutFirstChar + firstLetter;
                dataAppendedArray.add(appendToLast);
                System.out.println(dataAppendedArray.get(dataOfStringsIndex));
                dataOfStringsIndex++;
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
