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
@Table(name = "MGDE_CATALOGO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE MGDE_CATALOGO SET NCAT_ESELIMINADO = 1 WHERE NCAT_ID = ?")
@SQLRestriction(value = "NCAT_ESELIMINADO = 0")
public class Catalogo {

    @Column(name = "NCAT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "NCAT_IDPADRE", nullable = true)
    private Catalogo padre;

    @Column(name = "NCAT_CODIGO", nullable = true)
    private int codigo;

    @Column(name = "CCAT_DESCRIPCION", nullable = true)
    private String descripcion;

    @Column(name = "CCAT_VALOR", nullable = true)
    private String valor;

    @Column(name = "NCAT_ORDEN", nullable = true)
    private int orden;

    @Column(name = "NCAT_ESELIMINADO", nullable = false)
    private boolean esEliminado;

    @Column(name = "DCAT_FECCREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "NCAT_USUCREACION", nullable = false)
    private Integer usuarioCreacion;

    @Column(name = "DCAT_FECMODIFICACION", nullable = true)
    private Date fechaModificacion;

    @Column(name = "NCAT_USUMODIFICACION", nullable = true)
    private Integer usuarioModificacion;

    @Column(name = "DCAT_FECELIMINACION", nullable = true)
    private Date fechaEliminacion;

    @Column(name = "NCAT_USUELIMINACION", nullable = true)
    private Integer usuarioEliminacion;

}
