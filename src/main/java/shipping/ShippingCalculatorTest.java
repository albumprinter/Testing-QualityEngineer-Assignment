package shipping;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;
import shipping.models.ShippingCostInfo;
import shipping.models.ShippingInfoModel;
import shipping.services.ShippingInfoService;

import java.io.FileNotFoundException;

import static org.mockito.Mockito.when;

class ShippingCalculatorTest {

    @Mock
    ShippingInfoService service;

    @Test
    public void ShippingCalculatorTest() throws FileNotFoundException {
        // Arrange
        ShippingCostInfo mockShippingCostInfo = new ShippingCostInfo();
        service = Mockito.mock(ShippingInfoService.class);
        mockShippingCostInfo.setBasePrice("12.00");
        mockShippingCostInfo.setRate("1.1");

        ShippingInfoModel mockModel = new ShippingInfoModel();
        mockModel.setWeightLimitation(10);
        mockModel.setShippingCostInfo(mockShippingCostInfo);

        when(service.getShippingInfo()).thenReturn(mockModel);

        // Act
        ShippingInfoModel result = service.getShippingInfo();

        // Assert
        Assert.notNull(result.getShippingCostInfo().getBasePrice());
        Assert.isTrue(result.getShippingCostInfo().getBasePrice() == "12.00");
    }
}