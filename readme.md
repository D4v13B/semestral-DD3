Una universidad requiere conocer cuántos de sus investigadores tienen asignado
proyectos, para determinar en el próximo semestre cómo será su descarga horaria.
Para tomar las decisiones pertinentes se cuenta con la siguiente base de datos
llamada (investigación.sql), que cuenta con el siguiente diseño básico:
1. Entidades:
   a. Investigador
   Contendrá información sobre los investigadores, como Código del investigador, nombre
   y área de investigación.
   Una relación de muchos a muchos que vincula investigadores con proyectos, ya que un
   investigador puede participar en varios proyectos y un proyecto puede implicar a varios
   investigadores.
   b. Proyectos:
   Almacenará detalles sobre los proyectos de investigación, como Código de proyecto,
   nombre del proyecto, horas de dedicación, fecha de inicio, fecha de terminación y
   descripción.
   c. Publicaciones
   Para registrar las publicaciones realizadas como resultado de los proyectos de
   investigaciónse incluiría detalles como título, autor(es), fecha de publicación,
   revista/conferencia.
2. Relaciones:
   a. InvestigadorProyecto: Una relación de muchos a muchos que vincula
   investigadores con proyectos, ya que un investigador puede participar en
   varios proyectos y un proyecto puede implicar a varios investigadores. Esta
   puede contener el Código del investigador y código de proyecto.
   b. ProyectoPublicación: Una relación de uno a muchos que vincula
   proyectos con publicaciones. Un proyecto puede generar múltiples
   publicaciones, pero una publicación está asociada a un solo proyecto.
   A partir de esta información realice una aplicación que permita a la
   universidad realizar los siguientes procesos presentando un menú de
   opciones:
   • Listado de proyectos por investigador (por procedimiento almacenado)
   • Listado de investigadores por proyecto
   • Mostrar el número total de horas de dedicación de cada investigador
   • Mostrar cuantos proyectos culminan a la fecha de hoy (consola), y eliminarlos
   físicamente y saca un respaldo en un archivo Csv en disco.
   Recuerde que existen eliminaciones lógicas, pero en este proyecto no se va a
   considerar.
   • Agregar nuevas publicaciones.
   • Modificar nombres de investigadoreso o área de investigación para corregir.
   • Se debe permitir corregir datos, en este caco solamente deberá permitir
   modificar nombres de investigadores o área de investigación para corregir.