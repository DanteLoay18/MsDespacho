package Contraloria.MsDespacho.model;

import java.sql.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import Contraloria.MsDespacho.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENTREGAS")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE ENUMERADOS SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class Entrega extends BaseModel{
    
    @Column(name = "nroDocumento", nullable = false)
    String nroDocumento;

    @Column(name = "fechaDeIngreso", nullable = false)
    Date fechaDeIngresa;

    @Column(name = "codigo", nullable = false)
    String codigo;

    @Column(name = "entidad", nullable = false)
    String entidad;

    @Column(name = "asunto", nullable = false)
    String asunto;

    @Column(name = "noCto", nullable = false)
    String noCto;

    @Column(name = "documentosAdicionales", nullable = false)
    String documentosAdicionales;

}
