package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaReptiles.BOTON_IGUANA;
import static com.sofka.ui.PaginaTipoReptil.BOTON_RETURN_TO_REPTILES;

public class ElegirIguana implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_IGUANA)
        );
    }

    public static ElegirIguana elegirIguana(){
        return new ElegirIguana();
    }
}
