import Caso1.Alumno;
import Caso2.Producto;
import Caso3.Libro;
import Caso4.Empleado;
import jdk.dynalink.Operation;

import java.sql.SQLOutput;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //CASO 1
        System.out.println("==============CASO 1==============");
        List<Alumno> alumnos = Arrays.asList(
            Alumno.builder()
                .nombre("Nicolas")
                .nota(4)
                .curso("Desarrollo de Software")
                .build(),
            Alumno.builder()
                .nombre("Octavio")
                .nota(10)
                .curso("Desarrollo de Software")
                .build(),
            Alumno.builder()
                .nombre("Tiago")
                .nota(7)
                .curso("Analisis Numerico")
                .build(),
            Alumno.builder()
                .nombre("Antonio")
                .nota(3)
                .curso("Analisis Numerico")
                .build(),
            Alumno.builder()
                .nombre("Ramiro")
                .nota(7)
                .curso("Analisis Matematico")
                .build()
        );

        System.out.println("ALUMNOS APROBADOS");
        alumnos.stream()
                .filter(nota -> nota.getNota() >= 7)
                .forEach(System.out::println);
        OptionalDouble promedioNotas = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average();

        System.out.println("PROMEDIO DE NOTAS: " + promedioNotas.getAsDouble());

        System.out.println("ALUMNOS CON MEJOR NOTA: ");
        alumnos.stream()
                .sorted(Comparator.comparingInt(Alumno::getNota).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("ALUMNOS POR CURSO: ");
        Map<String, List<Alumno>> agrupadoPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println(agrupadoPorCurso);
        System.out.println("==============CASO 2==============");

        List<Producto> listaProductos = Arrays.asList(
                Producto.builder()
                        .nombre("Café Molido Premium")
                        .categoria("Bebidas")
                        .precio(24.99)
                        .stock(120)
                        .build(),

                Producto.builder()
                        .nombre("Auriculares Bluetooth WaveSound")
                        .categoria("Tecnologia")
                        .precio(189.50)
                        .stock(45)
                        .build(),

                Producto.builder()
                        .nombre("Campera Deportiva WindFlex")
                        .categoria("Ropa")
                        .precio(134.00)
                        .stock(60)
                        .build(),

                Producto.builder()
                        .nombre("Mouse Gamer RGB X300")
                        .categoria("Tecnologia")
                        .precio(749.90)
                        .stock(85)
                        .build(),

                Producto.builder()
                        .nombre("Taza Cerámica UrbanStyle")
                        .categoria("Hogar")
                        .precio(18.00)
                        .stock(200)
                        .build(),

                Producto.builder()
                        .nombre("Cargador Portátil PowerGo 10000mAh")
                        .categoria("Tecnologia")
                        .precio(99.00)
                        .stock(70)
                        .build(),

                Producto.builder()
                        .nombre("Zapatillas Running AirBoost")
                        .categoria("Ropa")
                        .precio(259.99)
                        .stock(35)
                        .build(),

                Producto.builder()
                        .nombre("Botella de Acero Inoxidable 750ml")
                        .categoria("Deportes")
                        .precio(549.50)
                        .stock(150)
                        .build(),

                Producto.builder()
                        .nombre("Silla Ergonómica ProOffice")
                        .categoria("Hogar")
                        .precio(679.00)
                        .stock(25)
                        .build(),

                Producto.builder()
                        .nombre("Set de Velas Aromáticas Relax")
                        .categoria("Hogar")
                        .precio(45.00)
                        .stock(90)
                        .build()
        );
        System.out.println("PRODUCTOS CON PRECIO MAYOR A 100: ");
        listaProductos.stream().filter(producto -> producto.getPrecio() >= 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .forEach(System.out::println);
        System.out.println("PRODUCTOS POR CATEGORIA: ");
        Map<String, Integer> agrupadoPorProducto = listaProductos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)));
        System.out.println(agrupadoPorProducto);
        System.out.println("PRODUCTOS CON FORMATO: ");
        String productosFormateados = listaProductos.stream()
                .map(p -> p.getNombre() + ": " + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println(productosFormateados);

        System.out.println("PRECIO PROMEDIO GENERAL: ");
        OptionalDouble precioPromedioProd = listaProductos.stream()
                .mapToDouble(Producto::getPrecio)
                .average();
        System.out.println(precioPromedioProd.getAsDouble());

        System.out.println("PRECIO PROMEDIO POR CATEGORIA: ");
        Map<String, Double> precioPromedioProdCategoria = listaProductos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.summingDouble(Producto::getPrecio)));
        System.out.println(precioPromedioProdCategoria);

        System.out.println("==============CASO 3==============");
        List<Libro> listaLibros = Arrays.asList(
                Libro.builder()
                        .nombre("Cien años de soledad")
                        .autor("Gabriel García Márquez")
                        .precio(15999.99)
                        .paginas(496)
                        .build(),
                Libro.builder()
                        .nombre("El amor en los tiempos del cólera")
                        .autor("Gabriel García Márquez")
                        .precio(14250.00)
                        .paginas(432)
                        .build(),
                Libro.builder()
                        .nombre("Crónica de una muerte anunciada")
                        .autor("Gabriel García Márquez")
                        .precio(11900.00)
                        .paginas(176)
                        .build(),
                Libro.builder()
                        .nombre("La casa de los espíritus")
                        .autor("Isabel Allende")
                        .precio(13499.99)
                        .paginas(544)
                        .build(),
                Libro.builder()
                        .nombre("Eva Luna")
                        .autor("Isabel Allende")
                        .precio(12250.00)
                        .paginas(384)
                        .build(),
                Libro.builder()
                        .nombre("Inés del alma mía")
                        .autor("Isabel Allende")
                        .precio(13999.00)
                        .paginas(456)
                        .build(),
                Libro.builder()
                        .nombre("Rayuela")
                        .autor("Julio Cortázar")
                        .precio(17800.00)
                        .paginas(600)
                        .build(),
                Libro.builder()
                        .nombre("Bestiario")
                        .autor("Julio Cortázar")
                        .precio(8900.00)
                        .paginas(200)
                        .build(),
                Libro.builder()
                        .nombre("Final del juego")
                        .autor("Julio Cortázar")
                        .precio(9600.00)
                        .paginas(240)
                        .build(),
                Libro.builder()
                        .nombre("Las armas secretas")
                        .autor("Julio Cortázar")
                        .precio(10150.00)
                        .paginas(260)
                        .build()
        );
        System.out.println("LIBROS COM MAS DE 300 PAGINAS ORDENADOS POR TITULO ALFABETICAMENTE:");
        listaLibros.stream()
                .filter(l -> l.getPaginas() >= 300)
                .map(Libro::getNombre)
                .sorted()
                .forEach(System.out::println);

        System.out.println("PROMEDIO DE PAGINAS DE LOS LIBROS: ");
        OptionalDouble promPag = listaLibros.stream()
                .mapToDouble(Libro::getPaginas)
                .average();
        System.out.println(promPag.getAsDouble());

        System.out.println("CANTIDAD DE LIBROS POR AUTOR: ");
        Map<String, Long> librosPorAutor= listaLibros.stream()
                .collect(Collectors.groupingBy(Libro::getAutor, Collectors.counting()));
        System.out.println(librosPorAutor);

        System.out.println("LIBRO MAS CARO: ");
        Optional libroPorPrecio = listaLibros.stream()
                .max(Comparator.comparing(Libro::getPrecio));
        System.out.println(libroPorPrecio);

        System.out.println("==============CASO 4==============");
        List<Empleado> listaEmpleados = Arrays.asList(
                Empleado.builder()
                        .nombre("Lucía Fernández")
                        .departamento("Marketing Digital")
                        .edad(29)
                        .salario(4200.00)
                        .build(),

                Empleado.builder()
                        .nombre("Marcos Gómez")
                        .departamento("Desarrollo de Software")
                        .edad(33)
                        .salario(620.00)
                        .build(),

                Empleado.builder()
                        .nombre("Sofía Herrera")
                        .departamento("Marketing Digital")
                        .edad(27)
                        .salario(480.00)
                        .build(),

                Empleado.builder()
                        .nombre("Carlos Ramírez")
                        .departamento("Desarrollo de Software")
                        .edad(38)
                        .salario(7100.00)
                        .build(),

                Empleado.builder()
                        .nombre("Valentina Morales")
                        .departamento("Administración")
                        .edad(41)
                        .salario(5300.00)
                        .build(),

                Empleado.builder()
                        .nombre("Julián Torres")
                        .departamento("Administración")
                        .edad(25)
                        .salario(350.00)
                        .build()
        );

        System.out.println("EMPLEADOS CON SALARIO MAYOR A $2.000: ");
        listaEmpleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                .forEach(System.out::println);

        System.out.println("SALARIO PROMEDIO GENERAL: ");
        OptionalDouble promedioSalario = listaEmpleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average();
        System.out.println(promedioSalario.getAsDouble());

        System.out.println("SALARIO PROMEDIO POR DEPARTAMENTO: ");
        Map<String, Double> promedioDepto = listaEmpleados.stream()
                .collect(Collectors.groupingBy(
                                Empleado::getDepartamento, Collectors.summingDouble(Empleado::getSalario)));

        System.out.println(promedioDepto);

        System.out.println("LOS 2 EMPLEADOS MAS JOVENES: ");
        List<String> empleadoMasJoven = listaEmpleados.stream().
                sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
        System.out.println(empleadoMasJoven);

    }
}