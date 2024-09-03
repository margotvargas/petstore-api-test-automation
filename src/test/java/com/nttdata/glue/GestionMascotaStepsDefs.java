package com.nttdata.glue;

import com.nttdata.steps.GestionMascota;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class GestionMascotaStepsDefs {

    @Steps
    GestionMascota gestionMascota;

    //Steps definition para el POST CREAR MASCOTA
    @When("creo la mascota con id {string}, name {string}, status {string}")
    public void crearMascota(String id, String name, String status) {
        gestionMascota.crearMascota(id, name, status);
    }

    @Then("el código de respuesta para la mascota es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        gestionMascota.validarCodigoRespuesta(statusCode);
    }

    @And("el nombre de la mascota es {string}")
    public void elNombreDeLaMascotaEs(String name) {
        gestionMascota.validarNombreMascota(name);
    }


    //Steps para el GET CONSULTA MASCOTA
    @Given("consulto la mascota con id {string}")
    public void consultoMascota(String id) {
        Assert.assertTrue("No existe mascota", gestionMascota.consultoMascota(id));
    }

    //Steps para el PUT AZTUALIZAR MASCOTA
    @When("actualizo la mascota con id {string} con nuevo nombre {string}")
    public void actualizoMascota(String id, String nuevoNombre) {
        gestionMascota.actualizoNombreMascota(id, nuevoNombre);
    }


    @When("elimino la mascota con id {string}")
    public void eliminoMascota(String id) {
        gestionMascota.eliminarMascota(id);
    }
}