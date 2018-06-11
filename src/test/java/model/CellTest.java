package model;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CellTest {

    private Position position;

    @Before
    public void setUp() throws Exception {
        position = new Position(1, 1);
    }

    @Test
    public void shouldCellBecomeDeadWhenItHasOneOrLessAliveNeighbors() throws Exception {
        Cell cell = new Cell(position, CellStatus.ALIVE);

        assertThat(cell.getNextStatus(0), is(CellStatus.DEAD));
        assertThat(cell.getNextStatus(1), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepAliveWhenItHasTwoOrThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(position, CellStatus.ALIVE);

        assertThat(cell.getNextStatus(2), is(CellStatus.ALIVE));
        assertThat(cell.getNextStatus(3), is(CellStatus.ALIVE));
    }

    @Test
    public void shouldCellBecomeDeadWhenItHasFourOrMoreAliveNeighbors() throws Exception {
        Cell cell = new Cell(position, CellStatus.ALIVE);

        assertThat(cell.getNextStatus(4), is(CellStatus.DEAD));
        assertThat(cell.getNextStatus(5), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepDeadWhenItHasTwoOrLessAliveNeighbors() throws Exception {
        Cell cell = new Cell(position, CellStatus.DEAD);

        assertThat(cell.getNextStatus(0), is(CellStatus.DEAD));
        assertThat(cell.getNextStatus(1), is(CellStatus.DEAD));
        assertThat(cell.getNextStatus(2), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepDeadWhenItHasMoreThanThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(position, CellStatus.DEAD);

        assertThat(cell.getNextStatus(4), is(CellStatus.DEAD));
        assertThat(cell.getNextStatus(5), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellBecomeAliveWhenItHasThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(position, CellStatus.DEAD);

        assertThat(cell.getNextStatus(3), is(CellStatus.ALIVE));
    }
}
