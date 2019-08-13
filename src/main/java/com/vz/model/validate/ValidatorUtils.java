package com.vz.model.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 校验java对象字段
 * <pre>
 * 在Spring运行环境能才能执行!
 * </pre>
 * @author Administrator
 *
 */
public class ValidatorUtils {
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); 

	/**
	 * @param obj
	 * @param clazzes 需要校验的内容，不输入则校验所有可能的异常问题
	 * @return
	 */
	public static <T> Map<String, String> validate(T obj, Class<?> ... clazzes) { 
		Map<String, StringBuilder> errorMap = new HashMap<>(); 
		
		Set<ConstraintViolation<T>> set = validator.validate(obj, clazzes); 
		if (set != null && set.size() > 0) { 
			String property = null; 
			for (ConstraintViolation<T> cv : set) { 
				//这里循环获取错误信息，可以自定义格式 
				property = cv.getPropertyPath().toString(); cv.getRootBean();
				if (errorMap.get(property) != null) { 
					errorMap.get(property).append("," + cv.getMessage()); 
				} else { 
					StringBuilder sb = new StringBuilder(); 
					sb.append(cv.getMessage()); 
					errorMap.put(property, sb); 
				} 
			} 	
		} 
		
		return errorMap.entrySet().stream().collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())); 
	}
}

