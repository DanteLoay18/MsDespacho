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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import Contraloria.MsDespacho.model.base.BaseModel;
import java.sql.Date;

@Entity
@Table(name = "MGDE_CARGODEVOLUCION")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGODEVOLUCION SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class CargoDevolucion extends BaseModel{
    

    @ManyToOne
    @JoinColumn(name = "idCargoDistribucion", nullable = true)
    CargoDistribucion cargoDistribucion;

    @Column(name = "idUsuarioRecibe", nullable = true)
    public int idUsuarioRecibe;

    @Column(name = "idSedeDestino", nullable = true)
    public int idSedeDestino;

    @Column(name = "fechaDevolucion", nullable = true)
    public Date fechaDevolucion;
}
