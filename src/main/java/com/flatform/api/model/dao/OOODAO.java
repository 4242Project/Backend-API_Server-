package com.flatform.api.model.dao;

import com.flatform.api.model.dto.OOODTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OOODAO {
    List<OOODTO> sqlxmlid();
}