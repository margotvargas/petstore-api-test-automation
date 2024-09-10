package petStore.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UsuarioSteps {

    private static String USER_API_URL = "https://petstore.swagger.io/v2/user";

    //POST CREAR USUARIO
    @Step("Crear usuario {0} en PetStore")
    public void crearUsuario(String username, String firstName, String lastName) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"" + username + "\",\n" +
                        "  \"firstName\": \"" + firstName + "\",\n" +
                        "  \"lastName\": \"" + lastName + "\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .log().all()
                .post(USER_API_URL)
                .then()
                .log().all();
    }

    //GET CONSULTAR USUARIO
    @Step("Consultar usuario con nombre {0}")
    public boolean consultoUsuario(String username) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(USER_API_URL + "/" + username)
                .then()
                .log().all();

        return lastResponse().statusCode() == 200;
    }

    //PUT ACTUALIZAR USUARIO
    @Step("Actualizar usuario {0} a nuevo nombre {1}")
    public void actualizoUserName(String usernameOld, String usernameNew) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"" + usernameNew + "\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .log().all()
                .put(USER_API_URL + "/" + usernameOld)
                .then()
                .log().all();
    }

    //DELETE ELIMINAR USUARIO
    @Step("Eliminar usuario con nombre {0}")
    public void eliminarUsuario(String username) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .delete(USER_API_URL + "/" + username)
                .then()
                .log().all();
    }

    //POST CREAR USUARIO MASIVO
    public void crearUsuariomasivo(String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"" + username + "\",\n" +
                        "  \"firstName\": \"" + firstName + "\",\n" +
                        "  \"lastName\": \"" + lastName + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"" + password + "\",\n" +
                        "  \"phone\": \"" + phone + "\",\n" +
                        "  \"userStatus\": " + userStatus + "\n" +
                        "}")
                .log().all()
                .post(USER_API_URL)
                .then()
                .log().all();
    }

    //METODO DE ASSERT DE RESPUESTA type es "unknown"
    public void validarType(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
    }

    //METODO ASSERT DE CODIGO DE RESPUESTA REUTILIZADO EN TODOS LAS PETICIONES
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void actualizarUsuarioMasivo(String oldUsername, String newUsername, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"" + newUsername + "\",\n" +
                        "  \"firstName\": \"" + firstName + "\",\n" +
                        "  \"lastName\": \"" + lastName + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"" + password + "\",\n" +
                        "  \"phone\": \"" + phone + "\",\n" +
                        "  \"userStatus\": " + userStatus + "\n" +
                        "}")
                .log().all()
                .put(USER_API_URL + "/" + oldUsername)
                .then()
                .log().all();
    }
}
