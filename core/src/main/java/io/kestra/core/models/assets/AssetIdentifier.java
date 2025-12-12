package io.kestra.core.models.assets;

public record AssetIdentifier(String id){
    public String uid() {
        return id;
    }
}
