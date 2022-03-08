package com.flatform.api.service;

import com.flatform.api.model.dto.MemberStampNumDTO;
import java.util.List;

public interface MemberStampNumService
{
    List<MemberStampNumDTO> getMemberStampNumber(String member_id);
}
