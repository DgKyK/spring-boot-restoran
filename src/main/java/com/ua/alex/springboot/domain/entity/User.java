package com.ua.alex.springboot.domain.entity;

import com.ua.alex.springboot.domain.entity.enums.Role;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Pattern(regexp = "[^_\\\\.&,#@!\\\\?\\\\(\\\\)\\-\\\\=\\\\+\\\\\\\\`\\\\~\\s][A-za-z]{1,5}[A-Za-z0-9_]{0,15}",
            message = "{message.loginrules}")
    private String name;
    @NotBlank(message = "{message.passwordnotempty}")
    private String password;
    @Email(message = "{message.emailcorrect}")
    @NotBlank(message = "{message.emailcorrect}")
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user_id")
    private List<Order> orders;
    private boolean accountStatus;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getUsername() {
        return name;
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
        return isAccountStatus();
    }

    public boolean isUser() {
        return role == Role.USER;
    }

    public boolean isAdmin() {
        return role == Role.ADMIN;
    }
}
