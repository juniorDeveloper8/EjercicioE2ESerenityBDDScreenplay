package com.nttdata.tasks;

import com.nttdata.pages.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenCartPage implements Task {

    public static Performable open() {
        return instrumented(OpenCartPage.class);
    }


    @Override
    @Step("{0} abre la página del carrito")
    public <T extends Actor> void performAs(T actor) {
        // Hacer clic en el botón del carrito
        actor.attemptsTo(
                WaitUntil.the(CartPage.CART_BTN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CartPage.CART_BTN)
        );

        // Esperar hasta que la tabla de productos sea visible
        actor.attemptsTo(
                WaitUntil.the(CartPage.PRODUCT_TABLE_BODY, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}