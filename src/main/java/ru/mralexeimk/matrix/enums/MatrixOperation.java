package ru.mralexeimk.matrix.enums;

public enum MatrixOperation {
    NONE("None"),
    SUM("+"),
    DIFF("-"),
    MULTIPLY("x"),
    CONVOLUTION("Convolution"),
    DETERMINANT_A("Determinant A"),
    INVERSE_A("Inverse A"),
    TRANSPOSE_A("Transpose A"),
    LOWER_TRIANGULAR_A("Lower Triangular A"),
    UPPER_TRIANGULAR_A("Upper Triangular A"),
    DIAGONAL_FORM_A("Diagonal Form A"),
    DETERMINANT_B("Determinant B"),
    INVERSE_B("Inverse B"),
    TRANSPOSE_B("Transpose B"),
    LOWER_TRIANGULAR_B("Lower Triangular B"),
    UPPER_TRIANGULAR_B("Upper Triangular B"),
    DIAGONAL_FORM_B("Diagonal Form B");

    private final String operation;

    MatrixOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return this.getOperation();
    }

    public static MatrixOperation getEnum(String value) {
        for(MatrixOperation v : values())
            if(v.getOperation().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
