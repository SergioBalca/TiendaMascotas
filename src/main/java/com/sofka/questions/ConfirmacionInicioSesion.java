package com.sofka.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.PaginaInicial.BOTON_SIGNOUT;

public class ConfirmacionInicioSesion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BOTON_SIGNOUT.resolveFor(actor).getText();
    }

    public static ConfirmacionInicioSesion confirmacionInicioSesion(){
        return new ConfirmacionInicioSesion();
    }
}
