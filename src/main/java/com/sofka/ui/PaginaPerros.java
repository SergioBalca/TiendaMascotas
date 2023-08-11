package com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaPerros extends PageObject {

    public static final Target GOLDEN_RETREIVER = Target.the("Boton golden")
            .located(By.xpath("//a[contains(text(),'K9-RT-01')]"));
}
