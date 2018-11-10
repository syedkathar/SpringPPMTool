package com.spring.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {
        if(result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String, String> fieldErrorsMap = new HashMap<String, String>();
            fieldErrors.forEach(fieldError -> {
                fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            return new ResponseEntity<Map<String,String>>(fieldErrorsMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
