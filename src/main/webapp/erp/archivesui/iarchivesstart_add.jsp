<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String gid = request.getParameter("gid");//选择人员的新增部分
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员档案首页！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员档案首页信息！";
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员档案首页</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrIarchivesstartService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
  //第一个输入框获取焦点
    document.getElementById("memberId").focus();
}


function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrIarchivesstartService.getIMemberByPk(pk,setIarchivesstart);
    }
}

<!--新增内容-->
var fckvalue = "";
var fck;
function FCKeditor_OnComplete(editorInstance) {
    fck = editorInstance;
    editorInstance.SetHTML(fckvalue);
    window.status = editorInstance.Description;
}

function setIarchivesstart(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iarchivesstart = data.resultList[0];
            DWRUtil.setValue("memberId",iarchivesstart.memberId);//会员id
            DWRUtil.setValue("memberName",iarchivesstart.memberName);//会员姓名
           // DWRUtil.setValue("memberSex",iarchivesstart.memberSex);//会员性别
            setRadioValueByName("memberSex",iarchivesstart.memberSex);	//设置radio的值
            DWRUtil.setValue("memberAge",iarchivesstart.memberAge);//会员年龄
            DWRUtil.setValue("memberBirthday",iarchivesstart.memberBirthday);//会员生日
            DWRUtil.setValue("memberCountry",iarchivesstart.memberCountry);//会员国籍
            DWRUtil.setValue("memberBirthplace",iarchivesstart.memberBirthplace);//出生地
            DWRUtil.setValue("memberOriginplace",iarchivesstart.memberOriginplace);//籍贯
            
            //DWRUtil.setValue("memberNation",iarchivesstart.memberNation);//民族
            setSelectValue("memberNation",iarchivesstart.memberNation);
            DWRUtil.setValue("memberIdcard",iarchivesstart.memberIdcard);//会员卡号
            
            // DWRUtil.setValue("memberIsmarry",iarchivesstart.memberIsmarry);//婚姻状况
            setSelectValue("memberIsmarry",iarchivesstart.memberIsmarry);
            
            DWRUtil.setValue("memberAddress",iarchivesstart.memberAddress);//住址
            DWRUtil.setValue("memberPhone",iarchivesstart.memberPhone);//手机号码
            DWRUtil.setValue("memberJointime",iarchivesstart.memberJointime);//入会时间
            
           // DWRUtil.setValue("bloodType",iarchivesstart.bloodType);//血型
            setSelectValue("bloodType",iarchivesstart.bloodType);
            
            DWRUtil.setValue("rh",iarchivesstart.rh);
            DWRUtil.setValue("companyId",iarchivesstart.companyId);
            DWRUtil.setValue("firstOperator",iarchivesstart.firstOperator);
            DWRUtil.setValue("firstOperatorTime",iarchivesstart.firstOperatorTime);
            DWRUtil.setValue("lastOperator",iarchivesstart.lastOperator);
            DWRUtil.setValue("lastOperatorTime",iarchivesstart.lastOperatorTime);
            DWRUtil.setValue("memo",iarchivesstart.memo);
            DWRUtil.setValue("dr",iarchivesstart.dr);
        }else{
            alert(data.message);
        }
    }else{
        alert(data.message);
    }
}



//--身份证号码验证-支持新的带x身份证
function isIdCardNo(num) 
{
    var factorArr = new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);
    var error;
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;    
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        error = "输入身份证号码长度不对！";
      //  alert(error);
        //frmAddUser.txtIDCard.focus();
        return false;
    }    
    // check and set value
    for(i=0;i<intStrLen;i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            error = "错误的身份证号码！.";
        //    alert(error);
            //frmAddUser.txtIDCard.focus();
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i]*factorArr[i];
        }
    }
    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6,14);
        if (checkDate(date8) == false) {
          //  error = "身份证中日期信息不正确！.";
            //alert(error);
            return false;
        }        
        // calculate the sum of the products
        for(i=0;i<17;i++) {
            lngProduct = lngProduct + varArray[i];
        }        
        // calculate the check digit
        intCheckDigit = 12 - lngProduct % 11;
        switch (intCheckDigit) {
            case 10:
                intCheckDigit = 'X';
                break;
            case 11:
                intCheckDigit = 0;
                break;
            case 12:
                intCheckDigit = 1;
                break;
        }        
        // check last digit
        if (varArray[17].toUpperCase() != intCheckDigit) {
            error = "身份证效验位错误!...正确为： " + intCheckDigit + ".";
            //alert(error);
            return false;
        }
    } 
    else{        //length is 15
        //check date
        var date6 = idNumber.substring(6,12);
        if (checkDate(date6) == false) {
            alert("身份证日期信息有误！.");
            return false;
        }
    }
    //alert ("Correct.");
    return true;
}

function checkDate(date)
{
    return true;
} 










function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    //alert("开始保存数据"+bl);
    if(bl){
        //此处可编写js代码进一步验证数据项
         var memberIdcard = DWRUtil.getValue("memberIdcard");//身份证号
         //alert("身份证号验证的结果为"+isIdCardNo(memberIdcard));
         
         if(!isIdCardNo(memberIdcard)){
             setMustWarn("memberIdcardMust","身份证号格式不正确！");
             return ;
        }
        //Btn.close();
        if(<%=isedit%>){
            dwrIarchivesstartService.updateIMember(getIarchivesstart(),updateCallback);
        }else{
        	
            dwrIarchivesstartService.saveIMember(getIarchivesstart(),saveCallback);
        }
    }
}
function getIarchivesstart(){
    var iarchivesstart = new Object();
    if(<%=isedit%>){
        iarchivesstart.primaryKey = '<%=pk%>';
    }
    iarchivesstart.memberId = DWRUtil.getValue("memberId");
    iarchivesstart.memberName = DWRUtil.getValue("memberName");
    
    //iarchivesstart.memberSex = DWRUtil.getValue("memberSex");
   iarchivesstart.memberSex = getRadioValueByName("memberSex");	//获取radio的值
    iarchivesstart.memberAge = DWRUtil.getValue("memberAge");
    iarchivesstart.memberBirthday = DWRUtil.getValue("memberBirthday");
    iarchivesstart.memberCountry = DWRUtil.getValue("memberCountry");
    iarchivesstart.memberBirthplace = DWRUtil.getValue("memberBirthplace");
    iarchivesstart.memberOriginplace = DWRUtil.getValue("memberOriginplace");
    iarchivesstart.memberNation = DWRUtil.getValue("memberNation");
    iarchivesstart.memberIdcard = DWRUtil.getValue("memberIdcard");
    iarchivesstart.memberIsmarry = DWRUtil.getValue("memberIsmarry");
    iarchivesstart.memberAddress = DWRUtil.getValue("memberAddress");
    iarchivesstart.memberPhone = DWRUtil.getValue("memberPhone");
    iarchivesstart.memberJointime = DWRUtil.getValue("memberJointime");
    iarchivesstart.bloodType = DWRUtil.getValue("bloodType");
    iarchivesstart.rh = DWRUtil.getValue("rh");
    iarchivesstart.companyId = DWRUtil.getValue("companyId");
    iarchivesstart.firstOperator = DWRUtil.getValue("firstOperator");
    iarchivesstart.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    iarchivesstart.lastOperator = DWRUtil.getValue("lastOperator");
    iarchivesstart.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    iarchivesstart.memo = DWRUtil.getValue("memo");
    iarchivesstart.dr = DWRUtil.getValue("dr");
    return iarchivesstart;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员档案首页成功！是否想继续添加会员档案首页？","reset();","继续添加","closePage();","关闭页面");
    }else{
        alertmsg(data);
    }
}
function updateCallback(data){
    //Btn.open();
    if(data.success){
        alertmsg(data,"closePage();");
    }else{
        alertmsg(data);
    }
}
function reset(){
    Sys.reload();
}
function closePage(){
    closeMDITab(<%=tab%>);
}
<!--新增部分,用于选择人员-->
function getupcode(){
	if(<%=gid%>!=null){
		//用于得到用户名
		var box = SEL.getMemberNames("memberName","memberId","getusermsg()");
		box.show();
	}else{
	  	var box = SEL.getMemberNames("memberName","memberId","getusermsg()");
		box.show();
	}
}
</script>
</head>
<body class="inputcls">
    <div class="formDetail">
        <div class="requdiv"><label id="helpTitle"></label></div>
        <div class="formTitle"><%=saveOrEdit%>会员档案首页</div>
        <table class="inputtable">
        
        
            <tr>
              
                <th><em>*</em>&nbsp;&nbsp;会员姓名</th>
                <td>
                    <input type="text" id="memberName" must="会员姓名不能为空!" formust="memberNameMust"></input>
                      <button    onclick="getupcode()" >选择用户</button>
                    <label id="memberNameMust"></label>
                </td>
            </tr>
            
            
      
          <tr>      
                 <th><em>*</em>&nbsp;&nbsp;性别</th>
               <!-- 修改部分 -->
                <td><%=UtilTool.getRadioOptionsByEnum(EnumUtil.HRM_EMPLOYEE_SEX.getSelectAndText(""),"memberSex")%></td>
                <th><em>*</em>&nbsp;&nbsp;会员年龄</th>
                <td>
                    <input type="text" id="memberAge" must="会员年龄不能为空!" formust="memberAgeMust"></input><label id="memberAgeMust"></label>
              </td>
            </tr>
            
          
            
            <tr>          
                 <th><em>*</em>&nbsp;&nbsp;出生日期</th>                                        
                   <td>
						    <input type="text" must="出生日期不能为空！" readonly="readonly" id="memberBirthday" formust="memberBirthdayMust" class="Wdate" onClick="WdatePicker({maxDate:'%y-%M-%d'})" value="<%=UtilWork.getToday() %>">
						    <label id="memberBirthdayMust"></label>
			      </td> 	
                <th><em>*</em>&nbsp;&nbsp;国籍</th>
                <td>
                    <input type="text" id="memberCountry" must="国籍不能为空!" formust="memberCountryMust"></input><label id="memberCountryMust"></label>
                </td>
            </tr>
            
            
            
            
            <tr>
                <th><em>*</em>&nbsp;&nbsp;出生地</th>
                <td>
                    <input type="text" id="memberBirthplace" must="出生地不能为空!" formust="memberBirthplaceMust"></input><label id="memberBirthplaceMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;籍贯</th>
                <td>
                    <input type="text" id="memberOriginplace" must="籍贯不能为空!" formust="memberOriginplaceMust"></input><label id="memberOriginplaceMust"></label>
                </td>
            </tr>
            
            
            
            
            <tr>
               <th><em>*</em>&nbsp;&nbsp;民族</th>       
                	<td>
						  <select must="请选择民族" id="memberNation">
						  <%=UtilTool.getSelectOptions(this.getServletContext(),request,null,"20") %>
						  </select>
						</td>
                <th><em>*</em>&nbsp;&nbsp;身份证号</th>
                <td>
                    <input type="text" id="memberIdcard" must="身份证号不能为空!" formust="memberIdcardMust"></input><label id="memberIdcardMust"></label>
                </td>
            </tr>
            
            
            
            
            <tr>
               <th><em>*</em>&nbsp;&nbsp;婚姻</th> 
                  <td>
						     <select must="请选择婚姻状况" id="memberIsmarry">
						     <%=UtilTool.getSelectOptions(this.getServletContext(),request,null,"02") %>
						     </select>
				</td>
                   
                <th><em>*</em>&nbsp;&nbsp;住址</th>
                <td>
                    <input type="text" id="memberAddress" must="住址不能为空!" formust="memberAddressMust"></input><label id="memberAddressMust"></label>
                </td>
            </tr>
            
            
            
            <tr>
                <th><em>*</em>&nbsp;&nbsp;电话</th>
                <td>
                    <input type="text" id="memberPhone" must="电话不能为空!" formust="memberPhoneMust"></input><label id="memberPhoneMust"></label>
                </td>
              <th><em>*</em>&nbsp;&nbsp;入会时间</th>   
                 <td>
						    <input type="text" must="出生日期不能为空！" readonly="readonly" id="memberJointime" formust="memberJointimeMust" class="Wdate" onClick="WdatePicker({maxDate:'%y-%M-%d'})" value="<%=UtilWork.getToday() %>">
						    <label id="memberJointimeMust"></label>
			      </td> 
            </tr>
            
            
            
                
            <tr>
                <th><em>*</em>&nbsp;&nbsp;药物过敏</th>
                <td>
                    <input type="text" id="drugAllergy" must="药物过敏不能为空!" formust="drugAllergyMust"></input><label id="drugAllergyMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;确诊疾病</th>
                <td>
                    <input type="text" id="diseaseName" must="确诊疾病不能为空!" formust="diseaseNameMust"></input><label id="diseaseNameMust"></label>
                </td>
            </tr>
            
            
            <tr>
                 <th><em>*</em>&nbsp;&nbsp;血型</th>
               
                <td>
						  <select must="请选择血型" id="bloodType">
						  <%=UtilTool.getSelectOptions(this.getServletContext(),request,null,"19") %>
						  </select>
				</td>
                <th><em>*</em>&nbsp;&nbsp;rh</th>
                <td>
                    <input type="text" id="rh" must="rh不能为空!" formust="rhMust"></input><label id="rhMust"></label>
                </td>
            </tr>
            
            
            
            
            <tr>
                <th><em>*</em>&nbsp;&nbsp;公司ID</th>
                <td>
                    <input type="text" id="companyId" must="公司ID不能为空!" formust="companyIdMust"></input><label id="companyIdMust"></label>
                </td>
               
            </tr>
            
           
            <tr>	
				<th>备注</th>
				<td colspan="3">
				<textarea id="memo"  width="90%" style="height: 150px;" ></textarea>		
				</td>
		</tr>
		
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员档案首页信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
