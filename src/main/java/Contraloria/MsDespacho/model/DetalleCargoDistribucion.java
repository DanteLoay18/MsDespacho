package Contraloria.MsDespacho.model;

import Contraloria.MsDespacho.model.base.BaseModel;

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
@Table(name = "DETALLECARGODISTRIBUCION")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE DETALLECARGODISTRIBUCION SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class DetalleCargoDistribucion extends BaseModel{
    
    @ManyToOne
    @JoinColumn(name = "idCargo", nullable = true)
    Cargo cargo;


    @ManyToOne
    @JoinColumn(name = "idCargoDistribucion", nullable = true)
    CargoDistribucion cargoDistribucion;




}
