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
        int leftBoundary = getLeftBoundary(position);
        int rightBoundary = getRightBoundary(position);
        int upperBoundary = getUpperBoundary(position);
        int bottomBoundary = getBottomBoundary(position);

        int aliveNumbers = countAliveNumbers(leftBoundary, rightBoundary, upperBoundary, bottomBoundary);
        return minusCellItself(position, aliveNumbers);
    }

    public Chessboard getNextChessBoard() {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                Position position = new Position(i, j);
                Cell oldCell = getCell(position);
                Cell newCell = new Cell(oldCell.getNextStatus(getAliveNeighborNumber(position)));
                cells.put(position, newCell);
            }
        }
        return this;
    }

    private Cell getCell(Position position) {
        return this.cells.get(position);
    }

    private int getBottomBoundary(Position position) {
        return position.getY() + 1 > width ? width : position.getY() + 1;
    }

    private int getUpperBoundary(Position position) {
        return position.getY() - 1 == 0 ? 1 : position.getY() - 1;
    }

    private int getRightBoundary(Position position) {
        return position.getX() + 1 > length ? length : position.getX() + 1;
    }

    private int getLeftBoundary(Position position) {
        return position.getX() - 1 == 0 ? 1 : position.getX() - 1;
    }

    private int minusCellItself(Position position, int aliveNumbers) {
        return getCell(position).getCellStatus() == CellStatus.ALIVE ? aliveNumbers - 1 : aliveNumbers;
    }

    private int countAliveNumbers(int leftBoundary, int rightBoundary, int upperBoundary, int bottomBoundary) {
        int aliveNumbers = 0;
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            aliveNumbers = aliveNumbers + countEachRow(upperBoundary, bottomBoundary, i);
        }
        return aliveNumbers;
    }

    private int countEachRow(int upperBoundary, int bottomBoundary, int i) {
        int aliveNumbers = 0;
        for (int j = upperBoundary; j <= bottomBoundary; j++) {
            if (getCell(new Position(i, j)).getCellStatus() == CellStatus.ALIVE) {
                aliveNumbers++;
            }
        }
        return aliveNumbers;
    }

    public Map<Position, Cell> getCells() {
        return cells;
    }
}
