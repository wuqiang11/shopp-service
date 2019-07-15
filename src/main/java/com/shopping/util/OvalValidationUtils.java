/*
 * 文 件 名:  OvalValidationUtils.java
 * 版    权:  Copyright (c) Hiaward Coperation.
 * 描    述:  <描述>
 * 修 改 人:   wuqiang
 * 修改时间:  2019年1月4日
 * 修改内容:  <修改内容>
 */
package com.shopping.util;

import com.shopping.exception.BussinessException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 参数校验工具类
 * 
 * @author wuqiang
 * @version [版本号, 2019年1月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OvalValidationUtils {

	private static Validator validator = new Validator();

	/**
	 * 
	 * 功能描述:
	 * 
	 * 〈功能详细描述〉
	 *
	 * @param obj
	 */
	public static void validate(Object obj) {
		List<ConstraintViolation> constraintViolation = getRootViolation(validator.validate(obj));
		if (CollectionUtils.isNotEmpty(constraintViolation)) {
			throw new BussinessException(constraintViolation.get(0).getErrorCode(),
					constraintViolation.get(0).getMessage());
		}
	}

	/**
	 * OVal在校验对象嵌套的属性时，只抛出最外层的非法信息，需要循环获取根本的cause
	 * 
	 * @param shallowViolationSet
	 * @return
	 */
	public static List<ConstraintViolation> getRootViolation(List<ConstraintViolation> shallowViolationSet) {
		final List<ConstraintViolation> rootViolationSet = new ArrayList<ConstraintViolation>();
		NsfCollectionOptional.of(shallowViolationSet)
				.ifPresent(new NsfCollectionOptional.Consumer<Collection<ConstraintViolation>>() {
					@Override
					public void accept(Collection<ConstraintViolation> shallowViolationSet) {
						for (ConstraintViolation shallowViolation : shallowViolationSet) {
							if (shallowViolation.getCauses() != null) {
								accept(Arrays.asList(shallowViolation.getCauses()));
							} else {
								rootViolationSet.add(shallowViolation);
							}
						}
					}
				});
		return rootViolationSet;
	}
}
