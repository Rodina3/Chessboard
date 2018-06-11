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

    public int getAliveNeighborNumber(Position position) {
        int leftBoundary = position.getX() - 1 == 0 ? 1 : position.getX() - 1;
        int rightBoundary = position.getX() + 1 > length ? length : position.getX() + 1;
        int upperBoundary = position.getY() - 1 == 0 ? 1 : position.getY() - 1;
        int bottomBoundary = position.getY() + 1 > width ? width : position.getY() + 1;

        int aliveNeighborCount = 0;
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            for (int j = upperBoundary; j <= bottomBoundary; j++) {
                if (cells.get(new Position(i, j)).getCellStatus() == CellStatus.ALIVE) {
                    aliveNeighborCount++;
                }
            }
        }
        return cells.get(position).getCellStatus() == CellStatus.ALIVE ? aliveNeighborCount - 1 : aliveNeighborCount;
    }

    public Chessboard getNextChessBoard() {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                Position position = new Position(i, j);
                Cell cell = this.cells.get(position);
                cells.put(position, new Cell(cell.getNextStatus(getAliveNeighborNumber(position))));
            }
        }
        return this;
    }

    public Map<Position, Cell> getCells() {
        return cells;
    }
}
