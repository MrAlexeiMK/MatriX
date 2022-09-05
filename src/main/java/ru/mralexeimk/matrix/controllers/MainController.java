package ru.mralexeimk.matrix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mralexeimk.matrix.enums.MatrixOperation;
import ru.mralexeimk.matrix.models.MatrixInfo;
import ru.mralexeimk.matrix.utils.MatrixUtils;

@Controller
public class MainController {
    @GetMapping()
    public String startPage(Model model) {
        model.addAttribute("matrixInfo", new MatrixInfo());
        return "index";
    }

    @PostMapping()
    public String startPage(@RequestParam(value = "operation", defaultValue = "NONE", required = false) String operation,
                            @ModelAttribute("matrixInfo") MatrixInfo matrixInfo) {
        if(matrixInfo != null) {
            matrixInfo.setMatrixOperation(MatrixOperation.getEnum(operation));
            matrixInfo.setMatrixResult(MatrixUtils.computeMatrixOperation(matrixInfo));
        }
        return "index";
    }
}
