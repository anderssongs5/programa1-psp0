package co.edu.udea.pruebassoftware.psp.programa1.controller;

import co.edu.udea.pruebassoftware.psp.programa1.linkedlist.LinkedList;
import co.edu.udea.pruebassoftware.psp.programa1.util.constants.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Program1PSPController {

    public Program1PSPController() {
        super();
    }

    public boolean checkFile(File selectedFile) {
        if ((selectedFile == null) || !(selectedFile.canRead())
                || !(selectedFile.isFile())) {

            return false;
        }

        return selectedFile.getName().endsWith(Constants.FILE_EXTENSION);
    }

    public LinkedList readFile(File file) throws IOException {
        LinkedList linkedList = new LinkedList();
        List<StringBuilder> lines = this.readLines(file);

        for (StringBuilder sb : lines) {
            String line = sb.toString();
            StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String numberString = stringTokenizer.nextToken().trim();
                    if (!numberString.equals("")) {
                        double num = Double.parseDouble(numberString);
                        linkedList.link(num);
                    }
                } catch (NumberFormatException ex) {

                    return null;
                }
            }
        }

        return linkedList;
    }

    public List<StringBuilder> readLines(File selectedFile)
            throws FileNotFoundException, IOException {
        System.out.println(selectedFile.getAbsolutePath());
        
        FileReader fileReader = new FileReader(selectedFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<StringBuilder> lines = new ArrayList<>();
        String stringTemp = bufferedReader.readLine();
        StringBuilder temp;

        while (stringTemp != null) {
            temp = new StringBuilder(stringTemp.trim());

            if (temp.length() == 0) {
                stringTemp = bufferedReader.readLine();
                continue;
            }

            lines.add(temp);
            stringTemp = bufferedReader.readLine();
        }

        return (lines);
    }
}
