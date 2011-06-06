
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
 * �쐬��: 2010/11/15  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��^���Ǘ� (008)
 * �v���O���� ��^�����ڈꗗ (QO008)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo008;
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
 * ��^�����ڈꗗ��ʍ��ڃf�U�C��(QO008) 
 */
public class QO008Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar Buttons;

  private ACAffairButton update;

  private ACPanel contents;

  private VRLayout contentLayout;

  private ACPanel fixedFormPanels;

  private ACPanel fixedFormPanel;

  private ACGroupBox fixedForm;

  private VRLayout fixedFormLayout;

  private ACLabel fixedFormLabel;

  private ACTable fixedFormTable;

  private VRTableColumnModel fixedFormTableColumnModel;

  private ACTableColumn fixedFormTableColumn�P;

  private ACTableColumn fixedFormTableColumn�Q;

  private ACTableColumn fixedFormTableColumn�R;

  private ACPanel fixedFormEdits;

  private ACGroupBox fixedFormEdit;

  private VRLayout fixedFormEditLayout;

  private ACPanel fixedFormEditComments;

  private VRLayout fixedFormEditCommentLayout;

  private ACLabel fixedFormEditComment1;

  private ACLabel fixedFormEditComment2;

  private ACPanel fixedFormEdititemAndItemManipulateButtons;

  private ACPanel fixedFormEdititems;

  private ACTable fixedFormEditItemTable;

  private VRTableColumnModel fixedFormEditItemTableColumnModel;

  private ACTableColumn fixedFormEditItemTableColumn1;

  private ACTableColumn fixedFormEditItemTableColumn2;

  private ACTableColumn fixedFormEditItemTableColumn4;

  private ACTableColumn fixedFormEditItemTableColumn3;

  private ACPanel fixedFormEditItemManipulateButtons;

  private ACButton fixedFormEditItemManipulateButtonUp;

  private ACButton fixedFormEditItemManipulateButtonDown;

  private ACPanel fixedFormEditInputAndCompileTextBoxs;

  private ACPanel fixedFormEditInputLefts;

  private ACLabel fixedFormEditInputLeft;

  private ACLabel fixedFormEditInputCaption1;

  private ACLabel fixedFormEditInputCaption2;

  private ACLabel fixedFormEditInputCaption3;

  private ACPanel fixedFormEditInputCaptions;

  private VRLayout fixedFormEditInputCaptionLayout;

  private ACTextField fixedFormEditInputAndCompileTextBox;

  private ACLabelContainer fixedFormEditInputAndCompileTextBoxContainer;

  private ACPanel fixedFormEditDownButtons;

  private ACButton fixedFormEditInsert;

  private ACButton fixedFormEditUpdate;

  private ACButton fixedFormEditDelete;

  private ACButton fixedFormEditCancelDelete;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(Buttons==null){

      Buttons = new ACAffairButtonBar();

      Buttons.setText("��^���ҏW");

      addButtons();
    }
    return Buttons;

  }

  /**
   * �X�V�{�^�����擾���܂��B
   * @return �X�V�{�^��
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("�X�V(S)");

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

      contents.setLayout(getContentLayout());

      addContents();
    }
    return contents;

  }

  /**
   * �N���C�A���g�̈�E���C�A�E�g���擾���܂��B
   * @return �N���C�A���g�̈�E���C�A�E�g
   */
  public VRLayout getContentLayout(){
    if(contentLayout==null){

      contentLayout = new VRLayout();

      addContentLayout();
    }
    return contentLayout;

  }

  /**
   * ��^�����ڈꗗ�E�p�l�����擾���܂��B
   * @return ��^�����ڈꗗ�E�p�l��
   */
  public ACPanel getFixedFormPanels(){
    if(fixedFormPanels==null){

      fixedFormPanels = new ACPanel();

      addFixedFormPanels();
    }
    return fixedFormPanels;

  }

  /**
   * ��^�����ڑI���p�l�����擾���܂��B
   * @return ��^�����ڑI���p�l��
   */
  public ACPanel getFixedFormPanel(){
    if(fixedFormPanel==null){

      fixedFormPanel = new ACPanel();

      addFixedFormPanel();
    }
    return fixedFormPanel;

  }

  /**
   * ��^�����ڑI���t���[�����擾���܂��B
   * @return ��^�����ڑI���t���[��
   */
  public ACGroupBox getFixedForm(){
    if(fixedForm==null){

      fixedForm = new ACGroupBox();

      fixedForm.setText("��^�����ڑI��");

      fixedForm.setLayout(getFixedFormLayout());

      addFixedForm();
    }
    return fixedForm;

  }

  /**
   * ��^�����ڑI�����C�A�E�g���擾���܂��B
   * @return ��^�����ڑI�����C�A�E�g
   */
  public VRLayout getFixedFormLayout(){
    if(fixedFormLayout==null){

      fixedFormLayout = new VRLayout();

      fixedFormLayout.setHgap(0);

      addFixedFormLayout();
    }
    return fixedFormLayout;

  }

  /**
   * ��^�����ڑI�����x�����擾���܂��B
   * @return ��^�����ڑI�����x��
   */
  public ACLabel getFixedFormLabel(){
    if(fixedFormLabel==null){

      fixedFormLabel = new ACLabel();

      fixedFormLabel.setText("�ҏW��������^�����ڂ�I�����Ă��������B");

      addFixedFormLabel();
    }
    return fixedFormLabel;

  }

  /**
   * ��^�����ڑI���e�[�u�����擾���܂��B
   * @return ��^�����ڑI���e�[�u��
   */
  public ACTable getFixedFormTable(){
    if(fixedFormTable==null){

      fixedFormTable = new ACTable();

      fixedFormTable.setColumnModel(getFixedFormTableColumnModel());

      fixedFormTable.setPreferredSize(new Dimension(700,140));

      addFixedFormTable();
    }
    return fixedFormTable;

  }

  /**
   * ��^�����ڑI���e�[�u���J�������f�����擾���܂��B
   * @return ��^�����ڑI���e�[�u���J�������f��
   */
  protected VRTableColumnModel getFixedFormTableColumnModel(){
    if(fixedFormTableColumnModel==null){
      fixedFormTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addFixedFormTableColumnModel();
    }
    return fixedFormTableColumnModel;
  }

  /**
   * �e�[�u���FNo.���擾���܂��B
   * @return �e�[�u���FNo.
   */
  public ACTableColumn getFixedFormTableColumn�P(){
    if(fixedFormTableColumn�P==null){

      fixedFormTableColumn�P = new ACTableColumn();

      fixedFormTableColumn�P.setHeaderValue("No.");

      fixedFormTableColumn�P.setColumns(4);

      fixedFormTableColumn�P.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      fixedFormTableColumn�P.setSortable(false);

      addFixedFormTableColumn�P();
    }
    return fixedFormTableColumn�P;

  }

  /**
   * �e�[�u���F���ނ��擾���܂��B
   * @return �e�[�u���F����
   */
  public ACTableColumn getFixedFormTableColumn�Q(){
    if(fixedFormTableColumn�Q==null){

      fixedFormTableColumn�Q = new ACTableColumn();

      fixedFormTableColumn�Q.setHeaderValue("����");

      fixedFormTableColumn�Q.setColumnName("FIXED_FORM_GROUP");

      fixedFormTableColumn�Q.setColumns(14);

      addFixedFormTableColumn�Q();
    }
    return fixedFormTableColumn�Q;

  }

  /**
   * �e�[�u���F���ڂ��擾���܂��B
   * @return �e�[�u���F����
   */
  public ACTableColumn getFixedFormTableColumn�R(){
    if(fixedFormTableColumn�R==null){

      fixedFormTableColumn�R = new ACTableColumn();

      fixedFormTableColumn�R.setHeaderValue("����");

      fixedFormTableColumn�R.setColumnName("FIXED_FORM_TITLE");

      fixedFormTableColumn�R.setColumns(10);

      addFixedFormTableColumn�R();
    }
    return fixedFormTableColumn�R;

  }

  /**
   * ��^���ҏW�p�l�����擾���܂��B
   * @return ��^���ҏW�p�l��
   */
  public ACPanel getFixedFormEdits(){
    if(fixedFormEdits==null){

      fixedFormEdits = new ACPanel();

      addFixedFormEdits();
    }
    return fixedFormEdits;

  }

  /**
   * ��^���ҏW�E�t���[�����擾���܂��B
   * @return ��^���ҏW�E�t���[��
   */
  public ACGroupBox getFixedFormEdit(){
    if(fixedFormEdit==null){

      fixedFormEdit = new ACGroupBox();

      fixedFormEdit.setText("��^���ҏW");

      fixedFormEdit.setLayout(getFixedFormEditLayout());

      addFixedFormEdit();
    }
    return fixedFormEdit;

  }

  /**
   * ��^���ҏW�p�l���E���C�A�E�g���擾���܂��B
   * @return ��^���ҏW�p�l���E���C�A�E�g
   */
  public VRLayout getFixedFormEditLayout(){
    if(fixedFormEditLayout==null){

      fixedFormEditLayout = new VRLayout();

      addFixedFormEditLayout();
    }
    return fixedFormEditLayout;

  }

  /**
   * �R�����g�̈���擾���܂��B
   * @return �R�����g�̈�
   */
  public ACPanel getFixedFormEditComments(){
    if(fixedFormEditComments==null){

      fixedFormEditComments = new ACPanel();

      fixedFormEditComments.setLayout(getFixedFormEditCommentLayout());

      addFixedFormEditComments();
    }
    return fixedFormEditComments;

  }

  /**
   * �R�����g�̈�E���C�A�E�g���擾���܂��B
   * @return �R�����g�̈�E���C�A�E�g
   */
  public VRLayout getFixedFormEditCommentLayout(){
    if(fixedFormEditCommentLayout==null){

      fixedFormEditCommentLayout = new VRLayout();

      fixedFormEditCommentLayout.setHgap(0);

      addFixedFormEditCommentLayout();
    }
    return fixedFormEditCommentLayout;

  }

  /**
   * �R�����g�E���x��1���擾���܂��B
   * @return �R�����g�E���x��1
   */
  public ACLabel getFixedFormEditComment1(){
    if(fixedFormEditComment1==null){

      fixedFormEditComment1 = new ACLabel();

      fixedFormEditComment1.setText("[�ύX]��������[�폜]���������ڂ���⃊�X�g����I��ł��������B");

      addFixedFormEditComment1();
    }
    return fixedFormEditComment1;

  }

  /**
   * �R�����g�E���x��2���擾���܂��B
   * @return �R�����g�E���x��2
   */
  public ACLabel getFixedFormEditComment2(){
    if(fixedFormEditComment2==null){

      fixedFormEditComment2 = new ACLabel();

      fixedFormEditComment2.setText("[�ǉ�]�̎��͉��̃e�L�X�g�{�b�N�X�ɓ��͂���[�ǉ�]�������Ă��������B");

      addFixedFormEditComment2();
    }
    return fixedFormEditComment2;

  }

  /**
   * ���ځE���ڑ���{�^���̈���擾���܂��B
   * @return ���ځE���ڑ���{�^���̈�
   */
  public ACPanel getFixedFormEdititemAndItemManipulateButtons(){
    if(fixedFormEdititemAndItemManipulateButtons==null){

      fixedFormEdititemAndItemManipulateButtons = new ACPanel();

      addFixedFormEdititemAndItemManipulateButtons();
    }
    return fixedFormEdititemAndItemManipulateButtons;

  }

  /**
   * ���ڗ̈���擾���܂��B
   * @return ���ڗ̈�
   */
  public ACPanel getFixedFormEdititems(){
    if(fixedFormEdititems==null){

      fixedFormEdititems = new ACPanel();

      fixedFormEdititems.setHgap(0);

      addFixedFormEdititems();
    }
    return fixedFormEdititems;

  }

  /**
   * ���ڃe�[�u�����擾���܂��B
   * @return ���ڃe�[�u��
   */
  public ACTable getFixedFormEditItemTable(){
    if(fixedFormEditItemTable==null){

      fixedFormEditItemTable = new ACTable();

      fixedFormEditItemTable.setColumnModel(getFixedFormEditItemTableColumnModel());

      fixedFormEditItemTable.setPreferredSize(new Dimension(700,220));

      addFixedFormEditItemTable();
    }
    return fixedFormEditItemTable;

  }

  /**
   * ���ڃe�[�u���J�������f�����擾���܂��B
   * @return ���ڃe�[�u���J�������f��
   */
  protected VRTableColumnModel getFixedFormEditItemTableColumnModel(){
    if(fixedFormEditItemTableColumnModel==null){
      fixedFormEditItemTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addFixedFormEditItemTableColumnModel();
    }
    return fixedFormEditItemTableColumnModel;
  }

  /**
   * �e�[�u���FNo.���擾���܂��B
   * @return �e�[�u���FNo.
   */
  public ACTableColumn getFixedFormEditItemTableColumn1(){
    if(fixedFormEditItemTableColumn1==null){

      fixedFormEditItemTableColumn1 = new ACTableColumn();

      fixedFormEditItemTableColumn1.setHeaderValue("No.");

      fixedFormEditItemTableColumn1.setColumns(4);

      fixedFormEditItemTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      fixedFormEditItemTableColumn1.setSortable(false);

      addFixedFormEditItemTableColumn1();
    }
    return fixedFormEditItemTableColumn1;

  }

  /**
   * �e�[�u���F�������[�h���擾���܂��B
   * @return �e�[�u���F�������[�h
   */
  public ACTableColumn getFixedFormEditItemTableColumn2(){
    if(fixedFormEditItemTableColumn2==null){

      fixedFormEditItemTableColumn2 = new ACTableColumn();

      fixedFormEditItemTableColumn2.setHeaderValue("����");

      fixedFormEditItemTableColumn2.setColumns(4);

      fixedFormEditItemTableColumn2.setRendererType(ACTableCellViewer.RENDERER_TYPE_STATE_ICON);

      fixedFormEditItemTableColumn2.setSortable(false);

      addFixedFormEditItemTableColumn2();
    }
    return fixedFormEditItemTableColumn2;

  }

  /**
   * �T�[�r�X��ނ��擾���܂��B
   * @return �T�[�r�X���
   */
  public ACTableColumn getFixedFormEditItemTableColumn4(){
    if(fixedFormEditItemTableColumn4==null){

      fixedFormEditItemTableColumn4 = new ACTableColumn();

      fixedFormEditItemTableColumn4.setHeaderValue("�T�[�r�X���");

      fixedFormEditItemTableColumn4.setColumnName("SERVICE_CODE_KIND");

      fixedFormEditItemTableColumn4.setColumns(14);

      fixedFormEditItemTableColumn4.setFormat(QkanServiceKindNameFormat.getInstance());

      fixedFormEditItemTableColumn4.setSortable(false);

      addFixedFormEditItemTableColumn4();
    }
    return fixedFormEditItemTableColumn4;

  }

  /**
   * �e�[�u���F���e���擾���܂��B
   * @return �e�[�u���F���e
   */
  public ACTableColumn getFixedFormEditItemTableColumn3(){
    if(fixedFormEditItemTableColumn3==null){

      fixedFormEditItemTableColumn3 = new ACTableColumn();

      fixedFormEditItemTableColumn3.setHeaderValue("���e");

      fixedFormEditItemTableColumn3.setColumnName("CONTENT");

      fixedFormEditItemTableColumn3.setColumns(25);

      fixedFormEditItemTableColumn3.setSortable(false);

      addFixedFormEditItemTableColumn3();
    }
    return fixedFormEditItemTableColumn3;

  }

  /**
   * ���ڑ���{�^���̈���擾���܂��B
   * @return ���ڑ���{�^���̈�
   */
  public ACPanel getFixedFormEditItemManipulateButtons(){
    if(fixedFormEditItemManipulateButtons==null){

      fixedFormEditItemManipulateButtons = new ACPanel();

      addFixedFormEditItemManipulateButtons();
    }
    return fixedFormEditItemManipulateButtons;

  }

  /**
   * ��փ{�^�����擾���܂��B
   * @return ��փ{�^��
   */
  public ACButton getFixedFormEditItemManipulateButtonUp(){
    if(fixedFormEditItemManipulateButtonUp==null){

      fixedFormEditItemManipulateButtonUp = new ACButton();

      fixedFormEditItemManipulateButtonUp.setText("���");

      addFixedFormEditItemManipulateButtonUp();
    }
    return fixedFormEditItemManipulateButtonUp;

  }

  /**
   * ���փ{�^�����擾���܂��B
   * @return ���փ{�^��
   */
  public ACButton getFixedFormEditItemManipulateButtonDown(){
    if(fixedFormEditItemManipulateButtonDown==null){

      fixedFormEditItemManipulateButtonDown = new ACButton();

      fixedFormEditItemManipulateButtonDown.setText("����");

      addFixedFormEditItemManipulateButtonDown();
    }
    return fixedFormEditItemManipulateButtonDown;

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�̈���擾���܂��B
   * @return ���́E�ҏW�e�L�X�g�{�b�N�X�̈�
   */
  public ACPanel getFixedFormEditInputAndCompileTextBoxs(){
    if(fixedFormEditInputAndCompileTextBoxs==null){

      fixedFormEditInputAndCompileTextBoxs = new ACPanel();

      addFixedFormEditInputAndCompileTextBoxs();
    }
    return fixedFormEditInputAndCompileTextBoxs;

  }

  /**
   * ���́E�ҏW���x���̈���擾���܂��B
   * @return ���́E�ҏW���x���̈�
   */
  public ACPanel getFixedFormEditInputLefts(){
    if(fixedFormEditInputLefts==null){

      fixedFormEditInputLefts = new ACPanel();

      addFixedFormEditInputLefts();
    }
    return fixedFormEditInputLefts;

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X���x�����擾���܂��B
   * @return ���́E�ҏW�e�L�X�g�{�b�N�X���x��
   */
  public ACLabel getFixedFormEditInputLeft(){
    if(fixedFormEditInputLeft==null){

      fixedFormEditInputLeft = new ACLabel();

      fixedFormEditInputLeft.setText("���́E�ҏW��");

      addFixedFormEditInputLeft();
    }
    return fixedFormEditInputLeft;

  }

  /**
   * ���́E�ҏW�L���v�V�������x��1���擾���܂��B
   * @return ���́E�ҏW�L���v�V�������x��1
   */
  public ACLabel getFixedFormEditInputCaption1(){
    if(fixedFormEditInputCaption1==null){

      fixedFormEditInputCaption1 = new ACLabel();

      fixedFormEditInputCaption1.setText("(");

      addFixedFormEditInputCaption1();
    }
    return fixedFormEditInputCaption1;

  }

  /**
   * ���́E�ҏW�L���v�V�������x��2���擾���܂��B
   * @return ���́E�ҏW�L���v�V�������x��2
   */
  public ACLabel getFixedFormEditInputCaption2(){
    if(fixedFormEditInputCaption2==null){

      fixedFormEditInputCaption2 = new ACLabel();

      fixedFormEditInputCaption2.setText("100");

      addFixedFormEditInputCaption2();
    }
    return fixedFormEditInputCaption2;

  }

  /**
   * ���́E�ҏW�L���v�V�������x��3���擾���܂��B
   * @return ���́E�ҏW�L���v�V�������x��3
   */
  public ACLabel getFixedFormEditInputCaption3(){
    if(fixedFormEditInputCaption3==null){

      fixedFormEditInputCaption3 = new ACLabel();

      fixedFormEditInputCaption3.setText("�����ȓ�)");

      addFixedFormEditInputCaption3();
    }
    return fixedFormEditInputCaption3;

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�̈���擾���܂��B
   * @return ���́E�ҏW�e�L�X�g�{�b�N�X�̈�
   */
  public ACPanel getFixedFormEditInputCaptions(){
    if(fixedFormEditInputCaptions==null){

      fixedFormEditInputCaptions = new ACPanel();

      fixedFormEditInputCaptions.setLayout(getFixedFormEditInputCaptionLayout());

      addFixedFormEditInputCaptions();
    }
    return fixedFormEditInputCaptions;

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�̈�E���C�A�E�g���擾���܂��B
   * @return ���́E�ҏW�e�L�X�g�{�b�N�X�̈�E���C�A�E�g
   */
  public VRLayout getFixedFormEditInputCaptionLayout(){
    if(fixedFormEditInputCaptionLayout==null){

      fixedFormEditInputCaptionLayout = new VRLayout();

      fixedFormEditInputCaptionLayout.setHgap(0);

      addFixedFormEditInputCaptionLayout();
    }
    return fixedFormEditInputCaptionLayout;

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X���擾���܂��B
   * @return ���́E�ҏW�e�L�X�g�{�b�N�X
   */
  public ACTextField getFixedFormEditInputAndCompileTextBox(){
    if(fixedFormEditInputAndCompileTextBox==null){

      fixedFormEditInputAndCompileTextBox = new ACTextField();

      fixedFormEditInputAndCompileTextBox.setBindPath("CONTENT");

      fixedFormEditInputAndCompileTextBox.setColumns(60);

      fixedFormEditInputAndCompileTextBox.setIMEMode(InputSubset.KANJI);

      fixedFormEditInputAndCompileTextBox.setMaxLength(100);

      addFixedFormEditInputAndCompileTextBox();
    }
    return fixedFormEditInputAndCompileTextBox;

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�R���e�i���擾���܂��B
   * @return ���́E�ҏW�e�L�X�g�{�b�N�X�R���e�i
   */
  protected ACLabelContainer getFixedFormEditInputAndCompileTextBoxContainer(){
    if(fixedFormEditInputAndCompileTextBoxContainer==null){
      fixedFormEditInputAndCompileTextBoxContainer = new ACLabelContainer();
      fixedFormEditInputAndCompileTextBoxContainer.setFollowChildEnabled(true);
      fixedFormEditInputAndCompileTextBoxContainer.setVAlignment(VRLayout.CENTER);
      fixedFormEditInputAndCompileTextBoxContainer.add(getFixedFormEditInputAndCompileTextBox(), VRLayout.CLIENT);
    }
    return fixedFormEditInputAndCompileTextBoxContainer;
  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getFixedFormEditDownButtons(){
    if(fixedFormEditDownButtons==null){

      fixedFormEditDownButtons = new ACPanel();

      addFixedFormEditDownButtons();
    }
    return fixedFormEditDownButtons;

  }

  /**
   * �ǉ��{�^�����擾���܂��B
   * @return �ǉ��{�^��
   */
  public ACButton getFixedFormEditInsert(){
    if(fixedFormEditInsert==null){

      fixedFormEditInsert = new ACButton();

      fixedFormEditInsert.setText("�ǉ�");

      fixedFormEditInsert.setToolTipText("��^����ǉ����܂��B");

      fixedFormEditInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addFixedFormEditInsert();
    }
    return fixedFormEditInsert;

  }

  /**
   * �ҏW�{�^�����擾���܂��B
   * @return �ҏW�{�^��
   */
  public ACButton getFixedFormEditUpdate(){
    if(fixedFormEditUpdate==null){

      fixedFormEditUpdate = new ACButton();

      fixedFormEditUpdate.setText("�ҏW");

      fixedFormEditUpdate.setToolTipText("��^����ύX���܂��B");

      fixedFormEditUpdate.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addFixedFormEditUpdate();
    }
    return fixedFormEditUpdate;

  }

  /**
   * �폜�{�^�����擾���܂��B
   * @return �폜�{�^��
   */
  public ACButton getFixedFormEditDelete(){
    if(fixedFormEditDelete==null){

      fixedFormEditDelete = new ACButton();

      fixedFormEditDelete.setText("�폜");

      fixedFormEditDelete.setToolTipText("��^�����폜���܂��B");

      fixedFormEditDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addFixedFormEditDelete();
    }
    return fixedFormEditDelete;

  }

  /**
   * �폜����{�^�����擾���܂��B
   * @return �폜����{�^��
   */
  public ACButton getFixedFormEditCancelDelete(){
    if(fixedFormEditCancelDelete==null){

      fixedFormEditCancelDelete = new ACButton();

      fixedFormEditCancelDelete.setText("�폜���");

      fixedFormEditCancelDelete.setToolTipText("��^���̍폜���������܂��B");

      fixedFormEditCancelDelete.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addFixedFormEditCancelDelete();
    }
    return fixedFormEditCancelDelete;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO008Design() {

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

    Buttons.add(getUpdate(), VRLayout.EAST);
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

    contents.add(getFixedFormPanels(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentLayout(){

  }

  /**
   * ��^�����ڈꗗ�E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormPanels(){

    fixedFormPanels.add(getFixedFormPanel(), VRLayout.NORTH);

    fixedFormPanels.add(getFixedFormEdits(), VRLayout.NORTH);

  }

  /**
   * ��^�����ڑI���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormPanel(){

    fixedFormPanel.add(getFixedForm(), VRLayout.FLOW);

  }

  /**
   * ��^�����ڑI���t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedForm(){

    fixedForm.add(getFixedFormLabel(), VRLayout.NORTH);

    fixedForm.add(getFixedFormTable(), VRLayout.FLOW);

  }

  /**
   * ��^�����ڑI�����C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormLayout(){

  }

  /**
   * ��^�����ڑI�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormLabel(){

  }

  /**
   * ��^�����ڑI���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormTable(){

  }

  /**
   * ��^�����ڑI���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormTableColumnModel(){

    getFixedFormTableColumnModel().addColumn(getFixedFormTableColumn�P());

    getFixedFormTableColumnModel().addColumn(getFixedFormTableColumn�Q());

    getFixedFormTableColumnModel().addColumn(getFixedFormTableColumn�R());

  }

  /**
   * �e�[�u���FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormTableColumn�P(){

  }

  /**
   * �e�[�u���F���ނɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormTableColumn�Q(){

  }

  /**
   * �e�[�u���F���ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormTableColumn�R(){

  }

  /**
   * ��^���ҏW�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEdits(){

    fixedFormEdits.add(getFixedFormEdit(), VRLayout.FLOW);

  }

  /**
   * ��^���ҏW�E�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEdit(){

    fixedFormEdit.add(getFixedFormEditComments(), VRLayout.NORTH);

    fixedFormEdit.add(getFixedFormEdititemAndItemManipulateButtons(), VRLayout.NORTH);

    fixedFormEdit.add(getFixedFormEditInputAndCompileTextBoxs(), VRLayout.NORTH);

    fixedFormEdit.add(getFixedFormEditDownButtons(), VRLayout.NORTH);

  }

  /**
   * ��^���ҏW�p�l���E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditLayout(){

  }

  /**
   * �R�����g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditComments(){

    fixedFormEditComments.add(getFixedFormEditComment1(), VRLayout.FLOW_RETURN);

    fixedFormEditComments.add(getFixedFormEditComment2(), VRLayout.FLOW);

  }

  /**
   * �R�����g�̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditCommentLayout(){

  }

  /**
   * �R�����g�E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditComment1(){

  }

  /**
   * �R�����g�E���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditComment2(){

  }

  /**
   * ���ځE���ڑ���{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEdititemAndItemManipulateButtons(){

    fixedFormEdititemAndItemManipulateButtons.add(getFixedFormEdititems(), VRLayout.WEST);

    fixedFormEdititemAndItemManipulateButtons.add(getFixedFormEditItemManipulateButtons(), VRLayout.WEST);

  }

  /**
   * ���ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEdititems(){

    fixedFormEdititems.add(getFixedFormEditItemTable(), VRLayout.FLOW);

  }

  /**
   * ���ڃe�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemTable(){

  }

  /**
   * ���ڃe�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemTableColumnModel(){

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn1());

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn2());

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn4());

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn3());

  }

  /**
   * �e�[�u���FNo.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemTableColumn1(){

  }

  /**
   * �e�[�u���F�������[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemTableColumn2(){

  }

  /**
   * �T�[�r�X��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemTableColumn4(){

  }

  /**
   * �e�[�u���F���e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemTableColumn3(){

  }

  /**
   * ���ڑ���{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemManipulateButtons(){

    fixedFormEditItemManipulateButtons.add(getFixedFormEditItemManipulateButtonUp(), VRLayout.FLOW_RETURN);

    fixedFormEditItemManipulateButtons.add(getFixedFormEditItemManipulateButtonDown(), VRLayout.FLOW_RETURN);

  }

  /**
   * ��փ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemManipulateButtonUp(){

  }

  /**
   * ���փ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditItemManipulateButtonDown(){

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputAndCompileTextBoxs(){

    fixedFormEditInputAndCompileTextBoxs.add(getFixedFormEditInputLefts(), VRLayout.NORTH);

    fixedFormEditInputAndCompileTextBoxs.add(getFixedFormEditInputCaptions(), VRLayout.FLOW);

  }

  /**
   * ���́E�ҏW���x���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputLefts(){

    fixedFormEditInputLefts.add(getFixedFormEditInputLeft(), VRLayout.WEST);

    fixedFormEditInputLefts.add(getFixedFormEditInputCaption3(), VRLayout.EAST);
    fixedFormEditInputLefts.add(getFixedFormEditInputCaption2(), VRLayout.EAST);
    fixedFormEditInputLefts.add(getFixedFormEditInputCaption1(), VRLayout.EAST);
  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputLeft(){

  }

  /**
   * ���́E�ҏW�L���v�V�������x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputCaption1(){

  }

  /**
   * ���́E�ҏW�L���v�V�������x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputCaption2(){

  }

  /**
   * ���́E�ҏW�L���v�V�������x��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputCaption3(){

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputCaptions(){

    fixedFormEditInputCaptions.add(getFixedFormEditInputAndCompileTextBoxContainer(), VRLayout.WEST);

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputCaptionLayout(){

  }

  /**
   * ���́E�ҏW�e�L�X�g�{�b�N�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInputAndCompileTextBox(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditDownButtons(){

    fixedFormEditDownButtons.add(getFixedFormEditInsert(), VRLayout.WEST);

    fixedFormEditDownButtons.add(getFixedFormEditUpdate(), VRLayout.WEST);

    fixedFormEditDownButtons.add(getFixedFormEditDelete(), VRLayout.WEST);

    fixedFormEditDownButtons.add(getFixedFormEditCancelDelete(), VRLayout.WEST);

  }

  /**
   * �ǉ��{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditInsert(){

  }

  /**
   * �ҏW�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditUpdate(){

  }

  /**
   * �폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditDelete(){

  }

  /**
   * �폜����{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFixedFormEditCancelDelete(){

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
      ACFrame.debugStart(new ACAffairInfo(QO008Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO008Design getThis() {
    return this;
  }
}
