
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
 */

package jp.or.med.orca.qkan.affair.qm.qm001;

import jp.nichicom.ac.sql.ACDBManager;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p�^�X�N�N���X
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
            // �\�h�Ń^�X�N
            task1(dbm);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    /**
     * �X�֔ԍ��e�[�u����PRIMARY KEY�폜
     * @param dbm DBManager
     * @throws Exception
     */
    public void task1(ACDBManager dbm) throws Exception{

        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            // �X�֔ԍ��e�[�u����PRIMARY KEY�폜���s
            op.dropPostPrimaryKey(dbm);
            
            // �R�~�b�g
            dbm.commitTransaction();
                
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
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
