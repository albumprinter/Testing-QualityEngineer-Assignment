package shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import shipping.exceptions.InvalidWeightException;
import shipping.services.ShippingCalculationService;

@SpringBootApplication
public class ShippingCalculator {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ShippingCalculator.class, args);
        ShippingCalculationService service = applicationContext.getBean(ShippingCalculationService.class);
        int weight = 1;
        try{
            int cost = service.calculateShippingCost(weight);
            System.out.println(String.format("Shipping cost is: %d", cost));
        } catch (InvalidWeightException e){
            System.out.println(String.format("InvalidWeightException occurs: %s", e.getMessage()));
        } catch (Exception e) {
            System.out.println(String.format("Exception occurs: %s", e.getMessage()));
        }
    }
}
