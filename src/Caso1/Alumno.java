package Caso1;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Alumno {
    private String nombre;
    private int nota;
    private String curso;
}
