package model;

public class Cell {
    private CellStatus cellStatus;

    public Cell(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }


    public void evolve(int aliveNeighbors) {
        if (this.cellStatus == CellStatus.ALIVE) {
            aliveCellEvolve(aliveNeighbors);
        } else {
            deadCellEvolve(aliveNeighbors);
        }
    }

    private void deadCellEvolve(int aliveNeighbors) {
        if (aliveNeighbors == 3) {
            this.cellStatus = CellStatus.ALIVE;
        }
    }

    private void aliveCellEvolve(int aliveNeighbors) {
        if (aliveNeighbors > 3 || aliveNeighbors < 2) {
            this.cellStatus = CellStatus.DEAD;
        }
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }
}
