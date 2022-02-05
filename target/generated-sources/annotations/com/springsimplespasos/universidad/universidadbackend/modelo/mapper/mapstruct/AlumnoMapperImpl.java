package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-05T18:45:17-0500",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class AlumnoMapperImpl extends AlumnoMapper {

    @Override
    public AlumnoDTO mapAlumno(Alumno alumno) {
        if ( alumno == null ) {
            return null;
        }

        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setApellido( alumno.getApellido() );
        alumnoDTO.setDireccion( alumno.getDireccion() );
        alumnoDTO.setDni( alumno.getDni() );
        alumnoDTO.setId( alumno.getId() );
        alumnoDTO.setNombre( alumno.getNombre() );

        return alumnoDTO;
    }

    @Override
    public Alumno mapAlumno(AlumnoDTO alumnoDTO) {
        if ( alumnoDTO == null ) {
            return null;
        }

        Alumno alumno = new Alumno();

        alumno.setId( alumnoDTO.getId() );
        alumno.setNombre( alumnoDTO.getNombre() );
        alumno.setApellido( alumnoDTO.getApellido() );
        alumno.setDni( alumnoDTO.getDni() );
        alumno.setDireccion( alumnoDTO.getDireccion() );

        return alumno;
    }
}
