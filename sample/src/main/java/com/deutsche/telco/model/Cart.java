package com.deutsche.telco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_on", updatable = false)
    @CreationTimestamp
    private Timestamp createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Timestamp updatedOn;

//    @ManyToOne
//    private ParentCart parentCart;

    private String email;

    private String note;

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "device_plan_id")
    List<DevicePlan> devicePlanList;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "recharge_plan_id")
    List<RechargePlan> rechargePlanList;
}
