package io.kestra.core.models.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

public class TableAsset extends Asset {
    public static final String ASSET_TYPE = "TABLE";

    @JsonCreator
    @Builder
    public TableAsset(
        String tenantId,
        String namespace,
        String id,
        String displayName,
        String description,
        String system,
        String database,
        String schema,
        String name,
        Map<String, Object> metadata,
        Instant created,
        Instant updated,
        boolean deleted
    ) {
        super(tenantId, namespace, id, ASSET_TYPE, displayName, description, metadata, created, updated, deleted);

        this.setSystem(system);
        this.setDatabase(database);
        this.setSchema(schema);
        this.setName(name);
    }

    public String getSystem() {
        return Optional.ofNullable(metadata.get("system")).map(Object::toString).orElse(null);
    }

    public String getDatabase() {
        return Optional.ofNullable(metadata.get("database")).map(Object::toString).orElse(null);
    }

    public String getSchema() {
        return Optional.ofNullable(metadata.get("schema")).map(Object::toString).orElse(null);
    }

    public String getName() {
        return Optional.ofNullable(metadata.get("name")).map(Object::toString).orElse(null);
    }

    public void setSystem(String system) {
        if (system != null) {
            metadata.put("system", system);
        }
    }

    public void setDatabase(String database) {
        if (database != null) {
            metadata.put("database", database);
        }
    }

    public void setSchema(String schema) {
        if (schema != null) {
            metadata.put("schema", schema);
        }
    }

    public void setName(String name) {
        if (name != null) {
            metadata.put("name", name);
        }
    }
}
