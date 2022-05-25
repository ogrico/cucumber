import com.geovany.juego.Juego;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JuegoTest {

    public static final int PIEDRA = 0;
    public static final int PAPEL = 1;
    public static final int TIJERAS = 2;

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

    @Test
    public void cuando_escribaSALIR_finalizarJuego() {
        when(scanner.nextLine()).thenReturn("Salir");
        juego.jugar();

        Assert.assertTrue(out.toString().contains("Juego Piedra, Papel o Tijeras"));
    }

    @Test
    public void cuando_selecionePIEDRA_pierdeTIJERAS() {
        when(scanner.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(TIJERAS);

        juego.jugar();

        Assert.assertTrue(out.toString().contains("la computadora eligio tijeras"));
        Assert.assertTrue(out.toString().contains("Victorias:1"));
    }

    @Test
    public void cuando_seleccioneTijeras_pierdePAPEL() {
        when(scanner.nextLine()).thenReturn("Tijeras").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(PAPEL);

        juego.jugar();

        Assert.assertTrue(out.toString().contains("la computadora eligio papel"));
        Assert.assertTrue(out.toString().contains("Victorias:1"));
    }

    @Test
    public void cuando_selecionePAPEL_pierdePIEDRA() {
        when(scanner.nextLine()).thenReturn("Papel").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(PIEDRA);

        juego.jugar();

        Assert.assertTrue(out.toString().contains("la computadora eligio piedra"));
        Assert.assertTrue(out.toString().contains("Victorias:1"));
    }

    @Test
    public void caundo_seleccionanPIEDRA_empatan() {
        when(scanner.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(PIEDRA);

        juego.jugar();

        Assert.assertTrue(out.toString().contains("la computadora eligio piedra"));
        Assert.assertTrue(out.toString().contains("Empates:1"));
    }

    @Test
    public void caundo_selecionePIEDRA_YlaComputadoraPapel_pierdo() {
        when(scanner.nextLine()).thenReturn("Piedra").thenReturn("Salir");
        when(random.nextInt(3)).thenReturn(PAPEL);

        juego.jugar();

        Assert.assertTrue(out.toString().contains("la computadora eligio papel"));
        Assert.assertTrue(out.toString().contains("Derrotas:1"));
    }
}
