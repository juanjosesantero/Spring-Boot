Clase que representa nuestras tablas en la db, creando atributos para enlazarlos

Spring Data JPA, construye las tablas automaticamente pudiendo transformar objetos a registros y poder recuperar informacion

El repositorio es la capa de acceso a datos siguiendo patron DAO, Data Access Object. Estandariza el acceso a datos
Requiere la interfaz JpaRepository, con <tipo Objeto,tipo clave>
el repositorio hereda de CrudRepositori con metodos basicos CRUD
PaginAndSortingRepository para trabajar con grandes conjuntos de datos eficientemente
JpaRepository

# Configuracion de la db
spring.datasource.url=jdbc:mysql:://localhost:3306/db_ferreteria # Conectividad y tipo
spring.datasource.username=root
spring.datasource.password=usuario
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-plataform=org.hibernate.dialect.MySQLDialect # Permite hacer relaciones entre tablas, restricciones ...
spring.jpa.show-sql=true # Si queremos que aparezcan o no las sentencias SQL en consola

https://dev.mysql.com/downloads/installer/
El segundo