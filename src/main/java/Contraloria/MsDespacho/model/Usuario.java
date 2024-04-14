package Contraloria.MsDespacho.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import Contraloria.MsDespacho.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MGDE_USUARIOS")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_USUARIOS SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class Usuario extends BaseModel{

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

   
    @Column(name = "apellidoPaterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "pais", nullable = true)
    private String pais;

    @Column(name = "departamento", nullable = true)
    private String departamento;

    @Column(name = "provincia", nullable = true)
    private String provincia;

    @Column(name = "distrito", nullable = true)
    private String distrito;

    @Column(name = "tipoDocumento", nullable = false)
    private String tipoDocumento;

    @Column(name = "numeroDocumento", nullable = false)
    private String numeroDocumento;

    @Column(name = "razonSocial", nullable = true)
    private String razonSocial;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "fechaInicio", nullable = false)
    private String fechaInicio;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "esActivo", nullable = false)
    private boolean esActivo;

    
}
