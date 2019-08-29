package com.vz.model.utils.uri;

import java.net.URI;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vzoom.blloseutils.uri
 * @ClassName: UriInterfaces
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/7/22 16:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/7/22 16:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UriInterfaces {

    boolean upload(String absoluteName);

    boolean download(String absoluteName, URI uri);

    boolean push(String absoluteName);

    UriInterfaces init(URI uri) throws Exception;
}
