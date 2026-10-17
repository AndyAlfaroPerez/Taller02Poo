# Taller 02 - La Fonda del Papu

## Descripción del proyecto

Este proyecto consiste en un sistema de gestión de consumos desarrollado en Java, utilizando Programación Orientada a Objetos (POO).

El programa permite administrar los registros de choripanes y terremotos consumidos por los participantes de una fonda, además de calcular estadísticas individuales y generales.

La información se carga desde archivos de texto y las modificaciones realizadas se guardan para mantener los registros actualizados.

## Funcionalidades

El sistema cuenta con un menú principal que permite realizar las siguientes operaciones:

**1. Ver registros**
- Visualizar los choripanes registrados.
- Visualizar los terremotos registrados.
- Consultar consumidores, cantidades, fechas y calorías.

**2. Actualizar registros**
- Agregar nuevos consumos.
- Editar registros existentes.
- Eliminar registros.
- Guardar los cambios en `Consumido.txt`.

**3. Calcular métricas**
- Cantidad total de choripanes y terremotos.
- Cantidad consumida por cada participante.
- Calorías acumuladas por participante.
- Días en que un participante consumió 2 litros o más de terremoto.

**4. Salir**
- Finalizar la ejecución del programa.

## Estructura del proyecto

El proyecto está organizado en el paquete `taller02` y contiene las siguientes clases:

- **Main.java:** contiene el menú principal, los submenús y la interacción con el usuario.
- **Fonda.java:** administra los participantes, los registros de consumo, la lectura y escritura de archivos y el cálculo de métricas.
- **Choripan.java:** representa los consumos de choripanes y permite calcular sus calorías.
- **Terremoto.java:** representa los consumos de terremotos y permite calcular sus calorías.

**Archivos de entrada y almacenamiento:**

- `Participantes.txt`: contiene los nombres de los participantes.
- `Consumido.txt`: contiene los registros de choripanes y terremotos.

## Instrucciones de ejecución

### 1. Clonar el repositorio

Desde una terminal, ejecutar:

```bash
git clone URL_DEL_REPOSITORIO
```

### 2. Abrir el proyecto

1. Abrir Eclipse IDE.
2. Importar el proyecto Java.
3. Verificar que los archivos `Participantes.txt` y `Consumido.txt` estén ubicados en la raíz del proyecto.

### 3. Ejecutar el programa

1. Abrir la clase `Main.java`.
2. Seleccionar **Run As > Java Application**.
3. Utilizar el menú de consola para interactuar con el sistema.

## Pruebas del programa

Para comprobar su funcionamiento se pueden realizar las siguientes pruebas:

1. Visualizar los registros cargados desde los archivos.
2. Agregar un choripán o terremoto y comprobar que se guarde correctamente.
3. Editar un registro y verificar los cambios.
4. Eliminar un registro y comprobar que desaparezca del archivo.
5. Consultar las métricas y verificar los cálculos.
6. Ingresar opciones incorrectas para comprobar las validaciones.
7. Reiniciar el programa para verificar que los cambios se mantengan guardados.

## Consideraciones técnicas

- Desarrollo en Java utilizando Programación Orientada a Objetos.
- Uso de atributos privados, constructores y métodos.
- Almacenamiento mediante arreglos estáticos.
- Lectura y escritura de archivos `.txt`.
- Validación de entradas para evitar errores durante la ejecución.
- Interacción mediante consola.

## Integrante

**Nombre:** Andy Alfaro Perez  
**RUT:** 21.918.973-7  
**Carrera:** ICCI 
**GitHub:** [AndyAlfaroPerez](https://github.com/AndyAlfaroPerez)
