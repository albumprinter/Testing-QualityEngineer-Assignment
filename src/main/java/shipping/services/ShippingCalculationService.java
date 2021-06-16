package shipping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shipping.exceptions.InvalidWeightException;
import shipping.models.ShippingCostInfo;
import shipping.models.ShippingInfoModel;

import java.io.FileNotFoundException;

@Service
public class ShippingCalculationService {

    private ShippingInfoService shippingInfoService;

    @Autowired
    public ShippingCalculationService(ShippingInfoService shippingInfoService) {
        this.shippingInfoService = shippingInfoService;
    }

    public int calculateShippingCost(int weight) throws FileNotFoundException, InvalidWeightException {
        ShippingInfoModel shippingInfo = shippingInfoService.getShippingInfo();
        if (weight > shippingInfo.getWeightLimitation()) {
            throw new InvalidWeightException(String.format("Weight %d Exceeded the limitation", weight));
        }
        ShippingCostInfo shippingCostInfo = shippingInfo.getShippingCostInfo();
        int basePrice = Integer.parseInt(shippingCostInfo.getBasePrice());
        int rate = Integer.parseInt(shippingCostInfo.getRate());
        int cost = basePrice + weight * rate;
        return cost;
    }
}
