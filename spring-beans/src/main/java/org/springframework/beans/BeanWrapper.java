/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans;

import java.beans.PropertyDescriptor;

/**
 * Spring 低层级 JavaBeans 基础设施的核心接口。
 *
 * <p>通常不会被直接使用，而是通过 {@link org.springframework.beans.factory.BeanFactory}
 * 或 {@link org.springframework.validation.DataBinder} 间接使用。
 *
 * <p>提供分析和操作标准 JavaBeans 的操作功能：
 * 能够获取和设置属性值（单个或批量），
 * 获取属性描述符，以及查询属性是否可读/可写。
 *
 * <p>该接口支持<b>嵌套属性</b>，允许设置任意深度的子属性。
 *
 * <p>BeanWrapper 的 "extractOldValueForEditor" 设置默认是 "false"，
 * 以避免因调用 getter 方法带来的副作用。
 * 若设置为 "true"，则可将当前属性值暴露给自定义编辑器。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 2001 年 4 月 13 日
 * @see PropertyAccessor
 * @see PropertyEditorRegistry
 * @see PropertyAccessorFactory#forBeanPropertyAccess
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.validation.BeanPropertyBindingResult
 * @see org.springframework.validation.DataBinder#initBeanPropertyAccess()
 */

public interface BeanWrapper extends ConfigurablePropertyAccessor {

	/**
	 * Specify a limit for array and collection auto-growing.
	 * <p>Default is unlimited on a plain BeanWrapper.
	 * @since 4.1
	 */
	void setAutoGrowCollectionLimit(int autoGrowCollectionLimit);

	/**
	 * Return the limit for array and collection auto-growing.
	 * @since 4.1
	 */
	int getAutoGrowCollectionLimit();

	/**
	 * Return the bean instance wrapped by this object.
	 */
	Object getWrappedInstance();

	/**
	 * Return the type of the wrapped bean instance.
	 */
	Class<?> getWrappedClass();

	/**
	 * Obtain the PropertyDescriptors for the wrapped object
	 * (as determined by standard JavaBeans introspection).
	 * @return the PropertyDescriptors for the wrapped object
	 */
	PropertyDescriptor[] getPropertyDescriptors();

	/**
	 * Obtain the property descriptor for a specific property
	 * of the wrapped object.
	 * @param propertyName the property to obtain the descriptor for
	 * (may be a nested path, but no indexed/mapped property)
	 * @return the property descriptor for the specified property
	 * @throws InvalidPropertyException if there is no such property
	 */
	PropertyDescriptor getPropertyDescriptor(String propertyName) throws InvalidPropertyException;

}
