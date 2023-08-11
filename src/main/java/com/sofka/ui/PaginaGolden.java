package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaGolden extends PageObject {

    public static final Target BOTON_ADD_TO_CART = Target.the("Boton agregar a carrito compras")
            .located(By.xpath("//a[contains(text(),'Add to Cart')]"));
}
