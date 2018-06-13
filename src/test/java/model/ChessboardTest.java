package model;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessboardTest {
    private Chessboard chessboard;

    @Before
    public void setUp() throws Exception {
        Map<Position, Cell> aliveCells = new HashMap<>();

        aliveCells.put(new Position(2, 1), new Cell(CellStatus.ALIVE));
        aliveCells.put(new Position(2, 2), new Cell(CellStatus.ALIVE));
        aliveCells.put(new Position(3, 2), new Cell(CellStatus.ALIVE));
        chessboard = new Chessboard(3, 3);
        chessboard.initChessboard(aliveCells);
    }

    @Test
    public void shouldCellP11GetTwoAliveNeighbors() throws Exception {
        assertThat(chessboard.countAliveNeighbors(new Position(1, 1)), is(2));
    }

    @Test
    public void shouldCellP13GetOneAliveNeighbors() throws Exception {
        assertThat(chessboard.countAliveNeighbors(new Position(1, 3)), is(1));
    }

    @Test
    public void shouldCellP31GetThreeAliveNeighbors() throws Exception {
        assertThat(chessboard.countAliveNeighbors(new Position(3, 1)), is(3));
    }

    @Test
    public void shouldCellP33GetOneAliveNeighbors() throws Exception {
        assertThat(chessboard.countAliveNeighbors(new Position(3, 3)), is(2));
    }

    @Test
    public void shouldCellP22GetTwoAliveNeighbors() throws Exception {
        assertThat(chessboard.countAliveNeighbors(new Position(2, 2)), is(2));
    }

    @Test
    public void shouldChessBoardGetNext() throws Exception {
        Chessboard nextChessBoard = chessboard.getNextChessBoard();

        Map<Position, Cell> cells = nextChessBoard.getCells();
        assertThat(cells.get(new Position(1,1)).getCellStatus(),is(CellStatus.DEAD));
        assertThat(cells.get(new Position(2,1)).getCellStatus(),is(CellStatus.ALIVE));
        assertThat(cells.get(new Position(3,1)).getCellStatus(),is(CellStatus.ALIVE));
        assertThat(cells.get(new Position(3,2)).getCellStatus(),is(CellStatus.ALIVE));
        assertThat(cells.get(new Position(3,3)).getCellStatus(),is(CellStatus.DEAD));
    }
}