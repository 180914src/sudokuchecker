package net.xoono;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    int[][] loadFile(String fileName) throws IOException {

        int[][] result = new int[9][9];

        try( BufferedReader inputStream = new BufferedReader(new FileReader(fileName)) ) {
            String line;
            int i;
            for(i = 0; i< 9 && (line=inputStream.readLine()) != null; i++) {
                String[] elements = line.split(",");
                if(elements.length != 9) throw new WrongNumberOfElementsInLineException();
                for(int j=0; j<9; j++) {
                    result[i][j] = Integer.parseInt(elements[j]);
                }
            }
            if(i<9) throw new WrongNumberOfLinesException();
        }
        return result;
    }
}

class WrongNumberOfLinesException extends RuntimeException {}

class WrongNumberOfElementsInLineException extends RuntimeException {}