import java.io.*;

public class LineIO {
    private LineManager theManager;
    private File theFile;
    private static final String filename = "file/data.txt";

    public LineIO(LineManager manager) {
        theManager = manager;

        theFile = new File(filename);
    }

    public void readLines() {
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String currentLineBeingRead;

            while((currentLineBeingRead = bufferedReader.readLine()) != null){
                System.out.println(currentLineBeingRead);
                theManager.addLine(currentLineBeingRead);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("**********************");
        // close file
    }

    public void writeLines() {
        PrintWriter writer = null;


             try {
                 writer = new PrintWriter("file/dataWriteMainTwo.txt", "UTF-8");
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
             }
        for (int i = 0; i < theManager.getNumLines(); i++)
        {
            writer.println(theManager.getLine(i));
        }

        // send output to console
        writer.close();
    }
}
