import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Test {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Supplier<String> farmDetails = () -> "UBNI CH AWAL";
        Supplier<String> farmerDetails = () -> "KESHAVRAO DAHULE";

        CompletableFuture<String> farmerFuture = CompletableFuture.supplyAsync(farmerDetails, executorService);
        CompletableFuture<String> farmFuture = CompletableFuture.supplyAsync(farmDetails, executorService);

        CompletableFuture<String> combinedFuture = farmerFuture
                .thenCombine(farmFuture, (farmer, farm) -> "Farmer: " + farmer + ", Farm: " + farm);

        // Blocking call to get the result (avoid in real async applications)
        System.out.println(combinedFuture.join());


    }
}
