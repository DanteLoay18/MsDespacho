package Contraloria.MsDespacho.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import Contraloria.MsDespacho.model.base.BaseModel;



@Entity
@Table(name = "MGDE_DOCUMENTO")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_DOCUMENTO SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class Documento extends BaseModel{

    @Column(name = "tipoDocumento", nullable = false) 
    int tipoDocumento;

    @Column(name = "numeroDocumento", nullable = false, length = 50)
    String numeroDocumento;

    @Column(name = "fechaDocumento", nullable = false)
    Date fechaDocumento;

    @Column(name = "movimiento", nullable = false)
    int movimiento;

    @Column(name = "fechaIngreso", nullable = false)
    Date fechaIngreso;

    @Column(name = "clase", nullable = false)
    int clase;

    @Column(name = "fechaEnvio", nullable = false)
    Date fechaEnvio;

    @Column(name = "fechaRevision", nullable = false)
    Date fechaRevision;

    @Column(name = "flujo", nullable = false, length = 100)
    String flujo;

    @Column(name = "ddjj", nullable = false, length = 100)
    String ddjj;

    @Column(name = "notas", nullable = false, length = 500)
    String notas;
}
