package com.vz.model.utils.special;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**java对象到java对象的转换
 * @ProjectName: bllose-utils
 * @Package: com.vzoom.blloseutils.transfer
 * @ClassName: Java2Java
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/13 18:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 18:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Java2Java {

    private final static Logger logger = LogManager.getLogger(Java2Java.class);

    // 忽视掉需要打印警告的 key 值。统一在业务层面进行补充
    private final static List<String> IGNORE_LIST = new ArrayList<String>(){{
        add("nsrsbh");
        add("NSRSBH");
    }};
    /**
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/13
     * @description
     * @param origin 数据源  a_b
     * @param target 移入目标 aB
     * */
    public static <T> T magicFunction(Object origin, Class<T> target) throws IllegalAccessException, InstantiationException {
        if(null == origin || null == target){
            logger.error("转换的java对象不能为null!");
            return null;
        }

        T result = target.newInstance();
        Class originClass = origin.getClass();

        // 以目标为基准， 遍历所有域。 尝试从数据源获取对应的方法
        Field[] fields = target.getDeclaredFields();
        for(Field field: fields){
            String fieldName = field.getName();
            Class type = field.getType();
            logger.debug("当前处理域：{}, 类型: {}", fieldName, type.getName());

            try {
                String setFunctionName = "set"+FunctionFormat(fieldName);
                String getFunctionName = "get"+FunctionFormat(fieldName);
                Method getFunction = null;

                // 尝试获取数据源的get方法
                try {
                    originClass.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                    logger.debug("数据源没有域:{}, 尝试转译格式 aB -> a_b", fieldName);
                    getFunctionName = transferFieldName2GetFunction(fieldName);
                    try {
                        getFunction = originClass.getMethod(getFunctionName);
                    }catch (Exception e1){
                        logger.debug("数据源无"+getFunctionName+"方法, 特殊处理...");
                        Object special = specialHandler(type);
                        if(null != special) {
                            target.getMethod(setFunctionName, type).invoke(result, special);
                        }else{
                            if(!IGNORE_LIST.contains(fieldName))
                                logger.warn("数据源缺少域{}, 并且不存在处理办法", fieldName);
                        }
                        continue;
                    }
                }
                getFunction = (null == getFunction)?originClass.getMethod(getFunctionName):getFunction;

                // 获取 数据源 某一域 的 值
                Object setTarget = getFunction.invoke(origin);
                if(null == setTarget){
                    logger.warn("数据源的get方法 {} 获取不到值，无法插入目标对象", getFunction.getName());
                    continue;
                }

                // 从目标对象中获取插入值的set方法
                Method targetMethod = target.getMethod(setFunctionName, type);
                logger.debug("目标对象的set方法: "+targetMethod.getName());

                // 将值插入最终的result对象中
                targetMethod.invoke(result, setTarget);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /** 尝试转变域名称格式
     * <pre>
     *     aB -> a_b
     * </pre>
     * @author Administrator
     * @createTime 2019/8/13
     * @description
     * */
    private static String transferFieldName2GetFunction(String fieldName) {
        String preHandlerName = uppercase2_(fieldName);
        return "get"+FunctionFormat(preHandlerName);
    }

    private static String uppercase2_(String target){
        String regex = "([A-Z][a-z]+)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(target);

        if(m.find()){
            String currect = m.group();
            String newString = "_"+String.valueOf(currect.toCharArray()[0]).toLowerCase()+currect.substring(1);
            target = uppercase2_(m.replaceFirst(newString));
        }

        return target;
    }


    /**特殊处理
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/13
     * @description
     * */
    private static Object specialHandler(Class type) {
        if(Date.class.equals(type)){
            return new Date();
        }
        return null;
    }

    private static String FunctionFormat(String fieldName) {
        String firstLetter = fieldName.substring(0,1).toUpperCase();
        return firstLetter + fieldName.substring(1);
    }
}
