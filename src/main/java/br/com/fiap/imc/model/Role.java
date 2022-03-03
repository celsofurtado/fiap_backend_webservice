package br.com.fiap.imc.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "role")
public class Role implements GrantedAuthority{

    public Role(){}

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    private String name;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
