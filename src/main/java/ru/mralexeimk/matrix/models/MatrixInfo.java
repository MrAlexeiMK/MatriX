package ru.mralexeimk.matrix.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import ru.mralexeimk.matrix.enums.MatrixOperation;

@AllArgsConstructor
@Data
public class MatrixInfo {
    private String matrixA;
    private String matrixB;
    private String matrixResult;
    private MatrixOperation matrixOperation;
    private Settings settings;

    public MatrixInfo() {
        matrixA = "";
        matrixB = "";
        matrixResult = "";
        matrixOperation = MatrixOperation.NONE;
        settings = new Settings();
    }
}
