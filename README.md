# Hoja-de-trabajo-4

Revise qué ventajas / desventajas hay al utilizar el patrón Singlenton en general, ya que su comportamiento es muy similar a una variable global. ¿Cree que su uso es adecuado en este programa?
Ventajas
  -Garantiza que solo exista una instancia de una clase en la aplicación
  -Proporciona un punto de acceso global a esa instancia.
  -Promueve el uso eficiente de recursos al no permitir la creación innecesaria de múltiples instancias.
Desventajas
  -Puede dificultar la prueba unitaria, ya que la clase Singleton puede tener un estado global que afecte a otras pruebas.
  -Puede dificultar la extensibilidad, ya que no es posible heredar de una clase Singleton.
En cuanto a si su uso es adecuado en este programa, pensamos que si es adecuado ya que esta garantiza que solo exista una instancia de la clase calculadora y que esta es accesible globalmente.
