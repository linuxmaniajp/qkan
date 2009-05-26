/*
 * �쐬��: 2006/06/08
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎��փW�����v:
 * �E�B���h�E - �ݒ� - Java - �R�[�h�E�X�^�C�� - �R�[�h�E�e���v���[�g
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import java.util.Iterator;
import java.util.Stack;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeIntegerFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p����N���X
 * @author n0153
 *
 */
public class QM001UpdateMasterOperation {

	/**
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterOperation() {
	}

	/**
	 * �}�X�^�o�[�W�������擾���܂��B
	 * @param dbm
	 * @return version �}�X�^�o�[�W����
	 * @throws Exception
	 */
	protected String getVersion(ACDBManager dbm) throws Exception {

		String version = "";

		try {
			VRList result = dbm.executeQuery(getSQL_GET_QKAN_VERSION(null));
			version = ACCastUtilities.toString(VRBindPathParser.get(
					"MASTER_DATA_VERSION", (VRMap) result.get(0)));
		} catch (Exception ex) {
			throw ex;
		}

		return version;

	}

	protected void updateVersion(ACDBManager dbm, String version)
			throws Exception {

		try {
			VRMap param = new VRHashMap();
			VRBindPathParser.set("MASTER_DATA_VERSION", param, version);
			dbm.executeUpdate(getSQL_UPDATE_MASTER_VERSION(param));
		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * ���p�Ҍ���T�[�r�X�e�[�u���̕␳
	 * @throws Exception
	 */
	protected void adjustPatientKohiService(ACDBManager dbm) throws Exception {

		try {

			// ���p�Ҍ���T�[�r�X�e�[�u���̏�����
			dbm.executeUpdate(getSQL_DELETE_PATIENT_KOHI_SERVICE(null));

			// ���p�҂̌���e���̎擾�iID�̎擾�j
			VRList patientKohiList = dbm
					.executeQuery(getSQL_GET_PATIENT_KOHI(null));

			// �擾����ID�������[�v
			Iterator it = patientKohiList.iterator();
			while (it.hasNext()) {
				VRMap patientKohi = (VRMap) it.next();
				// KOHI_TYPE�ɂ�����̑ΏۃT�[�r�X�����擾
				VRList masterKohiServiceList = dbm
						.executeQuery(getSQL_GET_KOHI_SERVICE(patientKohi));
				// �擾�����ΏۃT�[�r�X���i�������j�����ɗ��p�Ҍ���T�[�r�X���e�[�u���֏�������
				for (int i = 0; i < masterKohiServiceList.size(); i++) {
					int systemServiceKindDetail = ACCastUtilities
							.toInt(VRBindPathParser.get(
									"SYSTEM_SERVICE_KIND_DETAIL",
									(VRMap) masterKohiServiceList.get(i)));
					VRBindPathParser.set("SYSTEM_SERVICE_KIND_DETAIL",
							patientKohi, new Integer(systemServiceKindDetail));
					dbm
							.executeUpdate(getSQL_INSERT_PATIENT_KOHI_SERVICE(patientKohi));
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * ���Ə����j���[�e�[�u���̕␳
	 * ���胁�j���[�̒ǉ�
	 * @throws Exception
	 */
	protected void adjustProviderMenu(ACDBManager dbm, int menuId)
			throws Exception {

		try {

			// �����Ə��ԍ��̎擾
			VRList providerList = dbm
					.executeQuery(getSQL_GET_LOGIN_PROVIDER(null));

			// �����Ə��ԍ������[�v
			Iterator it = providerList.iterator();
			while (it.hasNext()) {
				VRMap provider = (VRMap) it.next();
				// ���ǉ�
				VRBindPathParser.set("MENU_ID", provider, new Integer(menuId));
				VRBindPathParser.set("SHOW_FLAG", provider, new Integer(1));
				// ���ɓo�^����Ă��Ȃ����`�F�b�N����
				VRList count = dbm
						.executeQuery(getSQL_GET_EXISTING_PROVIDER_MENU(provider));
				if (count.size() <= 0) {
					// �����Ə����ƂɃ��j���[�ǉ�
					dbm.executeUpdate(getSQL_INSERT_PROVIDER_MENU(provider));
				}
			}

		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * �u���t�Ǘ��䒠�V�X�e���́v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_GET_QKAN_VERSION(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" MASTER_DATA_VERSION");

		sb.append(",SCHEME_VERSION");

		sb.append(" FROM");

		sb.append(" M_QKAN_VERSION");

		return sb.toString();
	}

	/**
	 * �u�}�X�^�o�[�W�����X�V�v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_UPDATE_MASTER_VERSION(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("UPDATE");

		sb.append(" M_QKAN_VERSION");

		sb.append(" SET");

		sb.append(" MASTER_DATA_VERSION");

		sb.append(" =");

		sb.append(ACSQLSafeStringFormat.getInstance().format(
				VRBindPathParser.get("MASTER_DATA_VERSION", sqlParam)));

		sb.append(",");

		sb.append(" LAST_TIME");

		sb.append(" =");

		sb.append(" CURRENT_TIMESTAMP");

		return sb.toString();
	}

	/**
	 * �u���p�Ҍ���T�[�r�X�e�[�u���̏������v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_DELETE_PATIENT_KOHI_SERVICE(VRMap sqlParam)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("DELETE FROM");

		sb.append(" PATIENT_KOHI_SERVICE");

		return sb.toString();
	}

	/**
	 * �u���p�Ҍ�����̎擾�v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_GET_PATIENT_KOHI(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" PATIENT_ID");

		sb.append(",KOHI_ID");

		sb.append(",KOHI_TYPE");

		sb.append(" FROM");

		sb.append(" PATIENT_KOHI");

		return sb.toString();
	}

	/**
	 * �u����̋��t�ΏۃT�[�r�X���̎擾�v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_GET_KOHI_SERVICE(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT DISTINCT");

		sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

		sb.append(" FROM");

		sb.append(" M_KOHI_SERVICE");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" KOHI_TYPE");

		sb.append(" =");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("KOHI_TYPE", sqlParam)));

		sb.append(")");

		return sb.toString();
	}

	/**
	 * �u���p�Ҍ���T�[�r�X�e�[�u���ւ̒ǉ��v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_INSERT_PATIENT_KOHI_SERVICE(VRMap sqlParam)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("INSERT INTO");

		sb.append(" PATIENT_KOHI_SERVICE");

		sb.append("(");

		sb.append(" PATIENT_ID");

		sb.append(",KOHI_ID");

		sb.append(",SYSTEM_SERVICE_KIND_DETAIL");

		sb.append(",LAST_TIME");

		sb.append(")VALUES(");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("PATIENT_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("KOHI_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

		sb.append(",");

		sb.append(" CURRENT_TIMESTAMP");

		sb.append(")");

		return sb.toString();
	}

	/**
	 * �u�����Ə��ԍ��̎擾�v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_GET_LOGIN_PROVIDER(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" PROVIDER_ID");

		sb.append(" FROM");

		sb.append(" PROVIDER");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" PROVIDER_JIJIGYOUSHO_TYPE");

		sb.append(" =");

		sb.append(" 1");

		sb.append(")");

		return sb.toString();
	}

	/**
	 * �u���j���[�̑��݊m�F�v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_GET_EXISTING_M_MENU(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" MENU_ID");

		sb.append(" FROM");

		sb.append(" M_MENU");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" MENU_ID");

		sb.append(" =");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("MENU_ID", sqlParam)));

		sb.append(")");

		return sb.toString();
	}

	/**
	 * �u���j���[�̑��݊m�F�v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_GET_EXISTING_PROVIDER_MENU(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("SELECT");

		sb.append(" MENU_ID");

		sb.append(" FROM");

		sb.append(" PROVIDER_MENU");

		sb.append(" WHERE");

		sb.append("(");

		sb.append(" MENU_ID");

		sb.append(" =");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("MENU_ID", sqlParam)));

		sb.append(")");

		if(VRBindPathParser.has("PROVIDER_ID", sqlParam)){
			
			sb.append("AND");
	
			sb.append("(");
	
			sb.append(" LOGIN_PROVIDER_ID");
	
			sb.append(" =");
	
			sb.append(ACSQLSafeStringFormat.getInstance().format(
					VRBindPathParser.get("PROVIDER_ID", sqlParam)));
	
			sb.append(")");
			
		}
		
		return sb.toString();
	}

	/**
	 * �u���Ə����j���[�e�[�u���ւ̒ǉ��v�̂��߂�SQL��Ԃ��܂��B
	 * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
	 * @throws Exception ������O
	 * @return SQL��
	 */
	public String getSQL_INSERT_PROVIDER_MENU(VRMap sqlParam) throws Exception {
		StringBuffer sb = new StringBuffer();
		Object[] inValues;
		Stack conditionStack = new Stack();
		boolean firstCondition = true;
		Object obj;

		sb.append("INSERT INTO");

		sb.append(" PROVIDER_MENU");

		sb.append("(");

		sb.append(" LOGIN_PROVIDER_ID");

		sb.append(",MENU_ID");

		sb.append(",SHOW_FLAG");

		sb.append(",LAST_TIME");

		sb.append(")VALUES(");

		sb.append(ACSQLSafeStringFormat.getInstance().format(
				VRBindPathParser.get("PROVIDER_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("MENU_ID", sqlParam)));

		sb.append(",");

		sb.append(ACSQLSafeIntegerFormat.getInstance().format(
				VRBindPathParser.get("SHOW_FLAG", sqlParam)));

		sb.append(",");

		sb.append(" CURRENT_TIMESTAMP");

		sb.append(")");

		return sb.toString();
	}
    
      /**
       * �u�w��T�[�r�X�̎��Ə��T�[�r�X�ԍ����擾���܂��B�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Masahiko_Higuchi
       * @since V540
       */
      public String getSQL_GET_PROVIDER_SERVICE_ID(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();
        Object[] inValues;
        Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
        boolean firstCondition = true, firstConditionOfFrom = true;
        Object obj;

        sb.append("SELECT");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append(" FROM");

        sb.append(" PROVIDER_SERVICE");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

        sb.append(" =");

        sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));

        sb.append(")");

        return sb.toString();
      }

      /**
       * �u���Ə��̏����X�V���܂��B�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Masahiko_Higuchi
       * @since V540
       */
      public String getSQL_INSERT_PROVIDER_SERVICE_DETAIL_INTEGER(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();
        Object[] inValues;
        Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
        boolean firstCondition = true, firstConditionOfFrom = true;
        Object obj;

        sb.append("INSERT INTO");

        sb.append(" PROVIDER_SERVICE_DETAIL_INTEGER");

        sb.append("(");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append(",SYSTEM_BIND_PATH");

        sb.append(",DETAIL_VALUE");

        sb.append(",LAST_TIME");

        sb.append(")VALUES(");

        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PROVIDER_SERVICE_ID", sqlParam)));

        sb.append(",");

        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_BIND_PATH", sqlParam)));

        sb.append(",");

        sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("DETAIL_VALUE", sqlParam)));

        sb.append(",");

        sb.append(" CURRENT_TIMESTAMP");

        sb.append(")");

        return sb.toString();
      }
      /**
       * �u�A�b�v�f�[�g�Ώۊm�F�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Masahiko_Higuchi
       * @since V540
       */
      public String getSQL_GET_PROVIDER_SERVICE_ROUKEN(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();
        Object[] inValues;
        Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
        boolean firstCondition = true, firstConditionOfFrom = true;
        Object obj;

        sb.append("SELECT");

        sb.append(" COUNT(*)");

        sb.append(" FROM");

        sb.append("  PROVIDER_SERVICE_DETAIL_INTEGER");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append("  IN");

        sb.append(" (");

        sb.append("SELECT");

        sb.append(" PROVIDER_SERVICE_ID");

        sb.append(" FROM");

        sb.append(" PROVIDER_SERVICE");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" SYSTEM_SERVICE_KIND_DETAIL");

        sb.append(" IN");

        sb.append(" ('12211','15211','12511')");

        sb.append(")");

        sb.append(")");

        sb.append(")");

        sb.append("AND");

        sb.append("(");

        sb.append(" SYSTEM_BIND_PATH");

        sb.append(" IN");

        sb.append(" ('1220120','1220121','1520122','1520123','1520124','1250116','1250117')");

        sb.append(")");

        return sb.toString();
      }

      /**
       * �u����21�N4���@�����Ɋւ���A�b�v�f�[�g�Ώۊm�F�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Tozo TANAKA
       * @since V545
       */
      public String getSQL_GET_PROVIDER_SERVICE_DETAIL_H2104(VRMap sqlParam) throws Exception{
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT");

        sb.append(" COUNT(*) AS COUNTVAL");

        sb.append(" FROM");

        sb.append("  PROVIDER_SERVICE_DETAIL_INTEGER");

        sb.append(" WHERE");

        sb.append("(");

        sb.append(" SYSTEM_BIND_PATH");

        sb.append(" IN");

        sb.append(" ('2','3','1150113','1150115','1150116','1160112','1220126','1230124','1230126','1230127','1330108','1430104','1510134','1520130','1520131','1530126','1530128','1530129','1530131','1530225','1530322','1720109','1540135','1250122','1260122','1260123','1260124','1260125','1230123','1230125','1530127','1530130','1260121')");

        sb.append(")");

        return sb.toString();
      }
      
      //[ID:0000447][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
      /**
       * �ύX�Ώۂ̌�����������p�ҏ��擾�pSQL
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Shin Fujihara
       * @since V546
       */
      public String getSQL_GET_PATIENT_KOHI_H2104(VRMap sqlParam) throws Exception{
    	  StringBuffer sb = new StringBuffer();
    	  
    	  sb.append(" SELECT");
    	  sb.append(" k.PATIENT_ID,");
    	  sb.append(" K.KOHI_ID");
    	  sb.append(" FROM PATIENT_KOHI k");
    	  sb.append(" LEFT OUTER JOIN");
    	  sb.append(" PATIENT_KOHI_SERVICE s");
    	  sb.append(" ON");
    	  sb.append(" (k.PATIENT_ID = s.PATIENT_ID)");
    	  sb.append(" AND (k.KOHI_ID = s.KOHI_ID)");
    	  sb.append(" AND (s.SYSTEM_SERVICE_KIND_DETAIL = ");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));
    	  sb.append(")");
    	  sb.append(" WHERE");
    	  sb.append(" (k.INSURE_TYPE = 1)");
    	  sb.append(" AND (k.KOHI_TYPE = ");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_TYPE", sqlParam)));
    	  sb.append(")");
    	  sb.append(" AND ('2009-03-31' < k.KOHI_VALID_END)");
    	  sb.append(" AND (s.PATIENT_ID IS NULL)");
    	  
    	  return sb.toString();
      }
      
      /**
       * ���p�҂̌�����C���pSQL
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Shin Fujihara
       * @since V546
       */
      public String getSQL_INSERT_PATIENT_KOHI_H2104(VRMap sqlParam) throws Exception{
    	  StringBuffer sb = new StringBuffer();
    	  
    	  sb.append(" INSERT");
    	  sb.append(" INTO");
    	  sb.append(" PATIENT_KOHI_SERVICE");
    	  sb.append(" (PATIENT_ID,");
    	  sb.append(" KOHI_ID,");
    	  sb.append(" SYSTEM_SERVICE_KIND_DETAIL,");
    	  sb.append(" LAST_TIME)");
    	  sb.append(" VALUES (");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("PATIENT_ID", sqlParam)));
    	  sb.append(",");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("KOHI_ID", sqlParam)));
    	  sb.append(",");
    	  sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", sqlParam)));
    	  sb.append(",");
    	  sb.append(" CURRENT_TIMESTAMP)");
    	  
    	  return sb.toString();
      }
      //[ID:0000447][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
      
      
      // [ID:0000493][Tozo TANAKA] 2009/04/28 add begin �yDB�␳�z�s���ȃT�[�r�X�f�[�^(����f�Ô)�폜�Ή�
      /**
       * �u�T�[�r�X�ڍ׃e�[�u���̔N�x���Ԏ擾�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_GET_SERVICE_DETAIL_YEAR_RANGE(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          sb.append("SELECT");
          sb.append(" MINIMUM_YEAR");
          sb.append(",MAXIMUM_YEAR");
          sb.append(" FROM");
          sb.append(" M_DETAIL_CONTROL");
          sb.append(" WHERE");
          sb.append(" TABLE_NAME = 'SERVICE_DETAIL'");
          
          return sb.toString();
      }
      
      /**
       * �u�T�[�r�X�ڍ׃e�[�u���̑��݊m�F�p�����擾�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_GET_SERVICE_DETAIL_TABLE_ROWS(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          sb.append("SELECT");
          sb.append(" COUNT(*) AS CNT_VAL");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_");
          sb.append(ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("YEAR", sqlParam)));
          
          return sb.toString();
      }
      
      /**
       * �u�T�[�r�X�ڍ׃e�[�u���̕s���ȃ��R�[�h�폜1�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_DELETE_JUNK_SERVICE_DETAIL1(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          String year = ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("YEAR", sqlParam));
          
          sb.append("DELETE");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year);
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 3010142");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID IN");
          sb.append(" (");
          sb.append("SELECT");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year);
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 14");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".DETAIL_VALUE = 20090401");
          sb.append(")");
          
          return sb.toString();
      }
      /**
       * �u�T�[�r�X�ڍ׃e�[�u���̕s���ȃ��R�[�h�폜2�v�̂��߂�SQL��Ԃ��܂��B
       * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
       * @throws Exception ������O
       * @return SQL��
       * 
       * @author Tozo TANAKA
       * @since V547
       */
      public String getSQL_DELETE_JUNK_SERVICE_DETAIL2(VRMap sqlParam) throws Exception{
          StringBuffer sb = new StringBuffer();
          
          String year = ACSQLSafeIntegerFormat.getInstance().format(VRBindPathParser.get("YEAR", sqlParam));
          
          sb.append("DELETE");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year);
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 3010104");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID IN");
          sb.append(" (");
          sb.append("SELECT");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID");
          sb.append(" FROM");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+"");
          sb.append(",SERVICE");
          sb.append(" WHERE");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SYSTEM_BIND_PATH = 14");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".DETAIL_VALUE = 20090401");
          sb.append(" AND");
          sb.append(" SERVICE_DETAIL_INTEGER_"+year+".SERVICE_ID = SERVICE.SERVICE_ID");
          sb.append(" AND");
          sb.append(" SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(15311,15312,15313)");
          sb.append(")");
          
          return sb.toString();
      }
      
      // [ID:0000493][Tozo TANAKA] 2009/04/28 add end �yDB�␳�z�s���ȃT�[�r�X�f�[�^(����f�Ô)�폜�Ή�
      
      
      
}
