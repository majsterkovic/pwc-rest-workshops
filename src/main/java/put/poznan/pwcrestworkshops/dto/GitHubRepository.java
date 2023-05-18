package put.poznan.pwcrestworkshops.dto;

import lombok.Builder;

@Builder
public record GitHubRepository(
        String name,
        Long id
) {
}