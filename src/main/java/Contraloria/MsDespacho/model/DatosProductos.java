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

import java.util.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_DATOSPRODUCTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_DATOSPRODUCTOS SET NPROD_ESELIMINADO = 1 WHERE NPROD_ID = ?")
@SQLRestriction(value = "NPROD_ESELIMINADO = 0")
public class DatosProductos{
    
    @Column(name = "NPROD_ID")
    @Id
    @GeneratedValue(strategy = GenerationType .AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "NPROD_IDPROVEEDOR", nullable = false)
    Proveedor proveedor;

    @Column(name = "NPROD_CODIGO",length=15, nullable = true)
    String codigo;

    @Column(name = "CCAT_TIPOSERVICIO", nullable = true)
    int tipoServicio;

    @Column(name = "CCAT_TIPOACCESO", nullable = true)
    int tipoAcceso;

    @Column(name = "CCAT_TIPOENTREGA", nullable = true)
    int tipoEntrega;

    @Column(name = "CCAT_ESTENTREGA", nullable = true)
    int estadoEntrega;

    @Column(name = "CPROD_PLAENTREGA", nullable = true)
    int plazoEntrega;

    @Column(name = "CPROD_PLARETORNO", nullable = true)
    int plazoRetorno;

    @Column(name = "CPROD_PAIS", nullable = true)
    int pais;

    @Column(name = "NPROD_UBIGEO",length=6, nullable = true)
    String ubigeo;

    @Column(name = "NPROD_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NPROD_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DPROD_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NPROD_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DPROD_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NPROD_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DPROD_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}
