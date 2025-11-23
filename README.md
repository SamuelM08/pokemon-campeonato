Pokémon Campeonato

Proyecto final de Lógica de Programación y Laboratorio  
Autor: SamuelM08

📚 Descripción

**Pokémon Campeonato** es una aplicación de consola en Java para gestionar una mini liga Pokémon. Permite registrar Pokémon y entrenadores, simular batallas individuales y campeonatos tipo Round Robin, y consultar estadísticas detalladas.  
Este proyecto demuestra estructuras de datos, búsquedas, ordenamientos y una sólida validación de entradas.

🚀 Funcionalidades principales

- **Registrar Pokémon:** Añade Pokémons con ID único, nombre, tipo, ataque y defensa (estadísticas aleatorias).
- **Registrar Entrenador:** Cada entrenador puede tener hasta 6 Pokémon asignados a su equipo.
- **Buscar Pokémon:** Búsqueda por nombre (lineal) y por ID (binaria, previa ordenación).
- **Ordenar Pokémon:** Por ataque (selección), defensa e ID (inserción), implementaciones manuales.
- **Batalla y Campeonato:** Simulación detallada de cada turno en 1v1 y campeonatos todos contra todos con tabla final.
- **Validación robusta:** El sistema nunca se cae por datos incorrectos, siempre guía hasta que la entrada sea válida.

📁 Estructura del proyecto

pokemon-campeonato/
├── src/
│ ├── model/
│ │ ├── Pokemon.java
│ │ └── Entrenador.java
│ ├── service/
│ │ ├── Batalla.java
│ │ └── Campeonato.java
│ ├── util/
│ │ ├── UtilBusqueda.java
│ │ └── UtilOrdenamiento.java
│ └── Main.java
└── README.md

💻 ¿Cómo ejecutar?

1. **Compila el proyecto** (dentro de `src`):

javac Main.java model/.java service/.java util/*.java

2. **Ejecuta la aplicación**:

java Main

3. **Navega por el menú interactivo** siguiendo las instrucciones en pantalla.

🛡️ Validaciones y robustez

- Toda entrada del usuario es validada: si escribes letras donde van números (o viceversa), el sistema lo detecta y te pide repetir el dato.
- Solo se aceptan los tipos de Pokémon requeridos: Agua, Fuego, Planta, Eléctrico.
- No se permite sobrepasar los límites de registro (máximo 40 Pokémon, 4 entrenadores, 6 Pokémon por equipo).

🎲 Ejemplo de uso

--- MENÚ PRINCIPAL ---

Registrar Pokémon

Registrar Entrenador

Buscar Pokémon
...
Selecciona opción: a
Inválido, aquí van solo números.
Selecciona opción: 1
ID: abc
Inválido, aquí van solo números.
ID: 7
Nombre: Pikachu
Tipo (Agua/Fuego/Planta/Eléctrico): Electrico
Entrenador: Ash
¡Pokémon registrado!

📝 Notas académicas

- El código no utiliza librerías de búsqueda ni ordenamiento avanzadas; todo fue implementado manualmente como lo pide la materia.
- Los arreglos son estáticos y el control de flujo 100% basado en lo aprendido en clase.
- Comentado y estructurado para que cualquier compañero o docente lo pueda entender.

👩‍💻 Autoría y créditos

Desarrollado por SamuelM08 para la materia Lógica de Programación y Laboratorio.

