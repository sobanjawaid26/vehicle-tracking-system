package com.sobanscode.user.data.entity;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "auth_table")
public class AuthTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "username", nullable = false, length = 100)
    private String username;

    //@jakarta.validation.constraints.Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;

}