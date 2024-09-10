package petStore.stepsDefs;

import net.serenitybdd.rest.SerenityRest;
import petStore.steps.MascotaSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class MascotaStepsDefs {

    @Steps
    MascotaSteps mascotaSteps;

    //Steps definition para el POST CREAR MASCOTA
    @When("creo la mascota con id {string}, name {string}, status {string}")
    public void crearMascota(String id, String name, String status) {
        mascotaSteps.crearMascota(id, name, status);
    }

    @Then("el código de respuesta para la mascota es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        mascotaSteps.validarCodigoRespuesta(statusCode);
    }

    @And("valido que el nombre de la mascota es {string}")
    public void elNombreDeLaMascotaEs(String name) {
        mascotaSteps.validarNombreMascota(name);
    }

    //Steps para el GET CONSULTA MASCOTA
    @Given("consulto la mascota con id {string}")
    public void consultoMascota(String id) {
        Assert.assertTrue("No existe mascota", mascotaSteps.consultoMascota(id));
    }

    //Steps para el PUT AZTUALIZAR MASCOTA
    @When("actualizo la mascota con id {string} con nuevo nombre {string}")
    public void actualizoMascota(String id, String nuevoNombre) {
        mascotaSteps.actualizoNombreMascota(id, nuevoNombre);
    }

    @When("elimino la mascota con id {string}")
    public void eliminoMascota(String id) {
        mascotaSteps.eliminarMascota(id);
    }

    @Given("consulto la mascota eliminada con id {string}")
    public void consultoLaMascotaEliminadaConId(String id) {
        mascotaSteps.consultoMascota(id);
        int statusCode = SerenityRest.lastResponse().statusCode();
        Assert.assertEquals("Se esperaba que el código de respuesta fuera 404, pero fue " + statusCode, 404, statusCode);
    }

}