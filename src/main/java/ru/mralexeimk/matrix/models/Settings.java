package ru.mralexeimk.matrix.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mralexeimk.matriximpl.enums.PaddingFill;

@Data
@AllArgsConstructor
public class Settings {
    private int convPaddingSizeX, convPaddingSizeY;
    private int convStridingSizeX, convStridingSizeY;
    private PaddingFill paddingFill;

    public Settings() {
        convPaddingSizeX = 0;
        convPaddingSizeY = 0;
        convStridingSizeX = 1;
        convStridingSizeY = 1;
        paddingFill = PaddingFill.BY_ZEROES;
    }
}
