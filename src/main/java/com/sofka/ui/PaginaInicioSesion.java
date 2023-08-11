package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaInicioSesion extends PageObject {

    public static final Target USER_NAME = Target.the("nombre de usuario")
            .located(By.name("username"));

    public static final Target PASSWORD = Target.the("password")
            .located(By.name("password"));

    public static final Target BOTON_LOGIN = Target.the("boton login")
            .located(By.name("signon"));
}
