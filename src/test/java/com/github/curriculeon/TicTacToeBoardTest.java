package com.github.curriculeon;

import com.github.curriculeon.arcade.tictactoe.TicTacToeBoard;
import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {
    @Test
    public void testSetCell() {
        testSetCell(1, 0,0);
        testSetCell(2, 0,1);
        testSetCell(3, 0,2);
        testSetCell(4, 1,0);
        testSetCell(5, 1,1);
        testSetCell(6, 1,2);
        testSetCell(7, 2,0);
        testSetCell(8, 2,1);
        testSetCell(9, 2,2);
    }

    private void testSetCell(int index, int row, int column) {
        // given
        final TicTacToeBoard board = new TicTacToeBoard();
        final String[][] matrix = board.getMatrix();
        final String preSetCell = matrix[row][column];
        final String expected = "SYMBOL";
        Assert.assertNotEquals(preSetCell, expected);

        // when
        board.setCellByIndex(index, expected);
        final String actual = matrix[row][column];

        // then
        Assert.assertEquals(expected, actual);
    }
}
