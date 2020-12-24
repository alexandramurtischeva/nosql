package com.nosql.sasha.SQLEntity;


import javax.persistence.*;
import java.util.List;

@Entity
public class ModelSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @Column(name = "brand", nullable = true)
    private String brand;

    @Column(name = "firm", nullable = true)
    private String firm;
    @Column(name = "country", nullable = false)
    private String country;
    @OneToMany(mappedBy = "modelSQL", fetch = FetchType.LAZY)
    private List<PrinterSQL> printerSQLS;

    public ModelSQL(Long id, String typeName, String brand, String firm, String country) {
        this.id = id;
        this.typeName = typeName;
        this.brand = brand;
        this.firm = firm;
        this.country = country;
    }

    public ModelSQL(String typeName, String brand, String firm, String country) {
        this.typeName = typeName;
        this.brand = brand;
        this.firm = firm;
        this.country = country;
    }

    public ModelSQL() {
        typeName = " Series AA312";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public List<PrinterSQL> getPrinterSQLS() {
        return printerSQLS;
    }

    public void setPrinterSQLS(List<PrinterSQL> printerSQLS) {
        this.printerSQLS = printerSQLS;
    }

    @Override
    public String toString() {
        return "ModelSQL{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", brand='" + brand + '\'' +
                ", firm='" + firm + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

