package org.springframework.aop.framework;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 用于创建代理时的通用配置类，确保所有代理创建器使用一致的配置属性。
 *
 * 常用于继承构建 AOP 配置支持类（如 AdvisedSupport）。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see AdvisedSupport
 */
public class ProxyConfig implements Serializable {

	/** 为了兼容 Spring 1.2 的版本，保持相同的序列化 ID。 */
	private static final long serialVersionUID = -8409359707199703185L;

	/**
	 * 是否强制使用 CGLIB 代理类，而不是基于接口的 JDK 动态代理。
	 * 默认为 false，即优先使用接口代理。
	 *
	 * 若设置为 true：
	 * - 若目标是接口，仍使用 JDK 代理；
	 * - 若目标是普通类，则使用 CGLIB 创建子类代理。
	 */
	private boolean proxyTargetClass = false;

	/**
	 * 是否启用优化模式，通常与 CGLIB 配合使用。
	 * 默认为 false。
	 *
	 * 注意：开启后可能会跳过一些代理类的合法性校验（例如 final 方法），
	 * 主要用于性能调优场景。
	 */
	private boolean optimize = false;

	/**
	 * 是否隐藏代理的真实身份，禁止将代理对象强转为 {@link Advised} 接口。
	 * 默认为 false，即允许外部访问代理的元数据（Advice 列表等）。
	 */
	boolean opaque = false;

	/**
	 * 是否将代理对象暴露为线程本地变量（ThreadLocal），以便通过 {@link AopContext} 获取。
	 * 默认为 false。
	 *
	 * 如果需要在代理对象内部调用自身的另一个被通知方法，应设置为 true。
	 * 否则直接使用 this 调用会绕过 AOP 拦截器链。
	 */
	boolean exposeProxy = false;

	/**
	 * 是否冻结当前代理配置，防止 Advice 被动态更改。
	 * 默认为 false。
	 *
	 * 冻结后可提高运行时性能，并避免运行时误修改代理行为。
	 */
	private boolean frozen = false;

	/** 设置是否强制使用类代理（即 CGLIB 代理） */
	public void setProxyTargetClass(boolean proxyTargetClass) {
		this.proxyTargetClass = proxyTargetClass;
	}

	/** 获取是否使用类代理（CGLIB） */
	public boolean isProxyTargetClass() {
		return this.proxyTargetClass;
	}

	/** 设置是否开启优化模式 */
	public void setOptimize(boolean optimize) {
		this.optimize = optimize;
	}

	/** 获取是否处于优化模式 */
	public boolean isOptimize() {
		return this.optimize;
	}

	/** 设置代理是否不可被强转为 {@link Advised} */
	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}

	/** 获取代理是否不可被强转为 {@link Advised} */
	public boolean isOpaque() {
		return this.opaque;
	}

	/** 设置是否暴露当前代理对象（用于 AopContext.getCurrentProxy） */
	public void setExposeProxy(boolean exposeProxy) {
		this.exposeProxy = exposeProxy;
	}

	/** 获取是否暴露当前代理对象 */
	public boolean isExposeProxy() {
		return this.exposeProxy;
	}

	/** 设置是否冻结该代理配置，不再允许添加/修改 Advice */
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	/** 获取该配置是否被冻结 */
	public boolean isFrozen() {
		return this.frozen;
	}

	/**
	 * 从另一个 ProxyConfig 对象中复制所有配置属性。
	 *
	 * @param other 要复制配置的对象，不能为空
	 */
	public void copyFrom(ProxyConfig other) {
		Assert.notNull(other, "Other ProxyConfig object must not be null");
		this.proxyTargetClass = other.proxyTargetClass;
		this.optimize = other.optimize;
		this.exposeProxy = other.exposeProxy;
		this.frozen = other.frozen;
		this.opaque = other.opaque;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("proxyTargetClass=").append(this.proxyTargetClass).append("; ");
		sb.append("optimize=").append(this.optimize).append("; ");
		sb.append("opaque=").append(this.opaque).append("; ");
		sb.append("exposeProxy=").append(this.exposeProxy).append("; ");
		sb.append("frozen=").append(this.frozen);
		return sb.toString();
	}

}
