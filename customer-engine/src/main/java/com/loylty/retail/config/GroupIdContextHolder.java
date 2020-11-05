package com.loylty.retail.config;

public class GroupIdContextHolder {
	private static final ThreadLocal<String> context = new ThreadLocal<>();
	
	public static void set(String groupId) {
		context.set(groupId);
		System.out.println("********set: " + get() + " by: " + Thread.currentThread().getId());
	}
	
	public static String get() {
		return context.get();
	}
	
	public static void unset() {
		System.out.println("**************unset: " + get() + " by: " + Thread.currentThread().getId());
		context.get();
	}
	
	public static void clear() {
		System.out.println("**************clear: " + get() + " by: " + Thread.currentThread().getId());
		context.remove();
	}
	
}
