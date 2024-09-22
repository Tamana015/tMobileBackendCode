package com.deutsche.telco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "recharge_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RechargePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String planType;
    private String title;
    private String price;
    private String data;
    private String validity;
    private String voiceCalls;
    private String sms;
    private String specialNote;
    private String dataBonus;
    private String internationalCalls;
    private String specialFeatures;
}
