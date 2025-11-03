package Caso3;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Libro {
    private String nombre;
    private String autor;
    private double precio;
    private Integer paginas;
}
