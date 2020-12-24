package com.nosql.sasha.SQLEntity;

import javax.persistence.*;
import java.util.List;


@Entity
public class TypeSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "typeSQL", fetch = FetchType.LAZY)
    private List<PrinterSQL> printerSQLS;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cartridge")
    private CartridgeSQL cartridgeSQL;

    public TypeSQL() {
    }

    public TypeSQL(Long id, String name, String description, CartridgeSQL cartridgeSQL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cartridgeSQL = cartridgeSQL;
    }

    public TypeSQL(String name, String description, CartridgeSQL cartridgeSQL) {
        this.name = name;
        this.description = description;
        this.cartridgeSQL = cartridgeSQL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<PrinterSQL> getPrinterSQLS() {
        return printerSQLS;
    }

    public void setPrinterSQLS(List<PrinterSQL> printerSQLS) {
        this.printerSQLS = printerSQLS;
    }

    public CartridgeSQL getCartridgeSQL() {
        return cartridgeSQL;
    }

    public void setCartridgeSQL(CartridgeSQL cartridgeSQL) {
        this.cartridgeSQL = cartridgeSQL;
    }

    @Override
    public String toString() {
        return "TypeSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cartridgeSQL=" + cartridgeSQL +
                '}';
    }
}
