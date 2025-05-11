package com.crud.demo.controler;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.crud.demo.interfaceService.FotosService;
import com.crud.demo.modelo.fotos;

@RestController
@RequestMapping("/fotos")
@CrossOrigin(origins = "*")
public class FotosController {

    @Autowired
    private FotosService service;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarFoto(@RequestParam("nombre") String nombre,
            @RequestParam("correo") String correo,
            @RequestParam("imagen") MultipartFile imagen) {
        if (imagen.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La imagen no puede estar vacía");
        }

        // Validar el tipo de archivo
        String contentType = imagen.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El archivo debe ser una imagen (JPEG, PNG, GIF, WebP)");
        }

        // Validar el tamaño del archivo (máximo 5MB)
        long maxSize = 5 * 1024 * 1024; // 5MB en bytes
        if (imagen.getSize() > maxSize) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El archivo es demasiado grande. El tamaño máximo permitido es 5MB.");
        }

        // Verificar si ya existe una foto para este correo
        List<fotos> fotosExistentes = service.listar().stream()
                .filter(foto -> foto.getCorreo().equalsIgnoreCase(correo))
                .toList();
        if (!fotosExistentes.isEmpty()) {
            // Eliminar la foto existente
            for (fotos foto : fotosExistentes) {
                service.delete(foto.getId());
            }
        }

        fotos f = new fotos();
        f.setNombre(nombre);
        f.setCorreo(correo);
        f.setContentType(contentType);
        try {
            f.setImagen(imagen.getBytes());
            int id = service.save(f);
            return ResponseEntity.ok(id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al procesar la imagen: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/imagen")
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable int id) {
        Optional<fotos> foto = service.listarId(id);
        if (foto.isPresent()) {
            MediaType mediaType;
            String contentType = foto.get().getContentType();
            try {
                mediaType = contentType != null ? MediaType.parseMediaType(contentType) : MediaType.IMAGE_JPEG;
            } catch (Exception e) {
                mediaType = MediaType.IMAGE_JPEG; // Fallback a JPEG si hay error
            }
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(foto.get().getImagen());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<fotos>> buscarPorCorreo(@RequestParam("correo") String correo) {
        List<fotos> fotos = service.listar().stream()
                .filter(foto -> foto.getCorreo().equalsIgnoreCase(correo))
                .toList();
        return ResponseEntity.ok(fotos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarFoto(@PathVariable int id) {
        if (!service.listarId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}