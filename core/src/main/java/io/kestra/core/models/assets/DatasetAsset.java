package io.kestra.core.models.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

public class DatasetAsset extends Asset {
    public static final String ASSET_TYPE = "DATASET";

    @JsonCreator
    @Builder
    public DatasetAsset(
        String tenantId,
        String namespace,
        String id,
        String displayName,
        String description,
        String system,
        String location,
        String format,
        Map<String, Object> metadata,
        Instant created,
        Instant updated,
        boolean deleted
    ) {
        super(tenantId, namespace, id, ASSET_TYPE, displayName, description, metadata, created, updated, deleted);

        this.setSystem(system);
        this.setLocation(location);
        this.setFormat(format);
    }

    public String getSystem() {
        return Optional.ofNullable(metadata.get("system")).map(Object::toString).orElse(null);
    }

    public String getLocation() {
        return Optional.ofNullable(metadata.get("location")).map(Object::toString).orElse(null);
    }

    public String getFormat() {
        return Optional.ofNullable(metadata.get("format")).map(Object::toString).orElse(null);
    }

    public void setSystem(String system) {
        if (system != null) {
            metadata.put("system", system);
        }
    }

    public void setLocation(String location) {
        if (location != null) {
            metadata.put("location", location);
        }
    }

    public void setFormat(String format) {
        if (format != null) {
            metadata.put("format", format);
        }
    }
}
