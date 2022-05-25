package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameSteps {

    @And("el computador elige {string}")
    public void elComputadorElige(String arg0) {
    }

    @Given("el jugador elige {string}")
    public void elJugadorElige(String arg0) {
    }

    @When("el usuario juega")
    public void elUsuarioJuega() {

    }

    @Then("verificar que la computadora eligio {string}")
    public void verificarQueLaComputadoraEligio(String arg0) {

    }

    @And("el jugador gana")
    public void elJugadorGana() {
    }

}
