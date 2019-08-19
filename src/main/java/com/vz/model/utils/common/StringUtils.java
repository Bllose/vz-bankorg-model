package com.vz.model.utils.common;

/**
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.utils.common
 * @ClassName: StringUtils
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 9:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StringUtils {

    public static boolean isBlank(String target){
        if(null != target && !"".equals(target.trim())) return false;

        return true;
    }

    /**除了“空”以外，也不能为"null"这个字符串
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/19
     * @description
     * */
    public static boolean isNotNull(String target){
        if(null != target && !"".equals(target.trim())){
            if(!"null".equals(target.trim().toLowerCase())) return true;
        }
        return false;
    }
}
