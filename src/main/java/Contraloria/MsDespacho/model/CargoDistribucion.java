package Contraloria.MsDespacho.model;

import Contraloria.MsDespacho.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "CARGODISTRIBUCION")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE CARGODISTRIBUCION SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class CargoDistribucion extends BaseModel{

    @Column(name = "numeroCargo", nullable = true, length = 50)
    public String numeroCargo;

    @Column(name = "fechaCargo", nullable = true)
    public Date fechaCargo;
    
    @Column(name = "idSedeDestino", nullable = true)
    public int idSedeDestino;
}
