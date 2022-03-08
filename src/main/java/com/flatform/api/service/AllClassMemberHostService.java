package com.flatform.api.service;

import com.flatform.api.model.dto.AllClassMemberHostDTO;
import java.util.List;

public interface AllClassMemberHostService
{
    List<AllClassMemberHostDTO> getAllClassMemberHost(String member_id);
}
