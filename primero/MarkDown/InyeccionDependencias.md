Es un patron de diseño que forma parte del principio de inversion de depencias o IOC. Eso delega responsabilidad de crear y gestionar los objetos a un contenerdor.

Si una clase A necesita de B, esa B es una depencia y A instancia una de B, si A requiere de B, Spring lo crea y pasa. Reduce acoplamiento

Para ello se deben crear clases que tengan dependencia entre si o Beans