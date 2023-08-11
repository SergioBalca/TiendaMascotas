package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.CarritoCompra.BOTON_CHECKOUT;
import static com.sofka.ui.PaginaDetallePago.BOTON_CONTINUE;
import static com.sofka.ui.PaginaGolden.BOTON_ADD_TO_CART;
import static com.sofka.ui.PaginaInicial.BOTON_PERROS;
import static com.sofka.ui.PaginaOrdenCompra.BOTON_CONFIRM;
import static com.sofka.ui.PaginaPerros.GOLDEN_RETREIVER;

public class ComprarGolden implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_PERROS),
                Click.on(GOLDEN_RETREIVER),
                Click.on(BOTON_ADD_TO_CART),
                Click.on(BOTON_CHECKOUT),
                Click.on(BOTON_CONTINUE),
                Click.on(BOTON_CONFIRM)
        );
    }

    public static ComprarGolden comprarGolden(){
        return new ComprarGolden();
    }
}
