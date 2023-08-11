package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaOrdenCompra extends PageObject {
    public static final Target BOTON_CONFIRM = Target.the("Boton confirm")
            .located(By.xpath("//a[contains(text(),'Confirm')]"));

}
