package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaInicial.BOTON_REPTILES;

public class ElegirReptiles implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_REPTILES)
        );
    }

    public static ElegirReptiles elegirReptiles(){
        return new ElegirReptiles();
    }
}
