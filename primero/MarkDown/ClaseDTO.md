# Clase Data Transfer Object
Clase para transferir datos entre capas de nuestra aplicacion, se usa para separacion de preocupaciones (Como logica de negocio, seguridad, persistencia)
Sirven para reducir datos expuestos y el tamaño de carga


# DTO vs Entidad
DTO, transferir datps entre capas, usado en interfaz de usuario o API, sin relaciones complejas.
Entidadm representa una tabla de la bd, se usa en persistencia con relaciones entre ellas e incluye anotaciones JPA

Obligatorio constructor, getters y setters

Una clase mapper, convierte el objeto a dto en controladores y servicios