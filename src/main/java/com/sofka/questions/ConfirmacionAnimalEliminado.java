package com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofka.ui.CarritoCompra.CARRITO_VACIO;

public class ConfirmacionAnimalEliminado implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return CARRITO_VACIO.resolveFor(actor).getText();
    }

    public static ConfirmacionAnimalEliminado confirmacionAnimalEliminado(){
        return new ConfirmacionAnimalEliminado();
    }
}
