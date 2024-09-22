package com.deutsche.telco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "otp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Otp {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_id")
        private Long userId;

        @Column(name = "email", length = 100)
        private String email;

        @Column(name = "otp")
        private Long otp;

        @Column(name = "expiry_time")
        private Timestamp expiryTime;

        @Column(name = "created_on")
        private Timestamp createdOn;

        @Column(name = "updated_on")
        private Timestamp updatedOn;

        @Column(name = "is_active")
        private Boolean isActive;

        @Lob
        @Column(name = "notes")
        private String notes;


        @PrePersist
        protected void onCreate() {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            this.createdOn = now;
            this.updatedOn = now;
        }

        @PreUpdate
        protected void onUpdate() {
            this.updatedOn = new Timestamp(System.currentTimeMillis());
        }
}
