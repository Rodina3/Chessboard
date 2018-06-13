package model;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CellTest {

    @Test
    public void shouldCellBecomeDeadWhenItHasOneOrLessAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.ALIVE);

        assertThat(cell.evolve(0).getCellStatus(), is(CellStatus.DEAD));
        assertThat(cell.evolve(1).getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepAliveWhenItHasTwoOrThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.ALIVE);

        assertThat(cell.evolve(2).getCellStatus(), is(CellStatus.ALIVE));
        assertThat(cell.evolve(3).getCellStatus(), is(CellStatus.ALIVE));
    }

    @Test
    public void shouldCellBecomeDeadWhenItHasFourOrMoreAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.ALIVE);

        assertThat(cell.evolve(4).getCellStatus(), is(CellStatus.DEAD));
        assertThat(cell.evolve(5).getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepDeadWhenItHasTwoOrLessAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.DEAD);

        assertThat(cell.evolve(0).getCellStatus(), is(CellStatus.DEAD));
        assertThat(cell.evolve(1).getCellStatus(), is(CellStatus.DEAD));
        assertThat(cell.evolve(2).getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepDeadWhenItHasMoreThanThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.DEAD);

        assertThat(cell.evolve(4).getCellStatus(), is(CellStatus.DEAD));
        assertThat(cell.evolve(5).getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellBecomeAliveWhenItHasThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.DEAD);

        assertThat(cell.evolve(3).getCellStatus(), is(CellStatus.ALIVE));
    }
}
