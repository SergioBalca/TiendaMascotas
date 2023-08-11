package com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sofka.ui.PaginaInicioSesion.*;

public class IniciarSesion  implements Task {

    private String usuario;
    private String password;

    public IniciarSesion conElUsuario(String usuario){
        this.usuario=usuario;
        return this;
    }

    public IniciarSesion yConElPassword(String password){
        this.password=password;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(USER_NAME),
                Enter.theValue(usuario).into(USER_NAME),
                Enter.theValue(password).into(PASSWORD),
                Click.on(BOTON_LOGIN)
        );
    }

    public static IniciarSesion iniciarSesion(){
        return new IniciarSesion();
    }
}
