package com.flatform.api.service;

import java.util.List;

public interface ClassListService {
    public List getClassListByCat(String univ_id, String cat_name);
    public List getClassListByQuery(String univ_id, String query);
}
