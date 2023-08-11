package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.PaginaConfirmacionCompra.MENSAJE_CONFIRMACION_COMPRA;

public class ConfirmacionCompra implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_CONFIRMACION_COMPRA.resolveFor(actor).getText();
    }

    public static ConfirmacionCompra confirmacionCompra(){
        return new ConfirmacionCompra();
    }
}
