package shipping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;
import shipping.exceptions.InvalidWeightException;
import shipping.models.ShippingCostInfo;
import shipping.models.ShippingInfoModel;
import shipping.services.ShippingCalculationService;
import shipping.services.ShippingInfoService;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.when;

class ShippingCalculationServiceTest {

    @Mock
    ShippingInfoService service;
    ShippingCalculationService shippingCalculationService;

    @BeforeEach
    public void setup(){
        service = Mockito.mock(ShippingInfoService.class);
        shippingCalculationService = new ShippingCalculationService(service);
    }

    @Test
    public void calculateShippingCostTest() throws FileNotFoundException, InvalidWeightException {
        // Arrange
        ShippingCostInfo mockShippingCostInfo = new ShippingCostInfo();
        mockShippingCostInfo.setBasePrice("3");
        mockShippingCostInfo.setRate("3");
        ShippingInfoModel mockModel = new ShippingInfoModel();
        mockModel.setWeightLimitation(10);
        mockModel.setShippingCostInfo(mockShippingCostInfo);
        when(service.getShippingInfo()).thenReturn(mockModel);

        // Act
        int result = shippingCalculationService.calculateShippingCost(5);

        // Assert
        assertEquals(result, 18);
    }
}