package com.vz.model;

import com.vz.model.exception.ErrorInfo;
import com.vz.model.mq.common.two.MQMessage;
import com.vz.model.validate.Validater;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class VzoomModelIniter {
	
	public static void main(String[] args) {
//		Response response = getDeepInitialization(Response.class);
//		response.getBody();
//		response.getBody().getFeedbackInfo();
		MQMessage mqMessage= getDeepInitialization(MQMessage.class);
		mqMessage.getBody();
		
//		MQMessage mqMessage = new MQMessage();
	}

	/**
	 * 获取深度初始化实例
	 * */
	public static <T> T getDeepInitialization(Class<T> clazz) {
		
		T target = getDefaultInstance(clazz);
			
		Field[] fields = target.getClass().getDeclaredFields();
		
		for(Field field : fields) {
			if(isBaseType(field)) continue;
			
			PropertyDescriptor pd;
			try {
				// 参数描述
				String propertyName = field.getName();
				if(ignoreMethList.contains(propertyName)) continue;
				pd = new PropertyDescriptor(field.getName(), target.getClass());
				
				Method setMethod = pd.getWriteMethod();
				
				setMethod.invoke(target, getDeepInitialization(field.getType()));

			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					 | IntrospectionException e) {
				logger.error("尝试深度实例化{}时异常", clazz.getName());
				e.printStackTrace();
			}
			
		}
		
		return target;
	}
	/** 深度初始化时，需要忽略的方法 */
	private static final List<String> ignoreMethList = Arrays.asList("isWtb","isCdate","isJcal", "isGcal", "isCASE_INSENSITIVE_ORDER", "isSerialPersistentFields", "isValue");
	
	/**
	 * 基础类型不用实例化
	 * 
	 * @param field
	 * @return
	 */
	private static boolean isBaseType(Field field) {
		
		Class fieldType = field.getType();

		// 忽略基础类型
		if(fieldType.isPrimitive()) return true;
		// 忽略额外的不需要的类型
		 if(Validater.IGNORE_TYPE_LIST.contains(fieldType)) return true;
		
		logger.debug("自动装载对象：{}",fieldType.getName());
		return false;
	}

	/**
	 * 对一个class进行基本的实例化
	 * <pre>
	 * 需要无参数构造器
	 * 
	 * </pre>
	 * */
	private static <T> T getDefaultInstance(Class<T> clazz) {
		
		Constructor<?>[] constructors = clazz.getConstructors();
		
		if(isEmpty(constructors)) {
			return null;
		}

		if(logger.isTraceEnabled()) {
			logger.trace("尝试查找{}的无参数构造器,用以创建实例化对象",clazz.getSimpleName());
		}	
		Constructor constructor = null;
		if((constructor = findTheDefaultConstructor(constructors))== null) {
			return null;
		}
		
		try {
			return (T) constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
			
		
		return null;
	}
	
	
	/**
	 * 找到默认的构造函数，即无参数构造函数
	 * @param constructors
	 * @return
	 */
	private static Constructor findTheDefaultConstructor(Constructor<?>[] constructors) {
		
		for(Constructor constructor : constructors) {
			if(constructor.getParameterCount()>0) continue;
			return constructor;
		}
		
		logger.warn(ErrorInfo.NEER_DEFAULT_CONSTRUCTOR);
		return null;
	}


	/**
	 * 构造函数列表为空，则返回false
	 * @param constructors
	 * @return
	 */
	private static boolean isEmpty(Constructor<?>[] constructors) {
		if(null == constructors || constructors.length == 0) {
			logger.warn(ErrorInfo.NEER_DEFAULT_CONSTRUCTOR);
			return true;
		}
		return false;
	}


	/**
	 * 浅层自动初始化对象
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInitialization(Class<T> clazz) {
		T target = null;
		try {
			target = (T) clazz.getConstructors()[0].newInstance();
			
			Field[] fields = target.getClass().getDeclaredFields();
			for(Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), target.getClass());
				Method setMethod = pd.getWriteMethod();
				setMethod.invoke(target, field.getType().newInstance());
			}
			
			return target;
			
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	private static final Logger logger = LogManager.getLogger(VzoomModelIniter.class);
//	private static final List<String> BASE_TYPE_LIST = Arrays.asList("String","int","double","long","byte","short","boolean","char","Date","List","Map");
}
