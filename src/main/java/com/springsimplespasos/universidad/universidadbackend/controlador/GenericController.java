package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

@Deprecated
public class GenericController <E, S extends GenericoDAO<E>> {

    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();

        if(listado.isEmpty()) {
            //throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", listado);

        return ResponseEntity.ok(mensaje);
    }


    //obtener un registro por id
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable(required = false) Integer id){
        Map<String, Object> mesnsaje = new HashMap<>();
        Optional<E> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()) {
            mesnsaje.put("success", Boolean.FALSE);
            mesnsaje.put("mensaje", String.format("Alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(mesnsaje);
        }
        mesnsaje.put("success", Boolean.TRUE);
        mesnsaje.put("datos", oAlumno.get());
        return ResponseEntity.ok(mesnsaje);
    }

    //crear un registro
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody E entidad, BindingResult result){
        Map<String, Object> mesnsaje = new HashMap<>();
        if(result.hasErrors()) {
            mesnsaje.put("success", Boolean.FALSE);
            mesnsaje.put("errores", result.getAllErrors());
            return ResponseEntity.badRequest().body(mesnsaje);
        }
        service.save(entidad);
        mesnsaje.put("success", Boolean.TRUE);
        mesnsaje.put("mensaje", String.format("%s creado con éxito", nombreEntidad));
        return ResponseEntity.ok(mesnsaje);
    }

    //eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(required = false) Integer id){
        Map<String, Object> mesnsaje = new HashMap<>();
        Optional<E> oAlumno = service.findById(id);
        if(!oAlumno.isPresent()) {
            mesnsaje.put("success", Boolean.FALSE);
            mesnsaje.put("mensaje", String.format("Alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(mesnsaje);
        }
        service.deleteById(id);
        mesnsaje.put("success", Boolean.TRUE);
        mesnsaje.put("datos", oAlumno.get());
        return ResponseEntity.ok(mesnsaje);
    }

}
