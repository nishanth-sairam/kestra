package io.kestra.core.models.assets;

import io.kestra.core.utils.IdUtils;

/**
 * Represents an entity that used an asset
 */
public record AssetUser(String tenantId, String namespace, String flowId, Integer flowRevision, String executionId, String taskRunId) {
    public String uid() {
        return IdUtils.fromParts(tenantId, namespace, flowId, String.valueOf(flowRevision), executionId, taskRunId);
    }
}
