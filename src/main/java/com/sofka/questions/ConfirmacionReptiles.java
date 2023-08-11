package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.PaginaReptiles.MENSAJE_REPTILES;

public class ConfirmacionReptiles implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_REPTILES.resolveFor(actor).getText();
    }

    public static ConfirmacionReptiles confirmacionReptiles(){
        return new ConfirmacionReptiles();
    }
}
