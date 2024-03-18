package Contraloria.MsDespacho.model;

import Contraloria.MsDespacho.model.base.BaseModel;
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



@Entity
@Table(name = "CARGOADICIONAL")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE CARGOADICIONAL SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class CargoAdicional extends BaseModel{
    
    @Column(name = "numeroDocumento", nullable = true, length = 100)
    public String numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "idCargoDistribucion", nullable = true)
    CargoDistribucion cargoDistribucion;
}   
