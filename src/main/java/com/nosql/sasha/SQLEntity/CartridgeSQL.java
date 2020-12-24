package com.nosql.sasha.SQLEntity;


import javax.persistence.*;
import java.util.List;

@Entity
public class CartridgeSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tittle", nullable = false)
    private String tittle;

    @Column(name = "print_capacity", nullable = false)
    private Integer print_capacity;

    @Column(name = "firm")
    private String firm;

    @Column(name = "life_time", nullable = false)
    private Double life_time;

    @Column(name = "colors", nullable = false)
    private String colors;
    @Column(name = "ink_type")
    private String ink_type;
    @OneToMany(mappedBy = "cartridgeSQL", fetch = FetchType.LAZY)
    private List<TypeSQL> typeSQLS;

    public CartridgeSQL() {
    }

    public CartridgeSQL(Long id, String tittle, Integer print_capacity, String firm, Double life_time, String colors, String ink_type) {
        this.id = id;
        this.tittle = tittle;
        this.print_capacity = print_capacity;
        this.firm = firm;
        this.life_time = life_time;
        this.colors = colors;
        this.ink_type = ink_type;
    }

    public CartridgeSQL(String tittle, Integer print_capacity, String firm, Double life_time, String colors, String ink_type) {
        this.tittle = tittle;
        this.print_capacity = print_capacity;
        this.firm = firm;
        this.life_time = life_time;
        this.colors = colors;
        this.ink_type = ink_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrint_capacity() {
        return print_capacity;
    }

    public void setPrint_capacity(Integer print_capacity) {
        this.print_capacity = print_capacity;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public Double getLife_time() {
        return life_time;
    }

    public void setLife_time(Double life_time) {
        this.life_time = life_time;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getInk_type() {
        return ink_type;
    }

    public void setInk_type(String ink_type) {
        this.ink_type = ink_type;
    }

    public List<TypeSQL> getTypeSQLS() {
        return typeSQLS;
    }

    public void setTypeSQLS(List<TypeSQL> typeSQLS) {
        this.typeSQLS = typeSQLS;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "CartridgeSQL{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", print_capacity=" + print_capacity +
                ", firm='" + firm + '\'' +
                ", life_time=" + life_time +
                ", colors='" + colors + '\'' +
                ", ink_type='" + ink_type + '\'' +
                '}';
    }
}
