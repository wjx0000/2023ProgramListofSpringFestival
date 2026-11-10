package com.wjx.homework.NeedDelete;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"id","typeName","name","view","actorList","num"})

public class Program {

    public Integer id;

    @JsonProperty("type")
    public String typeName;

    public String name;

    @JsonProperty("point")
    public String view;

    @JsonProperty("actors")
    public String actorList;

}
