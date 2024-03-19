package com.playground.bodyoft.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerimetryModel {
    private float stature;
    private float weight;
    private float fat;
    private float fatPercentage;
    private float leanMass;
    private float leanMassPercentage;
    private float basalMetabolism;
    private float bodyAge;
    private float visceralFatpercentage;

    //Diameter
    private float rightArm;
    private float leftArm;
    private float shoulder;
    private float chest;
    private float waist;
    private float abdomen;
    private float hip;
    private float rightThigh;
    private float leftThigh;
    private float rightCalf;
    private float leftCalf;
}
