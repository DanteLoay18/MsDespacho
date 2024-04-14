package Contraloria.MsDespacho.model;

import java.sql.Date;

import Contraloria.MsDespacho.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_CARGO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGO SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class Cargo extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = true)
    Documento documento;

    @Column(name = "idSedeDestino", nullable = false)
    int idSedeDestino;

    @Column(name = "fechaRecepcion", nullable = false)
    Date fechaRecepcion;

    @Column(name = "fechaRetorno", nullable = false)
    Date fechaRetorno;
    
    @Column(name = "intento", nullable = false)
    int intento;

    @Column(name = "enuMotivoDevolucion", nullable = true)
    int enuMotivoDevolucion;

    @Column(name = "descMotivoDevolucion", nullable = true, length = 100)
    String descMotivoDevolucion;

    @Column(name = "notas", nullable = true, length = 500)
    String notas;

    @Column(name = "codigoBarra", nullable = true, length = 50)
    String codigoBarra;
    
}
