package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.demo.entity.Book;
import com.demo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {


	@Resource
	private BookService bookService;


	@RequestMapping(value = "/pin", method = RequestMethod.GET)
	@ResponseBody
	private String pin(Model model) {
		return "PONG";
	}

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseBody
	private String ping(Model model) {
		String ping = bookService.ping();
		return ping;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	private String insert(Model model) {

		Book book = new Book();
		book.setName("Java");
		book.setNumber(10);
		int insert = bookService.insert(book);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", insert);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	private String delete(@RequestParam("id") int id) {
		int delete = bookService.delete(id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", delete);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	private String update(Model model) {
		Book select = bookService.selectBook(1000);
		select.setName("New Book");
		select.setNumber(1000);
		int update = bookService.update(select);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", update);
		return jsonObject.toJSONString();// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	private String select(Model model) {
		Book select = bookService.selectBook(1000);
		return JSONObject.toJSONString(select);// WEB-INF/jsp/"list".jsp
	}


}
