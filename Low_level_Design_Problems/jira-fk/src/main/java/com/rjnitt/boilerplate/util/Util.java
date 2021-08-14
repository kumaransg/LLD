package com.rjnitt.boilerplate.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.rjnitt.boilerplate.entity.Task;

public class Util {

	public static void validateLong(Long num) {
		if (num == null || num < 0L) {
			throw new IllegalArgumentException("number not validate");
		}

	}

	public static void validateLong(Long num, String error) {
		if (num == null || num < 0L) {
			throw new IllegalArgumentException(error);
		}

	}

	public static void validateString(String str) {
		if (StringUtils.isEmpty(str)) {
			throw new IllegalArgumentException("String not validate");
		}
	}

	public static void validateString(String str, String error) {

		if (StringUtils.isEmpty(str)) {
			throw new IllegalArgumentException(error);
		}

	}

	public static <T> List<T> noRecordFoundForList(List<T> disableTasks) {
		if (disableTasks.isEmpty()) {
			throw new IllegalArgumentException("No record(s) found ");
		}
		return disableTasks;
	}

	public static <T> List<T> noRecordFoundForList(List<T> disableTasks, String error) {
		if (disableTasks.isEmpty()) {
			throw new IllegalArgumentException(error);
		}
		return disableTasks;
	}

	public static <T> void noRecordFound(T tt) {
		if (tt == null) {
			throw new IllegalArgumentException("No record(s) found ");
		}
	}

	public static <T> void noRecordFound(T tt, String error) {
		if (tt == null) {
			throw new IllegalArgumentException(error);
		}
	}

	public static <T> T noRecordFoundWithReturn(T tt) {
		if (tt == null) {
			throw new IllegalArgumentException("No record(s) found ");
		}
		return tt;
	}

	public static <T> T noRecordFoundWithReturn(T tt, String error) {
		if (tt == null) {
			throw new IllegalArgumentException(error);
		}
		return tt;
	}

}
