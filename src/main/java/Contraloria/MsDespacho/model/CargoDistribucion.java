package Contraloria.MsDespacho.model;

import Contraloria.MsDespacho.model.base.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "MGDE_CARGODISTRIBUCION")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CARGODISTRIBUCION SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class CargoDistribucion extends BaseModel{

    @Column(name = "numeroCargo", nullable = true)
    public int numeroCargo;

    @Column(name = "fechaCargo", nullable = true)
    public Date fechaCargo;
    
    @Column(name = "idSedeDestino", nullable = true)
    public int idSedeDestino;

    @OneToMany(mappedBy = "cargoDistribucion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCargoDistribucion> cargos = new ArrayList<>();

    @OneToMany(mappedBy = "cargoDistribucion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CargoAdicional> cargosAdicionales = new ArrayList<>();
}
