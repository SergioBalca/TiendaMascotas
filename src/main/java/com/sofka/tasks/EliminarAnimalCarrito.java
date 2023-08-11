package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.CarritoCompra.BOTON_REMOVE;

public class EliminarAnimalCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_REMOVE)
        );
    }

    public static EliminarAnimalCarrito eliminarAnimalCarrito(){
        return new EliminarAnimalCarrito();
    }
}
