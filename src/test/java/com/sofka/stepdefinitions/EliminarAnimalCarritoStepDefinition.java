package com.sofka.stepdefinitions;

import com.sofka.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import static com.sofka.tasks.AbrirPaginaInicial.abrirPaginaInicial;
import static com.sofka.tasks.EliminarAnimalCarrito.eliminarAnimalCarrito;
import static com.sofka.tasks.IniciarSesion.iniciarSesion;
import static com.sofka.tasks.NavegarInicioSesion.navegarInicioSesion;
import static com.sofka.questions.ConfirmacionAnimalEliminado.confirmacionAnimalEliminado;
import static com.sofka.util.Constantes.MENSAJE_CARRITO_VACIO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static com.sofka.tasks.ElegirIguana.elegirIguana;
import static com.sofka.tasks.ElegirReptiles.elegirReptiles;
import static com.sofka.tasks.AgregarAnimalCarrito.agregarAnimalCarrito;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class EliminarAnimalCarritoStepDefinition extends Configuracion {

    public static Logger LOGGER = Logger.getLogger(EliminarAnimalCarritoStepDefinition.class);
    Properties properties = new Properties();

    @Given("el usuario inicia sesion exitosamente en la tienda virtual")
    public void elUsuarioIniciaSesionExitosamenteEnLaTiendaVirtual() {
        try{
            properties.load(new FileReader(new File("src/test/resources/valores.properties")));
            String user = properties.get("USER").toString();
            String password = properties.get("PASSWORD").toString();

            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    abrirPaginaInicial(),
                    navegarInicioSesion(),
                    iniciarSesion()
                            .conElUsuario(user)
                            .yConElPassword(password)
            );
        } catch (Exception e){
            LOGGER.info("Fallo en la configuracion inicial o de inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
            Assertions.fail();
        }
    }
    @Given("tiene agregado un animal al carrito de compras")
    public void tieneAgregadoUnAnimalAlCarritoDeCompras() {
        try{
            theActorInTheSpotlight().attemptsTo(
                    elegirReptiles(),
                    elegirIguana(),
                    agregarAnimalCarrito()
            );
        } catch (Exception e){
            LOGGER.info("Fallo al elegir el tipo de Reptil");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
    @When("decide elimnar el animal del carrito de compras")
    public void decideElimnarElAnimalDelCarritoDeCompras() {
        try {
            theActorInTheSpotlight().attemptsTo(
                   eliminarAnimalCarrito()
            );
        } catch (Exception e){
            LOGGER.info("Fallo a la hora de eliminar animal del carrito");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
    @Then("deberia observar un mensaje cofirmando que el carrito de compras esta vacio")
    public void deberiaObservarUnMensajeCofirmandoQueElCarritoDeComprasEstaVacio() {
        try{
            theActorInTheSpotlight().should(
                    seeThat(confirmacionAnimalEliminado(), equalTo(MENSAJE_CARRITO_VACIO))
            );
            LOGGER.info("Animal eliminado del carrito exitosamente");
            quitarDriver();
        } catch (Exception e){
            LOGGER.info("Fallo en la comparacion de mensaje animal eliminado");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }


}
