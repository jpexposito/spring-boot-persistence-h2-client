<div align="justify">

# <img src=images/spring-logo.png width="40"> Cliente Java en Servicios con Spring

<div align="center">
   <img src=images/users.png width="400">
</div>

## <img src=images/crud.png width="40"> Cliente para consumir el servicio de Usuarios en Java y Spring Boot

Un **Cliente REST en Java con Spring** es una implementación que permite consumir servicios web RESTful de manera eficiente utilizando el ecosistema de **Spring Framework**. Proporciona herramientas y abstracciones para realizar operaciones HTTP (`GET`, `POST`, `PUT`, `DELETE`, etc.) y gestionar las respuestas de manera sencilla.

## Características Principales

- **Uso de `RestTemplate`**:  
  Un cliente síncrono proporcionado por Spring para interactuar con servicios REST. Facilita la serialización/deserialización de objetos Java y el manejo de respuestas HTTP.

- **Compatibilidad con JSON y XML**:  
  Soporte integrado para procesar respuestas en formatos como JSON (con Jackson) y XML.

- **Inyección de Dependencias**:  
  Utiliza anotaciones como `@Autowired` o `@Component` para gestionar la configuración y creación de beans en el contenedor de Spring.

- **Extensible y Configurable**:  
  Permite añadir interceptores, configurar headers personalizados y manejar errores HTTP.

- **Alternativa Moderna con WebClient**:  
  Desde **Spring WebFlux**, `WebClient` se recomienda como una opción más flexible y asíncrona.

## Ventajas

- **Integración Simple**:  
  Configuración mínima, especialmente en aplicaciones Spring Boot.

- **Manejo de Errores Simplificado**:  
  Gestión de excepciones personalizadas como `HttpClientErrorException` para controlar respuestas no exitosas.

- **Flexibilidad**:  
  Posibilidad de personalizar solicitudes y reutilizar componentes para diferentes APIs.

- **Desempeño Mejorado**:  
  
  `WebClient` en particular proporciona capacidades asíncronas y reactivas, ideales para aplicaciones modernas.

> En el siguiente [enlace](https://github.com/jpexposito/code-learn/tree/main/segundo/pgv/5-red-servicos) se encuentra la documentación de creación y documentación de servicios en [Spring](https://spring.io/). El cliente representa el uso del servicio definido en el siguiente [enlace](https://github.com/jpexposito/spring-boot-persistence-h2/tree/jdk17).

</div>