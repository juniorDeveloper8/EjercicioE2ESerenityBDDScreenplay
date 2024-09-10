package com.nttdata.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import com.nttdata.pages.HomePage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AddCart implements Task {

    public static Performable shoping() {
        return instrumented(AddCart.class);
    }

    @Override
    @Step("{0} agrega un artículo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // articulo uno
                WaitUntil.the(HomePage.ARTICULO_UNO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ARTICULO_UNO),
                WaitUntil.the(HomePage.ADD_TO_CART_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ADD_TO_CART_BUTTON), // despues de esto sale la notificaion
                new AcceptAlert(),
                Click.on(HomePage.HOME_BTN),

                //articulo dos
                WaitUntil.the(HomePage.ARTICULO_DOS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ARTICULO_DOS),
                WaitUntil.the(HomePage.ADD_TO_CART_BUTTON_2, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ADD_TO_CART_BUTTON_2), // despues de esto sale la notificaion
                new AcceptAlert(),
                Click.on(HomePage.HOME_BTN)

        );
    }

}

