package com.flatform.api.service;

import com.flatform.api.repository.dao.*;
import com.flatform.api.repository.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassService
{
    //클래스 세부사항 조회
    @Autowired
    ClassDetailDAO classDetailDAO;

    public List<ClassDetailDTO> getClassDetailService(String classId)
    {
        //String res = classDetailDAO.getClassDetailListById(classId);
        return classDetailDAO.getClassDetailListById(classId);
    }


    //class 생성
    @Autowired
    AddClassDAO addClassDAO;

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

    //회원이 개설하는 클래스 전체목록
    @Autowired
    AllClassMemberHostRepository allClassMemberHostRepository;

    public List<AllClassMemberHostEntity> getAllClassMemberHost(String member_id)
    {
        return allClassMemberHostRepository.findByHostId(member_id);
    }


    //회원이 수강하는 클래스 전체목록
    @Autowired
    AllClassMemberTakeDAO allClassMemberTakeDAO;

    public List<AllClassMemberTakeDTO> allClassMemberTake(String member_id)
    {
        return allClassMemberTakeDAO.getAllClassMemberTake(member_id);
    }



    @Autowired
    UserClassDAO userClassDAO;

    public List<UserClassDTO> getUserTodayClass(String userId, int date)
    {
        HashMap<String, Object> parammap = new HashMap<>(); //다중 파라미터를 받기위한 코드
        parammap.put("userId", userId);
        parammap.put("date", date);
        System.out.println(parammap);

        return userClassDAO.getTodayClass(parammap);
    }


    // 점수 매기는 기능
    @Autowired
    ClassGradingDAO classGradingDAO;

    public String classGradingService(ClassGradingDTO classGradingDTO)
    {
        //ClassGradingDTO 로부터 새로운 점수(사이값)(클라이언트에서 지정한 값) 가져온 후 소수점으로 재연산 해서 재설정
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

    //카테고리 기준으로 전체 클래스 검색
    @Autowired
    ClassListDAO classListDAO;

    public List<ClassListDTO> getClassListByCat(String univ_id, String cat_name)
    {

        HashMap<String, Object> parammap = new HashMap<>();
        parammap.put("univ_id", univ_id);
        parammap.put("cat_name", cat_name);

        return classListDAO.getClassListByCat(parammap);
    }

    //검색어 쿼리 기준으로 전체 클래스 검색
    public List<ClassListDTO> getClassListByQuery(String univ_id, String Query)
    {

        HashMap<String, Object> parammap = new HashMap<>();
        parammap.put("univ_id", univ_id);
        parammap.put("Query", Query);

        return classListDAO.getClassListByQuery(parammap);
    }

    // 클래스 수강생 목록 가져오기
    @Autowired
    ClassTakerListDAO classTakerListDAO;

    public List<ClassTakerListDTO> getClasstakerList(String class_id)
    {
        return classTakerListDAO.getClassTakerListDB(class_id);
    }


    // 클래스 등록
    @Autowired
    EnrollClassRepository enrollClassRepository;

    public void enrollClass(EnrollClassEntity enrollClassDTO)
    {
        enrollClassRepository.save(enrollClassDTO);
    }


}
