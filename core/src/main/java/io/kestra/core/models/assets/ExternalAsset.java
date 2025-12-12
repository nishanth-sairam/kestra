package io.kestra.core.models.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

public class ExternalAsset extends Asset {
    public static final String ASSET_TYPE = "EXTERNAL";

    @JsonCreator
    @Builder
    public ExternalAsset(
        String tenantId,
        String namespace,
        String id,
        String displayName,
        String description,
        Map<String, Object> metadata,
        Instant created,
        Instant updated,
        boolean deleted
    ) {
        super(tenantId, namespace, id, ASSET_TYPE, displayName, description, metadata, created, updated, deleted);
    }
}
