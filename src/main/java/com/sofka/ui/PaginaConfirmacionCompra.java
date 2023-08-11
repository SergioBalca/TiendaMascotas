package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaConfirmacionCompra extends PageObject {
    public static final Target MENSAJE_CONFIRMACION_COMPRA = Target.the("confirmacion compra")
            .located(By.xpath("//li[contains(text(),'Thank you, your order has been submitted.')]"));
}
