import app.OperacionesPublicaciones;
import app.OperacionesProyectos;
import app.OperacionesInvestigador;
import app.Publicaciones;
import config.Conexion;
import app.Proyectos;
import app.Investigador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OperacionesPublicaciones operacionesPublicaciones = new OperacionesPublicaciones();
        OperacionesProyectos operacionesProyectos = new OperacionesProyectos();
        OperacionesInvestigador operacionesInvestigador = new OperacionesInvestigador();
        Conexion con = new Conexion();

        Investigador investigador;

        while (true) {
            try {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Listado de proyectos por investigador");
                System.out.println("2. Listado de investigadores por proyecto");
                System.out.println("3. Mostrar el número total de horas de dedicación de cada investigador");
                System.out.println("4. Mostrar cuantos proyectos culminan a la fecha de hoy y eliminarlos");
                System.out.println("5. Agregar nuevas publicaciones");
                System.out.println("6. Modificar nombres de investigadores o área de investigación");
                System.out.println("7. Salir");
                int opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        // Código para listar proyectos por investigador
                        try{
                            LinkedList<Investigador> investigadores = operacionesInvestigador.obtenerInvestigadores(con);
                            System.out.printf("%-5s %-10s %-10s %-10s\n", "ID", "Nombre", "Area", "Código");
                            System.out.println("----------------------------------------------------");
                            //Mostramos todos los investigadores para poder ver su info y seleccionarlo mediante su ID unico
                            for (Investigador inv : investigadores) {
                                System.out.printf("%-5d %-10s %-10s %-10s\n", inv.getInveId(), inv.getInveNombre(), inv.getInveArea(), inv.getInveCodigo());
                            }
                            System.out.println("\nSelecciona el ID del investigador para ver sus proyectos");
                            int id = Integer.parseInt(reader.readLine());
                            //Guardamos los proyectos de ese investigador seleccionado
                            LinkedList<Proyectos> proyectos = operacionesInvestigador.investigadoresXProyectos(con, id);
                            //Recorremos y mostramos en modo de tabla los proyectos del investigador especificado
                            System.out.printf("%-4s %-10s %-10s %-30s %-20s %-20s\n", "ID", "Código", "Nombre" ,"Horas de dedicación", "Fecha inicio", "Fecha fin");
                            System.out.println("----------------------------------------------------------------------------------------------------");
                            for (Proyectos pro : proyectos) {
                                System.out.printf("%-4d %-10s %-10s %-30s %-20s %-20s\n", pro.getProyId(), pro.getProyCodigo(), pro.getProyNombre() ,pro.getProyHorasDedicacion(), pro.getProyFechaInicio(), pro.getProyFechaFin());
                            }
                        }catch (SQLException e){
                            System.out.println("Error SQL " + e.getMessage());
                        }
                        break;
                    case 2:
                        // Código para listar investigadores por proyecto
                        LinkedList<Proyectos> proyectos = operacionesProyectos.obtenerProyectos(con);
                        System.out.printf("%-4s %-10s %-10s %-30s %-20s %-20s\n", "ID", "Código", "Nombre" ,"Horas de dedicación", "Fecha inicio", "Fecha fin");
                        System.out.println("----------------------------------------------------------------------------------------------------");
                        /*
                            Mostramos todos los proyectos para que el usuario escoja mediante el ID
                         */
                        for (Proyectos pro : proyectos) {
                            System.out.printf("%-4d %-10s %-10s %-30s %-20s %-20s\n", pro.getProyId(), pro.getProyCodigo(), pro.getProyNombre() ,pro.getProyHorasDedicacion(), pro.getProyFechaInicio(), pro.getProyFechaFin());
                        }
                        System.out.println("\nInserta el ID del proyecto que quieres saber la info");
                        int id = Integer.parseInt(reader.readLine());

                        LinkedList<Investigador> investigadors = operacionesProyectos.investigadoresXProyectos(con, id);
                        System.out.println("Esto son los investigadores del proyecto------------------------------------");
                        System.out.printf("%-5s %-10s %-10s %-10s\n", "ID", "Nombre", "Area", "Código");
                        System.out.println("----------------------------------------------------");
                        for (Investigador inv : investigadors) {
                            System.out.printf("%-5d %-10s %-10s %-10s\n", inv.getInveId(), inv.getInveNombre(), inv.getInveArea(), inv.getInveCodigo());
                        }
                        break;
                    case 3:
                        // Código para mostrar el total de horas de dedicación de cada investigador
                        break;
                    case 4:
                        // Código para mostrar proyectos que culminan hoy y eliminarlos
                        break;
                    case 5:
                        try {
                            System.out.println("Ingrese el ID de la publicación:");
                            int publiId = Integer.parseInt(reader.readLine());
                            System.out.println("Ingrese el título de la publicación:");
                            String publiTitulo = reader.readLine();
                            System.out.println("Ingrese la fecha de publicación (YYYY-MM-DD):");
                            String publiFecha = reader.readLine();
                            Publicaciones publicacion = new Publicaciones();
                            publicacion.setPubliId(publiId);
                            publicacion.setPubliTitulo(publiTitulo);
                            publicacion.setPubliFechaPublicacion(publiFecha);
                            operacionesPublicaciones.agregarPublicacion(con, publicacion);
                            System.out.println("Publicación agregada exitosamente.");
                        } catch (NumberFormatException e) {
                            System.err.println("Error: ID de publicación inválido. " + e.getMessage());
                        } catch (SQLException e) {
                            System.err.println("Error al agregar la publicación: " + e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            while (true) {
                                System.out.println("Seleccione una opción:");
                                System.out.println("1. Modificar nombre del investigador");
                                System.out.println("2. Modificar área del investigador");
                                System.out.println("3. Salir");
                                opcion = Integer.parseInt(reader.readLine());

                                switch (opcion) {
                                    case 1:
                                        // Código para modificar el nombre del investigador
                                        System.out.println("Ingrese el ID del investigador:");
                                        int inveId = Integer.parseInt(reader.readLine());
                                        investigador = operacionesInvestigador.obtenerInvestigador(con, inveId);
                                        System.out.println("Va a modificar al siguiente investigador:");
                                        System.out.print("\nNombre" + "\t\t" + "Área de investigación" + "\t\t" + "Código");
                                        System.out.println("\n" + investigador.getInveNombre() + "\t" + investigador.getInveArea() + "\t" + investigador.getInveCodigo());

                                        System.out.println("Ingrese el nuevo nombre del investigador:");
                                        String nuevoNombre = reader.readLine();
                                        operacionesInvestigador.actualizarNombreInvestigador(con, inveId, nuevoNombre);
                                        System.out.println("Nombre del investigador actualizado exitosamente.");
                                        break;
                                    case 2:
                                        // Código para modificar el área del investigador
                                        System.out.println("Ingrese el ID del investigador:");
                                        inveId = Integer.parseInt(reader.readLine());
                                        System.out.println("Ingrese el nuevo área del investigador:");
                                        String nuevaArea = reader.readLine();
                                        operacionesInvestigador.actualizarAreaInvestigacion(con, inveId, nuevaArea);
                                        System.out.println("Área del investigador actualizada exitosamente.");
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Intente de nuevo.");
                                        break;
                                }
                                if (opcion == 3) {
                                    break; // Salir del bucle while
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error: ID de investigador inválido. " + e.getMessage());
                        } catch (SQLException e) {
                            System.err.println("Error al actualizar el investigador: " + e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Opción inválida. " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error de entrada/salida: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error de base de datos: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}