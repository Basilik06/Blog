package com.crud.demo.interfaces;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.crud.demo.modelo.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByUsuario_Id(Integer id);

    @Query("SELECT n FROM Notificacion n WHERE n.usuario.id = :idUsuario AND n.leida = false")
    List<Notificacion> findNotificacionesNoLeidasPorUsuario(@Param("idUsuario") Integer idUsuario);
}