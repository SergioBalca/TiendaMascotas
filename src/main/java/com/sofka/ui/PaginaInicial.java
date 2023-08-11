package com.sofka.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PaginaInicial extends PageObject {
    public static final Target BOTON_REPTILES = Target.the("boton reptiles")
            .located(By.xpath("//img[@src='../images/reptiles_icon.gif']"));

    public static final Target BOTON_INICIO_SESION = Target.the("boton inicio sesion")
            .located(By.xpath("//a[contains(text(),'Sign In')]"));

    public static final Target BOTON_SIGNOUT = Target.the("boton cerrar sesion")
            .located(By.xpath("//a[contains(text(),'Sign Out')]"));

    public static final Target BOTON_PERROS = Target.the("boton perros")
            .located(By.xpath("//img[@src=\"../images/dogs_icon.gif\"]"));
}
