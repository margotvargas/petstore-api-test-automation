package petStore.stepsDefs;

import petStore.steps.UsuarioSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class UsuarioStepsDefs {

    @Steps
    UsuarioSteps usuarioSteps;
    //CREAR USUARIO
    @When("creo el usuario con username {string}, firstname {string}, lastname {string}")
    public void crearUsuario(String username, String firstName, String lastName) {
        usuarioSteps.crearUsuario(username, firstName, lastName);
    }

    //CONSULTAR USUARIO
    @Given("consulto el usuario con nombre {string}")
    public void consultoElUsuarioConNombre(String username) {
        Assert.assertTrue("No existe usuario", usuarioSteps.consultoUsuario(username));
    }

    //ACTUALIZAR USUARIO
    @When("actualizo el usuario {string} con nuevo username {string}")
    public void actualizoElUsuarioConNuevoUsername(String usernameOld, String usernameNew) {
        usuarioSteps.actualizoUserName(usernameOld, usernameNew);
    }

    //ELIMINAR USUARIO
    @When("elimino el usuario con nombre {string}")
    public void eliminoElUsuarioConNombre(String username) {
        usuarioSteps.eliminarUsuario(username);
    }

    //CREAR USUARIOS MASIVOS
    @When("creo el usuario con username {string}, firstname {string}, lastname {string}, email {string}, password {string}, phone {string}, userStatus {string}")
    public void creoElUsuarioConUsernameFirstnameLastnameEmailPasswordPhoneUserStatus(String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        usuarioSteps.crearUsuariomasivo(username, firstName, lastName, email, password, phone, userStatus);
    }

    // CONSULTAR USUARIO ESPERANDO 404 POST ELIMINACIÓN
    @Given("consulto el usuario eliminado con nombre {string}")
    public void consultoElUsuarioEliminadoConNombre(String username) {
        usuarioSteps.consultoUsuario(username);
        int statusCode = SerenityRest.lastResponse().statusCode();
        Assert.assertEquals("Se esperaba que el código de respuesta fuera 404, pero fue " + statusCode, 404, statusCode);
    }

    //METODO DE VALIDACION DE CODIGO ESPERADO REUTILIZADO EN TODOS LOS CASOS
    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        usuarioSteps.validarCodigoRespuesta(statusCode);
    }

    //METODO DE VALIDACION DE DEL TYPE PARA EL CASO DE CREACION DE USUARIO
    @And("el type es {string}")
    public void elTypeEs(String type) {
        usuarioSteps.validarType(type);
    }

    @When("actualizo el usuario {string} con nuevo username {string}, firstname {string}, lastname {string}, email {string}, password {string}, phone {string}, userStatus {string}")
    public void actualizoElUsuarioConNuevoUsernameFirstnameLastnameEmailPasswordPhoneUserStatus(String oldUsername, String newUsername, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        usuarioSteps.actualizarUsuarioMasivo(oldUsername, newUsername, firstName, lastName, email, password, phone, userStatus);
    }

}