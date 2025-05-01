/** Company Asset Tracker (Map<String, Set<Asset>>)
 Store assets per department with unique Asset objects.
 •	Detect duplicate asset IDs globally.
 */

package CollectionAssignments.Ques11CompanyAssetTracker;

public class Main {
    public static void main(String[] args) {
        CompanyAssetTracker tracker = new CompanyAssetTracker();

        // Adding assets to HR
        tracker.addAsset("HR", new Asset("A101", "Office Chair"));
        tracker.addAsset("HR", new Asset("A102", "Laptop"));

        // Adding assets to IT
        tracker.addAsset("IT", new Asset("A201", "Server Rack"));
        tracker.addAsset("IT", new Asset("A202", "Switch"));

        // Trying to add a duplicate asset ID across departments
        tracker.addAsset("Finance", new Asset("A101", "Projector")); // Duplicate ID: A101

        // Display all assets
        tracker.displayAssets();
    }
}

