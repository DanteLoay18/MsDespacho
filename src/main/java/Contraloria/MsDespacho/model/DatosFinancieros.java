package Contraloria.MsDespacho.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_DATOSFINANCIEROS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_DATOSFINANCIEROS SET ES_ELIMINADO = 1 WHERE NFIN_ID = ?")
@SQLRestriction(value = "NFIN_ESELIMINADO = 0")
public class DatosFinancieros{
   
    @Column(name = "NFIN_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    @ManyToOne
    @JoinColumn(name = "NFIN_IDFINEEDOR", nullable = false)
    Proveedor proveedor;

    @Column(name = "NCAT_TIPOCONTRATO", nullable = true)
    Integer tipoContrato;

    @Column(name = "CFIN_NROCONTRATO", nullable = true)
    Integer nroContrato;

    @Column(name = "CFIN_ARCHCONTRANTO",length=100, nullable = true)
    String archivoContrato;

    @Column(name = "CFIN_FECINICIO", nullable = true)
    Date fechaInicio;

    @Column(name = "CFIN_FECFIN", nullable = true)
    Date fechaFin;

    @Column(name = "CFIN_FECCONSULTA", nullable = true)
    Date fechaConsulta;

    @Column(name = "CCAT_TIPOSERVICIO", nullable = true)
    Integer tipoServicio;

    @Column(name = "CFIN_MONCONTRATO")
    Double montoContrato;

    @Column(name = "NFIN_SALCONTRATO")
    Double saldoContrato;
    
    @Column(name = "NCAT_ESTFINANCIERO", nullable = true)
    Integer estado;

    @Column(name = "NFIN_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NFIN_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DFIN_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NFIN_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DFIN_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NFIN_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DFIN_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}

