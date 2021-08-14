package com.rjnitt.boilerplate.util;

import org.apache.commons.lang3.EnumUtils;

public enum IssueType {
	STORY, BUG, FEATURE;

	public static void validate(String issueType) {

		boolean validEnum = EnumUtils.isValidEnum(IssueType.class, issueType);
		if (validEnum == false) {
			throw new IllegalArgumentException("Issye type not valid");
		}

	}
}
