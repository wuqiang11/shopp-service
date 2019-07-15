/*
 * 文 件 名:  NsfCollectionOptional.java
 * 版    权:  Copyright (c) Hiaward Coperation.
 * 描    述:  <描述>
 * 修 改 人:   wuqiang
 * 修改时间:  2019年1月4日
 * 修改内容:  <修改内容>
 */
package com.shopping.util;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * <功能详细描述>
 * 
 * @author wuqiang
 * @version [版本号, 2019年1月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class NsfCollectionOptional<T> {

	private final Collection<T> value;

	private NsfCollectionOptional(Collection<T> value) {
		this.value = value;
	}

	public static <T> NsfCollectionOptional<T> of(Collection<T> value) {
		return new NsfCollectionOptional<T>(value);
	}

	public <R> R ifPresent(Function<? super Collection<T>, ? extends R> function, R defaultValue) {
		return CollectionUtils.isEmpty(value) ? defaultValue : function.apply(value);
	}

	public <R> R ifPresent(Function<? super Collection<T>, ? extends R> function) {
		return ifPresent(function, null);
	}

	public <X extends Throwable> Collection<T> orElseThrow(Supplier<X> exceptionSupplier) throws X {
		if (CollectionUtils.isNotEmpty(value)) {
			return value;
		} else {
			throw exceptionSupplier.get();
		}
	}

	public <X extends Throwable> void orNegativeThrow(Supplier<X> exceptionSupplier) throws X {
		if (CollectionUtils.isNotEmpty(value)) {
			throw exceptionSupplier.get();
		}
	}

	public void ifPresent(Consumer<? super Collection<T>> consumer) {
		if (CollectionUtils.isNotEmpty(value)) {
			consumer.accept(value);
		}
	}

	public interface Consumer<U> {
		void accept(U u);

	}

}
