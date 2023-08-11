# TiendaMascotas

## Descripción del ejercicio

Considere como SUT la app https://petstore.octoperf.com/actions/Catalog.action una tienda virtual de mascotas Implementar
los casos de pruebas asociados a las siguientes funcionalidades:
- Consultar todas las clases de reptiles
- Comprar un perro Golden Retriever
- Eliminar un animal de una orden de compra
- Logearse en el sistema

## Solución

Para la solución del ejercicio planteado se implementa una automatización usando el patrón de pruebas ScreenPlay, el
framework Serenety, el gestor de dependicas Gradle y Java en su versión 11.

### Dependencias

Las dependencias utilizadas en la automatización se encuentran en archivo build.gradle. A continuación se presenta cada
una de ellas con su respectiva versión:
- Junit: 5.7.2
- Serenity: 2.2.9
- Serenity Cucumber: 2.2.6
- apache: 3.17
- Java version 11
- webdrivermanager: 5.3.2
- log4j 1.2.17

### Repositorio

Para ejecutar la automatización, primero se debe clonar el presente repositorio, utilizando el siguiente comando:
``` git clone git@github.com:SergioBalca/TiendaMascotas.git ```

La ejecución del proyecto se realiza utilizando Junit

### Inicio de sesión en JPetStore

Para realizar compras en la página web de JPetStore es necesario realizar el registro manual, ya que este proceso no
hace parte de la automatización implementada. Una vez se tengan el username y password definidas, estas credenciales
deben ser agregadas al archivo valores.properties; el cual se encuentra en la ruta:

```src/test/resources```

el username y password deben ser agregados al archivo en el siguiente formato:
```
   USER=username
   PASSWORD=password
```