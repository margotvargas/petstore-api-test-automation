package com.nttdata.glue;

import com.nttdata.steps.GestionUsuario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class GestionUsuarioStepsDefs {

    @Steps
    GestionUsuario gestionUsuario;
    //CREAR USUARIO
    @When("creo el usuario con username {string}, firstname {string}, lastname {string}")
    public void crearUsuario(String username, String firstName, String lastName) {
        gestionUsuario.crearUsuario(username, firstName, lastName);
    }

    //CONSULTAR USUARIO
    @Given("consulto el usuario con nombre {string}")
    public void consultoElUsuarioConNombre(String username) {
        Assert.assertTrue("No existe usuario", gestionUsuario.consultoUsuario(username));
    }

    //ACTUALIZAR USUARIO
    @When("actualizo el usuario {string} con nuevo username {string}")
    public void actualizoElUsuarioConNuevoUsername(String usernameOld, String usernameNew) {
        gestionUsuario.actualizoUserName(usernameOld, usernameNew);
    }

    //ELIMINAR USUARIO
    @When("elimino el usuario con nombre {string}")
    public void eliminoElUsuarioConNombre(String username) {
        gestionUsuario.eliminarUsuario(username);
    }

    //CREAR USUARIOS MASIVOS
    @When("creo el usuario con username {string}, firstname {string}, lastname {string}, email {string}, password {string}, phone {string}, userStatus {string}")
    public void creoElUsuarioConUsernameFirstnameLastnameEmailPasswordPhoneUserStatus(String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        gestionUsuario.crearUsuariomasivo(username, firstName, lastName, email, password, phone, userStatus);
    }

    //METODO DE VALIDACION DE CODIGO ESPERADO REUTILIZADO EN TODOSS LOS CASOS
    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        gestionUsuario.validarCodigoRespuesta(statusCode);
    }

    //METODO DE VALIDACION DE DEL TYPE PARA EL CASO DE CREACION DE USUARIO
    @And("el type es {string}")
    public void elTypeEs(String type) {
        gestionUsuario.validarType(type);
    }

    @When("actualizo el usuario {string} con nuevo username {string}, firstname {string}, lastname {string}, email {string}, password {string}, phone {string}, userStatus {string}")
    public void actualizoElUsuarioConNuevoUsernameFirstnameLastnameEmailPasswordPhoneUserStatus(String oldUsername, String newUsername, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        gestionUsuario.actualizarUsuarioMasivo(oldUsername, newUsername, firstName, lastName, email, password, phone, userStatus);
    }
}