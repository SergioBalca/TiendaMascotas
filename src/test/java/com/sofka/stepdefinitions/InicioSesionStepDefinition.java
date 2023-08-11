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
import static com.sofka.tasks.NavegarInicioSesion.navegarInicioSesion;
import static com.sofka.tasks.IniciarSesion.iniciarSesion;
import static com.sofka.questions.ConfirmacionInicioSesion.confirmacionInicioSesion;
import static com.sofka.util.Constantes.MENSAJE_INICIO_SESION;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class InicioSesionStepDefinition extends Configuracion {

    public static Logger LOGGER = Logger.getLogger(InicioSesionStepDefinition.class);
    Properties properties = new Properties();

    @Given("el usuario navega hasta el formulario de inicio de sesion")
    public void elUsuarioNavegaHastaElFormularioDeInicioDeSesion() {
        try{
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    abrirPaginaInicial(),
                    navegarInicioSesion()
            );
        } catch (Exception e){
            LOGGER.info("Fallo en la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
            Assertions.fail();
        }
    }

    @When("ingresa usuario y clave validos")
    public void ingresaUsuarioYClaveValidos() {
        try {
            properties.load(new FileReader(new File("src/test/resources/valores.properties")));
            String user = properties.get("USER").toString();
            String password = properties.get("PASSWORD").toString();

            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .conElUsuario(user)
                            .yConElPassword(password)
            );
        } catch (Exception e){
            LOGGER.info("Fallo en el inicio de sesion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("deberia ser dirigido a la pagina principal de la tienda")
    public void deberiaSerDirigidoALaPaginaPrincipalDeLaTienda() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(confirmacionInicioSesion(), equalTo(MENSAJE_INICIO_SESION))
            );
            quitarDriver();
            LOGGER.info("Inicio de sesion realizado de manera exitosa");
        } catch (Exception e){
            LOGGER.info("Fallo al comparar mensaje de inicio sesion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();

        }
    }

}
