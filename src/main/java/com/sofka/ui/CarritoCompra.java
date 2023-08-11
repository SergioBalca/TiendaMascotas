package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CarritoCompra extends PageObject {

    public static final Target BOTON_CHECKOUT = Target.the("Boton checkout")
            .located(By.xpath("//a[contains(text(),'Proceed to Checkout')]"));

    public static final Target BOTON_REMOVE = Target.the("boton remove")
            .located(By.xpath("//a[contains(text(),'Remove')]"));

    public static final Target CARRITO_VACIO = Target.the("carrito vacio")
            .located(By.xpath("//b[contains(text(),'Your cart is empty.')]"));
}
