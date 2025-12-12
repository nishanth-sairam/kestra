package io.kestra.core.models.assets;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.kestra.core.models.DeletedInterface;
import io.kestra.core.models.HasUID;
import io.kestra.core.utils.IdUtils;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, include = JsonTypeInfo.As.EXISTING_PROPERTY, defaultImpl = CustomAsset.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = TableAsset.class, name = TableAsset.ASSET_TYPE),
    @JsonSubTypes.Type(value = FileAsset.class, name = FileAsset.ASSET_TYPE),
    @JsonSubTypes.Type(value = DatasetAsset.class, name = DatasetAsset.ASSET_TYPE),
    @JsonSubTypes.Type(value = ExternalAsset.class, name = ExternalAsset.ASSET_TYPE)
})
@Getter
@Setter
public abstract class Asset implements HasUID, DeletedInterface {
    @Hidden
    @Pattern(regexp = "^[a-z0-9][a-z0-9_-]*")
    protected String tenantId;

    @Pattern(regexp = "^[a-z0-9][a-z0-9._-]*")
    @Size(min = 1, max = 150)
    protected String namespace;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9._-]*")
    @Size(min = 1, max = 150)
    protected final String id;

    @NotBlank
    protected final String type;

    protected String displayName;

    protected String description;

    protected Map<String, Object> metadata;

    @Nullable
    @Hidden
    private Instant created;

    @Nullable
    @Hidden
    private Instant updated;

    @Hidden
    private boolean deleted;

    public Asset(
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
        this.tenantId = tenantId;
        this.namespace = namespace;
        this.id = id;
        this.type = type;
        this.displayName = displayName;
        this.description = description;
        this.metadata = Optional.ofNullable(metadata).map(HashMap::new).orElse(new HashMap<>());
        Instant now = Instant.now();
        this.created = Optional.ofNullable(created).orElse(now);
        this.updated = Optional.ofNullable(updated).orElse(now);
        this.deleted = deleted;
    }

    public <T extends Asset> T toUpdated() {
        if (this.created == null) {
            this.created = Instant.now();
        }
        this.updated = Instant.now();
        return (T) this;
    }

    @JsonAnySetter
    public void setMetadata(String name, Object value) {
        metadata.put(name, value);
    }

    @Override
    public String uid() {
        return IdUtils.fromParts(tenantId, id);
    }

    public Asset withTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }
}
