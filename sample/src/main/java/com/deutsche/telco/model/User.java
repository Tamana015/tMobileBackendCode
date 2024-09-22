package com.deutsche.telco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "doj", updatable = false)
    private Timestamp doj;

    @Column(name = "created_on", updatable = false)
    @CreationTimestamp
    private Timestamp createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Timestamp updatedOn;

    @Column(name = "is_active")
    private Boolean isActive;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Column(name = "role", length = 64)
    private String role;

    @Column(name = "group_list")
    String groupList;

    @Column(name = "mobile_number")
    String mobileNumber;

    @OneToOne
    ParentCart parentCart;

    @OneToOne
    Cart cart;

    @PrePersist
    protected void onCreate() {
        createdOn = new Timestamp(System.currentTimeMillis());
        doj = new Timestamp(System.currentTimeMillis());
        updatedOn = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // or set roles/authorities if needed
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}
