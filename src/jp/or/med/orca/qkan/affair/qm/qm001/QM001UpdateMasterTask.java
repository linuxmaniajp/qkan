/*
 * �쐬��: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.sql.ACDBManager;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p�^�X�N�N���X
 * 
 * @author n0153
 * 
 */
public class QM001UpdateMasterTask {
    // �}�X�^�o�[�W����
    public String version = "";

    /**
     * �R���X�g���N�^
     */
    public QM001UpdateMasterTask() {
    }

    /**
     * �R���X�g���N�^
     */
    public QM001UpdateMasterTask(String version) {
        setVersion(version);
    }

    /**
     * �o�[�W�����␳�^�X�N�Ǘ�
     * 
     * @param dbm
     * @throws Exception
     */
    public void adjustTask(ACDBManager dbm) throws Exception {

        try {

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

}
