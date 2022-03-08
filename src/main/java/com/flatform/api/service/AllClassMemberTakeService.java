package com.flatform.api.service;

import com.flatform.api.model.dto.AllClassMemberTakeDTO;

import java.util.List;

public interface AllClassMemberTakeService
{
    List<AllClassMemberTakeDTO> allClassMemberTake(String member_id);
}
