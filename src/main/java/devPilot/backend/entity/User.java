package devPilot.backend.entity;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.Instant;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="github_id", unique = true, nullable = false)
    private Long githubId;

    @Column(name="github_username", unique = true, nullable = false, length = 100)
    private String githubUsername;

    @Column(name="display_name", length = 200 ,nullable = false )
    private String displayName;

    @Column(name="avatar_url", length = 500)
    private String avatarUrl;

    @Column(name="access_token", nullable = false, columnDefinition = "TEXT")
    private String accessToken;

    @Column(name="token_scopes", length = 500)
    private String tokenScopes;

    @Column(name="created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate(){
        if (createdAt == null){
            createdAt = Instant.now();
        }
    }

}
