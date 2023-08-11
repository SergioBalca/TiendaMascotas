package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaTipoReptil extends PageObject {

    public static final Target BOTON_RETURN_TO_REPTILES = Target.the("boton Rattlesnake")
            .located(By.id("BackLink"));
}
