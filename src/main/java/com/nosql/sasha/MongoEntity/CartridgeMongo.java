package com.nosql.sasha.MongoEntity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Cartridge")
public class CartridgeMongo {
    @Id
    private String id;

    @Field(name = "tittle")
    private String tittle;

    @Field(name = "print_capacity")
    private Integer print_capacity;

    @Field(name = "firm")
    private String firm;

    @Field(name = "life_time")
    private Double life_time;

    @Field(name = "colors")
    private String colors = "black";
    @Field(name = "ink_type")
    private String ink_type;

    public CartridgeMongo(String tittle, Integer print_capacity, String firm, Double life_time, String colors, String ink_type) {
        this.tittle = tittle;
        this.print_capacity = print_capacity;
        this.firm = firm;
        this.life_time = life_time;
        this.colors = colors;
        this.ink_type = ink_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "CartridgeMongo{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", print_capacity=" + print_capacity +
                ", firm='" + firm + '\'' +
                ", life_time=" + life_time +
                ", colors='" + colors + '\'' +
                ", ink_type='" + ink_type + '\'' +
                '}';
    }
}
