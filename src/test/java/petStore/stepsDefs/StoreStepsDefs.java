package petStore.stepsDefs;
import net.serenitybdd.rest.SerenityRest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import petStore.steps.StoreSteps;

public class StoreStepsDefs {
    @Steps
    StoreSteps storeSteps;

    //CREAR ORDEN
    // Este paso es una precondición, solo es para la verificación de disponibilidad del API
    @Given("que el API de PetStore está disponible")
    public void queElApiDePetStoreEstaDisponible() {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200);
    }

    @When("creo una orden con id {string}, petId {string}, quantity {string}, shipDate {string}, status {string}, complete {string}")
    public void creoUnaOrden(String id, String petId, String quantity, String shipDate, String status, String complete) {
        storeSteps.crearOrden(id, petId, quantity, shipDate, status, complete);
    }

    @Then("el código de respuesta para la tienda es {int}")
    public void elCodigoDeRespuestaParaTiendaEs(int statusCode) {
        storeSteps.validarCodigoRespuestaStore(statusCode);
    }

    @And("el estado de la orden es placed {string}")
    public void elEstadoDeLaOrdenEsPlaced(String status) {
        storeSteps.validarEstadoOrden(status);
    }

    // CONSULTAR ORDEN
    @When("deseo validar que la orden con id {string} existe")
    public void ValidoqueLaOrdenConIdExiste(String id) {
        storeSteps.consultarOrden(id);
    }

    @And("la orden tiene el id {string}")
    public void laOrdenTieneElId(String id) {
        storeSteps.validarIdOrden(id);
    }

    @And("la cantidad de la orden es {string}")
    public void laCantidadDeLaOrdenEs(String quantity) {
        storeSteps.validarCantidadOrden(quantity);
    }

    @When("elimino la orden con id {string}")
    public void eliminoLaOrdenConId(String id) {
        storeSteps.eliminarOrden(id);
    }

    // CONSULTAR ORDEN ESPERANDO 404 POST ELIMINACIÓN
    @Given("consulto la orden eliminada con id {string} no exista")
    public void consultoLaOrdenEliminadaConIdNoExista(String id) {
        storeSteps.consultarOrden(id);
        int statusCode = SerenityRest.lastResponse().statusCode();
        Assert.assertEquals("Se esperaba que el código de respuesta fuera 404, pero fue " + statusCode, 404, statusCode);
    }

}
