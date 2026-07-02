# @RequestParam

//http://localhost:8080/api/parametros/otro?informacion=saludo
        //(required=false),indica que el parametro es opcional, por defecto es null
        //(defaultValue="default"),indica que el parametro es opcional, por defecto es "default" 

Ejemplo: 
    public ParametroDTO otro(@RequestParam (required=false, defaultValue="default")String informacion){}

    Indica que sus argumentos no son obligatorios y por defecto toma default.
    En ausencia de lo segundo tomaria null y en ausencia de lo primero serian obligatorios