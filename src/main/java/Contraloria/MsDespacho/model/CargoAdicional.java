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
@Table(name = "MGDE_CARGOADICIONAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGOADICIONAL SET NCARADI_ESELIMINADO = 1 WHERE NCARADI_ID = ?")
@SQLRestriction(value = "NCARADI_ESELIMINADO = 0")
public class CargoAdicional{
    
    @Column(name = "NCARADI_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CCARADI_NUMDOCUMENTO", nullable = true, length = 100)
    public String numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "NCARADI_IDCARGODISTRIBUCION", nullable = true)
    CargoDistribucion cargoDistribucion;

    @Column(name = "NCARADI_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "NCARADI_USUCREACION", nullable = true)
    private Integer usuarioCreacion;

    @Column(name = "DCARADI_FECCREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "NCARADI_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DCARADI_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NCARADI_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

    @Column(name = "DCARADI_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;
}   
