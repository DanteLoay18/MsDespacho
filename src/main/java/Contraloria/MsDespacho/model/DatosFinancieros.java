package Contraloria.MsDespacho.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import Contraloria.MsDespacho.model.base.BaseModel;

@Entity
@Table(name = "MGDE_DATOSFINANCIEROS")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_DATOSFINANCIEROS SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class DatosFinancieros extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    Proveedor proveedor;

    @Column(name = "tipoContrato", nullable = true)
    int tipoContrato;

    @Column(name = "nroContrato", nullable = true)
    int nroContrato;

    @Column(name = "archivoContrato",length=100, nullable = true)
    String archivoContrato;

    @Column(name = "fechaInicio", nullable = true)
    Date fechaInicio;

    @Column(name = "fechaFin", nullable = true)
    Date fechaFin;

    @Column(name = "fechaConsulta", nullable = true)
    Date fechaConsulta;

    @Column(name = "estado", nullable = true)
    int estado;

    @Column(name = "tipoServicio", nullable = true)
    int tipoServicio;

    @Column(name = "montoContrato")
    double montoContrato;

    @Column(name = "saldoContrato")
    double saldoContrato;
}

