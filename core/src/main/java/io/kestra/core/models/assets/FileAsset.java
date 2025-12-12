package io.kestra.core.models.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

public class FileAsset extends Asset {
    public static final String ASSET_TYPE = "FILE";

    @JsonCreator
    @Builder
    public FileAsset(
        String tenantId,
        String namespace,
        String id,
        String displayName,
        String description,
        String system,
        String path,
        Map<String, Object> metadata,
        Instant created,
        Instant updated,
        boolean deleted
    ) {
        super(tenantId, namespace, id, ASSET_TYPE, displayName, description, metadata, created, updated, deleted);

        this.setSystem(system);
        this.setPath(path);
    }

    public String getSystem() {
        return Optional.ofNullable(metadata.get("system")).map(Object::toString).orElse(null);
    }

    public String getPath() {
        return Optional.ofNullable(metadata.get("path")).map(Object::toString).orElse(null);
    }

    public void setSystem(String system) {
        if (system != null) {
            metadata.put("system", system);
        }
    }

    public void setPath(String path) {
        if (path != null) {
            metadata.put("path", path);
        }
    }
}
