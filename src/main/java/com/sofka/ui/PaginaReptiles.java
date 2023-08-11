package com.sofka.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PaginaReptiles extends PageObject {
    public static final Target BOTON_RATTLESNAKE = Target.the("tipo Rattlesnake")
            .located(By.xpath("//a[contains(text(),'RP-SN-01')]"));

    public static final Target BOTON_IGUANA = Target.the("tipo Iguana")
            .located(By.xpath("//a[contains(text(),'RP-LI-02')]"));

    public static final Target MENSAJE_REPTILES = Target.the("Mensaje Reptiles")
            .located(By.xpath("//h2[contains(text(),'Iguana')]"));
}
