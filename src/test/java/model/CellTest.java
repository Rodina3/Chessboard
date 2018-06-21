package model;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CellTest {

    @Test
    public void shouldCellBecomeDeadWhenItHasOneOrLessAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.ALIVE);

        cell.evolve(0);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));

        cell.evolve(1);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepAliveWhenItHasTwoOrThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(2);
        assertThat(cell.getCellStatus(), is(CellStatus.ALIVE));
        cell.evolve(3);
        assertThat(cell.getCellStatus(), is(CellStatus.ALIVE));
    }

    @Test
    public void shouldCellBecomeDeadWhenItHasFourOrMoreAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.ALIVE);

        cell.evolve(4);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));

        cell.evolve(5);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepDeadWhenItHasTwoOrLessAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.DEAD);

        cell.evolve(0);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));

        cell.evolve(1);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));

        cell.evolve(2);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellKeepDeadWhenItHasMoreThanThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.DEAD);

        cell.evolve(4);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));

        cell.evolve(5);
        assertThat(cell.getCellStatus(), is(CellStatus.DEAD));
    }

    @Test
    public void shouldCellBecomeAliveWhenItHasThreeAliveNeighbors() throws Exception {
        Cell cell = new Cell(CellStatus.DEAD);

        cell.evolve(3);
        assertThat(cell.getCellStatus(), is(CellStatus.ALIVE));
    }
}
