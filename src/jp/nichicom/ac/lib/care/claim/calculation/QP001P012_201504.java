/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: 
 * �쐬��: 2016/07/11
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���t�Ǘ��[ (001)
 * �v���O���� ���t�Ǘ��[ (QP001P012)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ���t�Ǘ��[(�l�����̓�) ���[��`�̃t�@�C���� �F QP001P012_YYYYMM.xml
 */
public class QP001P012_201504 extends QP001PrintEvent {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P012_201504() {
    }

    /**
     * ���[�𐶐����܂��B
     * 
     * @param writer
     *            ����Ǘ��N���X
     * @param printParam
     *            ����p�����^
     * @throws Exception
     *             ������O
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {
        
        // printArray�ɁA�n��p�����[�^�� KEY : PARAM �� VALUE ��ݒ肷��B
        // ���ȉ��AprintArray�Ɋi�[����Ă��郌�R�[�h���Q�Ƃ���B
        VRList styles = (VRList)VRBindPathParser.get("STYLE_DATA", printParam);
        //���Ə����
        VRMap providerMap = (VRMap)printParam.get("PROVIDERS");
        VRMap style = (VRMap)styles.get(0);
        VRMap provider = (VRMap)providerMap.get(style.get("101003"));
        
        String formatName = "QP001P012_201504";
        ACChotarouXMLUtilities.addFormat(writer, formatName, formatName + ".xml");
        writer.beginPageEdit(formatName);
        
        
        // ����p���i�[�p��VRArrayList printArray���`����B
        //�l���ԍ��̕\���ݒ�
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            ACChotarouXMLUtilities.setInvisible(writer, "header1");
            ACChotarouXMLUtilities.setInvisible(writer, "header2");
        }
        
        
        //�T�[�r�X�񋟓���ݒ肷��B
        if(QP001Util.isDate(style.get("101002"))){
            Date target = ACCastUtilities.toDate(VRBindPathParser.get("101002",style) + "01");
            
            //�T�[�r�X�񋟘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer,"teikyoYMD.h1.w1",eraFormat.format(target));
            //�T�[�r�X�񋟘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer,"teikyoyear",eraYearFormat.format(target));
            //�T�[�r�X�񋟌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer,"teikyomonth",monthFormat.format(target));
        }
        
        //��������ݒ肷��B
        if(QP001Util.isDate(printParam.get("SEIKYU_DATE"))){
            Date seikyu = ACCastUtilities.toDate(VRBindPathParser.get("SEIKYU_DATE",printParam));
            //�������a���ݒ肷��B(�l�͉�ʏォ��擾)
            ACChotarouXMLUtilities.setValue(writer,"seikyuwareki",eraFormat.format(seikyu));
            //�������a��N(YY�t�H�[�}�b�g)��ݒ肷��B(�l�͉�ʏォ��擾)
            ACChotarouXMLUtilities.setValue(writer,"seikyuyear",eraYearFormat.format(seikyu));
            //�������񋟌�(MM�t�H�[�}�b�g)��ݒ肷��B(�l�͉�ʏォ��擾)
            ACChotarouXMLUtilities.setValue(writer,"seikyumonth",monthFormat.format(seikyu));
            //�������񋟓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer,"seikyuday",dayFormat.format(seikyu));
        }

        // ���Ə��ԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, style, "101003", "jigyosyono");
        
        // �������Ə����̂�ݒ肷��B �����Ə��̃}�X�^�Ɠˍ�����B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME","jigyosyo.h1.w3");
        // �������Ə��X�֔ԍ���ݒ肷��B �����Ə��̃}�X�^�Ɠˍ�����B
        //PROVIDER_ZIP_FIRST,PROVIDER_ZIP_SECOND
        
        ACChotarouXMLUtilities.setValue(writer, "jigyosyozipfirst", VRBindPathParser.get("PROVIDER_ZIP_FIRST", provider));
        ACChotarouXMLUtilities.setValue(writer, "jigyosyozipsecond",  VRBindPathParser.get("PROVIDER_ZIP_SECOND", provider));
        
        // �������Ə��Z����ݒ肷��B �����Ə��̃}�X�^�Ɠˍ�����B
        ACChotarouXMLUtilities.setValue(writer, provider ,"PROVIDER_ADDRESS","jigyosyo.h3.w3");
        // �������Ə��A�����ݒ肷��B �����Ə��̃}�X�^�Ɠˍ�����B
        ACChotarouXMLUtilities.setValue(writer, "jigyosyo.h5.w6", QkanCommon
                .toTel(VRBindPathParser.get("PROVIDER_TEL_FIRST", provider),
                        VRBindPathParser.get("PROVIDER_TEL_SECOND", provider),
                        VRBindPathParser.get("PROVIDER_TEL_THIRD", provider)));
        
        
        int _101007 = 0;
        int _101008 = 0;
        int _101009 = 0;
        int _101010 = 0;
        
        // �@�ʔԍ�(101005) 0�A�������敪�R�[�h(101006) 05�̃f�[�^���擾����B
        style = getTargetRecord(styles,"00","05");
        if(style != null){
            // (�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w2", getFormatData(style, "101007"));
            // (�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w3", getFormatData(style, "101008"));
            // (�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w4", getFormatData(style, "101009"));
            // (�T�[�r�X��p)�ی������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w5", getFormatData(style, "101010"));
            // (�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w6", getFormatData(style, "101011"));
            // (�T�[�r�X��p)���p�ҕ��S��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w7", getFormatData(style, "101012"));
            
            // (�T�[�r�X��p)������z���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w6", getFormatData(style, "101011"));
            // (�T�[�r�X��p)���p�ҕ��S���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w7", getFormatData(style, "101012"));
            
            _101007 += ACCastUtilities.toInt(style.get("101007"),0);
            _101008 += ACCastUtilities.toInt(style.get("101008"),0);
            _101009 += ACCastUtilities.toInt(style.get("101009"),0);
            _101010 += ACCastUtilities.toInt(style.get("101010"),0);
            
        }

        
        // �@�ʔԍ�(101005) 0�A�������敪�R�[�h(101006) 06�̃f�[�^���擾����B
        style = getTargetRecord(styles,"00","06");
        if(style != null){
            // (�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w2", getFormatData(style, "101007"));
            // (�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w3", getFormatData(style, "101008"));
            // (�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w4", getFormatData(style, "101009"));
            // (�T�[�r�X��p)�ی������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h2.w5", getFormatData(style, "101010"));
            
            _101007 += ACCastUtilities.toInt(style.get("101007"),0);
            _101008 += ACCastUtilities.toInt(style.get("101008"),0);
            _101009 += ACCastUtilities.toInt(style.get("101009"),0);
            _101010 += ACCastUtilities.toInt(style.get("101010"),0);
        }
        
        // (�T�[�r�X��p)�������Z��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w2", getFormatData(_101007));
        // (�T�[�r�X��p)�P�ʐ��E�_�����Z��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w3", getFormatData(_101008));
        // (�T�[�r�X��p)��p���v���Z��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w4", getFormatData(_101009));
        // (�T�[�r�X��p)�ی������z���Z��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w5", getFormatData(_101010));


        int total = 0;
        
        
        // �@�ʔԍ�(101005) 12�A�������敪�R�[�h(101006) 05�̃f�[�^���擾����B
        style = getTargetRecord(styles,"12","05");
        
        if(style != null){
            // (�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w3", getFormatData(style, "101007"));
            // (�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w4", getFormatData(style, "101008"));
            // (�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w5", getFormatData(style, "101009"));
            // (�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // �@�ʔԍ�(101005) 12�A�������敪�R�[�h(101006) 06�̃f�[�^���擾����B
        style = getTargetRecord(styles,"12","06");
        
        if(style != null){
            // (�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w3", getFormatData(style, "101007"));
            // (�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w4", getFormatData(style, "101008"));
            // �@(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w5", getFormatData(style, "101009"));
            // �@(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h2.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
       
        //�픚�ҏ���
        style = getTargetRecord(styles,"81","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h10.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        //���ʑ΍� �S�z�Ə�
        style = getTargetRecord(styles,"58","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h15.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        //�����c���M�l��
        style = getTargetRecord(styles,"25","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // �T�[�r�X��p����v��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w6",getFormatData(total));
        
        
        //�y�[�W�I��
        writer.endPageEdit();
        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }
    
    /**
     * �w�肵�����R�[�h���擾����B
     * @param list �f�[�^���X�g
     * @param lawNo �@�ʔԍ�
     * @param kbn  �������敪�R�[�h
     * @return
     * @throws Exception
     */
    private VRMap getTargetRecord(VRList list, String lawNo, String kbn) throws Exception {
        //�@�ʔԍ�(101005) 0�A�������敪�R�[�h(101006) 05�̃f�[�^���擾����B
        if(list == null) return null;
        
        for(int i = 0; i < list.getDataSize(); i++){
            VRMap map = (VRMap)list.get(i);
            //�@�ʔԍ����m�F����
            if(lawNo.equals(VRBindPathParser.get("101005",map))){
                //�������敪���R�[�h���m�F����
                if(kbn.equals(VRBindPathParser.get("101006",map))){
                    return map;
                }
            }
        }
        return null;
    }
    
    
    private String getFormatData(int value) throws Exception {
        if(value == 0) return "";
        
        return nf.format((double)(value));
    }
    
    private String getFormatData(VRMap style,String key) throws Exception{
        if((style == null) || !style.containsKey(key)) return "";
        
        String value = String.valueOf(style.get(key));
        
        if(ACTextUtilities.isNullText(value) || "0".equals(value)){
            return "";
        }
        
        return nf.format(ACCastUtilities.toDouble(value));
    }
}
