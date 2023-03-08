package com.curd.card.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.card.model.Card;
import com.curd.card.repository.ICardRepository;

@Service
public class CardServiceImpl implements ICardService {
	
	@Autowired
	private ICardRepository repository;
	

	@Override
	public List<Card> findAll() {
		List<Card> list = new ArrayList<>();
		try {
			list = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int save(Card card) {
		int row = 0;
		try {
			row = repository.save(card);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int update(Card card) {
		int row = 0;
		
		try {
			row = repository.update(card);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int deleteById(int id) {

		int row = 0;
		try {
			row = repository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}

}
