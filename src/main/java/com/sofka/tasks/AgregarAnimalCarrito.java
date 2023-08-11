package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaGolden.BOTON_ADD_TO_CART;

public class AgregarAnimalCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_ADD_TO_CART)
        );
    }

    public static AgregarAnimalCarrito agregarAnimalCarrito(){
        return new AgregarAnimalCarrito();
    }
}
