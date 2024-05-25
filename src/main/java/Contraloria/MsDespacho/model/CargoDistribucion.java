package Contraloria.MsDespacho.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_CARGODISTRIBUCION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGODISTRIBUCION SET NDIST_ESELIMINADO = 1 WHERE NDIST_ID = ?")
@SQLRestriction(value = "NDIST_ESELIMINADO = 0")
public class CargoDistribucion{

    @Column(name = "NDIST_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CDIST_NUMCARGO", nullable = true)
    public int numeroCargo;

    @Column(name = "DDIST_FECCARGO", nullable = true)
    public Date fechaCargo;
    
    @Column(name = "NDIST_IDSEDEDESTINO", nullable = true)
    public int idSedeDestino;

    @OneToMany(mappedBy = "cargoDistribucion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCargoDistribucion> cargos = new ArrayList<>();

   @OneToMany(mappedBy = "cargoDistribucion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CargoAdicional> cargosAdicionales = new ArrayList<>();

    @Column(name = "NDIST_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NDIST_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DDIST_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NDIST_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DDIST_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NDIST_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DDIST_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}
