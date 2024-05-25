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

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Date;

@Entity
@Table(name = "MGDE_CARGODEVOLUCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGODEVOLUCION SET NDEV_ESELIMINADO = 1 WHERE NDEV_ID = ?")
@SQLRestriction(value = "NDEV_ESELIMINADO = 0")
public class CargoDevolucion{
    
    @Column(name = "NDEV_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "NDEV_IDCARGODISTRIBUCION", nullable = true)
    CargoDistribucion cargoDistribucion;

    @Column(name = "NDEV_IDUSUARIORECIBE", nullable = true)
    public int idUsuarioRecibe;

    @Column(name = "NDEV_IDSEDEDESTINO", nullable = true)
    public int idSedeDestino;

    @Column(name = "DDEV_FECDEVOLUCION", nullable = true)
    public Date fechaDevolucion;

    @Column(name = "NDEV_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NDEV_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DDEV_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NDEV_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DDEV_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NDEV_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DDEV_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}
