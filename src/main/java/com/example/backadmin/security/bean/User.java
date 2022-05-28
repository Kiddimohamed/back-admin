package com.example.backadmin.security.bean;

import com.example.backadmin.bean.ExpressionBesoin;
import com.example.backadmin.bean.ServiceDemandeur;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

   // @ManyToOne
   // private ServiceDemandeur serviceDemandeur;

    @OneToMany
    private List<ExpressionBesoin> expressionBesoins;

   // public ServiceDemandeur getServiceDemandeur() {return serviceDemandeur;}

    //public void setServiceDemandeur(ServiceDemandeur serviceDemandeur) {this.serviceDemandeur = serviceDemandeur;}

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }


    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }



    public List<ExpressionBesoin> getExpressionBesoins() {
        return expressionBesoins;
    }

    public void setExpressionBesoins(List<ExpressionBesoin> expressionBesoins) {
        this.expressionBesoins = expressionBesoins;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
