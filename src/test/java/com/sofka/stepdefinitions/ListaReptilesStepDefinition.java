package com.sofka.stepdefinitions;

import com.sofka.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofka.questions.ConfirmacionReptiles.confirmacionReptiles;
import static com.sofka.util.Constantes.MENSAJE_LISTA_REPTILES;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static com.sofka.tasks.AbrirPaginaInicial.abrirPaginaInicial;
import static com.sofka.tasks.ElegirReptiles.elegirReptiles;
import static com.sofka.tasks.ElegirRattleSnake.elegirRattleSnake;
import static com.sofka.tasks.ElegirIguana.elegirIguana;
import static org.hamcrest.CoreMatchers.equalTo;

public class ListaReptilesStepDefinition extends Configuracion {
    public static Logger LOGGER = Logger.getLogger(ListaReptilesStepDefinition.class);

    @Given("el usuario ingresa a la pagina de inicio de JPetStore")
    public void elUsuarioIngresaALaPaginaDeInicioDeJPetStore() {
        try{
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    abrirPaginaInicial()
            );
        } catch (Exception e){
            LOGGER.info("Fallo en la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
            Assertions.fail();
        }
    }

    @When("selecciona la opcion reptiles del menu principal")
    public void seleccionaLaOpcionReptilesDelMenuPrincipal() {
        try{
            theActorInTheSpotlight().attemptsTo(
                    elegirReptiles()
            );
        } catch (Exception e){
            LOGGER.info("Fallo al elegir opcion reptiles");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @When("elige la opcion Rattlesnake y luego Iguana")
    public void eligeLaOpcionRattlesnakeYLuegoIguana() {
        try{
            theActorInTheSpotlight().attemptsTo(
                    elegirRattleSnake(),
                    elegirIguana()
            );
        } catch (Exception e){
            LOGGER.info("Fallo al elegir el tipo de Reptil");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("el usuario visualizara la lista de reptiles disponibles")
    public void elUsuarioVisualizaraLaListaDeReptilesDisponibles() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(confirmacionReptiles(), equalTo(MENSAJE_LISTA_REPTILES))
            );
            quitarDriver();
            LOGGER.info("Listado de reptiles presentado de manera exitosa");
        } catch (Exception e){
            LOGGER.info("Fallo al comparar resultado esperado con resultado obtenido");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

}
