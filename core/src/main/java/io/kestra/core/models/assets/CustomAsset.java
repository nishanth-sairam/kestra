package io.kestra.core.models.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

public class CustomAsset extends Asset {
    @JsonCreator
    @Builder
    public CustomAsset(
        String tenantId,
        String namespace,
        String id,
        String type,
        String displayName,
        String description,
        Map<String, Object> metadata,
        Instant created,
        Instant updated,
        boolean deleted
    ) {
        super(tenantId, namespace, id, type, displayName, description, metadata, created, updated, deleted);
    }
}
