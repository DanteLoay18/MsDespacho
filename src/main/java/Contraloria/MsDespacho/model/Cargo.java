package Contraloria.MsDespacho.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_CARGO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGO SET NCAR_ESELIMINADO = 1 WHERE NCAR_ID = ?")
@SQLRestriction(value = "NCAR_ESELIMINADO = 0")
public class Cargo{

    @Column(name = "NCAR_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "NCAR_IDDOCUMENTO", nullable = true)
    Documento documento;

    @Column(name = "NCAR_IDSEDEDESTINO", nullable = false)
    int idSedeDestino;

    @Column(name = "CCAR_FECRECEPCION", nullable = false)
    Date fechaRecepcion;

    @Column(name = "CCAR_FECRETORNO", nullable = false)
    Date fechaRetorno;
    
    @Column(name = "CCAR_NROINTENTO", nullable = false)
    int intento;

    @Column(name = "CCAT_TIPODEVOLUCION", nullable = true)
    int enuMotivoDevolucion;

    @Column(name = "descMotivoDevolucion", nullable = true, length = 100)
    String descMotivoDevolucion;

    @Column(name = "CCAR_NOTAS", nullable = true, length = 500)
    String notas;

    @Column(name = "codigoBarra", nullable = true, length = 50)
    String codigoBarra;

    @Column(name = "NCAR_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NCAR_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DCAR_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NCAR_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DCAR_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NCAR_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DCAR_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}
