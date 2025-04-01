package br.edu.utfpr.pb.pw44s.server.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String displayName;
    private String username;
    private String password;
}
