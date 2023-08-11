package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaDetallePago extends PageObject {
    public static final Target BOTON_CONTINUE = Target.the("Boton continue")
            .located(By.name("newOrder"));
}
