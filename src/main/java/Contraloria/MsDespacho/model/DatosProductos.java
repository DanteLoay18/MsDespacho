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

@Entity
@Table(name = "MGDE_DATOSPRODUCTOS")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_DATOSPRODUCTOS SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class DatosProductos extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    Proveedor proveedor;

    @Column(name = "codigo",length=15, nullable = true)
    String codigo;

    @Column(name = "tipoServicio", nullable = true)
    int tipoServicio;

    @Column(name = "tipoAcceso", nullable = true)
    int tipoAcceso;

    @Column(name = "tipoEntrega", nullable = true)
    int tipoEntrega;

    @Column(name = "estadoEntrega", nullable = true)
    int estadoEntrega;

    @Column(name = "plazoEntrega", nullable = true)
    int plazoEntrega;

    @Column(name = "plazoRetorno", nullable = true)
    int plazoRetorno;

    @Column(name = "pais", nullable = true)
    int pais;

    @Column(name = "ubigeo",length=6, nullable = true)
    String ubigeo;
}
