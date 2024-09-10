package petStore.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class MascotaSteps {
    // URL base para la creación de mascotas en la PetStore API.
    private static String PET_API_URL = "https://petstore.swagger.io/v2/pet";

    //METODO POST PARA CREAR UNA MASCOTA
    @Step("Crear mascota con id {0}, nombre {1} y estado {2}")
    public void crearMascota(String id, String name, String status) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"" + name + "\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"" + status + "\"\n" +
                        "}")
                .log().all()
                .post(PET_API_URL)
                .then()
                .log().all();
    }


    //METODO GET PARA CONSULTAR UNA MASCOTA - SE REUTILIZA TAMBIEN EN EL PUT Y DELETE
    public boolean consultoMascota(String id) {
        boolean existeMascota = false;
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(PET_API_URL + "/" + id)
                .then()
                .log().all();
        if (lastResponse().statusCode() == 200){
            existeMascota = true;
        }
        return  existeMascota;
    }

    //METODO PUT PARA ACTUALIZAR UNA MASCOTA
    @Step("Actualizar mascota con id {0} y nuevo nombre {1}")
    public void actualizoNombreMascota(String id, String nuevoNombre) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"" + nuevoNombre + "\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .log().all()
                .put(PET_API_URL)
                .then()
                .log().all();
    }

    //METODO DELETE PARA ELIMINAR UNA MASCOTA
    @Step("Eliminar mascota con id {0}")
    public void eliminarMascota(String id) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .delete(PET_API_URL + "/" + id)
                .then()
                .log().all();
    }

    //OTROS METODOS
    // Método para validar que el nombre de la mascota en la respuesta coincide con el esperado (ASSERT)
    public void validarNombreMascota(String name) {
        restAssuredThat(response -> response.body("name", equalTo(name)));
    }

    // Método para validar que el código de respuesta HTTP es el esperado SE REUTILIZO EN TODOS LOS ESCENARIOS
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

}
