
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
 * �J����: �T��@�z��Y
 * �쐬��: 2017/06/19 �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�P�A�}�l�W�����g (QS001_51511_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.adapter.VRComboBoxModelAdapter;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�����\�h�P�A�}�l�W�����g(QS001_51511_201804) 
 */
public class QS001_51511_201804 extends QS001_51511_201804Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_51511_201804(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u���x�������ԍ��i�\�h�x���j�擾�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void careManagerNameComboActionPerformed(ActionEvent e) throws Exception{
      // �����x�������ԍ��i�\�h�x���j�擾
      if (getCareManagerNameCombo().isSelected()
              && !ACTextUtilities.isNullText(getCareManagerNameCombo()
                      .getText())) {
          // ���x���������R���{�i�\�h�x���j�őI������Ă���f�[�^���擾
          VRMap data = (VRMap) getCareManagerNameCombo()
                  .getSelectedModelItem();
          // �擾�f�[�^�����x�������ԍ����擾���A�\��
          getCareManagerNoText().setText(
                  ACCastUtilities.toString(VRBindPathParser.get(
                          "CARE_MANAGER_NO", data)));
      }
  }

  /**
   * �u�x�����Ə��i�ϑ���j�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void consignmentProviderActionPerformed(ActionEvent e) throws Exception{
	  
      // ���x�����Ə��i�ϑ���j�I��
      checkState();
      // �l���N���A
      getConsignmentCareManagerNoText().setText("");
      if (getConsignmentProvider().isSelected()
              && !ACTextUtilities.isNullText(getConsignmentProvider()
                      .getText())) {
          // �����ϐ� sqlParam �𐶐�����B
          VRMap sqlParam = new VRHashMap();
          // sqlParam�ɉ��L�̒l���i�[����B
          // KEY�FPROVIDER__ID VALUE�F�I������Ă��鎖�Ə��ԍ��i�ϑ���j
          sqlParam.put("PROVIDER_ID", VRBindPathParser.get("PROVIDER_ID",
                  (VRMap) getConsignmentProvider().getSelectedModelItem()));

          // �����ϐ� staffs �𐶐�����B
          VRList staffs;
          // ���x�������擾�p��SQL���擾����B
          String sql = getSQL_GET_CARE_MANAGER(sqlParam);
          // staffs �Ɏ擾����SQL�����s�������ʂ��i�[����B
          staffs = getDBManager().executeQuery(sql);
          // �擾����VRList�̒��g�����[�v���Ȃ��琩������������B
          Iterator it = staffs.iterator();
          while (it.hasNext()) {
              VRMap row = (VRMap) it.next();
              // ���������l�����L��KEY�Ŋi�[����B
              // KEY�FCONSIGNMENT_STAFF_NAME
              VRBindPathParser.set("CONSIGNMENT_STAFF_NAME", row, QkanCommon
                      .toFullName(
                              VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                              VRBindPathParser.get("STAFF_FIRST_NAME", row)));
          }
          // staffs �����x�������R���{�i�ϑ��掖�Ə��j�ɐݒ肷��B
          getConsignmentCareManagerNameCombo().setModel(staffs);
      } else {
          VRList staffs = new VRArrayList();
          getConsignmentCareManagerNameCombo().setModel(staffs);
      }
  }

  /**
   * �u���x�������ԍ��i�ϑ���j�擾�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void consignmentCareManagerNameComboActionPerformed(ActionEvent e) throws Exception{
      // �����x�������ԍ��i�ϑ���j�擾
      if (getConsignmentCareManagerNameCombo().isSelected()
              && !ACTextUtilities
                      .isNullText(getConsignmentCareManagerNameCombo()
                              .getText())) {
          // ���x���������R���{�i�ϑ���j�őI������Ă���f�[�^���擾
          VRMap data = (VRMap) getConsignmentCareManagerNameCombo()
                  .getSelectedModelItem();
          // �擾�f�[�^�����x�������ԍ����擾���A�\��
          getConsignmentCareManagerNoText().setText(
                  ACCastUtilities.toString(VRBindPathParser.get(
                          "CARE_MANAGER_NO", data)));
      }
  }

  /**
   * �u�R�[�h���ꗗ�֒ǉ��{�^���̃N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void addCodeToListButtonActionPerformed(ActionEvent e) throws Exception{
		// �ی��Җ��̃`�F�b�N
		// �I������Ă��邩�ǂ���
		if (!getInsurerName().isSelected()) {
			// �I������Ă��Ȃ��ꍇ
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT("�ی���");
			return;
		}
		// �R�[�h�̃`�F�b�N
		if (ACTextUtilities.isNullText(getItemCodeText())) {
			// �I������Ă��Ȃ��ꍇ
			QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT("�R�[�h");
			return;
		}
		// �R�[�h�̌����`�F�b�N
		String itemCode = getItemCodeText().getText();
		if (4 != itemCode.length()) {
			QkanMessageList.getInstance().ERROR_OF_LENGTH("�R�[�h", 4);
			return;
		}

		// �R�[�h����}�X�^���Q�Ƃ��A�ꗗ�֒ǉ�
		VRMap map = (VRMap) getInsurerName().getSelectedItem();
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
		if (findCodeToList(insurerId, itemCode)) {
			getItemCodeText().setText("");
			getSvCodeTable().requestFocusInWindow();
			getSvCodeTable().setSelectedSortedLastRow();
		}
  }

  /**
   * �u�R�[�h�I���{�^���̃N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void codeFindButtonActionPerformed(ActionEvent e) throws Exception{
		// ���R�[�h�ꗗ�_�C�A���O���N������B�I����e�����X�g�ɒǉ�����B
		VRMap map = (VRMap) getInsurerName().getSelectedItem();
		String insurerId = ACCastUtilities.toString(map.get("INSURER_ID"));
		if (selectCodeToList(insurerId)) {
			getItemCodeText().setText("");
			getSvCodeTable().requestFocusInWindow();
			getSvCodeTable().setSelectedSortedLastRow();
		}
  }

  /**
   * �u�R�[�h�폜�{�^���̃N���b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void deleteCodeButtonActionPerformed(ActionEvent e) throws Exception{
		// ���R�[�h��0���������ꍇ
		// �I������Ă��郌�R�[�h�̉�ʏ�̃C���f�b�N�X
		int sortedRow = getSvCodeTable().getSelectedSortedRow();

		// �I������Ă��郌�R�[�h���폜����B
		getSvCodeList().remove(getSvCodeTable().getSelectedModelRow());

		// �폜���ꂽ�s��1�s���I������B
		getSvCodeTable().setSelectedSortedRowOnAfterDelete(sortedRow);

		// ��ʏ�Ԑ���
		checkState();
  }

  /**
   * �u��ʐ���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void svCodeTableSelectionChanged(ListSelectionEvent e) throws Exception{
		// ��ʏ�Ԑ���
		checkState();
  }

  /**
   * �u�ی��ґI���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void insurerNameActionPerformed(ActionEvent e) throws Exception{
		// �ی��҃R���{�N���b�N�̏ꍇ�Ƀ`�F�b�N����B
		if ( e.getModifiers() == MouseEvent.BUTTON1_MASK ){
			// �T�[�r�X�R�[�h�ꗗ�ɒǉ�����Ă�����N���A�m�F���b�Z�[�W��\������B
			if (getSvCodeList().size() != 0 && getInsurerName().getSelectedIndex() != getNowInsurerSelectedIndex()) {
	            int msgID = QkanMessageList.getInstance().QS001_WARNING_OF_CLEAR_SVCODELIST();
	            if (msgID == ACMessageBox.RESULT_OK) {
	                // �uOK�v�I�����A�N���A����B
	            	getSvCodeList().clear();
	            	getItemCodeText().setText("");
	            } else {
	                // �u�L�����Z���v�I�����A�ύX�����Ȃ��B
	            	getInsurerName().setSelectedIndex(getNowInsurerSelectedIndex());
	            }
			}
		}
		// �ی��҃R���{�̃C���f�b�N�X��ێ�����B
		setNowInsurerSelectedIndex(getInsurerName().getSelectedIndex());
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001_51511_201804.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
	  // �e�[�u�����f�������L�̉�ʂ̃e�[�u���ɐݒ肷��B
	  ACTableModelAdapter tableModel = new ACTableModelAdapter();
	
	  // �e�[�u�����f�����`
	  tableModel.setColumns(new String[] {
			"SERVICE_CODE_KIND+'-'+SERVICE_CODE_ITEM", "SERVICE_NAME",
			"SERVICE_UNIT", "KYUFURITSU", "INSURER_ID" });
	
	  setSvCodeTableModel(tableModel);
	  // �e�[�u�����f�����e�[�u���ɃZ�b�g
	  getSvCodeTable().setModel(tableModel);
		
      // ����ʓW�J���̏����ݒ�
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();
      
      
      // ���ݒ�
      // �ی��҃R���{
      VRList insurerList = QkanCommon.getInsurerInfoCareOnly(getDBManager());
      // �ی��Ҕԍ��𑍍����Ɨp�̃o�C���h�p�X�փR�s�[
      ACBindUtilities.copyBindPath(insurerList, "INSURER_ID",
    		  String.valueOf(SJ_HOKENSHA_NO_BIND_PATH));
      VRBindPathParser.set("INSURER", comboItemMap, insurerList);
		
      // ���W�J
      // ���g(this)��comboItemMap�ɐݒ肷��B
      getThis().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getThis().bindModelSource();
      // ���I�����ڂ̏����ݒ�
      // ������
      // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
      VRMap defaultMap = new VRHashMap();
      // ���ݒ�
      // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
      QkanCommon.selectFirstRadioItem(getThis());
      // ���W�J
      // ���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �����I�����ڂ�W�J����B
      getThis().bindSource();


      // �ی��҃R���{�̏����l�ݒ�
      String insurerId = getInitialInsurerId();
	
      // �擾�����ی��Ҕԍ��ɊY������ی��҂����݂���ꍇ
      VRMap item = (VRMap) getInsurerName().getDataFromBindPath(insurerId);
	
      // �ی��Җ��R���{�̊Y���ی��҂�I����Ԃɂ���B
      getInsurerName().setSelectedItem(item);
	
      // �ی��Җ��R���{�̃C���f�b�N�X������������B
      if (getNowInsurerSelectedIndex() < 0) {
    	  setNowInsurerSelectedIndex(getInsurerName().getSelectedIndex());
      }
		
      // ���ϑ��掖�Ə��ݒ�
      // ���ʊ֐� getProviderInfo
      // ���g�p��������x�����Ə��A���K�͑��@�\������x�����Ə��A���\�h�x���A���\�h���K�͑��@�\�^������x����񋟂��Ă��鎖�Ə����擾����B
      VRList list = (VRList) QkanCommon.getProviderInfo(getDBManager(),
              new int[] { 14311, 17311, 14611, 17511, 17711, 51511 });

      // �o�C���h�p�XPROVIDER_ID �� 1460102 �ɐU��Ȃ���
      ACBindUtilities.copyBindPath(list, "PROVIDER_ID", "1460102");
      // �ϑ��掖�Ə���ݒ�
      getConsignmentProvider().setModel(list);
      // �󔒂�ݒ�
      getConsignmentProvider().setSelectedIndex(0);

  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
      // �����Ə��R���{�ύX���ɌĂԊ֐�
      if (provider != null) {
          // �I�����Ə����null�łȂ��ꍇ
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
          // ������
          // ���x�������ԍ����󔒂ɂ���B
          getCareManagerNoText().setText("");
          // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
          VRMap defaultMap = new VRHashMap();
          // ���ݒ�
          // �����x�������R���{�ݒ�
          // �����ϐ� sqlParam �𐶐�����B
          VRMap sqlParam = new VRHashMap();
          // sqlParam�ɉ��L�̒l���i�[����B
          // KEY�FPROVIDER_ID VALUE�F���\�h�I�����Ə��ԍ�
          sqlParam.put("PROVIDER_ID",
                  VRBindPathParser.get("PROVIDER_ID", provider));
          // �����ϐ� staffs �𐶐�����B
          VRList staffs;
          // ���x�������擾�p��SQL���擾����B
          String sql = getSQL_GET_CARE_MANAGER(sqlParam);
          // staffs �Ɏ擾����SQL�����s�������ʂ��i�[����B
          staffs = getDBManager().executeQuery(sql);
          // �擾����VRList�̒��g�����[�v���Ȃ��琩������������B
          Iterator it = staffs.iterator();
          while (it.hasNext()) {
              VRMap row = (VRMap) it.next();
              // ���������l�����L��KEY�Ŋi�[����B
              // KEY�FSTAFF_NAME
              VRBindPathParser.set("STAFF_NAME", row, QkanCommon.toFullName(
                      VRBindPathParser.get("STAFF_FAMILY_NAME", row),
                      VRBindPathParser.get("STAFF_FIRST_NAME", row)));
          }
          // staffs �����x�������R���{�i���\�h�x�����Ə��j�ɐݒ肷��B
          getCareManagerNameCombo().setModel(staffs);
          // ���W�J
          // ���g(this)��defaultMap�ɐݒ肷��B
          getThis().setSource(defaultMap);
          // �����I�����ڂ�W�J����B
          getThis().bindSource();
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
          checkState();
      }
  }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
	  
	  // �ی��Җ��̃`�F�b�N
	  // �EkaigoInfoInsurerName�i�ی��Җ��j
	  // �I������Ă��邩�ǂ���
	  if (!getInsurerName().isSelected()) {
		  // �I������Ă��Ȃ��ꍇ
		  QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
		  return null;
	  }
		
	  // �o�^�����̃`�F�b�N
	  if (getSvCodeList().size() == 0) {
		  // �R�[�h���I������Ă��Ȃ��ꍇ
		  QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
				  "�T�[�r�X�R�[�h");
		  return null;
	  }
		
      // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
      // ���ԋp�p�̃��R�[�h(data)�𐶐�
      VRMap data = new VRHashMap();
      // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
      getThis().setSource(data);
      // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
      getThis().applySource();

      // ���ԋp�p���R�[�h����s�v�ȃL�[������
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // �����x�������ԍ����`�F�b�N����B
      // ���ϑ�����x�������ԍ��ƈϑ�����x�����Ə��̒l���`�F�b�N����B
      if (getConsignmentCareManagerNoText().isEnabled()) {
          if (ACTextUtilities.isNullText(getConsignmentCareManagerNoText()
                  .getText())) {
              // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
              QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
              // null��Ԃ��B
              // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
              return null;
          }
      } else {
          // �ϑ��掖�Ə������I���̏ꍇ
          // �ϑ��掖�Ə��̃L�[���f�[�^���珜�O����B
          data.remove(getConsignmentProvider().getBindPath());
      }
      // �Е����������͂������ꍇ �������Ƃ������͂̏ꍇ�͖��Ȃ�
      
      // �T�[�r�X�ꗗ�̃f�[�^��ǉ�
      addSvCodeToData(data);
		
      return data;
  }

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isUseProvider() throws Exception{
    // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
    // �@true��Ԃ��B
	  return true;
  }

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ���J�n�������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
	  return null;
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
	  return null;
  }

  /**
   * �u�f�[�^�o�C���h���v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void binded() throws Exception{
	  super.binded();
	  
      // ���f�[�^�o�C���h��
      ComboBoxModel mdl = getCareManagerNameCombo().getModel();
      // �����ϐ� src �𐶐�����B
      // src(VRBindSource);
      VRBindSource src = null;
      // �����ϐ� idx �𐶐�����B
      int idx = 0;
      // ���\�h�x�����x���������I������
      if (mdl instanceof VRComboBoxModelAdapter) {
          src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
      }
      // ���x�������R���{�icareManagerNameCombo�j���\�[�X���擾�� src �Ɋi�[����B
      // �擾���� src ��VRList�ł��邩�`�F�b�N����B
      if (src instanceof VRList) {
          // VRList�ł������ꍇ
          // ���͂���Ă�����x�������ԍ��icareManagerNoText�j�ƈ�v����ԍ��� src ���ɑ��݂��邩�`�F�b�N����B
          // getMatchIndexFromValue(src, "CARE_MANAGER_NO", ���͂���Ă�����x�������ԍ�);
          idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                  "CARE_MANAGER_NO", getCareManagerNoText().getText());
          // ���݂����ꍇ
          // �����ϐ� idx �Ɉ�v�������X�g���ڂ�Index���i�[����B
          // idx �̒l���`�F�b�N����B
          // �l��1���傫�������ꍇ
          // ���x�������R���{�ikaigoSupportSpecialMemberName�j�� idx �Ɠ����ԍ��őI����Ԃɂ���B
          if (idx >= 0) {
              getCareManagerNameCombo().setSelectedIndex(idx + 1);
          }
      }

      // ���ϑ�����x���������I������
      // src ������������B
      idx = 0;
      src = null;
      mdl = getConsignmentCareManagerNameCombo().getModel();
      // ���x�������R���{�iconsignmentProvider�j���\�[�X���擾�� src �Ɋi�[����B
      if (mdl instanceof VRComboBoxModelAdapter) {
          src = ((VRComboBoxModelAdapter) mdl).getAdaptee();
      }
      // �擾���� src ��VRList�ł��邩�`�F�b�N����B
      if (src instanceof VRList) {
          // VRList�ł������ꍇ
          // ���͂���Ă�����x�������ԍ��iconsignmentCareManagerNoText�j�ƈ�v����ԍ��� src
          // ���ɑ��݂��邩�`�F�b�N����B
          // getMatchIndexFromValue(src, "CARE_MANAGER_NO", ���͂���Ă�����x�������ԍ�);
          idx = ACBindUtilities.getMatchIndexFromValue((VRList) src,
                  "CARE_MANAGER_NO", getConsignmentCareManagerNoText()
                          .getText());
          // ���݂����ꍇ
          // �����ϐ� idx �Ɉ�v�������X�g���ڂ�Index���i�[����B
          // idx �̒l���`�F�b�N����B
          // �l��1���傫�������ꍇ
          // ���x�������R���{�ikaigoSupportSpecialMemberName�j�� idx+1(�󔒕�������̂�+1�j
          // �Ɠ����ԍ��őI����Ԃɂ���B
          if (idx >= 0) {
              getConsignmentCareManagerNameCombo().setSelectedIndex(idx + 1);
          }
      }
  }

  /**
   * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void checkState() throws Exception{
	  if (getSvCodeTable().isSelected()) {
		  setState_VALID_EDIT();
	  } else {
		  setState_INVALID_EDIT();
	  }
	  if (getSvCodeList().size() >= DOKUJI_TEIRITSU_SVCODE_SELECT_MAX) {
		  setState_INVALID_ADD();
	  } else {
		  setState_VALID_ADD();
	  }
      // �ϑ��掖�Ə��R���{�̒l���`�F�b�N����B
      // �ϑ��掖�Ə��R���{�ŋ󔒂��I������Ă����ꍇ
      if (getConsignmentProvider().getSelectedIndex() == 0) {
          // ��ʏ��1
          setState_STATE_MODE_1();
      } else {
          // ��ʏ��2
          setState_STATE_MODE_2();
      }

  }

}