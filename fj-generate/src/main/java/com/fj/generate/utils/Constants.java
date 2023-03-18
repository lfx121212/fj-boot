package com.fj.generate.utils;

/**
 * <p>
 * 常量类
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 17:19
 */
public class Constants {
    // 通用
    public final static String ERR_DATAERROR = "数据异常";
    public final static String ERR_PARSE_DATAERROR = "数据转换异常";

    public final static String SYNCDATASUCCESS = "同步基础数据成功";
    public final static String SYNCDATAFAILURE = "同步基础数据失败";

    public final static String SUCCESS = "操作成功";
    public final static String FAILURE = "操作失败";

    public final static String SUC_SAVE = "保存数据成功";
    public final static String SUC_UPDATE = "更新数据成功";
    public final static String SUC_DELETE = "删除数据成功";
    public final static String SUC_CANCEL = "撤消数据成功";
    public final static String SUC_FIND = "查询数据成功";
    public final static String SUC_QUERY = "查询数据列表成功";

    public final static String ERR_SAVE = "保存数据失败";
    public final static String ERR_UPDATE = "更新数据失败";
    public final static String ERR_DELETE = "删除数据失败";
    public final static String ERR_CANCEL = "撤消数据失败";
    public final static String ERR_FIND = "查询数据失败";
    public final static String ERR_QUERY = "查询数据列表失败";

    public final static String ERR_NO_RECORD = "未找到指定记录/列表信息";
    public final static String ERR_EXIST_RECORD = "指定记录/列表已存在";

    public final static String NO_PARAMETERS_NEED_OPERATED = "没有需要操作的数据";

    // 查询条件
    public final static String ERR_NEED_PARAMETERS = "指定参数不能为空";
    public final static String ERR_NEED_PATIENT = "患者基础信息不能为空";
    public final static String ERR_NEED_DEPT = "科室/病区(护理单元)信息不能为空";
    public final static String ERR_DATE_FORMAT = "时间格式错误";
    public final static String ERR_START_DATE_FORMAT = "开始时间格式错误";
    public final static String ERR_END_DATE_FORMAT = "结束时间格式错误";

    // 时间,注意前面带空格
    public final static String MIN_HOUR = " 00:00:00";
    public final static String MAX_HOUR = " 23:59:59";

    // 用户登录
    public final static String SUC_LOGIN_SUCCESS = "用户登录成功";
    public final static String ERR_LOGIN_FILURE = "登录用户或密码不正确";
    public final static String ERR_NO_USER = "未找到指定用户信息";
    public final static String ERR_NORIGHT = "用户无此权限";

    // 授权
    public final static String ERR_NO_AUTHORIZATION = "无法获取授权信息，请与供应商联系。";
    public final static String ERR_AUTHORIZATION = "授权错误，请与供应商联系。";
    public final static String ERR_AUTHORIZATION_EXPIRE = "此系统到期，不能继续使用，请与供应商联系。";
    public final static String SUC_AUTHORIZATION_ADVENTUS_EXPIRE = "此子系统还有day天使用权,请及时与供应商联系。";

    // 评估单/记录单相关
    public final static String ERR_ONLY_ONE_FOR_DEPT = "此类型,当前科室只能创建一个病例文件";
    public final static String ERR_ONLY_ONE = "此类型,全院只能创建一个病例文件";
    public final static String ERR_TEMPLET_TYPE = "评估单/记录单类型异常";
    public final static String ERR_NO_TEMPLET = "未查询到对应的病历模板信息";
    public final static String ERR_NO_RECORDINDEX = "未查询到对应的病历索引信息";
    public final static String ERR_IS_LOCKED = "当前文档已被锁定,无法修改";

    // 计划任务
    public final static String ERR_NORUN_JOB = "计划任务没有运行";
    public final static String SUC_START_JOB = "启动计划任务成功";
    public final static String SUC_STOP_JOB = "停止计划任务成功";
    public final static String SUC_PAUSE_JOB = "暂停计划任务成功";
    public final static String SUC_DEL_JOB = "删除计划任务成功";

    public final static String ERR_START_JOB = "启动计划任务失败";
    public final static String ERR_STOP_JOB = "停止计划任务失败";
    public final static String ERR_PAUSE_JOB = "暂停计划任务失败";
    public final static String ERR_DEL_JOB = "删除计划任务失败";

    // 其它
    public final static String ERR_NO_DEPT = "未找到对应的科室/病区(护理单元)信息";
    public final static String ERR_QUERY_DEPT = "查询科室/病区(护理单元)信息错误";
    public final static String ERR_QUERY_TEMPBASE = "查询体温单项目字典记录错误";

    public final static String SUC_CANCEL_ORDERS = "撤消当前医嘱执行单成功";
    public final static String ERR_CANCEL_ORDERS = "无法撤消当前医嘱执行单";
    public final static String ERR_CANCEL_CHECK = "当前药品已执行,无法取消核对";
    public final static String ERR_NO_CHECK = "当前药品未核对,无法执行";
    public final static String ERR_NO_ORDER = "未找到对应的药品信息,无法执行";

    public final static String ERR_CANNOT_OTHER = "无法更改其它用户信息";

    public final static String ERR_NO_GATHER = "存在标本未采集记录";
    public final static String ERR_NEED_RATE = "请输入滴速信息";

    // 住院新增项目，病人状态验证

    public final static String ERR_PATIENT_NOEXIST = "病人无在院记录";
    public final static String ERR_PATIENT_NOCHARGETYPE = "病人费别为空";

    public static final String ERR_PRESC_CHECK_DIAG_NULL = "诊断不能为空";
    public static final String ERR_PRESC_CHECK_DOSAGE_ILLEGAL = "药品【%s】单次用量不合法！";
    public static final String ERR_PRESC_CHECK_ADMINISTRATION_NULL = "药品【%s】途径不能为空！";
    public static final String ERR_PRESC_CHECK_UNIT_NULL = "药品【%s】剂量单位不能为空！";
    public static final String ERR_PRESC_CHECK_INPUT_AMOUNT_ILLEGAL = "【%s】数量非法！";
    /**
     * 出院带药标识，为1的时候是出院带药
     */
    public static final Integer DISCHARGE_TAKING_INDICATOR = 1;
    /**
     * 长期医嘱标识
     */
    public static final Integer REPEAT_INDICATOR_LONG = 1;
    /**
     * 临时医嘱标识
     */
    public static final Integer REPEAT_INDICATOR_SHORT = 0;
    /**
     * 出院带药医嘱的医生说明提示文字
     */
    public static final String DISCHARGE_TAKING_INDICATOR_FREQDETAILS = "出院带药;";
    public static final String PRESC_ATTR_NORMAL = "普通处方";
    public static final String PRESC_ATTR_DUMA = "毒麻精一";
    public static final String PRESC_ATTR_JINGSHEN = "精二处方";
    /**
     * 西药类别代码A
     */
    public static final String PRESC_DRUG_CLASS_WESTERN_MEDICINE = "A";
    /**
     * 草药类别代码B
     */
    public static final String PRESC_DRUG_CLASS_HERBS = "B";
    /**
     * 住院处方状态：未发药（0：未发药，1：已发药，2：已作废，3：等待退药）
     */
    public static final Integer PRESC_STATE_STAUTS_DISTRIBUTE_MEDICINE = 0;

    /**
     * 错误的处方状态
     */
    public static final String ERR_PRESC_STAUTS = "处方状态错误，不允许修改";
    /**
     * 病理检查项目类别名称
     */
    public static final String PATHOLOGY_EXAM_CLASS = "病理";
    /**
     * 查询发药药房时，默认的药房类型
     */
    public static final String DEFAULT_STORAGE_TYPE = "药房";

    public static final String ERR_PRICE = "药品【%s】，价表错误！";
    public static final String PRESC_MESSAGE_TYPE_01 = "请输入处方名称！";
    public static final String PRESC_MESSAGE_TYPE_02 = "请输入剂数！";
    public static final String PRESC_MESSAGE_TYPE_03 = "请先选择药局！";
    public static final String PRESC_MESSAGE_TYPE_05 = "-处方已发药，不能保存！";
    public static final String PRESC_MESSAGE_TYPE_06 = "-处方已发药，不能毁方！";
    public static final String PRESC_MESSAGE_TYPE_07 = "-处方已发药，不能删除！";
    public final static String PRESC_MESSAGE_TYPE_08 = "处方生成的医嘱护士已转抄，不能保存！";

    public static final String FTP_SERVER_ERROR = "连接Ftp服务器报错";

    public static final String FTP_SERVER_CLOSE_ERROR = "Ftp服务器关闭报错";

    public static final String FTP_DEL_ERROR = "FTP文件删除报错";

    public static final String FTP_DEL_LOCAL_ERROR = "删除本地文件报错";

    public static final String FTP_DOWNLOAD_ERROR = "FTP下载文件报错";

    public static final String FTP_DOWNLOAD_CANNOTUSE = "Ftp文件夹已经被删除无法下载文件";

    public static final String FTP_WRITE_LOCAL_ERROR = "写入本地文件报错";

    public static final String FTP_CREATE_DIR_ERROR = "创建Ftp文件夹出错请查找Ftp配置";

    public static final String FTP_UPLAOD_ERROR = "FTP上传文件报错";

    public static final String FTP_FILE_NOTEXIST_ERROR = "文件在本地不存在可能FTP上已经删除";

    public static final String FTP_FILE_DIR_ERROR = "FTP文件夹不存在";
    public static final String FTP_FILE_ISEXIST_ERROR = "FTP文件不存在";

    public static final String FTP_FILE_DEL_ERROR = "FTP删除文件错误";

    public static final String FILE_OPER_COPY_ERROR = "复制整个文件夹内容操作出错";

    public static final String FILE_OPER_RENAME_ERROR = "文件重命名出错";

    public static final String FILE_OPER_READ_ERROR = "文件读取出错";
    public static final String FILE_OPER_ISEXIST_ERROR = "文件不存在";
    public static final String FILE_OPER_DELEDIR_ERROR = "删除文件夹";
    public static final String FILE_OPER_DELEFILE_ERROR = "删除文件";
    public static final String FILE_OPER_CREATEDIR_ERROR = "新建目录";
    public static final String MR_DIAGNOSISNAME = "病种名称不存在";//模板病种未查询到新


    public static final String MR_FILE_NODATA_SUBMIT = "当前患者没有可提交的病历数据!";
    public static final String MR_FILE_UPLOAD_XML_ERROR = "病历文件Xml上传失败!";
    public static final String MR_FILE_UPLOAD_JSON_ERROR = "病历文件Json上传失败!";
    public static final String MR_FILE_NOSIGN = "当前患者有未签名的病历!";
    public static final String MR_FIEL_SIGN_ERROR = "病历签名错误!";
    public static final String MR_FILE_NO_SIGN = "未签名无需解签！";
    public static final String MR_FILE_SIGNED = "当前病历已签名!";
    public static final String MR_FILE_SIGN_ACCOUNT_ERROR = "当前签名账号不正确!";
    public static final String MR_FILE_SIGN_GRADE_ERROR = "签名级别不正确!";
    public static final String MR_FILE_UNSIGN_NO_ROLE_ERROR = "当前账号没有权限进行解签!";
    public static final String MR_FIEL_UNSIGN_ERROR = "解除病历签名错误!";
    public static final String MR_FILE_CREATE_ERROR = "创建病历文件失败!";
    public static final String NOT_EMPTY = "%s不能为空!";
    public static final String NOT_NULL = "%s不能为空!";

    // 医嘱状态字典名称(为了从公用大字典中获取数据)
    public final static String ORDER_STATUS_DICT = "order_status_dict";
    // 计价属性
    public final static String BILLING_ATTRIBUTE = "BILLING_ATTRIBUTE";

    //医嘱相关
    public final static String ERR_PATIENT_CANCEL_ORDERS = "【%s】已提交医嘱不能删除，请使用作废功能！";
    public final static String ORDER_MESSAGE_TYPE_01 = "【%s】未保存医嘱不用作废，可以直接删除！";
    public final static String ORDER_MESSAGE_TYPE_02 = "【%s】医嘱未传输，可以直接删除，不用作废！";
    public final static String ORDER_MESSAGE_TYPE_03 = "【%s】医嘱已经停止不允许作废！";
    public final static String ORDER_MESSAGE_TYPE_04 = "医嘱已经摆药不允许作废！";
    public final static String ORDER_MESSAGE_TYPE_05 = "医嘱已经计费不允许作废！";
    public final static String ORDER_MESSAGE_TYPE_06 = "非申请医生";
    public final static String ORDER_MESSAGE_TYPE_07 = "用血申请已经处理";
    public final static String ORDER_MESSAGE_TYPE_08 = "【%s】处方已经发药，不能作废医嘱!";
    public final static String ORDER_MESSAGE_TYPE_09 = "【%s】草药的药品请开具处方！";
    public final static String ORDER_MESSAGE_TYPE_10 = "药品【%s】已停价！";
    public final static String ORDER_MESSAGE_TYPE_11 = "【%s】医嘱已经作废，不能重复操作！";
    public final static String ORDER_MESSAGE_TYPE_12 = "【%s】医嘱的开始时间不能为空!";
    public final static String ORDER_MESSAGE_TYPE_13 = "【%s】医嘱开始时间不允许大于入科时间";
    public final static String ORDER_MESSAGE_TYPE_14 = "【%s】医嘱类型不能为空！";
    public final static String ORDER_MESSAGE_TYPE_15 = "【%s】长期和临时分类不能为空！";
    public final static String ORDER_MESSAGE_TYPE_16 = "【%s】药品剂量必须大于0！";
    public final static String ORDER_MESSAGE_TYPE_17 = "【%s】药品剂量单位不能为空！";
    public final static String ORDER_MESSAGE_TYPE_18 = "【%s】药品途径不能为空！";
    public final static String ORDER_MESSAGE_TYPE_19 = "【%s】是抗菌药物，请选择用药目的！";
    public final static String ORDER_MESSAGE_TYPE_20 = "【%s】长期医嘱频次不能为空！";
    public final static String ORDER_MESSAGE_TYPE_21 = "【%s】长期医嘱执行时间不能为空！";
    public final static String ORDER_MESSAGE_TYPE_22 = "医嘱已计价不能删除！";
    public final static String ORDER_MESSAGE_TYPE_23 = "医嘱已计价不能保存！";
    public final static String ORDER_MESSAGE_TYPE_24 = "医嘱已摆药不能删除！";
    public final static String ORDER_MESSAGE_TYPE_25 = "医嘱已摆药不能保存！";
    public final static String ORDER_MESSAGE_TYPE_26 = "【%s】的频次【%s】在医嘱执行频率字典(PERFORM_FREQ_DICT)未找到！";
    public final static String ORDER_MESSAGE_TYPE_27 = "【%s】医嘱开始时间合理范围是%s至%s！";
    public final static String ORDER_MESSAGE_TYPE_28 = "【%s】医嘱结束时间不能为空！";
    public final static String ORDER_MESSAGE_TYPE_29 = "【%s】医嘱未审核不能停止！";
    public final static String ORDER_MESSAGE_TYPE_30 = "【%s】医嘱非长期医嘱不能停止！";
    public final static String ORDER_MESSAGE_TYPE_31 = "【%s】医嘱计价属性不能为空！";

    public final static String PATIENT_MESSAGE_TYPE_01 = "【%s】病人已下出院通知，不能再新开项目！";
    public final static String PATIENT_MESSAGE_TYPE_02 = "该病人已出院，不能再新开项目！";

    public final static String OPERATION_MESSAGE_TYPE_01 = "预计手术时间不能为空，请填写申请时间！";
    public final static String OPERATION_MESSAGE_TYPE_02 = "手术室不能为空！";
    public final static String OPERATION_MESSAGE_TYPE_03 = "手术医师不能为空！";
    public final static String OPERATION_MESSAGE_TYPE_04 = "第一手术助手不能为空！";
    public final static String OPERATION_MESSAGE_TYPE_05 = "拟实施手术项目名称不能为空！";
    public final static String OPERATION_MESSAGE_TYPE_06 = "手术项目【%s】的手术等级不能为空！";
    public final static String OPERATION_MESSAGE_TYPE_07 = "预计手术时间【%s】不能小于当前时间【%s】！";
    public final static String OPERATION_MESSAGE_TYPE_08 = "普通手术：预计手术时间必须大于今日【%s】！";
    public final static String OPERATION_MESSAGE_TYPE_09 = "普通手术：预计手术时间的时间段必须在【%s】至【%s】，特殊情况请联系手术后再保存！\";！";
    public final static String OPERATION_MESSAGE_TYPE_10 = "普通手术的申请时间不允许在【%s】，系统设置合理的星期范围【%s】，请调整手术申请时间！";
    public final static String OPERATION_MESSAGE_TYPE_11 = "急诊或紧急手术，预计手术时间的时间段必须在【%s】至【%s】，特殊情况请联系手术后再保存！";
    public static final String DRUG_QUANTITY_UNDER_SUPPLY = "【%s】药品不可供！";
    public static final String DRUG_QUANTITY_NOT_ENOUGH = "%s药品库存为%s，使用数量为%s，库存不足！";

    public static final String LAB_MESSAGE_TYPE_01 = "检验申请项目【%S】执行科室不能为空！";
    public static final String LAB_MESSAGE_TYPE_02 = "检验申请项目【%s】采样标本不能为空！";
    public static final String LAB_MESSAGE_TYPE_03 = "【%s】有检验申请项目【%s】未做检查，请先撤销检验申请项目再开出院通知！";

    public static final String EXAM_MESSAGE_TYPE_01 = "检查申请项目【%S】执行科室不能为空！";
    public static final String EXAM_MESSAGE_TYPE_02 = "检查申请项目【%s】检查类别不能为空！";
    public static final String EXAM_MESSAGE_TYPE_03 = "检查申请项目【%s】检查部位不能为空！";
    public static final String EXAM_MESSAGE_TYPE_04 = "检查申请项目【%s】为病理类，请填写病理信息！";
    public static final String EXAM_MESSAGE_TYPE_05 = "检查申请项目【%s】为病理类，年龄在11与55岁之间的女性，需要填写末次月经！";
    public static final String EXAM_MESSAGE_TYPE_06 = "【%s】有检查申请项目【%s】未做检查，请先撤销检查申请项目再开出院通知！";

    public static final String DIAGNOSIS_MESSAGE_TYPE_01 = "【%s】项目临床诊断不能为空！";

    public static final String DISCHARGED_MESSAGE_TYPE_01 = "出院通知说明不允许超过80个字符！";
    public static final String DISCHARGED_MESSAGE_TYPE_02 = "【%s】有长期医嘱没有停止，请先停止长期医嘱再开出院通知！";
    public static final String DISCHARGED_MESSAGE_TYPE_03 = "【%s】保存的医嘱未提交，请先提交医嘱再开出院通知！";
    public static final String DISCHARGED_MESSAGE_TYPE_04 = "【%s】停止的医嘱未提交，请先提交医嘱再开出院通知！";
    public static final String DISCHARGED_MESSAGE_TYPE_05 = "【%s】临时医嘱未发药,请联系药房发药或者作废相应的医嘱！";

    public static final String TREAT_PROJECT_MESSAGE_TYPE_01 = "套餐模板标题不能为空！";
    public static final String TREAT_PROJECT_MESSAGE_TYPE_02 = "模板类型不能为空！";
    public static final String TREAT_PROJECT_MESSAGE_TYPE_03 = "科室不能为空！";
    public static final String TREAT_PROJECT_MESSAGE_TYPE_04 = "请选择模板权限！";
    public static final String CHARGE_TYPE_DICT_MESSAGE_01 = "费别【%s】，不在费别字典(CHARGE_TYPE_DICT)中，请联系管理员维护数据！";
    public static final String CHARGE_PRICE_SCHEDULE_MESSAGE_01 = "费别【%s】，不在 收费系数字典(CHARGE_PRICE_SCHEDULE)中，请联系管理员维护数据！";
    public static final String CLINIC_VS_CHARGE_MESSAGE_01 = "【%s】从临床与物价对照表中查询不到数据，请联系物价部门！";
    public final static String XML_ERROR = "XML解析错误!";

    public final static String BORROW_APPLY_ERROR = "申请失败，该患者已存在相同的申请记录，请修改申请时间重新申请!";
}
