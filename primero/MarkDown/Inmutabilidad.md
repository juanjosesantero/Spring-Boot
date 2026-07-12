El diseño de clases de beans, para que su estado no cambie tras ser construido
Se verifica cuando todos sus campos son final o dependencias e ponen una vez o no tienen getter  o no hay exposicion para ser modificada.
Hilos mas seguros y menos propensos a errores, ya que no hay riesgo de que el estado del objeto cambie inesperadamente. Además, los objetos inmutables son más fáciles de razonar y probar, ya que su comportamiento es predecible y consistente.

Al diseñar los bean,para que sus dependencias se definan una vez en su constructor y no puedan ser modificadas posteriormente, se logra una mayor seguridad y estabilidad en el código. Esto también facilita la implementación de patrones de diseño como el patrón Singleton, donde se garantiza que solo exista una instancia del objeto a lo largo de la aplicación.
