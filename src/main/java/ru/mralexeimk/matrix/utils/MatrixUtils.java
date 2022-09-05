package ru.mralexeimk.matrix.utils;

import ru.mralexeimk.matrix.enums.MatrixOperation;
import ru.mralexeimk.matrix.models.MatrixInfo;
import ru.mralexeimk.matrix.models.Settings;
import ru.mralexeimk.matriximpl.models.Matrix;
import ru.mralexeimk.matriximpl.models.MatrixExtractor;
import ru.mralexeimk.matriximpl.other.Constants;

public class MatrixUtils {
    public static String fixMatrixForm(String m) {
        StringBuilder res = new StringBuilder();
        String[] spl = m.split("\n");
        if(spl.length == 1) return m;
        for(int i = 1; i < spl.length; ++i) {
            res.append(spl[i].strip()).append(i < spl.length - 1 ? "\n" : "");
        }
        return res.toString().replaceAll(" ", ",");
    }

    public static String computeMatrixOperation(MatrixInfo matrixInfo) {
        String res = "";
        Matrix A = Constants.IDENTITY_3D, B = Constants.IDENTITY_3D;
        boolean c1 = !matrixInfo.getMatrixA().equals(""), c2 = !matrixInfo.getMatrixB().equals("");
        if(c1) {
            try {
                A = MatrixExtractor.getMatrixFromExpression(matrixInfo.getMatrixA(), "\n", ",");
            } catch (Exception ignored) {
                c1 = false;
            }
        }
        if(c2) {
            try {
                B = MatrixExtractor.getMatrixFromExpression(matrixInfo.getMatrixB(), "\n", ",");
            } catch (Exception ignored) {
                c2 = false;
            }
        }
        Settings s = matrixInfo.getSettings();

        try {
            if (c1 && c2) {
                switch (matrixInfo.getMatrixOperation()) {
                    case SUM -> res = MatrixExtractor.getSum(A, B).toString();
                    case DIFF -> res = MatrixExtractor.getDiff(A, B).toString();
                    case MULTIPLY -> res = MatrixExtractor.getMultiply(A, B).toString();
                    case CONVOLUTION -> res = MatrixExtractor.getConvertByKernel(A, B,
                            s.getConvPaddingSizeX(), s.getConvPaddingSizeY(), s.getPaddingFill(),
                            s.getConvStridingSizeX(), s.getConvStridingSizeY()).toString();
                }
            }

            if (c1) {
                switch (matrixInfo.getMatrixOperation()) {
                    case DETERMINANT_A -> res = String.valueOf(A.getDeterminant());
                    case TRANSPOSE_A -> res = A.getTransposed().toString();
                    case INVERSE_A -> res = A.getInverse().toString();
                    case LOWER_TRIANGULAR_A -> {
                        A.toTriangularDown();
                        res = A.toString();
                    }
                    case UPPER_TRIANGULAR_A -> {
                        A.toTriangularUp();
                        res = A.toString();
                    }
                    case DIAGONAL_FORM_A -> {
                        A.toUnit();
                        res = A.toString();
                    }
                }
            }

            if (c2) {
                switch (matrixInfo.getMatrixOperation()) {
                    case DETERMINANT_B -> res = String.valueOf(B.getDeterminant());
                    case TRANSPOSE_B -> res = B.getTransposed().toString();
                    case INVERSE_B -> res = B.getInverse().toString();
                    case LOWER_TRIANGULAR_B -> {
                        B.toTriangularDown();
                        res = B.toString();
                    }
                    case UPPER_TRIANGULAR_B -> {
                        B.toTriangularUp();
                        res = B.toString();
                    }
                    case DIAGONAL_FORM_B -> {
                        B.toUnit();
                        res = B.toString();
                    }
                }
            }
        } catch (Exception ignored) {
            return res;
        }
        return fixMatrixForm(res);
    }
}
