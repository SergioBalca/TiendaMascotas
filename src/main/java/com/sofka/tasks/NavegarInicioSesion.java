package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.ui.PaginaInicial.BOTON_INICIO_SESION;

public class NavegarInicioSesion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_INICIO_SESION)
        );
    }

    public static NavegarInicioSesion navegarInicioSesion(){
        return new NavegarInicioSesion();
    }
}
