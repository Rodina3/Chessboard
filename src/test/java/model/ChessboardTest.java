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
        Map<Position, Cell> cells = new HashMap<>();

        cells.put(new Position(1, 1), new Cell(CellStatus.DEAD));
        cells.put(new Position(1, 2), new Cell(CellStatus.DEAD));
        cells.put(new Position(1, 3), new Cell(CellStatus.DEAD));
        cells.put(new Position(2, 1), new Cell(CellStatus.ALIVE));
        cells.put(new Position(2, 2), new Cell(CellStatus.ALIVE));
        cells.put(new Position(2, 3), new Cell(CellStatus.DEAD));
        cells.put(new Position(3, 1), new Cell(CellStatus.DEAD));
        cells.put(new Position(3, 2), new Cell(CellStatus.ALIVE));
        cells.put(new Position(3, 3), new Cell(CellStatus.DEAD));
        chessboard = new Chessboard(3, 3, cells);
    }

    @Test
    public void shouldCellP11GetTwoAliveNeighbors() throws Exception {
        assertThat(chessboard.getAliveNeighborNumber(new Position(1, 1)), is(2));
    }

    @Test
    public void shouldCellP13GetOneAliveNeighbors() throws Exception {
        assertThat(chessboard.getAliveNeighborNumber(new Position(1, 3)), is(1));
    }

    @Test
    public void shouldCellP31GetThreeAliveNeighbors() throws Exception {
        assertThat(chessboard.getAliveNeighborNumber(new Position(3, 1)), is(3));
    }

    @Test
    public void shouldCellP33GetOneAliveNeighbors() throws Exception {
        assertThat(chessboard.getAliveNeighborNumber(new Position(3, 3)), is(2));
    }

    @Test
    public void shouldCllP22GetTwoAliveNeighbors() throws Exception {
        assertThat(chessboard.getAliveNeighborNumber(new Position(2, 2)), is(2));
    }
}