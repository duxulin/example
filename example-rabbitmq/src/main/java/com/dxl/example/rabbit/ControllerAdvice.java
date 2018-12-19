package com.dxl.example.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Program ControllerAdvice
 * @Description
 * @Author duxl
 * @Create 2018/11/28 13:52
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		LOGGER.error(e.getMessage());
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		map.put("msg", e.getMessage());
		return map;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Map methodArgumentMetod(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException e) {
		e.printStackTrace();
		LOGGER.error(e.getMessage());
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		map.put("msg", e.getMessage());
		return map;
	}


	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Map<String, Object> handleBindException(BindException e) {
		e.printStackTrace();
		FieldError fieldError = e.getBindingResult().getFieldError();

		LOGGER.error(fieldError.getDefaultMessage());
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		map.put("msg", fieldError.getDefaultMessage());
		return map;
	}
}
