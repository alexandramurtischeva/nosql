package com.nosql.sasha.SQLEntity;


import javax.persistence.*;

@Entity
public class PrinterSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "color", nullable = false)
    private String color;


    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "type_id", nullable = false)
    private TypeSQL typeSQL;


    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "model_id", nullable = false)
    private ModelSQL modelSQL;

    public PrinterSQL() {

    }

    public PrinterSQL(Long id, String name, Double price, String color, TypeSQL typeSQL, ModelSQL modelSQL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.typeSQL = typeSQL;
        this.modelSQL = modelSQL;
    }

    public PrinterSQL(String name, Double price, String color, TypeSQL typeSQL, ModelSQL modelSQL) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.typeSQL = typeSQL;
        this.modelSQL = modelSQL;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TypeSQL getTypeSQL() {
        return typeSQL;
    }

    public void setTypeSQL(TypeSQL typeSQL) {
        this.typeSQL = typeSQL;
    }

    public ModelSQL getModelSQL() {
        return modelSQL;
    }

    public void setModelSQL(ModelSQL modelSQL) {
        this.modelSQL = modelSQL;
    }

    @Override
    public String toString() {
        return "PrinterSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", typeSQL=" + typeSQL +
                ", modelSQL=" + modelSQL +
                '}';
    }
}
