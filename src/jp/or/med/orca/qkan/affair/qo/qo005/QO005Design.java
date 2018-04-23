
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
 * �쐬��: 2018/03/14  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �V�X�e���ݒ� (005)
 * �v���O���� �ݒ�ύX�E�����e�i���X (QO005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo005;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * �ݒ�ύX�E�����e�i���X��ʍ��ڃf�U�C��(QO005) 
 */
public class QO005Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton update;

  private ACPanel contents;

  private ACGroupBox dbs;

  private ACPanel serverSelects;

  private ACClearableRadioButtonGroup serverSelectRadios;

  private ACLabelContainer serverSelectRadiosContainer;

  private ACListModelAdapter serverSelectRadiosModel;

  private ACRadioButtonItem serverSelectRadioItem1;

  private ACRadioButtonItem serverSelectRadioItem2;

  private ACTextField serverSelectIpText;

  private ACLabelContainer serverSelectIpTextContainer;

  private ACPanel dbFileSelects;

  private ACTextField dbFileSelectFileName;

  private ACLabelContainer dbFileSelectFileNameContainer;

  private ACButton dbFileSelectFileCompareButton;

  private ACPanel dbComment;

  private ACLabel comment1;

  private ACLabel dbSettingComments;

  private ACGroupBox pdfFileSelects;

  private ACTextField pdfFileSelectFileName;

  private ACLabelContainer pdfFileSelectFileNameContainer;

  private ACButton pdfFileSelectFileCompareButton;

  private ACPanel pdfComment;

  private ACLabel comment2;

  private ACPanel affairSettings;

  private ACGroupBox chohyos;

  private ACIntegerCheckBox yoshikiBango;

  private ACGroupBox riyohyos;

  private ACIntegerCheckBox printHomeMedicalAdvice;

  private ACIntegerCheckBox ninchishoTokuteiShisetsu;

  private ACIntegerCheckBox shisetsuService;

  private ACIntegerCheckBox printSyoguKaizen;

  private ACIntegerCheckBox printSpecialArea;

  private ACIntegerCheckBox printChusankanArea;

  private ACIntegerCheckBox printSameBuilding;

  private ACIntegerCheckBox privateExpenses;

  private ACIntegerCheckBox printNursingZero;

  private ACIntegerCheckBox printNursingLimitZero;

  private ACGroupBox others;

  private ACIntegerCheckBox oncePerMonth;

  private ACLabelContainer taxContainer;

  private ACTextField tax;

  private ACLabel taxUnit;

  private ACButton taxChange;

  private ACIntegerCheckBox showOldLowProviderElements;

  private ACIntegerCheckBox kaigoHoken;

  private ACGroupBox backupResotres;

  private ACButton backup;

  private ACButton restore;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�ݒ�ύX�E�����e�i���X");

      addButtons();
    }
    return buttons;

  }

  /**
   * �X�V�{�^�����擾���܂��B
   * @return �X�V�{�^��
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("�X�V(S)");

      update.setToolTipText("���݂̐ݒ���e��ۑ����܂��B");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      addContents();
    }
    return contents;

  }

  /**
   * DB�ݒ�̈���擾���܂��B
   * @return DB�ݒ�̈�
   */
  public ACGroupBox getDbs(){
    if(dbs==null){

      dbs = new ACGroupBox();

      dbs.setText("�f�[�^�x�[�X�̐ݒ�");

      addDbs();
    }
    return dbs;

  }

  /**
   * �T�[�o�[�I��̈���擾���܂��B
   * @return �T�[�o�[�I��̈�
   */
  public ACPanel getServerSelects(){
    if(serverSelects==null){

      serverSelects = new ACPanel();

      serverSelects.setAutoWrap(false);

      addServerSelects();
    }
    return serverSelects;

  }

  /**
   * �T�[�o�[�I���E���W�I�O���[�v���擾���܂��B
   * @return �T�[�o�[�I���E���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getServerSelectRadios(){
    if(serverSelectRadios==null){

      serverSelectRadios = new ACClearableRadioButtonGroup();

      getServerSelectRadiosContainer().setText("�T�[�o�[");

      serverSelectRadios.setBindPath("SERVER_SELECT_RADIOS");

      serverSelectRadios.setUseClearButton(false);

      serverSelectRadios.setModel(getServerSelectRadiosModel());

      addServerSelectRadios();
    }
    return serverSelectRadios;

  }

  /**
   * �T�[�o�[�I���E���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �T�[�o�[�I���E���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getServerSelectRadiosContainer(){
    if(serverSelectRadiosContainer==null){
      serverSelectRadiosContainer = new ACLabelContainer();
      serverSelectRadiosContainer.setFollowChildEnabled(true);
      serverSelectRadiosContainer.setVAlignment(VRLayout.CENTER);
      serverSelectRadiosContainer.add(getServerSelectRadios(), null);
    }
    return serverSelectRadiosContainer;
  }

  /**
   * �T�[�o�[�I���E���W�I�O���[�v���f�����擾���܂��B
   * @return �T�[�o�[�I���E���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getServerSelectRadiosModel(){
    if(serverSelectRadiosModel==null){
      serverSelectRadiosModel = new ACListModelAdapter();
      addServerSelectRadiosModel();
    }
    return serverSelectRadiosModel;
  }

  /**
   * �T�[�o�[�I���E���W�I(���[�J��)���擾���܂��B
   * @return �T�[�o�[�I���E���W�I(���[�J��)
   */
  public ACRadioButtonItem getServerSelectRadioItem1(){
    if(serverSelectRadioItem1==null){

      serverSelectRadioItem1 = new ACRadioButtonItem();

      serverSelectRadioItem1.setText("���[�J��");

      serverSelectRadioItem1.setGroup(getServerSelectRadios());

      serverSelectRadioItem1.setConstraints(VRLayout.FLOW);

      addServerSelectRadioItem1();
    }
    return serverSelectRadioItem1;

  }

  /**
   * �T�[�o�[�I���E���W�I(���̃R���s���[�^�[)���擾���܂��B
   * @return �T�[�o�[�I���E���W�I(���̃R���s���[�^�[)
   */
  public ACRadioButtonItem getServerSelectRadioItem2(){
    if(serverSelectRadioItem2==null){

      serverSelectRadioItem2 = new ACRadioButtonItem();

      serverSelectRadioItem2.setText("���̃R���s���[�^�[");

      serverSelectRadioItem2.setGroup(getServerSelectRadios());

      serverSelectRadioItem2.setConstraints(VRLayout.FLOW);

      addServerSelectRadioItem2();
    }
    return serverSelectRadioItem2;

  }

  /**
   * IP�̈���擾���܂��B
   * @return IP�̈�
   */
  public ACTextField getServerSelectIpText(){
    if(serverSelectIpText==null){

      serverSelectIpText = new ACTextField();

      getServerSelectIpTextContainer().setText("IP");

      serverSelectIpText.setBindPath("SERVER_SELECT_IP_TEXT");

      serverSelectIpText.setColumns(20);

      serverSelectIpText.setCharType(ACConstants.CHAR_TYPE_IP_OR_HOSTNAME);

      serverSelectIpText.setIMEMode(InputSubset.LATIN);

      serverSelectIpText.setMaxLength(30);

      addServerSelectIpText();
    }
    return serverSelectIpText;

  }

  /**
   * IP�̈�R���e�i���擾���܂��B
   * @return IP�̈�R���e�i
   */
  protected ACLabelContainer getServerSelectIpTextContainer(){
    if(serverSelectIpTextContainer==null){
      serverSelectIpTextContainer = new ACLabelContainer();
      serverSelectIpTextContainer.setFollowChildEnabled(true);
      serverSelectIpTextContainer.setVAlignment(VRLayout.CENTER);
      serverSelectIpTextContainer.add(getServerSelectIpText(), null);
    }
    return serverSelectIpTextContainer;
  }

  /**
   * �t�@�C���I��̈���擾���܂��B
   * @return �t�@�C���I��̈�
   */
  public ACPanel getDbFileSelects(){
    if(dbFileSelects==null){

      dbFileSelects = new ACPanel();

      addDbFileSelects();
    }
    return dbFileSelects;

  }

  /**
   * �t�@�C�������͗̈���擾���܂��B
   * @return �t�@�C�������͗̈�
   */
  public ACTextField getDbFileSelectFileName(){
    if(dbFileSelectFileName==null){

      dbFileSelectFileName = new ACTextField();

      getDbFileSelectFileNameContainer().setText("�f�[�^�x�[�X�̏ꏊ");

      dbFileSelectFileName.setBindPath("DB_FILE_SELECT_FILE_NAME");

      dbFileSelectFileName.setColumns(37);

      dbFileSelectFileName.setIMEMode(InputSubset.LATIN);

      dbFileSelectFileName.setMaxLength(320);

      addDbFileSelectFileName();
    }
    return dbFileSelectFileName;

  }

  /**
   * �t�@�C�������͗̈�R���e�i���擾���܂��B
   * @return �t�@�C�������͗̈�R���e�i
   */
  protected ACLabelContainer getDbFileSelectFileNameContainer(){
    if(dbFileSelectFileNameContainer==null){
      dbFileSelectFileNameContainer = new ACLabelContainer();
      dbFileSelectFileNameContainer.setFollowChildEnabled(true);
      dbFileSelectFileNameContainer.setVAlignment(VRLayout.CENTER);
      dbFileSelectFileNameContainer.add(getDbFileSelectFileName(), null);
    }
    return dbFileSelectFileNameContainer;
  }

  /**
   * �t�@�C���Q�ƃ{�^�����擾���܂��B
   * @return �t�@�C���Q�ƃ{�^��
   */
  public ACButton getDbFileSelectFileCompareButton(){
    if(dbFileSelectFileCompareButton==null){

      dbFileSelectFileCompareButton = new ACButton();

      dbFileSelectFileCompareButton.setText("�Q��(L)");

      dbFileSelectFileCompareButton.setToolTipText("FDB�t�@�C���I����ʂ�\�����܂��B");

      dbFileSelectFileCompareButton.setMnemonic('L');

      addDbFileSelectFileCompareButton();
    }
    return dbFileSelectFileCompareButton;

  }

  /**
   * �R�����g�̈�1���擾���܂��B
   * @return �R�����g�̈�1
   */
  public ACPanel getDbComment(){
    if(dbComment==null){

      dbComment = new ACPanel();

      addDbComment();
    }
    return dbComment;

  }

  /**
   * �R�����g1���擾���܂��B
   * @return �R�����g1
   */
  public ACLabel getComment1(){
    if(comment1==null){

      comment1 = new ACLabel();

      comment1.setText("�f�[�^�x�[�X�̏ꏊ�̐ݒ�ɂ������ẮA�ȉ��̓_�ɗ��ӂ��������B");

      comment1.setForeground(Color.blue);

      comment1.setAutoWrap(true);

      addComment1();
    }
    return comment1;

  }

  /**
   * DB�ݒ�R�����g���擾���܂��B
   * @return DB�ݒ�R�����g
   */
  public ACLabel getDbSettingComments(){
    if(dbSettingComments==null){

      dbSettingComments = new ACLabel();

      dbSettingComments.setText("�E���̃R���s���[�^�[��I�������ꍇ�́A�ڑ���̃R���s���[�^�[��Firebird���C���X�g�[������K�v������܂��B" + ACConstants.LINE_SEPARATOR + "�@��NAS/SAN���̊O���X�g���[�W�͗��p�ł��܂���B" + ACConstants.LINE_SEPARATOR + "�E���̃R���s���[�^�[��I�������ꍇ�́A���̃R���s���[�^�[�ł̃f�[�^�x�[�X�̃t�@�C���p�X������͂��Ă��������B" + ACConstants.LINE_SEPARATOR + "�E���̃R���s���[�^�[��I�������ꍇ�́A�f�[�^�̑ޔ��ƕ��������s���鎖�͂ł��܂���B" + ACConstants.LINE_SEPARATOR + "�@�����̃R���s���[�^�[��ŋ��ǒ����N�����A�f�[�^�̑ޔ��ƕ��������s���Ă��������B" + ACConstants.LINE_SEPARATOR + "�E�f�[�^�x�[�X�̏ꏊ�ɓ��{����܂߂鎖�͂ł��܂���B�g�p����f�[�^�x�[�X�́A���{����܂܂Ȃ��ꏊ�Ɉړ����Ă��������B" + ACConstants.LINE_SEPARATOR + "�@�� ���F C:\\qkan\\Data\\QKAN.FDB" + ACConstants.LINE_SEPARATOR + "�@�� �~�F C:\\���ǒ�\\Data\\QKAN.FDB");

      dbSettingComments.setForeground(Color.blue);

      dbSettingComments.setAutoWrap(true);

      addDbSettingComments();
    }
    return dbSettingComments;

  }

  /**
   * PDF�ݒ�̈���擾���܂��B
   * @return PDF�ݒ�̈�
   */
  public ACGroupBox getPdfFileSelects(){
    if(pdfFileSelects==null){

      pdfFileSelects = new ACGroupBox();

      pdfFileSelects.setText("PDF�̐ݒ�");

      addPdfFileSelects();
    }
    return pdfFileSelects;

  }

  /**
   * PDF�t�@�C�������͗̈���擾���܂��B
   * @return PDF�t�@�C�������͗̈�
   */
  public ACTextField getPdfFileSelectFileName(){
    if(pdfFileSelectFileName==null){

      pdfFileSelectFileName = new ACTextField();

      getPdfFileSelectFileNameContainer().setText("�t�@�C����");

      pdfFileSelectFileName.setBindPath("PDF_FILE_SELECT_FILE_NAME");

      pdfFileSelectFileName.setColumns(37);

      pdfFileSelectFileName.setIMEMode(InputSubset.LATIN);

      pdfFileSelectFileName.setMaxLength(320);

      addPdfFileSelectFileName();
    }
    return pdfFileSelectFileName;

  }

  /**
   * PDF�t�@�C�������͗̈�R���e�i���擾���܂��B
   * @return PDF�t�@�C�������͗̈�R���e�i
   */
  protected ACLabelContainer getPdfFileSelectFileNameContainer(){
    if(pdfFileSelectFileNameContainer==null){
      pdfFileSelectFileNameContainer = new ACLabelContainer();
      pdfFileSelectFileNameContainer.setFollowChildEnabled(true);
      pdfFileSelectFileNameContainer.setVAlignment(VRLayout.CENTER);
      pdfFileSelectFileNameContainer.add(getPdfFileSelectFileName(), null);
    }
    return pdfFileSelectFileNameContainer;
  }

  /**
   * PDF�t�@�C���Q�ƃ{�^�����擾���܂��B
   * @return PDF�t�@�C���Q�ƃ{�^��
   */
  public ACButton getPdfFileSelectFileCompareButton(){
    if(pdfFileSelectFileCompareButton==null){

      pdfFileSelectFileCompareButton = new ACButton();

      pdfFileSelectFileCompareButton.setText("�Q�ƁiP)");

      pdfFileSelectFileCompareButton.setToolTipText("AcrobatReader�I����ʂ�\�����܂��B");

      pdfFileSelectFileCompareButton.setMnemonic('P');

      addPdfFileSelectFileCompareButton();
    }
    return pdfFileSelectFileCompareButton;

  }

  /**
   * �R�����g�̈�4���擾���܂��B
   * @return �R�����g�̈�4
   */
  public ACPanel getPdfComment(){
    if(pdfComment==null){

      pdfComment = new ACPanel();

      addPdfComment();
    }
    return pdfComment;

  }

  /**
   * �R�����g4���擾���܂��B
   * @return �R�����g4
   */
  public ACLabel getComment2(){
    if(comment2==null){

      comment2 = new ACLabel();

      comment2.setText("�t�@�C�����ɂ́A����ɗp����PDF�t�@�C���r���A�[(Adobe Reader /Adobe Acrobat Reader �j���̏ꏊ����͂��Ă��������B" + ACConstants.LINE_SEPARATOR + "Adobe Reader 10�̏ꍇ�A�W���ł� C:\\Program Files\\Adobe\\Reader 10.0\\Reader\\AcroRd32.exe �ƂȂ�܂��B");

      comment2.setForeground(Color.blue);

      comment2.setAutoWrap(true);

      addComment2();
    }
    return comment2;

  }

  /**
   * �d�l�ݒ���擾���܂��B
   * @return �d�l�ݒ�
   */
  public ACPanel getAffairSettings(){
    if(affairSettings==null){

      affairSettings = new ACPanel();

      addAffairSettings();
    }
    return affairSettings;

  }

  /**
   * ���[�ݒ�̈���擾���܂��B
   * @return ���[�ݒ�̈�
   */
  public ACGroupBox getChohyos(){
    if(chohyos==null){

      chohyos = new ACGroupBox();

      chohyos.setText("���[");

      addChohyos();
    }
    return chohyos;

  }

  /**
   * �l���ԍ�������擾���܂��B
   * @return �l���ԍ����
   */
  public ACIntegerCheckBox getYoshikiBango(){
    if(yoshikiBango==null){

      yoshikiBango = new ACIntegerCheckBox();

      yoshikiBango.setText("�l���ԍ����");

      yoshikiBango.setBindPath("YOSHIKI_BANGO");

      yoshikiBango.setMnemonic('F');

      addYoshikiBango();
    }
    return yoshikiBango;

  }

  /**
   * ���p�[�{�\�ւ̕\�����擾���܂��B
   * @return ���p�[�{�\�ւ̕\��
   */
  public ACGroupBox getRiyohyos(){
    if(riyohyos==null){

      riyohyos = new ACGroupBox();

      riyohyos.setText("���p�[�{�\�ւ̕\��");

      riyohyos.setAutoWrap(false);

      addRiyohyos();
    }
    return riyohyos;

  }

  /**
   * 31����×{�Ǘ��w�����擾���܂��B
   * @return 31����×{�Ǘ��w��
   */
  public ACIntegerCheckBox getPrintHomeMedicalAdvice(){
    if(printHomeMedicalAdvice==null){

      printHomeMedicalAdvice = new ACIntegerCheckBox();

      printHomeMedicalAdvice.setText("31,34����×{�Ǘ��w��");

      printHomeMedicalAdvice.setBindPath("PRINT_HOME_MEDICAL_ADVICE");

      addPrintHomeMedicalAdvice();
    }
    return printHomeMedicalAdvice;

  }

  /**
   * 32,37�F�m�ǑΉ��^�E33,35,36����{�ݓ����҂��擾���܂��B
   * @return 32,37�F�m�ǑΉ��^�E33,35,36����{�ݓ�����
   */
  public ACIntegerCheckBox getNinchishoTokuteiShisetsu(){
    if(ninchishoTokuteiShisetsu==null){

      ninchishoTokuteiShisetsu = new ACIntegerCheckBox();

      ninchishoTokuteiShisetsu.setText("32,37�F�m�ǑΉ��^�E33,35,36����{�ݓ�����");

      ninchishoTokuteiShisetsu.setBindPath("NINCHISHO_TOKUTEI_SHISETSU");

      addNinchishoTokuteiShisetsu();
    }
    return ninchishoTokuteiShisetsu;

  }

  /**
   * 51�`55�{�݃T�[�r�X���擾���܂��B
   * @return 51�`55�{�݃T�[�r�X
   */
  public ACIntegerCheckBox getShisetsuService(){
    if(shisetsuService==null){

      shisetsuService = new ACIntegerCheckBox();

      shisetsuService.setText("51,52,53,54,55�{�݃T�[�r�X");

      shisetsuService.setBindPath("SHISETSU_SERVICE");

      addShisetsuService();
    }
    return shisetsuService;

  }

  /**
   * ���E���������P���Z���擾���܂��B
   * @return ���E���������P���Z
   */
  public ACIntegerCheckBox getPrintSyoguKaizen(){
    if(printSyoguKaizen==null){

      printSyoguKaizen = new ACIntegerCheckBox();

      printSyoguKaizen.setText("���E���������P���Z");

      printSyoguKaizen.setBindPath("PRINT_SYOGU_KAIZEN");

      addPrintSyoguKaizen();
    }
    return printSyoguKaizen;

  }

  /**
   * ���ʒn����Z�E���K�͎��Ə����Z���擾���܂��B
   * @return ���ʒn����Z�E���K�͎��Ə����Z
   */
  public ACIntegerCheckBox getPrintSpecialArea(){
    if(printSpecialArea==null){

      printSpecialArea = new ACIntegerCheckBox();

      printSpecialArea.setText("���ʒn����Z�E���K�͎��Ə����Z");

      printSpecialArea.setBindPath("PRINT_SPECIAL_AREA");

      addPrintSpecialArea();
    }
    return printSpecialArea;

  }

  /**
   * ���R�Ԓn�擙�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�񋟉��Z
   */
  public ACIntegerCheckBox getPrintChusankanArea(){
    if(printChusankanArea==null){

      printChusankanArea = new ACIntegerCheckBox();

      printChusankanArea.setText("���R�Ԓn�擙�񋟉��Z");

      printChusankanArea.setBindPath("PRINT_CHUSANKAN_AREA");

      addPrintChusankanArea();
    }
    return printChusankanArea;

  }

  /**
   * ���ꌚ�����Z���擾���܂��B
   * @return ���ꌚ�����Z
   */
  public ACIntegerCheckBox getPrintSameBuilding(){
    if(printSameBuilding==null){

      printSameBuilding = new ACIntegerCheckBox();

      printSameBuilding.setText("���ꌚ�����Z");

      printSameBuilding.setBindPath("PRINT_SAME_BUILDING");

      addPrintSameBuilding();
    }
    return printSameBuilding;

  }

  /**
   * ����ڂɁ���������擾���܂��B
   * @return ����ڂɁ�������
   */
  public ACIntegerCheckBox getPrivateExpenses(){
    if(privateExpenses==null){

      privateExpenses = new ACIntegerCheckBox();

      privateExpenses.setText("����ڂɁ�������");

      privateExpenses.setBindPath("PRIVATE_EXPENSES");

      addPrivateExpenses();
    }
    return privateExpenses;

  }

  /**
   * ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂�����擾���܂��B
   * @return ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���
   */
  public ACIntegerCheckBox getPrintNursingZero(){
    if(printNursingZero==null){

      printNursingZero = new ACIntegerCheckBox();

      printNursingZero.setText("��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���");

      printNursingZero.setBindPath("PRINT_NURSING_ZERO");

      addPrintNursingZero();
    }
    return printNursingZero;

  }

  /**
   * ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂�����擾���܂��B
   * @return ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���
   */
  public ACIntegerCheckBox getPrintNursingLimitZero(){
    if(printNursingLimitZero==null){

      printNursingLimitZero = new ACIntegerCheckBox();

      printNursingLimitZero.setText("��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���");

      printNursingLimitZero.setBindPath("PRINT_NURSING_LIMIT_ZERO");

      addPrintNursingLimitZero();
    }
    return printNursingLimitZero;

  }

  /**
   * ���̑��̐ݒ�̈���擾���܂��B
   * @return ���̑��̐ݒ�̈�
   */
  public ACGroupBox getOthers(){
    if(others==null){

      others = new ACGroupBox();

      others.setText("���̑��̐ݒ�");

      addOthers();
    }
    return others;

  }

  /**
   * �ً}���K��Ō���Z�E���ʊǗ����Z����1��Z��ɐݒ肷����擾���܂��B
   * @return �ً}���K��Ō���Z�E���ʊǗ����Z����1��Z��ɐݒ肷��
   */
  public ACIntegerCheckBox getOncePerMonth(){
    if(oncePerMonth==null){

      oncePerMonth = new ACIntegerCheckBox();

      oncePerMonth.setText("<html>�ً}���K��Ō���Z�E���ʊǗ����Z����1��Z��ɐݒ肷��</html>");

      oncePerMonth.setBindPath("ONCE_PER_MONTH");

      addOncePerMonth();
    }
    return oncePerMonth;

  }

  /**
   * �ŗ��R���e�i���擾���܂��B
   * @return �ŗ��R���e�i
   */
  public ACLabelContainer getTaxContainer(){
    if(taxContainer==null){

      taxContainer = new ACLabelContainer();

      taxContainer.setText("����ŗ�");

      taxContainer.setVisible(false);

      addTaxContainer();
    }
    return taxContainer;

  }

  /**
   * �ŗ����擾���܂��B
   * @return �ŗ�
   */
  public ACTextField getTax(){
    if(tax==null){

      tax = new ACTextField();

      tax.setEditable(false);

      tax.setColumns(3);

      tax.setCharType(VRCharType.ONLY_FLOAT);

      tax.setHorizontalAlignment(SwingConstants.RIGHT);

      tax.setIMEMode(InputSubset.LATIN);

      tax.setMaxLength(3);

      addTax();
    }
    return tax;

  }

  /**
   * �ŗ��P�ʂ��擾���܂��B
   * @return �ŗ��P��
   */
  public ACLabel getTaxUnit(){
    if(taxUnit==null){

      taxUnit = new ACLabel();

      taxUnit.setText("%");

      addTaxUnit();
    }
    return taxUnit;

  }

  /**
   * �ŗ��ҏW���擾���܂��B
   * @return �ŗ��ҏW
   */
  public ACButton getTaxChange(){
    if(taxChange==null){

      taxChange = new ACButton();

      taxChange.setText("�ҏW");

      addTaxChange();
    }
    return taxChange;

  }

  /**
   * �ߋ��̎��Ə��̐������\��������擾���܂��B
   * @return �ߋ��̎��Ə��̐������\������
   */
  public ACIntegerCheckBox getShowOldLowProviderElements(){
    if(showOldLowProviderElements==null){

      showOldLowProviderElements = new ACIntegerCheckBox();

      showOldLowProviderElements.setText("�ߋ��̎��Ə��̐������\������");

      showOldLowProviderElements.setBindPath("SHOW_OLD_LOW_PROVIDER_ELEMENTS");

      addShowOldLowProviderElements();
    }
    return showOldLowProviderElements;

  }

  /**
   * ���ی��E���F�������荞�ށi�ŐV1���̂݁j���擾���܂��B
   * @return ���ی��E���F�������荞�ށi�ŐV1���̂݁j
   */
  public ACIntegerCheckBox getKaigoHoken(){
    if(kaigoHoken==null){

      kaigoHoken = new ACIntegerCheckBox();

      kaigoHoken.setText("<html>�����Z�A�g���ɉ��ی��E���F�������荞�ށi�ŐV1�����j<br>��dbs�p�b�P�[�W�ijma-receipt-dbs�j���ŐV�ɂ��Ă����p���������B</html>");

      kaigoHoken.setBindPath("KAIGO_HOKEN");

      addKaigoHoken();
    }
    return kaigoHoken;

  }

  /**
   * �f�[�^�̑ޔ��E�����̈���擾���܂��B
   * @return �f�[�^�̑ޔ��E�����̈�
   */
  public ACGroupBox getBackupResotres(){
    if(backupResotres==null){

      backupResotres = new ACGroupBox();

      backupResotres.setText("�f�[�^�̑ޔ��E����");

      backupResotres.setAutoWrap(false);

      addBackupResotres();
    }
    return backupResotres;

  }

  /**
   * �ޔ����擾���܂��B
   * @return �ޔ�
   */
  public ACButton getBackup(){
    if(backup==null){

      backup = new ACButton();

      backup.setText("�f�[�^�̑ޔ�");

      addBackup();
    }
    return backup;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACButton getRestore(){
    if(restore==null){

      restore = new ACButton();

      restore.setText("�f�[�^�̕���");

      addRestore();
    }
    return restore;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO005Design() {

    try {
      initialize();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g�̐ݒ���s�Ȃ��܂��B
   */
  protected void initThis(){
  }

  /**
   * this�ɓ������ڂ�ǉ����܂��B
   */
  protected void addThis(){

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
  }

  /**
   * �X�V�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdate(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getDbs(), VRLayout.NORTH);

    contents.add(getPdfFileSelects(), VRLayout.NORTH);

    contents.add(getAffairSettings(), VRLayout.NORTH);

    contents.add(getBackupResotres(), VRLayout.NORTH);

  }

  /**
   * DB�ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbs(){

    dbs.add(getServerSelects(), VRLayout.NORTH);

    dbs.add(getDbFileSelects(), VRLayout.NORTH);

    dbs.add(getDbComment(), VRLayout.NORTH);

  }

  /**
   * �T�[�o�[�I��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServerSelects(){

    serverSelects.add(getServerSelectRadiosContainer(), VRLayout.FLOW);

    serverSelects.add(getServerSelectIpTextContainer(), VRLayout.FLOW);

  }

  /**
   * �T�[�o�[�I���E���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServerSelectRadios(){

  }

  /**
   * �T�[�o�[�I���E���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServerSelectRadiosModel(){

    getServerSelectRadioItem1().setButtonIndex(1);

    getServerSelectRadiosModel().add(getServerSelectRadioItem1());

    getServerSelectRadioItem2().setButtonIndex(2);

    getServerSelectRadiosModel().add(getServerSelectRadioItem2());

  }

  /**
   * �T�[�o�[�I���E���W�I(���[�J��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServerSelectRadioItem1(){

  }

  /**
   * �T�[�o�[�I���E���W�I(���̃R���s���[�^�[)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServerSelectRadioItem2(){

  }

  /**
   * IP�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServerSelectIpText(){

  }

  /**
   * �t�@�C���I��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbFileSelects(){

    dbFileSelects.add(getDbFileSelectFileNameContainer(), VRLayout.FLOW);

    dbFileSelects.add(getDbFileSelectFileCompareButton(), VRLayout.FLOW);

  }

  /**
   * �t�@�C�������͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbFileSelectFileName(){

  }

  /**
   * �t�@�C���Q�ƃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbFileSelectFileCompareButton(){

  }

  /**
   * �R�����g�̈�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbComment(){

    dbComment.add(getComment1(), VRLayout.NORTH);

    dbComment.add(getDbSettingComments(), VRLayout.NORTH);

  }

  /**
   * �R�����g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addComment1(){

  }

  /**
   * DB�ݒ�R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbSettingComments(){

  }

  /**
   * PDF�ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPdfFileSelects(){

    pdfFileSelects.add(getPdfFileSelectFileNameContainer(), VRLayout.FLOW);

    pdfFileSelects.add(getPdfFileSelectFileCompareButton(), VRLayout.FLOW);

    pdfFileSelects.add(getPdfComment(), VRLayout.NORTH);

  }

  /**
   * PDF�t�@�C�������͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPdfFileSelectFileName(){

  }

  /**
   * PDF�t�@�C���Q�ƃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPdfFileSelectFileCompareButton(){

  }

  /**
   * �R�����g�̈�4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPdfComment(){

    pdfComment.add(getComment2(), VRLayout.NORTH);

  }

  /**
   * �R�����g4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addComment2(){

  }

  /**
   * �d�l�ݒ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAffairSettings(){

    affairSettings.add(getChohyos(), VRLayout.WEST);

    affairSettings.add(getOthers(), VRLayout.CLIENT);

  }

  /**
   * ���[�ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChohyos(){

    chohyos.add(getYoshikiBango(), VRLayout.FLOW_RETURN);

    chohyos.add(getRiyohyos(), VRLayout.FLOW_RETURN);

    chohyos.add(getPrintNursingZero(), VRLayout.FLOW_RETURN);

    chohyos.add(getPrintNursingLimitZero(), VRLayout.FLOW_RETURN);

  }

  /**
   * �l���ԍ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoshikiBango(){

  }

  /**
   * ���p�[�{�\�ւ̕\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRiyohyos(){

    riyohyos.add(getPrintHomeMedicalAdvice(), VRLayout.FLOW);

    riyohyos.add(getNinchishoTokuteiShisetsu(), VRLayout.FLOW_RETURN);

    riyohyos.add(getShisetsuService(), VRLayout.FLOW);

    riyohyos.add(getPrintSyoguKaizen(), VRLayout.FLOW_RETURN);

    riyohyos.add(getPrintSpecialArea(), VRLayout.FLOW);

    riyohyos.add(getPrintChusankanArea(), VRLayout.FLOW_RETURN);

    riyohyos.add(getPrintSameBuilding(), VRLayout.FLOW);

    riyohyos.add(getPrivateExpenses(), VRLayout.FLOW_RETURN);

  }

  /**
   * 31����×{�Ǘ��w���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintHomeMedicalAdvice(){

  }

  /**
   * 32,37�F�m�ǑΉ��^�E33,35,36����{�ݓ����҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchishoTokuteiShisetsu(){

  }

  /**
   * 51�`55�{�݃T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuService(){

  }

  /**
   * ���E���������P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintSyoguKaizen(){

  }

  /**
   * ���ʒn����Z�E���K�͎��Ə����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintSpecialArea(){

  }

  /**
   * ���R�Ԓn�擙�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintChusankanArea(){

  }

  /**
   * ���ꌚ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintSameBuilding(){

  }

  /**
   * ����ڂɁ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrivateExpenses(){

  }

  /**
   * ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintNursingZero(){

  }

  /**
   * ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintNursingLimitZero(){

  }

  /**
   * ���̑��̐ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOthers(){

    others.add(getOncePerMonth(), VRLayout.FLOW_RETURN);

    others.add(getTaxContainer(), VRLayout.FLOW_RETURN);

    others.add(getShowOldLowProviderElements(), VRLayout.FLOW_RETURN);

    others.add(getKaigoHoken(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ً}���K��Ō���Z�E���ʊǗ����Z����1��Z��ɐݒ肷��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOncePerMonth(){

  }

  /**
   * �ŗ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTaxContainer(){

    taxContainer.add(getTax(), VRLayout.FLOW);

    taxContainer.add(getTaxUnit(), VRLayout.FLOW);

    taxContainer.add(getTaxChange(), VRLayout.FLOW);

  }

  /**
   * �ŗ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTax(){

  }

  /**
   * �ŗ��P�ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addTaxUnit(){

  }

  /**
   * �ŗ��ҏW�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTaxChange(){

  }

  /**
   * �ߋ��̎��Ə��̐������\������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShowOldLowProviderElements(){

  }

  /**
   * ���ی��E���F�������荞�ށi�ŐV1���̂݁j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHoken(){

  }

  /**
   * �f�[�^�̑ޔ��E�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBackupResotres(){

    backupResotres.add(getBackup(), VRLayout.FLOW);

    backupResotres.add(getRestore(), VRLayout.FLOW);

  }

  /**
   * �ޔ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBackup(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRestore(){

  }

  /**
   * �R���|�[�l���g�����������܂��B
   * @throws Exception ��������O
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {

    return null;

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO005Design getThis() {
    return this;
  }
}
