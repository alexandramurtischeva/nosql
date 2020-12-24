package com.nosql.sasha.MongoEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Type")
public class TypeMongo {
    @Id
    private String id;

    @Field(name = "name")
    private String name = "Inject";

    @Field(name = "description")
    private String description;

    @Field(name = "cartridge")
    private CartridgeMongo cartridgeMongo;

    public TypeMongo(String name, String description, CartridgeMongo cartridgeMongo) {
        this.name = name;
        this.description = description;
        this.cartridgeMongo = cartridgeMongo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public CartridgeMongo getCartridgeMongo() {
        return cartridgeMongo;
    }

    public void setCartridgeMongo(CartridgeMongo cartridgeMongo) {
        this.cartridgeMongo = cartridgeMongo;
    }

    @Override
    public String toString() {
        return "TypeMongo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cartridgeMongo=" + cartridgeMongo +
                '}';
    }
}
