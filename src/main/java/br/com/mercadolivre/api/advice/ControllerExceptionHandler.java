package br.com.mercadolivre.api.advice;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mercadolivre.api.exception.InternalServerErrorException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler({Exception.class})
	public void handleException(Exception e) throws Exception
	{
	    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) 
	    {
	      throw e;
	    }
	    throw new InternalServerErrorException("Ocorreu um erro ao utilizar o serviço, por favor tente novamente mais tarde!");
    }

}
