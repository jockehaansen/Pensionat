package com.example.pensionat.Pensionat.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rum {

    @Id
    @GeneratedValue
    protected long id;
    protected boolean dubbelrum;
    protected int storlek;
    protected int numOfBeds;

    public Rum(boolean dubbelrum, int storlek, int numOfBeds) {
        this.dubbelrum = dubbelrum;
        this.storlek = storlek;
        this.numOfBeds=numOfBeds;
    }
}
