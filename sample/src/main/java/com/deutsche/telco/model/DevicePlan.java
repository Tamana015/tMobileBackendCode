package com.deutsche.telco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "device_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevicePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String deviceType;
    String name;
    String fullModel;
    String colors;
    String storageOptions;
    String imageUrl;
    String rating;
}
