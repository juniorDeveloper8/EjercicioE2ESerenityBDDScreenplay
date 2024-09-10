package com.nttdata.stepDef;

import com.nttdata.tasks.*;
import com.nttdata.util.JsonUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyItemsStepDef {
    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^el (.*) esta en la pagina de demoblaze$")
    public void elUsuarioEstaEnLaPaginaDeDemoblaze(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.demoblazePage()
        );
    }

    @When("escojo productos para el carro")
    public void escojoProductosParaElCarro() {
        theActorInTheSpotlight().attemptsTo(
                AddCart.shoping()
        );
    }


    @And("verifica la compra de los articulos")
    public void verificaLaCompraDeLosArticulos() {
        theActorInTheSpotlight().attemptsTo(
                OpenCartPage.open(),
                ValidateCart.forProduct("Nokia lumia 1520", "820"),
                ValidateCart.forProduct("Samsung galaxy s6", "360")
        );

    }

    @Then("llena el formulario de copra con los siguientes datos:")
    public void llenaElFormularioDeCopraConLosSiguientesDatos() throws IOException {
        String filePath = "src/test/resources/template/form-data.json";
        Map<String, String> data = JsonUtil.getFormDataFromJson(filePath);
        theActorInTheSpotlight().attemptsTo(
                Form.withData(data)
        );

    }
}
