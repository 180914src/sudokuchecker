package net.xoono;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuValidatorTest {

    SudokuValidator testValidator = new SudokuValidator();

    @Test
    void correctSolution() {
        int data[][] = {
                {5, 3, 6, 7, 8, 9, 1, 4, 2},
                {4, 8, 7, 6, 1, 2, 3, 9, 5},
                {1, 9, 2, 5, 3, 4, 8, 7, 6},
                {3, 7, 5, 4, 6, 8, 9, 2, 1},
                {9, 2, 8, 1, 5, 7, 6, 3, 4},
                {6, 4, 1, 2, 9, 3, 7, 5, 8},
                {8, 1, 3, 9, 2, 5, 4, 6, 7},
                {2, 6, 4, 3, 7, 1, 5, 8, 9},
                {7, 5, 9, 8, 4, 6, 2, 1, 3}
        };
        assertEquals(true, testValidator.validate(data));
    }

    @Test
    void verticalInvalid() {
        int data[][] = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        assertEquals(false, testValidator.validate(data));
    }

    @Test
    void horizontalInvalid() {
        int data[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5, 5, 5, 5, 5},
                {6, 6, 6, 6, 6, 6, 6, 6, 6},
                {7, 7, 7, 7, 7, 7, 7, 7, 7},
                {8, 8, 8, 8, 8, 8, 8, 8, 8},
                {9, 9, 9, 9, 9, 9, 9, 9, 9}
        };
        assertEquals(false, testValidator.validate(data));
    }

    @Test
    void validSumsWrongCells() {
        int data[][] = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };
        assertEquals(false, testValidator.validate(data));
    }
}
