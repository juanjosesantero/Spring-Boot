# @Value
Anotacion para inyectar valores en campos, metodos o constructores desde una fuente de configuración comoo .yaml o variables de entorno

Escribir en el aplication properties : variable=valor
En el controlador declarar las variables correspondientes y encima de cada variable @Value("${nombre_en_aplication_properties})