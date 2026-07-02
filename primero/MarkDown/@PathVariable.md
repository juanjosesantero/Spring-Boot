# @PathVariable
Extraer valores de la URL de una solicitud http y asignar a variables de un controlador. Parametro obligatorios.
Se pone en la url://http://localhost:8080/api/variable/pagina1/mensajeria%20movil 
y en el mapping-> @GetMapping("/pagina1/{mensaje}")