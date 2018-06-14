package model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class NeighborAreaTest {

    @Test
    public void upperLeftPoint() throws Exception {
        NeighborArea neighborArea = new NeighborArea(new Position(1, 1), 3, 3);

        assertThat(neighborArea.getUpperBoundary(),is(1));
        assertThat(neighborArea.getLeftBoundary(),is(1));
        assertThat(neighborArea.getRightBoundary(),is(2));
        assertThat(neighborArea.getBottomBoundary(),is(2));
    }

    @Test
    public void centerPoint() throws Exception {
        NeighborArea neighborArea = new NeighborArea(new Position(2, 2), 3, 3);

        assertThat(neighborArea.getUpperBoundary(),is(1));
        assertThat(neighborArea.getLeftBoundary(),is(1));
        assertThat(neighborArea.getRightBoundary(),is(3));
        assertThat(neighborArea.getBottomBoundary(),is(3));
    }

    @Test
    public void bottomRightPoint() throws Exception {
        NeighborArea neighborArea = new NeighborArea(new Position(3, 3), 3, 3);

        assertThat(neighborArea.getUpperBoundary(),is(2));
        assertThat(neighborArea.getLeftBoundary(),is(2));
        assertThat(neighborArea.getRightBoundary(),is(3));
        assertThat(neighborArea.getBottomBoundary(),is(3));
    }
}