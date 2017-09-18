package net.xoono;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        if(args.length != 1 ) {
            System.err.println("Please pass the file name as argument");
            System.exit(1);
        }

        FileLoader fileLoader = new FileLoader();
        SudokuValidator validator = new SudokuValidator();

        try {
            int data[][] = fileLoader.loadFile(args[0]);
            if (validator.validate(data)) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }
        } catch (WrongNumberOfLinesException notEnoughData) {
            System.err.println("INVALID");
        } catch (WrongNumberOfElementsInLineException lineTooLongElements) {
            System.err.println("INVALID");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File '" + args[0] + "' not found");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }
}
