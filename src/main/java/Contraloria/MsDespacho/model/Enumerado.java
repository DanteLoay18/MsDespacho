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
@Table(name = "ENUMERADOS")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE ENUMERADOS SET ES_ELIMINADO = 1 WHERE ID = ?")
@SQLRestriction(value = "ES_ELIMINADO = 0")
public class Enumerado extends BaseModel{
    
    @ManyToOne
    @JoinColumn(name = "idPadre", nullable = true)
    private Enumerado padre;

    @Column(name = "codigo", nullable = true)
    private int codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "abreviatura", nullable = true)
    private String abreviatura;

    @Column(name = "valor", nullable = true)
    private String valor;

    @Column(name = "orden", nullable = true)
    private int orden;
}
