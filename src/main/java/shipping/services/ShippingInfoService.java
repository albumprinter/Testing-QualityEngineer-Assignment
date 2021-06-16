package shipping.services;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Service;
import shipping.models.ShippingInfoModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class ShippingInfoService {
    public ShippingInfoModel getShippingInfo() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("C:\\myproject\\Testing-QualityEngineer-Assignment\\src\\main\\resources\\shipping\\shipingInfo.json"));
        ShippingInfoModel shippingInfo = gson.fromJson(reader, ShippingInfoModel.class);
        return shippingInfo;
    }
}
