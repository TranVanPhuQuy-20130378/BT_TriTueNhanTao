package BTTH6.student;


public class Queen {
    private int row;
    private int column;

    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Move the queen to a new position
    public void move(int newRow, int newColumn) {
        this.row = newRow;
        this.column = newColumn;
    }

    // Check whether this Queen can attack the given Queen (q)
    public boolean isConflict(Queen q) {
        return this.row == q.row || this.column == q.column || Math.abs(this.row - q.row) == Math.abs(this.column - q.column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
