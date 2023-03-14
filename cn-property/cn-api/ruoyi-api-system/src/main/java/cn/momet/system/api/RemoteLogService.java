package cn.momet.system.api;

import cn.momet.core.constant.SecurityConstants;
import cn.momet.core.constant.ServiceNameConstants;
import cn.momet.core.domain.R;
import cn.momet.system.api.domain.SysLogininfor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import cn.momet.system.api.domain.SysOperLog;
import cn.momet.system.api.factory.RemoteLogFallbackFactory;

/**
 * 日志服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {
	/**
	 * 保存系统日志
	 *
	 * @param sysOperLog 日志实体
	 * @param source     请求来源
	 * @return 结果
	 */
	@PostMapping("/operlog")
	public R<Boolean> saveLog(@RequestBody SysOperLog sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

	/**
	 * 保存访问记录
	 *
	 * @param sysLogininfor 访问实体
	 * @param source        请求来源
	 * @return 结果
	 */
	@PostMapping("/logininfor")
	public R<Boolean> saveLogininfor(@RequestBody SysLogininfor sysLogininfor, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
