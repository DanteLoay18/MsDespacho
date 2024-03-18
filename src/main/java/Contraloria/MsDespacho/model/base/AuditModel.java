package Contraloria.MsDespacho.model.base;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class AuditModel {

    @Column(name = "fechaCreacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "usuarioCreacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fechaModificacion", nullable = true)
    private Date fechaModificacion;

    @Column(name = "usuarioModificacion", nullable = true)
    private String usuarioModificacion;

    @Column(name = "fechaEliminacion", nullable = true)
    private Date fechaEliminacion;

    @Column(name = "usuarioEliminacion", nullable = true)
    private String usuarioEliminacion;
}
