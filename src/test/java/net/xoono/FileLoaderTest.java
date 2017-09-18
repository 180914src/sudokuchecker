package net.xoono;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FileLoaderTest {

    FileLoader testLoader = new FileLoader();


    @Test
    void correctFile() throws Exception {
        int data[][] = testLoader.loadFile("sudoku1.txt");
        assertEquals(9, data[0].length);
        assertEquals(9, data.length);
    }


    @Test
    void lineTooLong() {
        assertThrows(WrongNumberOfElementsInLineException.class, () -> {
                    testLoader.loadFile("sudoku-line-too-long.txt");
                }
        );
    }

    @Test
    void notEnoughData() {
        assertThrows(WrongNumberOfLinesException.class, () -> {
                    testLoader.loadFile("sudoku-not-enough-data.txt");
                }
        );
    }

}
