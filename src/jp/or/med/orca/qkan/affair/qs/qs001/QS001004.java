
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
 * �J����: �c���@����
 * �쐬��: 2006/05/29  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �v��P�ʐ��ҏW��� (QS001032)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �v��P�ʐ��ҏW���(QS001032) 
 */
@SuppressWarnings("serial")
public class QS001004 extends QS001004Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001004(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�j�����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // �����͓��e��j�����ĉ�ʂ����
    // �@��ʂ�j�����܂��B
      dispose();
  }

  /**
   * �u�ۑ����ĕ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void okActionPerformed(ActionEvent e) throws Exception{
    // �����͓��e��ۑ����ĉ�ʂ����
      if (!ACTextUtilities.isNullText(getSelectedProviderID())) {
          // �I�𒆂̎��Ə��ԍ�����łȂ��ꍇ
          // �e�[�u���ɓ��͂��ꂽ�v��P�ʐ����ďW�v���āA���Ə��ʌv��P�ʐ��ɒǉ�����B
          getPlanUnits().setData(getSelectedProviderID(),
                  getSelectedPlanUnits());
      }
      setApplied(true);
      
      // �@��ʂ�j�����܂��B
     dispose();
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001004.class.getName(), param));
  }

  //�����֐�

  /**
     * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean showModal(VRMap planUnit) throws Exception {
        // ����ʓW�J���̏����ݒ�

        // �����̌v��P�ʐ�������ϐ��ɑޔ�����B
        VRMap newMap = new VRHashMap();
        Iterator it = planUnit.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            newMap.setData(ent.getKey(), ((VRMap) ent.getValue()).clone());
        }
        setPlanUnits(newMap);

        // �����Ə��ꗗ���擾���A���Ə��R���{�ɐݒ肷��B
        VRList providers = getDBManager().executeQuery(
                getSQL_GET_MY_PROVIDER(null));
        
// 2016/9/6 [Yoichiro Kamei] add - begin �������ƑΉ�
        //�Ώۂ̎��Ə����ݒ肳��Ă���΂��̎��Ə��̂ݑI���Ƃ���
        if (!getTargetProviderIds().isEmpty()) {
        	VRList tmp = new VRArrayList();
        	for (int index = 0; index < providers.size(); index++) {
        		VRMap row = (VRMap) providers.get(index);
        		String provierId = ACCastUtilities.toString(row.get("PROVIDER_ID"));
        		if (getTargetProviderIds().contains(provierId)) {
        			tmp.add(row);
        		}
        	}
        	if (!tmp.isEmpty()) {
        		providers = tmp;
        	}
        }
// 2016/9/6 [Yoichiro Kamei] add - end
        getProvider().setModel(providers);
        
// 2016/9/6 [Yoichiro Kamei] mod - begin �������ƑΉ�
//        // ���O�C�����Ə����f�t�H���g�I������B
//        getProvider().setSelectedIndex(
//                ACBindUtilities.getMatchIndexFromValue(providers,
//                        "PROVIDER_ID", QkanSystemInformation.getInstance()
//                                .getLoginProviderID()));
        String iniProviderId = QkanSystemInformation.getInstance()
        		.getLoginProviderID();
        if (!getTargetProviderIds().isEmpty()) {
        	iniProviderId = (String) getTargetProviderIds().get(0);
        }
        getProvider().setSelectedIndex(
           ACBindUtilities.getMatchIndexFromValue(providers,
              "PROVIDER_ID", iniProviderId));
// 2016/9/6 [Yoichiro Kamei] mod - end
        

        // ���v��P�ʐ���̃G�f�B�^���e�L�X�g�t�B�[���h�Ƃ݂Ȃ��A�ȉ��̃v���p�e�B�ݒ���s���B
        Component unitEditor = getPlanUnitTableUnit().getCellEditorComponent();
        if (unitEditor instanceof ACTextField) {
            ACTextField editor = (ACTextField) unitEditor;
            // �ő���͕������F6
            editor.setMaxLength(6);
            // ��������ʁF����
            editor.setCharType(VRCharType.ONLY_DIGIT);
        }

        // ���E�B���h�E�^�C�g���̐ݒ�
        setAffairTitle("QS001004");
        // ��ʂ����[�_���\������B
        setVisible(true);
        //    ����{�^���������ĕ�������Ԃ��B
        return getApplied();
    }

  /**
   * �u�Ώێ��Ə��I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
    protected void providerActionPerformed(ActionEvent e) throws Exception {
        // ���v��P�ʐ��̕ҏW�Ώێ��Ə���I��
        if (!ACTextUtilities.isNullText(getSelectedProviderID())) {
            // �I�𒆂̎��Ə��ԍ�����łȂ��ꍇ
            // �e�[�u���ɓ��͂��ꂽ�v��P�ʐ����ďW�v���āA���Ə��ʌv��P�ʐ��ɒǉ�����B
            getPlanUnits().setData(getSelectedProviderID(),
                    getSelectedPlanUnits());

        }
        Object obj = getProvider().getSelectedModelItem();
        if (obj instanceof VRMap) {
            // �I�𒆂̎��Ə��ԍ��ɁA�I���������Ə��̎��Ə��ԍ���ݒ肷��B
            setSelectedProviderID(ACCastUtilities.toString(VRBindPathParser
                    .get("PROVIDER_ID", (VRMap) obj)));
            obj = getPlanUnits().get(getSelectedProviderID());
            if (!(obj instanceof VRMap)) {
                // ���Ə��ʌv��P�ʐ��̃L�[�ɑI�𒆂̎��Ə��ԍ����܂܂�Ȃ��ꍇ
                //�V�K�Ƀ��R�[�h�𐶐����A�I�𒆂̎��Ə��ԍ����L�[�Ƃ������Ə��ʌv��P�ʐ��̒l�Ƃ��Ēǉ�����B
                obj = new VRHashMap();
                getPlanUnits().setData(getSelectedProviderID(), obj);
            }
            // �����������Ƀe�[�u�����f�����쐬���A�v��P�ʐ��e�[�u��(planUnitTable)�ɐݒ肷��B
            VRMap planUnit = (VRMap) obj;
            VRArrayList units = new VRArrayList();
            String[] pathes = CareServiceCommon.getPlanUnitBindPathes();
// 2016/9/6 [Yoichiro Kamei] add - begin �������ƑΉ�
            //�Ώۂ̃T�[�r�X��ނ��ݒ肳��Ă���΂��̃T�[�r�X��ނ̂ݐݒ�Ƃ���
            VRList kindList = getTargetServiceCodeKinds();
            if (!kindList.isEmpty()) {
            	VRList tmp = new VRArrayList();
            	for (int index = 0; index < kindList.size(); index++) {
            		String kind = ACCastUtilities.toString(kindList.get(index));
            		String path = CareServiceCommon.getPlanUnitBindPath(kind);
            		if (!"".equals(path)) {
            			tmp.add(path);
            		}
            	}
            	if (!tmp.isEmpty()) {
            		pathes = (String[]) tmp.toArray(new String[0]);
            	}
            }
// 2016/9/6 [Yoichiro Kamei] add - end
            int end = pathes.length;
        	// [H28.4�@�����Ή�][Shinobu Hitaka] 2016/02/02 add - begin
            // 78:�n�斧���^�ʏ����͑Ώ۔N����H28.4�ȍ~�̏ꍇ�Ƃ���
            boolean h2804flag = true;
        	if (getTargetDate() != null && 
                    ACDateUtilities.getDifferenceOnDay(QkanConstants.H2804, getTargetDate()) > 0) {
        		h2804flag = false;
        	}
        	// [H28.4�@�����Ή�][Shinobu Hitaka] 2016/02/02 add - end
            for (int i = 0; i < end; i++) {
            	// [H28.4�@�����Ή�][Shinobu Hitaka] 2016/02/02 add - begin
            	if (h2804flag == false && pathes[i].equals("1078")) {
            		continue;
            	}
            	// [H28.4�@�����Ή�][Shinobu Hitaka] 2016/02/02 add - end
                VRMap row = new VRHashMap();
                row.setData("SERVICE_KIND_NAME", pathes[i]);
                row.setData("UNIT", ACCastUtilities.toInteger(VRBindPathParser
                        .get(pathes[i], planUnit), 0));
                units.add(row);
            }
            
            getPlanUnitTable().setModel(
                    new ACTableModelAdapter(units, new String[] {
                            "SERVICE_KIND_NAME", "UNIT" }));          
            setPlanUnitModelValue(units);
        }
    }

    /**
     * �u���͒��̌v��P�ʐ��̎擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     *
     */
    public VRMap getSelectedPlanUnits() throws Exception {
        // �e�[�u���ɓ��͂��ꂽ�v��P�ʐ����ďW�v���ĕԂ��B
        VRMap units = new VRHashMap();
        Iterator it = getPlanUnitModelValue().iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            int unit = ACCastUtilities.toInt(VRBindPathParser.get("UNIT", row),
                    0);
            if (unit > 0) {
                units.put(VRBindPathParser.get("SERVICE_KIND_NAME", row),
                        ACCastUtilities.toInteger(unit));
            }
        }
        if(!units.isEmpty()){
            units.setData("PROVIDER_ID", getSelectedProviderID());
        }
        return units;
    }

    /**
     * �u�m�肵���v��P�ʐ����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     * @return VRMap
     */
    public VRMap getAppliedValue() throws Exception {
        return getPlanUnits();
    }

}
