package io.kestra.core.services;

import io.kestra.core.models.assets.Asset;
import io.kestra.core.runners.Assets;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
@Named(AssetManagerFactory.ASSET_MANAGER_FACTORY_NAME)
public class AssetManagerFactory {
    public static final String ASSET_MANAGER_FACTORY_NAME = "assetManagerFactory";

    public Assets of(boolean enabled) {
        return new Assets() {
            @Override
            public void upsert(Asset asset) {
                throw new UnsupportedOperationException();
            }

            @Override
            public List<Asset> outputs() {
                return new ArrayList<>();
            }
        };
    }
}
