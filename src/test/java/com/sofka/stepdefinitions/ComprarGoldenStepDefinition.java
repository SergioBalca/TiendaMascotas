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
import static com.sofka.tasks.IniciarSesion.iniciarSesion;
import static com.sofka.tasks.NavegarInicioSesion.navegarInicioSesion;
import static com.sofka.tasks.ComprarGolden.comprarGolden;
import static com.sofka.util.Constantes.MENSAJE_CONFIRMACION_COMPRA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static com.sofka.questions.ConfirmacionCompra.confirmacionCompra;
import static org.hamcrest.CoreMatchers.equalTo;


public class ComprarGoldenStepDefinition extends Configuracion {

    public static Logger LOGGER = Logger.getLogger(ComprarGoldenStepDefinition.class);
    Properties properties = new Properties();

    @Given("el usuario inicia sesion exitosamente en la pagina web")
    public void elUsuarioIniciaSesionExitosamenteEnLaPaginaWeb() {
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
    @When("el usuario selecciona un Golden Retreiver para comprar")
    public void elUsuarioSeleccionaUnGoldenRetreiverParaComprar() {
        try{
            theActorInTheSpotlight().attemptsTo(
                   comprarGolden()
            );
        } catch (Exception e){
            LOGGER.info("Fallo a la hora de seleccionar perro");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
    @Then("deberia visualizar un mensaje de confirmacion de la compra realizada")
    public void deberiaVisualizarUnMensajeDeConfirmacionDeLaCompraRealizada() {
        try{
            theActorInTheSpotlight().should(
                    seeThat(confirmacionCompra(), equalTo(MENSAJE_CONFIRMACION_COMPRA))
            );
            LOGGER.info("Compra realizada de manera exitosa");
            quitarDriver();
        } catch (Exception e){
            LOGGER.info("Fallo al comparar mensaje confirmacion compra");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

}
