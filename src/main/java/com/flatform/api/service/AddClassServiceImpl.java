package com.flatform.api.service;

import com.flatform.api.model.dao.AddClassDAO;
import com.flatform.api.model.dto.AddClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AddClassService")
public class AddClassServiceImpl implements AddClassService
{
    @Autowired
    AddClassDAO addClassDAO;

    @Override
    public String addNewClass(AddClassDTO addClassDTO)
    {
        // 새로운 클래스 ID 생성
        String[] cidStd = (addClassDAO.getClassIdStd()).split("");
        int cIdStdInt = 0;
        cIdStdInt += (Integer.parseInt(cidStd[1]))*1000;
        cIdStdInt += (Integer.parseInt(cidStd[2]))*100;
        cIdStdInt += (Integer.parseInt(cidStd[3]))*10;
        cIdStdInt += Integer.parseInt(cidStd[4]);

        String newCid = String.format("%04d", cIdStdInt + 1);
        newCid = "C"+newCid;

        //새로운 클래스 아이디 DAO 삽입
        addClassDTO.setClass_id(newCid);

        // DAO
        boolean result = addClassDAO.addNewClass(addClassDTO);

        if(result)
        {
            return "Class Enrolling OK.";
        }
        else
        {
            return "Class Enrolling Fail.";
        }
    }

}
