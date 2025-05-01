package CollectionAssignments.Ques11CompanyAssetTracker;

import java.util.*;

public class CompanyAssetTracker {
    // Map to store department -> set of its assets
    private Map<String, Set<Asset>> departmentAssets;

    // Set to keep track of all asset IDs globally to avoid duplicates
    private Set<String> allAssetIds;

    // Constructor to initialize data structures
    public CompanyAssetTracker() {
        departmentAssets = new HashMap<>();
        allAssetIds = new HashSet<>();
    }

    // Method to add asset to a department
    public void addAsset(String department, Asset asset) {
        // Null check
        if (department == null || asset == null) {
            System.out.println("Error: Department or Asset cannot be null.");
            return;
        }

        // Check for global duplicate asset ID
        if (allAssetIds.contains(asset.getAssetId())) {
            System.out.println("Duplicate asset ID detected globally: " + asset.getAssetId());
            return;
        }

        // If department doesn't exist yet, create it
        departmentAssets.putIfAbsent(department, new HashSet<>());

        // Add asset to department's set
        departmentAssets.get(department).add(asset);

        // Add asset ID to global set
        allAssetIds.add(asset.getAssetId());

        System.out.println("Asset added to department " + department + ": " + asset);
    }

    // Method to display all department assets
    public void displayAssets() {
        System.out.println("\n--- Company Asset Records ---");
        for (String dept : departmentAssets.keySet()) {
            System.out.println("Department: " + dept);
            for (Asset asset : departmentAssets.get(dept)) {
                System.out.println("  " + asset);
            }
        }
    }
}

