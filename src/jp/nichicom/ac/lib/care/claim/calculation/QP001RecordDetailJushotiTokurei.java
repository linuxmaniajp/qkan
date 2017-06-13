package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 明細（住所地特例）レコード情報
 * 
 */
public class QP001RecordDetailJushotiTokurei  extends QP001RecordDetail {
    // 交換情報識別番号4桁
    private String _1801001 = "";

    // レコード種別コード2桁(14固定)
    private static final String _1801002 = "14";

    // サービス提供年月6桁(YYYYMM)
    private String _1801003 = "";

    // 事業所番号10桁
    private String _1801004 = "";

    // 証記載保険者番号8桁
    private String _1801005 = "";

    // 被保険者番号10桁
    private String _1801006 = "";

    // サービス種類コード2桁
    private String _1801007 = "";

    // サービス項目コード4桁
    private String _1801008 = "";

    // 単位数4桁
    private int _1801009 = 0;

    // 日数･回数2桁
    private int _1801010 = 0;

    // 公費1対象日数・回数2桁
    private int _1801011 = 0;

    // 公費2対象日数・回数2桁
    private int _1801012 = 0;

    // 公費3対象日数・回数2桁
    private int _1801013 = 0;

    // サービス単位数6桁
    private int _1801014 = 0;

    // 公費1対象サービス単位数6桁
    private int _1801015 = 0;

    // 公費2対象サービス単位数6桁
    private int _1801016 = 0;

    // 公費3対象サービス単位数6桁
    private int _1801017 = 0;
    
    // 施設所在保険者番号6桁
    private String _1801018 = "";
    
    // 摘要20桁
    private String _1801019 = "";

    // サービス名称(サービスコードマスタTBLのSERVICE_NAME)
    private String _1801020 = "";

    // 限度額管理対象フラグ
    private String _1801021 = "";

    // システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
    private String _1801022 = "";

    // システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
    private String _1801023 = "";

    // 公費1公費タイプ
    private String _1801024 = "";

    // 公費2公費タイプ
    private String _1801025 = "";

    // 公費3公費タイプ
    private String _1801026 = "";

    // 給付割合
    private int _1801027 = 0;
    
    // [H27.4改正対応][Shinobu Hitaka] 2016/10/04 add - begin 月額算定を印字しない判定用に設定追加
    // 集計集合化区分（算定単位）
    private int _1801028 = 0;
    // [H27.4改正対応][Shinobu Hitaka] 2016/10/04 add - end
    
    // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
    // 総合事業（独自定率）給付率
    private String _1801029 = "";
    
    // 総合事業（独自定額）利用者負担額
    private String _1801030 = "";
    // 2016/10/11 [Yoichiro Kamei] add - end
    
    /**
     * 交換情報識別番号4桁を取得します。
     * 
     * @return
     */
    protected String get_301001() {
        return _1801001;
    }

    /**
     * 交換情報識別番号4桁を設定します。
     * 
     * @param _301001
     */
    protected void set_301001(String _301001) {
        this._1801001 = _301001;
    }

    /**
     * レコード種別コード2桁を取得します。
     * 
     * @return
     */
    protected String get_301002() {
        return _1801002;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を取得します。
     * 
     * @return
     */
    protected String get_301003() {
        return _1801003;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を設定します。
     * 
     * @param _301003
     */
    protected void set_301003(String _301003) {
        this._1801003 = _301003;
    }

    /**
     * 事業所番号10桁を取得します。
     * 
     * @return
     */
    protected String get_301004() {
        return _1801004;
    }

    /**
     * 事業所番号10桁を設定します。
     * 
     * @param _301004
     */
    protected void set_301004(String _301004) {
        this._1801004 = _301004;
    }

    /**
     * 証記載保険者番号8桁を取得します。
     * 
     * @return
     */
    protected String get_301005() {
        return _1801005;
    }

    /**
     * 証記載保険者番号8桁を設定します。
     * 
     * @param _301005
     */
    protected void set_301005(String _301005) {
        this._1801005 = _301005;
    }

    /**
     * 被保険者番号10桁を取得します。
     * 
     * @return
     */
    protected String get_301006() {
        return _1801006;
    }

    /**
     * 被保険者番号10桁を設定します。
     * 
     * @param _301006
     */
    protected void set_301006(String _301006) {
        this._1801006 = _301006;
    }

    /**
     * サービス種類コード2桁を取得します。
     * 
     * @return
     */
    protected String get_301007() {
        return _1801007;
    }

    /**
     * サービス種類コード2桁を設定します。
     * 
     * @param _301007
     */
    protected void set_301007(String _301007) {
        this._1801007 = _301007;
    }

    /**
     * サービス項目コード4桁を取得します。
     * 
     * @return
     */
    protected String get_301008() {
        return _1801008;
    }

    /**
     * サービス項目コード4桁を設定します。
     */
    protected void set_301008(String _301008) {
        this._1801008 = _301008;
    }

    /**
     * 単位数4桁を取得します。
     * 
     * @return
     */
    protected int get_301009() {
        return _1801009;
    }

    /**
     * 単位数4桁を設定します。
     * 
     * @param _301009
     */
    protected void set_301009(int _301009) {
        this._1801009 = _301009;
    }

    /**
     * 日数･回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301010() {
        return _1801010;
    }

    /**
     * 日数･回数2桁を設定します。
     * 
     * @param _301010
     */
    protected void set_301010(int _301010) {
        this._1801010 = _301010;
    }

    /**
     * 公費1対象日数・回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301011() {
        return _1801011;
    }

    /**
     * 公費1対象日数・回数2桁を設定します。
     * 
     * @param _301011
     */
    protected void set_301011(int _301011) {
        this._1801011 = _301011;
    }

    /**
     * 公費2対象日数・回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301012() {
        return _1801012;
    }

    /**
     * 公費2対象日数・回数2桁を設定します。
     * 
     * @param _301012
     */
    protected void set_301012(int _301012) {
        this._1801012 = _301012;
    }

    /**
     * 公費3対象日数・回数2桁を取得します。
     * 
     * @return
     */
    protected int get_301013() {
        return _1801013;
    }

    /**
     * 公費3対象日数・回数2桁を設定します。
     * 
     * @param _301013
     */
    protected void set_301013(int _301013) {
        this._1801013 = _301013;
    }

    /**
     * サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301014() {
        return _1801014;
    }

    /**
     * サービス単位数6桁を設定します。
     * 
     * @param _301014
     */
    protected void set_301014(int _301014) {
        this._1801014 = _301014;
    }

    /**
     * 公費1対象サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301015() {
        return _1801015;
    }

    /**
     * 公費1対象サービス単位数6桁を設定します。
     * 
     * @param _301015
     */
    protected void set_301015(int _301015) {
        this._1801015 = _301015;
    }

    /**
     * 公費2対象サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301016() {
        return _1801016;
    }

    /**
     * 公費2対象サービス単位数6桁を設定します。
     * 
     * @param _301016
     */
    protected void set_301016(int _301016) {
        this._1801016 = _301016;
    }

    /**
     * 公費3対象サービス単位数6桁を取得します。
     * 
     * @return
     */
    protected int get_301017() {
        return _1801017;
    }

    /**
     * 公費3対象サービス単位数6桁を設定します。
     * 
     * @param _301017
     */
    protected void set_301017(int _301017) {
        this._1801017 = _301017;
    }

    /**
     * 施設所在保険者番号6桁を取得します。
     * 
     * @return
     */
    protected String get_1801018() {
        return _1801018;
    }

    /**
     * 施設所在保険者番号6桁を設定します。
     * 
     * @param _1801018
     */
    protected void set_1801018(String _1801018) {
        this._1801018 = _1801018;
    }
    
    /**
     * 摘要20桁を取得します。
     * 
     * @return
     */
    protected String get_301018() {
        return _1801019;
    }

    /**
     * 摘要20桁を設定します。
     * 
     * @param _301018
     */
    protected void set_301018(String _301018) {
        this._1801019 = _301018;
    }

    /**
     * サービス名称(サービスコードマスタTBLのSERVICE_NAME)を取得します。
     * 
     * @return
     */
    protected String get_301019() {
        return _1801020;
    }

    /**
     * サービス名称(サービスコードマスタTBLのSERVICE_NAME)を設定します。
     * 
     * @param _301019
     */
    protected void set_301019(String _301019) {
        this._1801020 = _301019;
    }

    /**
     * 限度額管理対象フラグを取得します。
     * 
     * @return
     */
    protected String get_301020() {
        return _1801021;
    }

    /**
     * 限度額管理対象フラグを設定します。
     * 
     * @param _301020
     */
    protected void set_301020(String _301020) {
        this._1801021 = _301020;
    }

    /**
     * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を取得します。
     * 
     * @return
     */
    protected String get_301021() {
        return _1801022;
    }

    /**
     * システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)を設定します。
     * 
     * @param _301021
     */
    protected void set_301021(String _301021) {
        this._1801022 = _301021;
    }

    /**
     * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を取得します。
     * 
     * @return
     */
    protected String get_301022() {
        return _1801023;
    }

    /**
     * システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)を設定します。
     * 
     * @param _301022
     */
    protected void set_301022(String _301022) {
        this._1801023 = _301022;
    }

    /**
     * 公費1公費タイプを取得します。
     * 
     * @return
     */
    protected String get_301023() {
        return _1801024;
    }

    /**
     * 公費1公費タイプを設定します。
     * 
     * @param _301023
     */
    protected void set_301023(String _301023) {
        this._1801024 = _301023;
    }

    /**
     * 公費2公費タイプを取得します。
     * 
     * @return
     */
    protected String get_301024() {
        return _1801025;
    }

    /**
     * 公費2公費タイプを設定します。
     * 
     * @param _301024
     */
    protected void set_301024(String _301024) {
        this._1801025 = _301024;
    }

    /**
     * 公費3公費タイプを取得します。
     * 
     * @return
     */
    protected String get_301025() {
        return _1801026;
    }

    /**
     * 公費3公費タイプを設定します。
     * 
     * @param _301025
     */
    protected void set_301025(String _301025) {
        this._1801026 = _301025;
    }

    /**
     * 給付割合を取得します。
     * 
     * @return
     */
    protected int get_301026() {
        return _1801027;
    }

    /**
     * 給付割合を設定します。
     * 
     * @param _301026
     */
    protected void set_301026(int _301026) {
        this._1801027 = _301026;
    }
    
    // [H27.4改正対応][Shinobu Hitaka] 2016/10/05 add - begin 月額算定を印字しない判定用に設定追加
    /**
     * 集計集合化区分（算定単位）を取得します。
     * 
     * @return
     */
    protected Integer get_301027() {
        return _1801028;
    }

    /**
     * 集計集合化区分（算定単位）を設定します。
     * 
     * @param _301027
     */
    protected void set_301027(Integer _301027) {
        this._1801028 = _301027;
    }
    // [H27.4改正対応][Shinobu Hitaka] 2016/10/05 add - end
    
    // 2016/10/11 [Yoichiro Kamei] add - begin 総合事業対応
    /**
     * 総合事業（独自定率）給付率を取得します。
     * 
     * @return
     */
    protected String get_301028() {
		return _1801029;
	}
    /**
     * 総合事業（独自定率）給付率を設定します。
     * 
     * @param _301028
     */
    protected void set_301028(String _301028) {
		this._1801029 = _301028;
	}
    /**
     * 総合事業（独自定額）利用者負担額を取得します。
     * 
     * @return
     */
    protected String get_301029() {
		return _1801030;
	}
    /**
     * 総合事業（独自定額）利用者負担額を設定します。
     * 
     * @param _301029
     */
    protected void set_301029(String _301029) {
		this._1801030 = _301029;
	}
    // 2016/10/11 [Yoichiro Kamei] add - end
    
    protected static QP001RecordDetailJushotiTokurei getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap detailMap,QP001Manager manager, String jushotiTokureiInsurerId) throws Exception {
        
    	QP001RecordDetailJushotiTokurei detail = null;
        
        //レコードの作成可否を判断
        if(!isMakeRecord(serviceDetail,serviceCode, patientState)){
            return detail;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState,
                                    manager,
                                    jushotiTokureiInsurerId);
        
        //条件に合致するレコードが存在しない場合
        if(!detailMap.containsKey(serial)){
            detail = new QP001RecordDetailJushotiTokurei();
        	//施設所在保険者番号
            detail.set_1801018(jushotiTokureiInsurerId);
            detailMap.put(serial,detail);
        //条件に合致するレコードが存在する場合
        } else {
            detail = (QP001RecordDetailJushotiTokurei)detailMap.get(serial);
        }
        
        return detail;
    }
    
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,QP001Manager manager, String jushotiTokureiInsurerId) throws Exception {
        //レコードのシリアルIDを作成
        StringBuilder serial = new StringBuilder();
        // 交換識別番号
        serial.append(identificationNo);
        // レコード種別コード2桁(02固定)
        serial.append(_1801002);
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // 事業所番号10桁
        serial.append(serviceDetail.get("PROVIDER_ID"));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(targetServiceDate));
        // 被保険者番号10桁
        serial.append(patientState.getInsuredId(targetServiceDate));
        // システム内サービス種類コード
        serial.append(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"));
        //サービス種類コード
        serial.append(serviceCode.get("SERVICE_CODE_KIND"));
        //サービス項目コード
        serial.append(serviceCode.get("SERVICE_CODE_ITEM"));
        
        // 施設所在保険者番号6桁
        serial.append(jushotiTokureiInsurerId);
        
        //福祉用具対応
        if(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0) != 3){
            //serial.append(QP001Manager.getInstance().getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
            serial.append(manager.getServiceUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),serviceCode));
        } else {
            serial.append(ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"),0));
        }
        
        serial.append(QP001SpecialCase.getDetailSerial(serviceDetail,serviceCode));
        
        return serial.toString();
    }
    
    
    /**
     * データ作成
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        // 交換情報識別番号4桁
        setData(result, "1801001", get_301001());
        // レコード種別コード2桁(14を設定)
        setData(result, "1801002", get_301002());
        // サービス提供年月6桁(YYYYMM)
        setData(result, "1801003", get_301003());
        // 事業所番号10桁
        setData(result, "1801004", get_301004());
        // 証記載保険者番号8桁
        setData(result, "1801005", get_301005());
        // 被保険者番号10桁
        setData(result, "1801006", get_301006());
        // サービス種類コード2桁
        setData(result, "1801007", get_301007());
        // サービス項目コード4桁
        setData(result, "1801008", get_301008());
        // 単位数4桁
        setData(result, "1801009", get_301009());

        //日数･回数2桁
        setData(result, "1801010", get_301010());
        //公費1対象日数・回数2桁
        setData(result, "1801011", get_301011());
        //公費2対象日数・回数2桁
        setData(result, "1801012", get_301012());
        //公費3対象日数・回数2桁
        setData(result, "1801013", get_301013());
        //サービス単位数6桁
        setData(result, "1801014", get_301014());
        //公費1対象サービス単位数6桁
        setData(result, "1801015", get_301015());
        //公費2対象サービス単位数6桁
        setData(result, "1801016", get_301016());
        //公費3対象サービス単位数6桁
        setData(result, "1801017", get_301017());
        
        //施設所在保険者番号6桁
        setData(result, "1801018", get_1801018());
        //摘要20桁
        setData(result, "1801019", get_301018());
        
        //サービス名称(サービスコードマスタTBLのSERVICE_NAME)
        setData(result, "1801020", get_301019());

        //限度額管理対象フラグ
        setData(result, "1801021", get_301020());
		//システム内サービス種類コード(SYSTEM_SERVICE_KIND_DETAIL)
		setData(result,"1801022",get_301021());
		//システム内サービス項目コード(SYSTEM_SERVICE_CODE_ITEM)
		setData(result,"1801023",get_301022());

		//集計集合化区分（算定単位）(TOTAL_GROUPING_TYPE) add 2016.10.05
		setData(result,"1801028",get_301027());
		
		//総合事業（独自定率）給付率 add 2016.10.11
		setData(result,"1801029",get_301028());
		//総合事業（独自定額）利用者負担額 add 2016.10.11
		setData(result,"1801030",get_301029());

        return result;
    }

    private VRMap copyStyle(VRMap style) {
        VRMap result = new VRHashMap();
        Object key;
        //ディープコピー
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        //明細情報（住所地特例）レコード        
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_DETAILED_JUSHOTI_TOKUREI);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[1801001=" + get_301001() + "]\n");
        result.append("[1801002=" + get_301002() + "]\n");
        result.append("[1801003=" + get_301003() + "]\n");
        result.append("[1801004=" + get_301004() + "]\n");
        result.append("[1801005=" + get_301005() + "]\n");
        result.append("[1801006=" + get_301006() + "]\n");
        result.append("[1801007=" + get_301007() + "]\n");
        result.append("[1801008=" + get_301008() + "]\n");
        result.append("[1801009=" + get_301009() + "]\n");
        result.append("[1801010=" + get_301010() + "]\n");
        result.append("[1801011=" + get_301011() + "]\n");
        result.append("[1801012=" + get_301012() + "]\n");
        result.append("[1801013=" + get_301013() + "]\n");
        result.append("[1801014=" + get_301014() + "]\n");
        result.append("[1801015=" + get_301015() + "]\n");
        result.append("[1801016=" + get_301016() + "]\n");
        result.append("[1801017=" + get_301017() + "]\n");        
        result.append("[1801018=" + get_1801018() + "]\n");
        result.append("[1801019=" + get_301018() + "]\n");
        result.append("[1801020=" + get_301019() + "]\n");
        result.append("[1801021=" + get_301020() + "]\n");
        result.append("[1801022=" + get_301021() + "]\n");
        result.append("[1801023=" + get_301022() + "]\n");
        result.append("[1801024=" + get_301023() + "]\n");
        result.append("[1801025=" + get_301024() + "]\n");
        result.append("[1801026=" + get_301025() + "]\n");
        result.append("[1801027=" + get_301026() + "]\n");
        result.append("[1801028=" + get_301027() + "]\n"); // add 2016.10.05
        //result.append(kohiManager);
        return result.toString();
    }    
    
}
