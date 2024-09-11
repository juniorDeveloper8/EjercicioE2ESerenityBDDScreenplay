package com.nttdata.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CART_BTN = Target.the("carrito de compra")
            .located(By.id("cartur"));

    public static final Target BUY_BTN = Target.the("boton de compra")
            .locatedBy("#");

    public static final Target PRODUCT_TABLE_BODY = Target.the("tabla de productos")
            .located(By.id("tbodyid"));

}
