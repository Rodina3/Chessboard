package model;

public class Cell {
    private CellStatus cellStatus;

    public Cell(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }


    public Cell evolve(int aliveNeighbors) {
        return cellStatus == CellStatus.ALIVE ? aliveCellEvolve(aliveNeighbors) : deadCellEvolve(aliveNeighbors);
    }

    private Cell deadCellEvolve(int aliveNeighbors) {
        if (aliveNeighbors == 3) {
            this.cellStatus = CellStatus.ALIVE;
        }
        return this;
    }

    private Cell aliveCellEvolve(int aliveNeighbors) {
        if (aliveNeighbors > 3 || aliveNeighbors < 2) {
            this.cellStatus = CellStatus.DEAD;
        }
        return this;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }
}
