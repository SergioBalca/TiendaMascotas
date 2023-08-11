package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Pause;

import static com.sofka.ui.PaginaReptiles.BOTON_RATTLESNAKE;
import static com.sofka.ui.PaginaTipoReptil.BOTON_RETURN_TO_REPTILES;

public class ElegirRattleSnake implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Click.on(BOTON_RATTLESNAKE),
                    Click.on(BOTON_RETURN_TO_REPTILES)

            );
    }

    public static ElegirRattleSnake elegirRattleSnake(){
        return new ElegirRattleSnake();
    }
}
