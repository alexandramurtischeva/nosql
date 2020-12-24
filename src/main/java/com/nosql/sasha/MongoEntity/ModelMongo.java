package com.nosql.sasha.MongoEntity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Model")
public class ModelMongo {
    @Id
    private String id;

    @Field(name = "type_name")
    private String typeName;

    @Field(name = "brand")
    private String brand;

    @Field(name = "firm")
    private String firm;
    @Field(name = "country")
    private String country = "Ukraine";

    public ModelMongo() {
        typeName = " Series AA312";
    }

    public ModelMongo(String typeName, String brand, String firm, String country) {
        this.typeName = typeName;
        this.brand = brand;
        this.firm = firm;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {
        return "ModelMongo{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", brand='" + brand + '\'' +
                ", firm='" + firm + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

