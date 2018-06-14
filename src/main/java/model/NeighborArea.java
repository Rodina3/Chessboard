package model;

public class NeighborArea {
    private int upperBoundary;
    private int bottomBoundary;
    private int leftBoundary;
    private int rightBoundary;

    public NeighborArea(Position centerPoint, int length, int width) {
        this.leftBoundary = calculateLeftBoundary(centerPoint);
        this.rightBoundary = calculateRightBoundary(centerPoint, length);
        this.upperBoundary = calculateUpperBoundary(centerPoint);
        this.bottomBoundary = calculateBottomBoundary(centerPoint, width);
    }

    private int calculateBottomBoundary(Position position, int width) {
        return position.getY() + 1 > width ? width : position.getY() + 1;
    }

    private int calculateUpperBoundary(Position position) {
        return position.getY() - 1 == 0 ? 1 : position.getY() - 1;
    }

    private int calculateRightBoundary(Position position, int length) {
        return position.getX() + 1 > length ? length : position.getX() + 1;
    }
    private int calculateLeftBoundary(Position position) {
        return position.getX() - 1 == 0 ? 1 : position.getX() - 1;
    }

    public int getUpperBoundary() {
        return upperBoundary;
    }

    public int getBottomBoundary() {
        return bottomBoundary;
    }

    public int getLeftBoundary() {
        return leftBoundary;
    }

    public int getRightBoundary() {
        return rightBoundary;
    }
}
