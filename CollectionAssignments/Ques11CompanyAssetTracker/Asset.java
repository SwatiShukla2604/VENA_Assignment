package CollectionAssignments.Ques11CompanyAssetTracker;

import java.util.Objects;

// Class representing a single asset in a department
public class Asset {
    private String assetId;
    private String name;

    // Constructor to create a new Asset
    public Asset(String assetId, String name) {
        this.assetId = assetId;
        this.name = name;
    }

    // Getters to access private fields
    public String getAssetId() {
        return assetId;
    }

    public String getName() {
        return name;
    }

    // Override equals and hashCode so Set<Asset> treats assets with same ID as duplicates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same object
        if (o == null || getClass() != o.getClass()) return false; // different type

        Asset asset = (Asset) o;

        // Two assets are equal if their assetIds are equal
        return Objects.equals(assetId, asset.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId); // Hash code based on ID only
    }

    @Override
    public String toString() {
        return "Asset{" +
                "ID='" + assetId + '\'' +
                ", Name='" + name + '\'' +
                '}';
    }
}

