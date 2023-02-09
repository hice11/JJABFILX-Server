package com.group.jjabflix.user.vo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    private String birth;
    private Membership membership;
    private UserStatus status;

    private String cardNumber;
    private String cardExpirationDate;

    private LocalDateTime paidAt;
    private LocalDateTime createdAt;
    private LocalDateTime withdrawAt;

    private Role role;

    public User(String email, String password, String phoneNumber, String name, String birth, Role role) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.birth = birth;
        this.role = role;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
