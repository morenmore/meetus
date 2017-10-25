package com.meet.together.holist.dao;

import java.util.List;

import com.meet.together.holist.dto.CategoryInfo;
import com.meet.together.holist.dto.ListInfo;
import com.meet.together.holist.dto.Place;

public interface HoListDao {
	int insertListInfo(ListInfo li);

	int insertPlace(Place pi);

	List<ListInfo> selectListInfo(ListInfo li);

	ListInfo selectListContent(ListInfo li);

	List<CategoryInfo> selectCategoryInfo();

	List<ListInfo> selectCategory(ListInfo li);
}