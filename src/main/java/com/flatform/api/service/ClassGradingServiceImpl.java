package com.flatform.api.service;

import com.flatform.api.model.dao.ClassGradingDAO;
import com.flatform.api.model.dto.ClassGradingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("ClassGradingService")
public class ClassGradingServiceImpl implements ClassGradingService{
    @Autowired
    ClassGradingDAO classGradingDAO;

    @Override
    public String classGradingService(ClassGradingDTO classGradingDTO) {
        //ClassGradingDTO로부터 새로운 점수(사이값)(클라이언트에서 지정한 값) 가져온 후 소수점으로 재연산 해서 재설정
        Double gradeVal = (classGradingDTO.getSai_change())*(0.1);

        //ClassGradingDTO 로부터 대상 클래스 ID 가져오기
        String targetClassId = classGradingDTO.getClass_id();

        // dao 복수 파라미터 설정
        Map<String, Object> daoParameter = new HashMap<>();
        daoParameter.put("classId", targetClassId);
        daoParameter.put("saiVal", gradeVal);

        System.out.println(daoParameter);
        boolean gradingResult = classGradingDAO.updateClassGrade(daoParameter);


        //gradingResult 값이 참이면 정상등록 메세지 반환
        //점수 반영이 올바르지 않다면(무결성 X) 에러 메세지 반환
        if(gradingResult)
        {
            return "Grading Success";
        }
        else
        {
            return "Grading Fail. Grade Data were not Changed.";
        }
    }
}
