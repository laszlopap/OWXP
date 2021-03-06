/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.social.activity.customizer.service.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.social.activity.customizer.service.base.CustomSocialActivitySetLocalServiceBaseImpl;
import com.liferay.social.activity.customizer.service.persistence.CustomSocialActivitySetFinder;
import com.liferay.social.kernel.model.SocialActivitySet;
import com.liferay.wiki.model.WikiPage;

import java.util.List;

/**
 * The implementation of the custom social activity set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.social.activity.customizer.service.CustomSocialActivitySetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomSocialActivitySetLocalServiceBaseImpl
 * @see com.liferay.social.activity.customizer.service.CustomSocialActivitySetLocalServiceUtil
 */
public class CustomSocialActivitySetLocalServiceImpl
	extends CustomSocialActivitySetLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.social.activity.customizer.service.CustomSocialActivitySetLocalServiceUtil} to access the custom social activity set local service.
	 */
	@Override
	public List<SocialActivitySet> getUserViewableActivitySets(
		long userId, int[] types, int start, int end) {

		long classNameId = _classNameLocalService.getClassNameId(
			WikiPage.class);

		return _customSocialActivitySetFinder.findByU_C_T(
			userId, classNameId, types, start, end);
	}

	@Override
	public int getUserViewableActivitySetsCount(long userId, int[] types) {
		long classNameId = _classNameLocalService.getClassNameId(
			WikiPage.class);

		return _customSocialActivitySetFinder.countByU_C_T(
			userId, classNameId, types);
	}

	@BeanReference(type = ClassNameLocalService.class)
	private ClassNameLocalService _classNameLocalService;

	@BeanReference(type = CustomSocialActivitySetFinder.class)
	private CustomSocialActivitySetFinder _customSocialActivitySetFinder;

}