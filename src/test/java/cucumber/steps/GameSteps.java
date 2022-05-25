package cucumber.steps;

import com.geovany.juego.Juego;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

@RunWith(MockitoJUnitRunner.class)
public class GameSteps {

    public static final int PIEDRA = 0, PAPEL = 1, TIJERAS = 2;

    @InjectMocks
    private Juego juego;

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream out;

    @Before
    public void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }
    
    @Given("el jugador elige {string}")
    public void elJugadorElige(String arg0) {
    }

    @And("el computador elige {string}")
    public void elComputadorElige(String arg0) {
    }

    @When("juegan")
    public void juegan() {
    }

    @Then("el jugador gana")
    public void elJugadorGana() {
    }

}
