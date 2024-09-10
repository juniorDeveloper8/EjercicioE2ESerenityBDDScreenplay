package com.nttdata.tasks;

import com.nttdata.pages.FormularioModal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Form implements Task {
    private final String name;
    private final String country;
    private final String city;
    private final String creditCard;
    private final String month;
    private final String year;

    public Form(String name, String country, String city, String creditCard, String month, String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.creditCard = creditCard;
        this.month = month;
        this.year = year;
    }

    public static Performable withData(Map<String, String> data) {
        return instrumented(Form.class,
                data.get("Name"),
                data.get("Country"),
                data.get("City"),
                data.get("CreditCard"),
                data.get("Month"),
                data.get("Year")
        );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(FormularioModal.OPEN_FORM),
                WaitUntil.the(FormularioModal.INPUT_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(FormularioModal.INPUT_NAME),
                WaitUntil.the(FormularioModal.INPUT_COUNTRY, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(country).into(FormularioModal.INPUT_COUNTRY),
                WaitUntil.the(FormularioModal.INPUT_CITY, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(city).into(FormularioModal.INPUT_CITY),
                WaitUntil.the(FormularioModal.INPUT_CREDIT_CARD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(creditCard).into(FormularioModal.INPUT_CREDIT_CARD),
                WaitUntil.the(FormularioModal.INPUT_MONTH, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(month).into(FormularioModal.INPUT_MONTH),
                WaitUntil.the(FormularioModal.INPUT_YEAR, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(year).into(FormularioModal.INPUT_YEAR),

                Click.on(FormularioModal.BUY),
                WaitUntil.the(FormularioModal.OK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(FormularioModal.OK)
        );
    }
}
