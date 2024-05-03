package Contraloria.MsDespacho.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import Contraloria.MsDespacho.model.base.BaseModel;

@Entity
@Table(name = "MGDE_PROVEEDOR")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_PROVEEDOR SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class Proveedor extends BaseModel{

    @Column(name = "tipoProveedor", nullable = false)
    int tipoProveedor;

    @Column(name = "tipoDocumento", nullable = false)
    int tipoDocumento;

    @Column(name = "numeroDocumento",length=15, nullable = false)
    String numeroDocumento;

    @Column(name = "apellidoPaterno",length=50, nullable = false)
    String apellidoPaterno;

    @Column(name = "apellidoMaterno",length=50, nullable = false)
    String apellidoMaterno;

    @Column(name = "nombres",length=100, nullable = false)
    String nombres;

    @Column(name = "telefono",length=15, nullable = true)
    String telefono;

    @Column(name = "celular",length=15, nullable = true)
    String celular;

    @Column(name = "correo",length=100, nullable = true)
    String correo;

    @Column(name = "estado", nullable = true)
    int estado;

    @Column(name = "pais", nullable = true)
    int pais;

    @Column(name = "ubigeo",length=6, nullable = true)
    String ubigeo;

    @Column(name = "direccionRENIEC",length=250, nullable = true)
    String direccionRENIEC;

    @Column(name = "direccion",length=250, nullable = true)
    String direccion;

    @Column(name = "representanteLegal",length=250, nullable = true)
    String representanteLegal;

    @Column(name = "paginaWeb",length=250, nullable = true)
    String paginaWeb;

    @Column(name = "tipoDeServicio", nullable = true)
    int tipoDeServicio;
}
