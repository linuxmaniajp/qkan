
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
 * �J����: ����@��F
 * �쐬��: 2006/02/01  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �o�[�W������� (V)
 * �v���Z�X �o�[�W������� (001)
 * �v���O���� �o�[�W������� (QV001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qv.qv001;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACTextArea;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �o�[�W�������(QV001) 
 */
public class QV001 extends QV001Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QV001(){
  }

  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);
  }
  /**
   * �������������s�Ȃ��܂��B
   * @param affair �Ɩ����
   * @throws Exception ������O
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    // �o�[�W���������擾����B
    QkanSystemInformation.getInstance().getSystemVersion();
    // �@�l���擾�ł����ꍇ
    // �@�@�擾�����l��(dataVersion)�Ɋi�[����
    // �@�@�������ցB
    // �@�l���擾�ł��Ȃ������ꍇ
    // �@�@��O�������s���B�V�X�e���̃o�[�W������񂪕\���ł��Ȃ����߁B
    // �@�@(dataVersion)�Ɂu�擾���s�v���i�[����
    // �@�@�������I����B�i�ُ�I���j
    // �u���ǒ��v��dataVersion����������B
    // �o�[�W������񕶎����versionData����������B

    setTitle("���t�Ǘ��^����V�����x���\�t�g�E�F�A Ver" + QkanSystemInformation.getInstance().getSystemVersion());
    getQkanInfoText().setText(getMainLicence());
    
    HashMap licenceMap = getLicences();
    Iterator it = licenceMap.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry ent = (Map.Entry) it.next();
        ACTextArea page = new ACTextArea();
        page.setText(String.valueOf(ent.getValue()));
        page.setEditable(false);
        page.setLineWrap(true);
        page.setBackground(Color.white);
        page.setSelectionStart(0);
        page.setSelectionEnd(0);
        getTabs().add(page, String.valueOf(ent.getKey()));
    }
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�I�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // �\������Ă���o�[�W��������ʂ����B
//    ACFrame.getInstance().next("QM001");
      dispose();
      
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    try{
    ACFrame.setVRLookAndFeel();
    }catch(Exception ex){}
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
//    ACFrame.debugStart(new ACAffairInfo(QV001.class.getName(), param));
    new QV001().setVisible(true);
  }
;
  /**
   * �傽�钘�쌠�\�����b�Z�[�W��Ԃ��܂��B
   * 
   * @return �傽�钘�쌠�\�����b�Z�[�W
   */
  protected String getMainLicence() {
      return readFile("licence/main_licence.txt");
  }

  /**
   * �e�L�X�g�t�@�C�����e��ǂݍ���ŕԂ��܂��B
   * 
   * @param path �t�@�C���p�X
   * @return �t�@�C�����e
   */
  protected String readFile(String path) {
      StringBuilder sb = new StringBuilder();
      try {

          FileReader fr;
          fr = new FileReader(new File(path));
          if (fr != null) {
              try {

                  BufferedReader br = new BufferedReader(fr);
                  if (br != null) {
                      // �Ǎ��݃��[�v�B
                      String line; // �ǂݍ��܂ꂽ�P�s�B
                      while ((line = br.readLine()) != null) {
                          sb.append(line);
                          sb.append(ACConstants.LINE_SEPARATOR);
                      }

                      // ���́E�o�̓X�g���[�������B
                      br.close();
                  }
              } catch (Exception ex) {

              } finally {
                  fr.close();
              }
          }
      } catch (Exception e) {
      }
      
      String ret = sb.toString();
      //���^�^�O�u��
      ret = ret.replaceAll("<system_version>", QkanSystemInformation.getInstance().getSystemVersion());
      
      return ret;
  }

  /**
   * �֘A���쌠�\�����b�Z�[�W��Ԃ��܂��B
   * 
   * @return �֘A���쌠�\�����b�Z�[�W(key:String �L���v�V����, value:String ���e)
   */
  protected HashMap getLicences() {
      LinkedHashMap licenceMap = new LinkedHashMap();

      String[] licences = readFile("licence/sub_licence.txt").split(
              ACConstants.LINE_SEPARATOR);
      int end = licences.length;
      for (int i = 0; i < end; i++) {
          String[] params = licences[i].split(",", 2);
          if (params.length >= 2) {
              licenceMap.put(params[1], readFile("licence/" + params[0]));
          }
      }
      return licenceMap;
  }
}
