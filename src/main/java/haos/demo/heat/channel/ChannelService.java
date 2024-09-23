package haos.demo.heat.channel;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ChannelService {

    /**
     * 渠道名称
     */
    String getChannelName();

    /**
     * 生成渠道单号
     */
    String channelOrderNumber();

    /**
     * 级联地址查询
     */
    List<JSONObject> queryAddress(JSONObject addressReq);

    /**
     * 模糊查询用户
     */
    List<JSONObject> fuzzyQueryCustomer(JSONObject fuzzyQueryReq);

    /**
     * 根据地址查用户
     */
    JSONObject queryCustomerByAddress(JSONObject queryUserByAddressReq);

    /**
     * 手机号查用户
     */
    List<JSONObject> queryCustomerByPhone(JSONObject customerQueryReq);

    /**
     * 根据用户编号查用户
     */
    JSONObject queryCustomerByCustomerNumber(JSONObject customerQueryReq);

    /**
     * 获取账单
     */
    JSONObject getBills(String commercialNumber, String searchId);

    /**
     * 销账
     */
    JSONObject crossOffAccount(JSONObject crossOffAccountReq);

}
