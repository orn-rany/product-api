package rany.com.api.config.jpa;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class EntityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}