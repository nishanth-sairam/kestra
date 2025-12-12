package io.kestra.core.services;

import io.kestra.core.models.assets.Asset;
import io.kestra.core.models.assets.AssetIdentifier;
import io.kestra.core.models.assets.AssetUser;
import io.kestra.core.queues.QueueException;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.List;

@Singleton
@Named(AssetService.ASSET_SERVICE_NAME)
public class AssetService {

    public static final String ASSET_SERVICE_NAME = "assetService";

    public void asyncUpsert(AssetUser assetUser, Asset asset) throws QueueException {
        // No-op
    }

    public void assetLineage(AssetUser assetUser, AssetIdentifier assetId) throws QueueException {
        // No-op
    }

    public List<Runnable> eventListeners(Class<?> queueType) {
        return Collections.emptyList();
    }
}
