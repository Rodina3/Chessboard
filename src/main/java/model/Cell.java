package model;

public class Cell {
    private CellStatus cellStatus;

    public Cell(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }


    public CellStatus getNextStatus(int aliveNeighbors) {
        if (cellStatus == CellStatus.ALIVE) {
            if (aliveNeighbors > 3 || aliveNeighbors < 2) {
                return CellStatus.DEAD;
            }
        } else {
            if (aliveNeighbors == 3) {
                return CellStatus.ALIVE;
            }
        }
        return cellStatus;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }
}
