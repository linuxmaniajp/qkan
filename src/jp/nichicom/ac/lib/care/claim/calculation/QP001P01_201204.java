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
 * �J����: �����@�L
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���t�Ǘ��[ (001)
 * �v���O���� ���t�Ǘ��[ (QP001P02)
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
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ���t�Ǘ��[(�l�����) ���[��`�̃t�@�C���� �F QP001P010_YYYYMM.xml
 */
public class QP001P01_201204 extends QP001PrintEvent {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P01_201204() {
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
        
        // [2015�N1������][Shinobu Hitaka] 2014/11/11 edit start ����54�ǉ��ɔ����l���C���ɑΉ�
        //ACChotarouXMLUtilities.addFormat(writer, "QP001P010_201204", "QP001P010_201204.xml");
        //writer.beginPageEdit("QP001P010_201204");
        Date targetDt = ACCastUtilities.toDate(VRBindPathParser.get("101002",style) + "01");
        String formatName = "QP001P010_201204";
        if (ACDateUtilities.getDifferenceOnDay(QkanConstants.H2701, targetDt) < 1) {
            formatName = "QP001P010_201501";
        }
        ACChotarouXMLUtilities.addFormat(writer, formatName, formatName + ".xml");
        writer.beginPageEdit(formatName);
        // [2015�N1������][Shinobu Hitaka] 2014/11/11 edit end
        
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
        
        // �@�ʔԍ�(101005) 0�A�������敪�R�[�h(101006) 01�̃f�[�^���擾����B
        style = getTargetRecord(styles,"00","01");
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
            
            // (��������҉��T�[�r�X�)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w8", getFormatData(style, "101013"));
            // (��������҉��T�[�r�X�)��p��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w9", getFormatData(style, "101015"));
            // (��������҉��T�[�r�X�)���p�ҕ��S��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w10", getFormatData(style, "101016"));
            // (��������҉��T�[�r�X�)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w11", getFormatData(style, "101017"));
            // (��������҉��T�[�r�X�)�ی���p�z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.h1.w12", getFormatData(style, "101018"));
            
            // (��������҉��T�[�r�X�)�������v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w8", getFormatData(style, "101013"));
            // (��������҉��T�[�r�X�)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w9", getFormatData(style, "101015"));
            // (��������҉��T�[�r�X�)���p�ҕ��S���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w10", getFormatData(style, "101016"));
            // (��������҉��T�[�r�X�)������z���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w11", getFormatData(style, "101017"));
            // (��������҉��T�[�r�X�)�ی���p�z���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu.total.w12", getFormatData(style, "101018"));
            

        }

        
        // �@�ʔԍ�(101005) 0�A�������敪�R�[�h(101006) 02�̃f�[�^���擾����B
        style = getTargetRecord(styles,"00","02");
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
        
        //[H20.5 �@�����Ή�] fujihara add start
        int tokuteiTotal = 0;
        //[H20.5 �@�����Ή�] fujihara add end
        
        // �@�ʔԍ�(101005) 12�A�������敪�R�[�h(101006) 01�̃f�[�^���擾����B
        style = getTargetRecord(styles,"12","01");
        
        if(style != null){
            // (�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w3", getFormatData(style, "101007"));
            // (�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w4", getFormatData(style, "101008"));
            // (�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w5", getFormatData(style, "101009"));
            // (�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w6", getFormatData(style, "101011"));
            // (��������҉��T�[�r�X�)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w7", getFormatData(style, "101013"));
            // (��������҉��T�[�r�X�)��p��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w8", getFormatData(style, "101015"));
            // (��������҉��T�[�r�X�)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h1.w9", getFormatData(style, "101017"));
            
            // (��������҉��T�[�r�X�)������z���v��ݒ肷��B
            //[H20.5 �@�����Ή�] fujihara edit start
            //ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w9", getFormatData(style, "101017"));
            tokuteiTotal += ACCastUtilities.toInt(style.get("101017"),0);
            //[H20.5 �@�����Ή�] fujihara edit end
            
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // �@�ʔԍ�(101005) 12�A�������敪�R�[�h(101006) 02�̃f�[�^���擾����B
        style = getTargetRecord(styles,"12","02");
        
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

        
        // �@�ʔԍ�(101005)��10,11,21,15,19,51,57,81,86,87,88�̃f�[�^�̏ꍇ�A�ȉ��̃f�[�^��ݒ肷��B
        //���j34��
        //2007.4�ȍ~�̏ꍇ�́A������
        style = getTargetRecord(styles,"10","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h3.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        //���_32��
        style = getTargetRecord(styles,"21","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h5.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //�g��E�X��
        style = getTargetRecord(styles,"15","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h6.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //�����E���
        style = getTargetRecord(styles,"19","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h7.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //���莾�������Ì���
        style = getTargetRecord(styles,"51","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h8.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //��a [2015�N1������][Shinobu Hitaka] 2014/11/11 add�@���o�͏ꏊ�̏C�����K�v
        style = getTargetRecord(styles,"54","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h17.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //��Q�ҁE�x���[�u
        style = getTargetRecord(styles,"57","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h9.w6", getFormatData(style, "101011"));
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
        //�픚�̌���
        style = getTargetRecord(styles,"86","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h11.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //�L�@�q�f�E�ً}�[�u
        style = getTargetRecord(styles,"87","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h12.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //�����a�����΍􃁃`������
        style = getTargetRecord(styles,"88","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h13.w6", getFormatData(style, "101011"));
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        //�Ζ�
        style = getTargetRecord(styles,"66","00");
        if(style != null){
            //(�T�[�r�X��p)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w3", getFormatData(style, "101007"));
            //(�T�[�r�X��p)�P�ʐ��E�_����ݒ肷��
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w4", getFormatData(style, "101008"));
            //(�T�[�r�X��p)��p���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w5", getFormatData(style, "101009"));
            //(�T�[�r�X��p)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h14.w6", getFormatData(style, "101011"));
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
            
            // (��������҉��T�[�r�X�)������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w7", getFormatData(style, "101013"));
            // (��������҉��T�[�r�X�)��p��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w8", getFormatData(style, "101015"));
            // (��������҉��T�[�r�X�)������z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.h16.w9", getFormatData(style, "101017"));
            
            tokuteiTotal += ACCastUtilities.toInt(style.get("101017"),0);
            
            total += ACCastUtilities.toInt(style.get("101011"),0);
        }
        
        // �T�[�r�X��p����v��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w6",getFormatData(total));
        
        //(��������҉��T�[�r�X�)������z���v��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu.total.w9", getFormatData(tokuteiTotal));
        
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
        //�@�ʔԍ�(101005) 0�A�������敪�R�[�h(101006) 01�̃f�[�^���擾����B
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
