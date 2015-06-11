package com.iseen.member.web.controller.dwr;

import com.iseen.member.core.pojo.IMember;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.centling.common.module.ResultBean;
import com.centling.common.pages.Pager;
import com.centling.common.pages.PagerHelper;
import com.centling.common.util.UtilTool;
import com.centling.common.util.UtilPrimaryKey;
import com.centling.common.util.UtilWork;
import com.centling.common.util.WebUtilWork;
import com.iseen.member.core.iservice.II_memberService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrI_memberService {

    private final static Logger logger = LoggerFactory.getLogger(DwrI_memberService.class);

    @Resource
    private II_memberService i_memberService;

    /**
     * 查询 IMember 分页列表
     * @param context
     * @param request
     * @param iMember
     * @param pager
     */
    public ResultBean listIMember(ServletContext context, HttpServletRequest request, IMember iMember, Pager pager){
        List<IMember> list = null;
        pager = PagerHelper.getPager(pager,i_memberService.listIMemberCount(iMember));
        list = i_memberService.listIMember(iMember, pager);
        logger.info("查询 IMember 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IMember 列表
     * @param context
     * @param request
     * @param iMember
     * @param pager
     */
    public ResultBean listIMemberAll(ServletContext context, HttpServletRequest request){
        IMember iMember = new IMember();
        List<IMember> list = i_memberService.listIMember(iMember);
        logger.info("查询所有 IMember 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IMember
     * @param context
     * @param request
     * @param iMember
     */
    public ResultBean saveIMember(ServletContext context, HttpServletRequest request, IMember iMember){
    	System.out.println("开始保存数据");
    	String empid = UtilTool.getEmployeeId(request);
        System.out.println("页面传递过来的参数为"+iMember.getMemberSex());
             
        try {
      	  iMember.initSave(empid);
      	  iMember.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iMember.setFirstOperator(UtilTool.getEmployeeId(request));
			iMember.setFirstOperatorTime(UtilWork.getNowTime());
			iMember.setLastOperator(UtilTool.getEmployeeId(request));
			iMember.setLastOperatorTime(UtilWork.getNowTime());
			iMember.setLastmodiId(UtilTool.getEmployeeId(request));
			iMember.setLastmodiDate(UtilWork.getNowTime());
			iMember.setDr("N");
		    i_memberService.saveIMember(iMember);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}            
        logger.info("保存 IMember...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IMember
     * @param context
     * @param request
     * @param iMember
     */
    public ResultBean updateIMember(ServletContext context, HttpServletRequest request, IMember iMember){
       
    	IMember tmp = i_memberService.getIMemberByPk(iMember.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        System.out.println("获取的empid的值为"+empid);
        
        try {
        	iMember.initUpdate(empid);
        	tmp.setMemberId(iMember.getMemberId());//更新会员id
        	tmp.setMemberName(iMember.getMemberName());//更新会员名字
        	tmp.setMemberSex(iMember.getMemberSex());//更新会员性别
        	tmp.setMemberAge(iMember.getMemberAge());//更新会员年龄
            tmp.setMemberBirthday(iMember.getMemberBirthday());//更新会员出生日期
            tmp.setMemberCountry(iMember.getMemberCountry());//更新会员国籍
            tmp.setMemberAddress(iMember.getMemberAddress());//更新住址
           tmp.setMemberBirthplace(iMember.getMemberBirthplace());//更新出生地
           tmp.setMemberIsmarry(iMember.getMemberIsmarry());//更新会员是否结婚
           tmp.setMemberIdcard(iMember.getMemberIdcard());//更新会员身份证
           tmp.setMemberJointime(iMember.getMemberJointime());//更新入会时间
           tmp.setMemberNation(iMember.getMemberNation());//更新国籍
           tmp.setMemberPhone(iMember.getMemberPhone());//更新手机号
           tmp.setBloodType(iMember.getBloodType());//更新血型
           tmp.setRh(iMember.getRh());//更新rh
           tmp.setCompanyId(iMember.getCompanyId());//更新子公司id
        	
        	tmp.initUpdate(empid);//这句话很重要
        	tmp.setLastOperator(UtilTool.getEmployeeId(request));
        	tmp.setLastOperatorTime(UtilWork.getNowTime());
        	//tmp.setLastmodiId(UtilTool.getEmployeeId(request));
        	//tmp.setLastmodiDate(UtilWork.getNowTime());
        	//tmp.setDr("N");
  		    i_memberService.saveIMember(tmp);//注意此处，问题全出在此处
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}            
        logger.info("更新 IMember...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IMember
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIMemberByPk(ServletContext context, HttpServletRequest request, String pk){
        IMember iMember = i_memberService.getIMemberByPk(pk);
        logger.info("根据ID获得 IMember...{}", iMember.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iMember);
    }

    /**
     * 删除 IMember
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIMemberByPks(ServletContext context, HttpServletRequest request, String[] pks){
        i_memberService.deleteIMemberByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IMember...{}", pk);
        }
        return WebUtilWork.WebResultPack(null);
    }

/**********************************************
 * 以上代码由CTOA代码生成工具自动生成，请根据具体需求进行修改。
 * 开发人员在此注释以下编写业务逻辑代码，并将自己写的代码框起来，便于后期代码合并，例如：
 **********************************************/

/**********************JC-begin**********************/
    public void method(){
        System.out.println("JC's code here");
    }
/**********************JC-end**********************/

/**********************Jacy-begin**********************/
    public void method2(){
        System.out.println("Jacy's code here");
    }
/**********************Jacy-end**********************/

}