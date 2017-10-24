package com.meet.together.list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meet.together.list.dao.ListDao;
import com.meet.together.list.dto.ListInfo;
import com.meet.together.list.dto.Place;

@Service
public class ListServiceImpl implements ListService {
	@Autowired
	ListDao listDao;

	@Override
	public int insertListInfo(ListInfo li) {
		return listDao.insertListInfo(li);
	}

	@Override
	public int insertPlace(Place pi) {
		return listDao.insertPlace(pi);
	}

	@Override
	public List<ListInfo> selectListInfo(ListInfo li) {
		return listDao.selectListInfo(li);
	}

	@Override
	public ListInfo selectListContent(ListInfo li) {
		return listDao.selectListContent(li);
	}

}
