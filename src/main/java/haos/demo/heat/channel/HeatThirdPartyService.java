package haos.demo.heat.channel;

import haos.demo.heat.channel.ChannelService;

/**
 * 第三方服务接口
 */
public interface HeatThirdPartyService extends ChannelService {
    /**
     * 三方商户号
     */
    String commercialNumber();
}
