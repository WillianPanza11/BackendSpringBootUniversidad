package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-05T18:45:18-0500",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class CarreraMapperMSImpl implements CarreraMapperMS {

    @Override
    public CarreraDTO mapCarrera(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }

        CarreraDTO carreraDTO = new CarreraDTO();

        carreraDTO.setCodigo( carrera.getId() );
        carreraDTO.setCantidad_materias( carrera.getCantidaMaterias() );
        carreraDTO.setCantidad_anios( carrera.getCantidadAnios() );
        carreraDTO.setNombre( carrera.getNombre() );

        return carreraDTO;
    }
}
