package com.vz.model.validate;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validater {

//	/**
//	 * 深度校验报文对象
//	 * @param object 解析目标
//	 * @param vr 校验记录器
//	 * @return
//	 */
//	public static boolean deepValidating(Object object, ValidationRecorder vr) {
//		/*
//		 * 由于在上一层已经校验过该对象的子对象，故此对象为null则不再校验其子对象的子对象了
//		 * */
//		if(object == null) return true;
//		
//		/*
//		 * 当前对象的浅层校验
//		 * */
//		validating(object, vr);
//		
//		Field [] fields = object.getClass().getDeclaredFields();
//		
//		/*
//		 * 当前对象所有域
//		 * */
//		for(Field field : fields) {
//			// 当前域的子域是否不用继续深入校验
//			if(ignoredSubObject(field, object)) continue;
//			// 进入当前域，开始校验子域
//			deepValidating(getField(field, object), vr);
//		}
//		return vr.isResult();
//	}

//	/**
//	 * 获取域对象
//	 * @param field
//	 * @param object
//	 * @return
//	 */
//	private static Object getField(Field field, Object object) {
//		PropertyDescriptor pd;
//		if(logger.isTraceEnabled()) {
//			logger.trace("尝试通过get方法获取域{}", field.getName());
//		}
//		try {
//			pd = new PropertyDescriptor(field.getName(), object.getClass());
//			Method readMethod = pd.getReadMethod();
//			return  readMethod.invoke(object);
//		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
//		}	
//		return null;
//	}

//	/**
//	 * 子对象不需要校验
//	 * @param field
//	 * @param object
//	 * @return
//	 */
//	private static boolean ignoredSubObject(Field field, Object object) {
//		
//		Class<?> fieldType = field.getType();
//		if(fieldType.isPrimitive() || IGNORE_TYPE_LIST.contains(fieldType)) {
//			logger.trace("域{}无需继续", field.getName());
//			return true;		
//		}
//		
//		logger.trace("域{}需要继续", field.getName());
//		return false;
//	}
	
	/**
	 * 需要被忽略的类
	 * */
	@SuppressWarnings("rawtypes")
	public static final List IGNORE_TYPE_LIST = 
			Arrays.asList(java.sql.Date.class, java.util.Date.class, String.class);

//	/**
//	 * 对Java对象进行浅层校验
//	 * */
//	public static boolean validating(Object object) {
//		
//		Field [] fields = object.getClass().getDeclaredFields();
//		
//		if(logger.isTraceEnabled()) {
//			logger.trace("当前校验{}的浅层域{}个",object.getClass().getSimpleName(), fields.length);
//		}
//		for(Field field : fields) {
//			if(field.isAnnotationPresent(NotNull.class)) {				
//				if(isNull(field, object)) {			
//					System.err.println(field.getAnnotation(NotNull.class).message());
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	/**
//	 * 深度校验时使用的单层校验
//	 * @param object
//	 * @param vr 用以记录校验结果
//	 */
//	private static void validating(Object object, ValidationRecorder vr) {
//		
//		Field [] fields = object.getClass().getDeclaredFields();
//		
//		if(logger.isTraceEnabled()) {
//			logger.trace("当前校验{}的浅层域{}个",object.getClass().getSimpleName(), fields.length);
//		}
//		if(object.getClass().equals(OrderInfoMessage.class)) {
//			System.out.println("");
//		}
//		for(Field field : fields) {
//			if(object.getClass().equals(OrderInfoMessage.class)) {
//				System.out.println("");
//			}
//			if(field.isAnnotationPresent(NotNull.class)) {	
//				if(isNull(field, object)) {			
//					vr.setResult(false);
//					vr.setRecord(object.getClass().getSimpleName() +"下的"+ field.getAnnotation(NotNull.class).message());
//				}
//			}
//		}		
//	}
//
//	/**
//	 * 尝试从对象中提取指定域
//	 * @return true 域为null; false 域不为null
//	 * */
//	private static boolean isNull(Field field, Object object) {
//		if(logger.isTraceEnabled()) {
//			logger.trace("对域{},进行非空校验",field.getName());
//		}
//		try {
//			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), object.getClass());
//			Method readMethod = pd.getReadMethod();
//			Object fieldValue = readMethod.invoke(object);
//			if(null == fieldValue) return true;
//		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
	
	private static final Logger logger = LogManager.getLogger(Validater.class);
}


