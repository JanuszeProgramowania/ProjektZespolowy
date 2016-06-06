package com.janusze.projektzespolowy.company.dto;

import com.google.gson.*;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@EqualsAndHashCode(of = {"id"})
public class CompanyDTO implements Serializable{
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String name;
    private String address;
    private String city;
    private String phone;

    public CompanyDTO(String stringJSON){
        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        Gson gson = builder.create();
        CompanyDTO company = gson.fromJson(stringJSON, CompanyDTO.class);
        this.id = company.getId();
        this.dataUtworzenia = company.getDataUtworzenia();
        this.dataModyfikacji = company.getDataModyfikacji();
        this.name = company.getName();
        this.address = company.getAddress();
        this.city = company.getCity();
        this.phone = company.getPhone();
    }

}
