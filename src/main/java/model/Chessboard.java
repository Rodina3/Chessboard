package model;

import java.util.HashMap;
import java.util.Map;

public class Chessboard {
    private int length;
    private int width;

    private Map<Position, Cell> cells = new HashMap<>();

    public Chessboard(int length, int width, Map<Position, Cell> cells) {
        this.length = length;
        this.width = width;
        this.cells = cells;
    }

    public Chessboard(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void initChessboardWithAliveCells(Map<Position, Cell> aliveCells) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                Position pos = new Position(i, j);
                if (aliveCells.containsKey(pos)) {
                    cells.put(pos, new Cell(CellStatus.ALIVE));
                } else {
                    cells.put(pos, new Cell(CellStatus.DEAD));
                }
            }
        }
    }

    public int countAliveNeighbors(Position position) {
        NeighborArea neighborArea = new NeighborArea(position, length, width);
        int aliveNumbers = countAliveCellsWithinArea(neighborArea);
        return minusCellItself(position, aliveNumbers);
    }

    public Chessboard getNextChessBoard() {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                Position pos = new Position(i, j);
                Map<Position, Cell> oldChessboard = this.getCells();
                Cell cell = oldChessboard.get(pos);
                cell.evolve(countAliveNeighbors(pos));
                cells.put(pos, cell);
            }
        }
        return this;
    }

    public Cell getOneCell(Position position) {
        return this.cells.get(position);
    }


    private int minusCellItself(Position position, int aliveNumbers) {
        return getOneCell(position).getCellStatus() == CellStatus.ALIVE ? aliveNumbers - 1 : aliveNumbers;
    }

    private int countAliveCellsWithinArea(NeighborArea neighborArea) {
        int aliveNumbers = 0;
        for (int i = neighborArea.getLeftBoundary(); i <= neighborArea.getRightBoundary(); i++) {
            for (int j = neighborArea.getUpperBoundary(); j <= neighborArea.getBottomBoundary(); j++) {
                if (getOneCell(new Position(i, j)).getCellStatus() == CellStatus.ALIVE) {
                    aliveNumbers++;
                }
            }
        }
        return aliveNumbers;
    }

    public Map<Position, Cell> getCells() {
        return cells;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
