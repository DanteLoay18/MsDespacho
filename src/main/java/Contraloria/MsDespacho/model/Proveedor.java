package Contraloria.MsDespacho.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_PROVEEDOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_PROVEEDOR SET NCAT_ESELIMINADO = 1 WHERE NPROV_ID = ?")
@SQLRestriction(value = "NPROV_ESELIMINADO = 0")
public class Proveedor{

    @Column(name = "NPROV_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NCAT_TIPOPROVEEDOR", nullable = false)
    Integer tipoProveedor;

    @Column(name = "NCAT_TIPODOCUMENTO", nullable = false)
    Integer tipoDocumento;

    @Column(name = "CPROV_NUMDOCUMENTO",length=15, nullable = false)
    String numeroDocumento;

    @Column(name = "CPROV_APEPATERNO",length=50, nullable = false)
    String apellidoPaterno;

    @Column(name = "CPROV_APEMATERNO",length=50, nullable = false)
    String apellidoMaterno;

    @Column(name = "CPROV_NOMBRES",length=100, nullable = false)
    String nombres;

    @Column(name = "CPROV_TELEFONO",length=15, nullable = true)
    String telefono;

    @Column(name = "CPROV_CELULAR",length=15, nullable = true)
    String celular;

    @Column(name = "CPROV_CORREO",length=100, nullable = true)
    String correo;

    @Column(name = "NPROV_PAIS", nullable = true)
    Integer pais;

    @Column(name = "CPROV_UBIGEO",length=6, nullable = true)
    String ubigeo;

    @Column(name = "CPROV_DIRRENIECSUNAT",length=250, nullable = true)
    String direccionRENIEC;

    @Column(name = "CPROV_DIRECCION",length=250, nullable = true)
    String direccion;

    @Column(name = "CPROV_REPLEGAL",length=250, nullable = true)
    String representanteLegal;

    @Column(name = "CPROV_PAGWEB",length=250, nullable = true)
    String paginaWeb;

    @Column(name = "NCAT_TIPOSERVICIO", nullable = true)
    Integer tipoDeServicio;
    
    @Column(name = "NCAT_ESTPROVEEDOR", nullable = true)
    Integer estado;

    @Column(name = "NPROV_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NPROV_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DPROV_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NPROV_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DPROV_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NPROV_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DPROV_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}

