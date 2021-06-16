package shipping.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ShippingInfoModel {

    @SerializedName("shippingCostInfo")
    @Expose
    private ShippingCostInfo shippingCostInfo;
    @SerializedName("weightLimitation")
    @Expose
    private Integer weightLimitation;

    public ShippingCostInfo getShippingCostInfo() {
        return shippingCostInfo;
    }

    public void setShippingCostInfo(ShippingCostInfo shippingCostInfo) {
        this.shippingCostInfo = shippingCostInfo;
    }

    public Integer getWeightLimitation() {
        return weightLimitation;
    }

    public void setWeightLimitation(Integer weightLimitation) {
        this.weightLimitation = weightLimitation;
    }

}
