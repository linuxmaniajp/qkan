
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
 * �J����: �A�� ��C
 * �쐬��: 2018/02/20  ���{�R���s���[�^�[������� �A�� ��C �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X CSV�r���[�A (012)
 * �v���O���� CSV�r���[�A (QO012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.viewer.qo.qo012;
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
 * CSV�r���[�A��ʍ��ڃf�U�C��(QO012) 
 */
public class QO012Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton openButton;

  private ACAffairButton unitingButton;

  private ACPanel contents;

  private ACPanel fileInfoPanel;

  private ACGroupBox fileInfoGroup;

  private ACLabel fileTypeLabel;

  private ACLabel fileType;

  private ACLabel mediaTypeLabel;

  private ACLabel mediaType;

  private ACLabel targetYearAndMonthLabel;

  private ACLabel targetYearAndMonth;

  private ACLabel providerLabel;

  private ACLabel providerId;

  private ACLabel providerName;

  private ACTable totalInfoTable;

  private VRTableColumnModel totalInfoTableColumnModel;

  private ACTableColumn totalInfoTableColumn1;

  private ACTableColumn totalInfoTableColumn2;

  private ACTableColumn totalInfoTableColumn3;

  private ACTableColumn totalInfoTableColumn4;

  private ACTableColumn totalInfoTableColumn5;

  private ACTableColumn totalInfoTableColumn6;

  private ACTable csvDataTable;

  private VRTableColumnModel csvDataTableColumnModel;

  private ACTableColumn csvDataTableColumn1;

  private ACTableColumn csvDataTableColumn2;

  private ACTableColumn csvDataTableColumn3;

  private ACTableColumn csvDataTableColumn4;

  private ACTableColumn csvDataTableColumn5;

  private ACTableColumn csvDataTableColumn6;

  private ACTableColumn csvDataTableColumn7;

  private ACTableColumn csvDataTableColumn8;

  private ACTableColumn csvDataTableColumn9;

  private ACTableColumn csvDataTableColumn10;

  private ACTableColumn csvDataTableColumn11;

  private ACTableColumn csvDataTableColumn12;

  private ACTableColumn csvDataTableColumn13;

  private ACTableColumn csvDataTableColumn14;

  private ACTableColumn csvDataTableColumn69;

  private ACTableColumn csvDataTableColumn15;

  private ACTableColumn csvDataTableColumn16;

  private ACTableColumn csvDataTableColumn17;

  private ACTableColumn csvDataTableColumn46;

  private ACTableColumn csvDataTableColumn18;

  private ACTableColumn csvDataTableColumn47;

  private ACTableColumn csvDataTableColumn19;

  private ACTableColumn csvDataTableColumn20;

  private ACTableColumn csvDataTableColumn21;

  private ACTableColumn csvDataTableColumn22;

  private ACTableColumn csvDataTableColumn23;

  private ACTableColumn csvDataTableColumn70;

  private ACTableColumn csvDataTableColumn24;

  private ACTableColumn csvDataTableColumn25;

  private ACTableColumn csvDataTableColumn48;

  private ACTableColumn csvDataTableColumn49;

  private ACTableColumn csvDataTableColumn50;

  private ACTableColumn csvDataTableColumn26;

  private ACTableColumn csvDataTableColumn51;

  private ACTableColumn csvDataTableColumn53;

  private ACTableColumn csvDataTableColumn27;

  private ACTableColumn csvDataTableColumn28;

  private ACTableColumn csvDataTableColumn29;

  private ACTableColumn csvDataTableColumn30;

  private ACTableColumn csvDataTableColumn31;

  private ACTableColumn csvDataTableColumn32;

  private ACTableColumn csvDataTableColumn33;

  private ACTableColumn csvDataTableColumn34;

  private ACTableColumn csvDataTableColumn35;

  private ACTableColumn csvDataTableColumn36;

  private ACTableColumn csvDataTableColumn37;

  private ACTableColumn csvDataTableColumn71;

  private ACTableColumn csvDataTableColumn38;

  private ACTableColumn csvDataTableColumn39;

  private ACTableColumn csvDataTableColumn40;

  private ACTableColumn csvDataTableColumn41;

  private ACTableColumn csvDataTableColumn42;

  private ACTableColumn csvDataTableColumn52;

  private ACTableColumn csvDataTableColumn43;

  private ACTableColumn csvDataTableColumn44;

  private ACTableColumn csvDataTableColumn54;

  private ACTableColumn csvDataTableColumn55;

  private ACTableColumn csvDataTableColumn56;

  private ACTableColumn csvDataTableColumn57;

  private ACTableColumn csvDataTableColumn58;

  private ACTableColumn csvDataTableColumn59;

  private ACTableColumn csvDataTableColumn60;

  private ACTableColumn csvDataTableColumn61;

  private ACTableColumn csvDataTableColumn62;

  private ACTableColumn csvDataTableColumn63;

  private ACTableColumn csvDataTableColumn64;

  private ACTableColumn csvDataTableColumn65;

  private ACTableColumn csvDataTableColumn66;

  private ACTableColumn csvDataTableColumn67;

  private ACTableColumn csvDataTableColumn68;

  private ACTableColumn csvDataTableColumn45;

  //getter

  /**
   * �Ɩ��{�^���o�[���擾���܂��B
   * @return �Ɩ��{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���t�Ǘ�/����V���� CSV�t�@�C���r���[�A");

      buttons.setBackVisible(false);

      addButtons();
    }
    return buttons;

  }

  /**
   * �J�����擾���܂��B
   * @return �J��
   */
  public ACAffairButton getOpenButton(){
    if(openButton==null){

      openButton = new ACAffairButton();

      openButton.setText("�J��(O)");

      openButton.setMnemonic('O');

      openButton.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpenButton();
    }
    return openButton;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACAffairButton getUnitingButton(){
    if(unitingButton==null){

      unitingButton = new ACAffairButton();

      unitingButton.setText("����(U)");

      unitingButton.setMnemonic('U');

      unitingButton.setIconPath(ACConstants.ICON_PATH_COPY_24);

      addUnitingButton();
    }
    return unitingButton;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * ���ʗ̈���擾���܂��B
   * @return ���ʗ̈�
   */
  public ACPanel getFileInfoPanel(){
    if(fileInfoPanel==null){

      fileInfoPanel = new ACPanel();

      fileInfoPanel.setAutoWrap(false);

      addFileInfoPanel();
    }
    return fileInfoPanel;

  }

  /**
   * �t�@�C�����O���[�v���擾���܂��B
   * @return �t�@�C�����O���[�v
   */
  public ACGroupBox getFileInfoGroup(){
    if(fileInfoGroup==null){

      fileInfoGroup = new ACGroupBox();

      fileInfoGroup.setText("�t�@�C�����");

      addFileInfoGroup();
    }
    return fileInfoGroup;

  }

  /**
   * ��ރ��x�����擾���܂��B
   * @return ��ރ��x��
   */
  public ACLabel getFileTypeLabel(){
    if(fileTypeLabel==null){

      fileTypeLabel = new ACLabel();

      fileTypeLabel.setText("�y�@��@�ށ@�z");

      addFileTypeLabel();
    }
    return fileTypeLabel;

  }

  /**
   * ��ނ��擾���܂��B
   * @return ���
   */
  public ACLabel getFileType(){
    if(fileType==null){

      fileType = new ACLabel();

      fileType.setBindPath("FILE_TYPE");

      addFileType();
    }
    return fileType;

  }

  /**
   * �}�̃��x�����擾���܂��B
   * @return �}�̃��x��
   */
  public ACLabel getMediaTypeLabel(){
    if(mediaTypeLabel==null){

      mediaTypeLabel = new ACLabel();

      mediaTypeLabel.setText("�y�@�}�@�́@�z");

      addMediaTypeLabel();
    }
    return mediaTypeLabel;

  }

  /**
   * �}�̂��擾���܂��B
   * @return �}��
   */
  public ACLabel getMediaType(){
    if(mediaType==null){

      mediaType = new ACLabel();

      mediaType.setBindPath("MEDIA_TYPE");

      addMediaType();
    }
    return mediaType;

  }

  /**
   * �����Ώ۔N�����x�����擾���܂��B
   * @return �����Ώ۔N�����x��
   */
  public ACLabel getTargetYearAndMonthLabel(){
    if(targetYearAndMonthLabel==null){

      targetYearAndMonthLabel = new ACLabel();

      targetYearAndMonthLabel.setText("�y�����Ώی��z");

      addTargetYearAndMonthLabel();
    }
    return targetYearAndMonthLabel;

  }

  /**
   * �����Ώ۔N�����擾���܂��B
   * @return �����Ώ۔N��
   */
  public ACLabel getTargetYearAndMonth(){
    if(targetYearAndMonth==null){

      targetYearAndMonth = new ACLabel();

      targetYearAndMonth.setBindPath("TARGET_MONTH");

      targetYearAndMonth.setFormat(new ACBorderBlankDateFormat("yyyy�NMM��"));

      addTargetYearAndMonth();
    }
    return targetYearAndMonth;

  }

  /**
   * ���Ə����x�����擾���܂��B
   * @return ���Ə����x��
   */
  public ACLabel getProviderLabel(){
    if(providerLabel==null){

      providerLabel = new ACLabel();

      providerLabel.setText("�y���@�Ɓ@���z");

      addProviderLabel();
    }
    return providerLabel;

  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACLabel getProviderId(){
    if(providerId==null){

      providerId = new ACLabel();

      providerId.setBindPath("PROVIDER_ID");

      addProviderId();
    }
    return providerId;

  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACLabel getProviderName(){
    if(providerName==null){

      providerName = new ACLabel();

      providerName.setBindPath("PROVIDER_NAME");

      addProviderName();
    }
    return providerName;

  }

  /**
   * �W�v���e�[�u�����擾���܂��B
   * @return �W�v���e�[�u��
   */
  public ACTable getTotalInfoTable(){
    if(totalInfoTable==null){

      totalInfoTable = new ACTable();

      totalInfoTable.setColumnModel(getTotalInfoTableColumnModel());

      totalInfoTable.setColumnSort(true);

      totalInfoTable.setRows(3);

      addTotalInfoTable();
    }
    return totalInfoTable;

  }

  /**
   * �W�v���e�[�u���J�������f�����擾���܂��B
   * @return �W�v���e�[�u���J�������f��
   */
  protected VRTableColumnModel getTotalInfoTableColumnModel(){
    if(totalInfoTableColumnModel==null){
      totalInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTotalInfoTableColumnModel();
    }
    return totalInfoTableColumnModel;
  }

  /**
   * ���J�������擾���܂��B
   * @return ���J����
   */
  public ACTableColumn getTotalInfoTableColumn1(){
    if(totalInfoTableColumn1==null){

      totalInfoTableColumn1 = new ACTableColumn();

      totalInfoTableColumn1.setHeaderValue("����");

      totalInfoTableColumn1.setColumnName("TOTAL1");

      totalInfoTableColumn1.setEditable(false);

      totalInfoTableColumn1.setColumns(10);

      totalInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("yyyy�NMM��"));

      addTotalInfoTableColumn1();
    }
    return totalInfoTableColumn1;

  }

  /**
   * �l���J�������擾���܂��B
   * @return �l���J����
   */
  public ACTableColumn getTotalInfoTableColumn2(){
    if(totalInfoTableColumn2==null){

      totalInfoTableColumn2 = new ACTableColumn();

      totalInfoTableColumn2.setHeaderValue("�l��");

      totalInfoTableColumn2.setColumnName("TOTAL2");

      totalInfoTableColumn2.setEditable(false);

      totalInfoTableColumn2.setColumns(10);

      addTotalInfoTableColumn2();
    }
    return totalInfoTableColumn2;

  }

  /**
   * �T�[�r�X�����J�������擾���܂��B
   * @return �T�[�r�X�����J����
   */
  public ACTableColumn getTotalInfoTableColumn3(){
    if(totalInfoTableColumn3==null){

      totalInfoTableColumn3 = new ACTableColumn();

      totalInfoTableColumn3.setHeaderValue("�T�[�r�X����");

      totalInfoTableColumn3.setColumnName("TOTAL3");

      totalInfoTableColumn3.setEditable(false);

      totalInfoTableColumn3.setColumns(10);

      addTotalInfoTableColumn3();
    }
    return totalInfoTableColumn3;

  }

  /**
   * �P�A�v���������J�������擾���܂��B
   * @return �P�A�v���������J����
   */
  public ACTableColumn getTotalInfoTableColumn4(){
    if(totalInfoTableColumn4==null){

      totalInfoTableColumn4 = new ACTableColumn();

      totalInfoTableColumn4.setHeaderValue("�P�A�v��������");

      totalInfoTableColumn4.setColumnName("TOTAL4");

      totalInfoTableColumn4.setEditable(false);

      totalInfoTableColumn4.setColumns(10);

      addTotalInfoTableColumn4();
    }
    return totalInfoTableColumn4;

  }

  /**
   * �P�ʐ��J�������擾���܂��B
   * @return �P�ʐ��J����
   */
  public ACTableColumn getTotalInfoTableColumn5(){
    if(totalInfoTableColumn5==null){

      totalInfoTableColumn5 = new ACTableColumn();

      totalInfoTableColumn5.setHeaderValue("�P�ʐ�");

      totalInfoTableColumn5.setColumnName("TOTAL5");

      totalInfoTableColumn5.setEditable(false);

      totalInfoTableColumn5.setColumns(10);

      addTotalInfoTableColumn5();
    }
    return totalInfoTableColumn5;

  }

  /**
   * �ی������z�J�������擾���܂��B
   * @return �ی������z�J����
   */
  public ACTableColumn getTotalInfoTableColumn6(){
    if(totalInfoTableColumn6==null){

      totalInfoTableColumn6 = new ACTableColumn();

      totalInfoTableColumn6.setHeaderValue("�ی��^���Ɣ���z");

      totalInfoTableColumn6.setColumnName("TOTAL6");

      totalInfoTableColumn6.setEditable(false);

      totalInfoTableColumn6.setColumns(10);

      addTotalInfoTableColumn6();
    }
    return totalInfoTableColumn6;

  }

  /**
   * CSV�f�[�^�e�[�u�����擾���܂��B
   * @return CSV�f�[�^�e�[�u��
   */
  public ACTable getCsvDataTable(){
    if(csvDataTable==null){

      csvDataTable = new ACTable();

      csvDataTable.setColumnModel(getCsvDataTableColumnModel());

      csvDataTable.setColumnSort(true);

      csvDataTable.setHeaderRows(5);

      addCsvDataTable();
    }
    return csvDataTable;

  }

  /**
   * CSV�f�[�^�e�[�u���J�������f�����擾���܂��B
   * @return CSV�f�[�^�e�[�u���J�������f��
   */
  protected VRTableColumnModel getCsvDataTableColumnModel(){
    if(csvDataTableColumnModel==null){
      csvDataTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addCsvDataTableColumnModel();
    }
    return csvDataTableColumnModel;
  }

  /**
   * �N���J�������擾���܂��B
   * @return �N���J����
   */
  public ACTableColumn getCsvDataTableColumn1(){
    if(csvDataTableColumn1==null){

      csvDataTableColumn1 = new ACTableColumn();

      csvDataTableColumn1.setHeaderValue("�N��");

      csvDataTableColumn1.setColumnName("YEAR_AND_MONTH");

      csvDataTableColumn1.setEditable(false);

      csvDataTableColumn1.setColumns(8);

      csvDataTableColumn1.setFormat(new ACBorderBlankDateFormat("yyyy�NMM��"));

      csvDataTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn1();
    }
    return csvDataTableColumn1;

  }

  /**
   * ��ی��Ҕԍ��J�������擾���܂��B
   * @return ��ی��Ҕԍ��J����
   */
  public ACTableColumn getCsvDataTableColumn2(){
    if(csvDataTableColumn2==null){

      csvDataTableColumn2 = new ACTableColumn();

      csvDataTableColumn2.setHeaderValue("��ی��Ҕԍ�");

      csvDataTableColumn2.setColumnName("INSURED_ID");

      csvDataTableColumn2.setEditable(false);

      csvDataTableColumn2.setColumns(8);

      csvDataTableColumn2.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn2();
    }
    return csvDataTableColumn2;

  }

  /**
   * �����J�������擾���܂��B
   * @return �����J����
   */
  public ACTableColumn getCsvDataTableColumn3(){
    if(csvDataTableColumn3==null){

      csvDataTableColumn3 = new ACTableColumn();

      csvDataTableColumn3.setHeaderValue("����");

      csvDataTableColumn3.setColumnName("NAME");

      csvDataTableColumn3.setEditable(false);

      csvDataTableColumn3.setColumns(8);

      csvDataTableColumn3.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn3();
    }
    return csvDataTableColumn3;

  }

  /**
   * �v���x�J�������擾���܂��B
   * @return �v���x�J����
   */
  public ACTableColumn getCsvDataTableColumn4(){
    if(csvDataTableColumn4==null){

      csvDataTableColumn4 = new ACTableColumn();

      csvDataTableColumn4.setHeaderValue("�v���x");

      csvDataTableColumn4.setColumnName("CARE_LEVEL");

      csvDataTableColumn4.setEditable(false);

      csvDataTableColumn4.setColumns(8);

      csvDataTableColumn4.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn4();
    }
    return csvDataTableColumn4;

  }

  /**
   * �K��J�������擾���܂��B
   * @return �K��J����
   */
  public ACTableColumn getCsvDataTableColumn5(){
    if(csvDataTableColumn5==null){

      csvDataTableColumn5 = new ACTableColumn();

      csvDataTableColumn5.setHeaderValue("<html>11<br>�K<br>��<br><br>�@</html>");

      csvDataTableColumn5.setColumnName("11");

      csvDataTableColumn5.setEditable(false);

      csvDataTableColumn5.setColumns(3);

      csvDataTableColumn5.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn5();
    }
    return csvDataTableColumn5;

  }

  /**
   * �����J�������擾���܂��B
   * @return �����J����
   */
  public ACTableColumn getCsvDataTableColumn6(){
    if(csvDataTableColumn6==null){

      csvDataTableColumn6 = new ACTableColumn();

      csvDataTableColumn6.setHeaderValue("<html>12<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn6.setColumnName("12");

      csvDataTableColumn6.setEditable(false);

      csvDataTableColumn6.setColumns(3);

      csvDataTableColumn6.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn6();
    }
    return csvDataTableColumn6;

  }

  /**
   * �ŉ�J�������擾���܂��B
   * @return �ŉ�J����
   */
  public ACTableColumn getCsvDataTableColumn7(){
    if(csvDataTableColumn7==null){

      csvDataTableColumn7 = new ACTableColumn();

      csvDataTableColumn7.setHeaderValue("<html>13<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn7.setColumnName("13");

      csvDataTableColumn7.setEditable(false);

      csvDataTableColumn7.setColumns(3);

      csvDataTableColumn7.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn7();
    }
    return csvDataTableColumn7;

  }

  /**
   * �K���J�������擾���܂��B
   * @return �K���J����
   */
  public ACTableColumn getCsvDataTableColumn8(){
    if(csvDataTableColumn8==null){

      csvDataTableColumn8 = new ACTableColumn();

      csvDataTableColumn8.setHeaderValue("<html>14<br>�K<br>��<br><br>�@</html>");

      csvDataTableColumn8.setColumnName("14");

      csvDataTableColumn8.setEditable(false);

      csvDataTableColumn8.setColumns(3);

      csvDataTableColumn8.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn8();
    }
    return csvDataTableColumn8;

  }

  /**
   * �ʉ�J�������擾���܂��B
   * @return �ʉ�J����
   */
  public ACTableColumn getCsvDataTableColumn9(){
    if(csvDataTableColumn9==null){

      csvDataTableColumn9 = new ACTableColumn();

      csvDataTableColumn9.setHeaderValue("<html>15<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn9.setColumnName("15");

      csvDataTableColumn9.setEditable(false);

      csvDataTableColumn9.setColumns(3);

      csvDataTableColumn9.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn9();
    }
    return csvDataTableColumn9;

  }

  /**
   * �ʃ��J�������擾���܂��B
   * @return �ʃ��J����
   */
  public ACTableColumn getCsvDataTableColumn10(){
    if(csvDataTableColumn10==null){

      csvDataTableColumn10 = new ACTableColumn();

      csvDataTableColumn10.setHeaderValue("<html>16<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn10.setColumnName("16");

      csvDataTableColumn10.setEditable(false);

      csvDataTableColumn10.setColumns(3);

      csvDataTableColumn10.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn10();
    }
    return csvDataTableColumn10;

  }

  /**
   * �p��J�������擾���܂��B
   * @return �p��J����
   */
  public ACTableColumn getCsvDataTableColumn11(){
    if(csvDataTableColumn11==null){

      csvDataTableColumn11 = new ACTableColumn();

      csvDataTableColumn11.setHeaderValue("<html>17<br>�p<br>��<br><br>�@</html>");

      csvDataTableColumn11.setColumnName("17");

      csvDataTableColumn11.setEditable(false);

      csvDataTableColumn11.setColumns(3);

      csvDataTableColumn11.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn11();
    }
    return csvDataTableColumn11;

  }

  /**
   * �Z���J�������擾���܂��B
   * @return �Z���J����
   */
  public ACTableColumn getCsvDataTableColumn12(){
    if(csvDataTableColumn12==null){

      csvDataTableColumn12 = new ACTableColumn();

      csvDataTableColumn12.setHeaderValue("<html>21<br>�Z<br>��<br><br>�@</html>");

      csvDataTableColumn12.setColumnName("21");

      csvDataTableColumn12.setEditable(false);

      csvDataTableColumn12.setColumns(3);

      csvDataTableColumn12.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn12();
    }
    return csvDataTableColumn12;

  }

  /**
   * �Z�V�J�������擾���܂��B
   * @return �Z�V�J����
   */
  public ACTableColumn getCsvDataTableColumn13(){
    if(csvDataTableColumn13==null){

      csvDataTableColumn13 = new ACTableColumn();

      csvDataTableColumn13.setHeaderValue("<html>22<br>�Z<br>�V<br><br>�@</html>");

      csvDataTableColumn13.setColumnName("22");

      csvDataTableColumn13.setEditable(false);

      csvDataTableColumn13.setColumns(3);

      csvDataTableColumn13.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn13();
    }
    return csvDataTableColumn13;

  }

  /**
   * �Z��J�������擾���܂��B
   * @return �Z��J����
   */
  public ACTableColumn getCsvDataTableColumn14(){
    if(csvDataTableColumn14==null){

      csvDataTableColumn14 = new ACTableColumn();

      csvDataTableColumn14.setHeaderValue("<html>23<br>�Z<br>��<br><br>�@</html>");

      csvDataTableColumn14.setColumnName("23");

      csvDataTableColumn14.setEditable(false);

      csvDataTableColumn14.setColumns(3);

      csvDataTableColumn14.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn14();
    }
    return csvDataTableColumn14;

  }

  /**
   * �Z���J�������擾���܂��B
   * @return �Z���J����
   */
  public ACTableColumn getCsvDataTableColumn69(){
    if(csvDataTableColumn69==null){

      csvDataTableColumn69 = new ACTableColumn();

      csvDataTableColumn69.setHeaderValue("<html>2A<br>�Z<br>��<br>��<br>�@</html>");

      csvDataTableColumn69.setColumnName("2A");

      csvDataTableColumn69.setEditable(false);

      csvDataTableColumn69.setColumns(3);

      csvDataTableColumn69.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn69();
    }
    return csvDataTableColumn69;

  }

  /**
   * ����J�������擾���܂��B
   * @return ����J����
   */
  public ACTableColumn getCsvDataTableColumn15(){
    if(csvDataTableColumn15==null){

      csvDataTableColumn15 = new ACTableColumn();

      csvDataTableColumn15.setHeaderValue("<html>31<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn15.setColumnName("31");

      csvDataTableColumn15.setEditable(false);

      csvDataTableColumn15.setColumns(3);

      csvDataTableColumn15.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn15();
    }
    return csvDataTableColumn15;

  }

  /**
   * �F�m�J�������擾���܂��B
   * @return �F�m�J����
   */
  public ACTableColumn getCsvDataTableColumn16(){
    if(csvDataTableColumn16==null){

      csvDataTableColumn16 = new ACTableColumn();

      csvDataTableColumn16.setHeaderValue("<html>32<br>�F<br>�m<br><br>�@</html>");

      csvDataTableColumn16.setColumnName("32");

      csvDataTableColumn16.setEditable(false);

      csvDataTableColumn16.setColumns(3);

      csvDataTableColumn16.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn16();
    }
    return csvDataTableColumn16;

  }

  /**
   * ����J�������擾���܂��B
   * @return ����J����
   */
  public ACTableColumn getCsvDataTableColumn17(){
    if(csvDataTableColumn17==null){

      csvDataTableColumn17 = new ACTableColumn();

      csvDataTableColumn17.setHeaderValue("<html>33<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn17.setColumnName("33");

      csvDataTableColumn17.setEditable(false);

      csvDataTableColumn17.setColumns(3);

      csvDataTableColumn17.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn17();
    }
    return csvDataTableColumn17;

  }

  /**
   * ����Z�J�������擾���܂��B
   * @return ����Z�J����
   */
  public ACTableColumn getCsvDataTableColumn46(){
    if(csvDataTableColumn46==null){

      csvDataTableColumn46 = new ACTableColumn();

      csvDataTableColumn46.setHeaderValue("<html>27<br>��<br>��<br>�Z<br>�@</html>");

      csvDataTableColumn46.setColumnName("27");

      csvDataTableColumn46.setEditable(false);

      csvDataTableColumn46.setColumns(3);

      csvDataTableColumn46.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn46();
    }
    return csvDataTableColumn46;

  }

  /**
   * �n���J�������擾���܂��B
   * @return �n���J����
   */
  public ACTableColumn getCsvDataTableColumn18(){
    if(csvDataTableColumn18==null){

      csvDataTableColumn18 = new ACTableColumn();

      csvDataTableColumn18.setHeaderValue("<html>36<br>�n<br>��<br><br>�@</html>");

      csvDataTableColumn18.setColumnName("36");

      csvDataTableColumn18.setEditable(false);

      csvDataTableColumn18.setColumns(3);

      csvDataTableColumn18.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn18();
    }
    return csvDataTableColumn18;

  }

  /**
   * �n���Z�J�������擾���܂��B
   * @return �n���Z�J����
   */
  public ACTableColumn getCsvDataTableColumn47(){
    if(csvDataTableColumn47==null){

      csvDataTableColumn47 = new ACTableColumn();

      csvDataTableColumn47.setHeaderValue("<html>28<br>�n<br>��<br>�Z<br>�@</html>");

      csvDataTableColumn47.setColumnName("28");

      csvDataTableColumn47.setEditable(false);

      csvDataTableColumn47.setColumns(3);

      csvDataTableColumn47.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn47();
    }
    return csvDataTableColumn47;

  }

  /**
   * �F�Z�J�������擾���܂��B
   * @return �F�Z�J����
   */
  public ACTableColumn getCsvDataTableColumn19(){
    if(csvDataTableColumn19==null){

      csvDataTableColumn19 = new ACTableColumn();

      csvDataTableColumn19.setHeaderValue("<html>38<br>�F<br>�Z<br><br>�@</html>");

      csvDataTableColumn19.setColumnName("38");

      csvDataTableColumn19.setEditable(false);

      csvDataTableColumn19.setColumns(3);

      csvDataTableColumn19.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn19();
    }
    return csvDataTableColumn19;

  }

  /**
   * ���{�J�������擾���܂��B
   * @return ���{�J����
   */
  public ACTableColumn getCsvDataTableColumn20(){
    if(csvDataTableColumn20==null){

      csvDataTableColumn20 = new ACTableColumn();

      csvDataTableColumn20.setHeaderValue("<html>51<br>��<br>�{<br><br>�@</html>");

      csvDataTableColumn20.setColumnName("51");

      csvDataTableColumn20.setEditable(false);

      csvDataTableColumn20.setColumns(3);

      csvDataTableColumn20.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn20();
    }
    return csvDataTableColumn20;

  }

  /**
   * �V���J�������擾���܂��B
   * @return �V���J����
   */
  public ACTableColumn getCsvDataTableColumn21(){
    if(csvDataTableColumn21==null){

      csvDataTableColumn21 = new ACTableColumn();

      csvDataTableColumn21.setHeaderValue("<html>52<br>�V<br>��<br><br>�@</html>");

      csvDataTableColumn21.setColumnName("52");

      csvDataTableColumn21.setEditable(false);

      csvDataTableColumn21.setColumns(3);

      csvDataTableColumn21.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn21();
    }
    return csvDataTableColumn21;

  }

  /**
   * �×{�J�������擾���܂��B
   * @return �×{�J����
   */
  public ACTableColumn getCsvDataTableColumn22(){
    if(csvDataTableColumn22==null){

      csvDataTableColumn22 = new ACTableColumn();

      csvDataTableColumn22.setHeaderValue("<html>53<br>��<br>�{<br><br>�@</html>");

      csvDataTableColumn22.setColumnName("53");

      csvDataTableColumn22.setEditable(false);

      csvDataTableColumn22.setColumns(3);

      csvDataTableColumn22.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn22();
    }
    return csvDataTableColumn22;

  }

  /**
   * �n�{�J�������擾���܂��B
   * @return �n�{�J����
   */
  public ACTableColumn getCsvDataTableColumn23(){
    if(csvDataTableColumn23==null){

      csvDataTableColumn23 = new ACTableColumn();

      csvDataTableColumn23.setHeaderValue("<html>54<br>�n<br>�{<br><br>�@</html>");

      csvDataTableColumn23.setColumnName("54");

      csvDataTableColumn23.setEditable(false);

      csvDataTableColumn23.setColumns(3);

      csvDataTableColumn23.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn23();
    }
    return csvDataTableColumn23;

  }

  /**
   * ���J�������擾���܂��B
   * @return ���J����
   */
  public ACTableColumn getCsvDataTableColumn70(){
    if(csvDataTableColumn70==null){

      csvDataTableColumn70 = new ACTableColumn();

      csvDataTableColumn70.setHeaderValue("<html>55<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn70.setColumnName("55");

      csvDataTableColumn70.setEditable(false);

      csvDataTableColumn70.setColumns(3);

      csvDataTableColumn70.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn70();
    }
    return csvDataTableColumn70;

  }

  /**
   * ���J�������擾���܂��B
   * @return ���J����
   */
  public ACTableColumn getCsvDataTableColumn24(){
    if(csvDataTableColumn24==null){

      csvDataTableColumn24 = new ACTableColumn();

      csvDataTableColumn24.setHeaderValue("<html>71<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn24.setColumnName("71");

      csvDataTableColumn24.setEditable(false);

      csvDataTableColumn24.setColumns(3);

      csvDataTableColumn24.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn24();
    }
    return csvDataTableColumn24;

  }

  /**
   * �F�ʃJ�������擾���܂��B
   * @return �F�ʃJ����
   */
  public ACTableColumn getCsvDataTableColumn25(){
    if(csvDataTableColumn25==null){

      csvDataTableColumn25 = new ACTableColumn();

      csvDataTableColumn25.setHeaderValue("<html>72<br>�F<br>��<br><br>�@</html>");

      csvDataTableColumn25.setColumnName("72");

      csvDataTableColumn25.setEditable(false);

      csvDataTableColumn25.setColumns(3);

      csvDataTableColumn25.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn25();
    }
    return csvDataTableColumn25;

  }

  /**
   * ��K�ŃJ�������擾���܂��B
   * @return ��K�ŃJ����
   */
  public ACTableColumn getCsvDataTableColumn48(){
    if(csvDataTableColumn48==null){

      csvDataTableColumn48 = new ACTableColumn();

      csvDataTableColumn48.setHeaderValue("<html>76<br>��<br>��<br>�K<br>�@</html>");

      csvDataTableColumn48.setColumnName("76");

      csvDataTableColumn48.setEditable(false);

      csvDataTableColumn48.setColumns(3);

      csvDataTableColumn48.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn48();
    }
    return csvDataTableColumn48;

  }

  /**
   * �����J�������擾���܂��B
   * @return �����J����
   */
  public ACTableColumn getCsvDataTableColumn49(){
    if(csvDataTableColumn49==null){

      csvDataTableColumn49 = new ACTableColumn();

      csvDataTableColumn49.setHeaderValue("<html>77<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn49.setColumnName("77");

      csvDataTableColumn49.setEditable(false);

      csvDataTableColumn49.setColumns(3);

      csvDataTableColumn49.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn49();
    }
    return csvDataTableColumn49;

  }

  /**
   * �����Z�J�������擾���܂��B
   * @return �����Z�J����
   */
  public ACTableColumn getCsvDataTableColumn50(){
    if(csvDataTableColumn50==null){

      csvDataTableColumn50 = new ACTableColumn();

      csvDataTableColumn50.setHeaderValue("<html>79<br>��<br>��<br>�Z<br>�@</html>");

      csvDataTableColumn50.setColumnName("79");

      csvDataTableColumn50.setEditable(false);

      csvDataTableColumn50.setColumns(3);

      csvDataTableColumn50.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn50();
    }
    return csvDataTableColumn50;

  }

  /**
   * ���K�͑��@�\�J�������擾���܂��B
   * @return ���K�͑��@�\�J����
   */
  public ACTableColumn getCsvDataTableColumn26(){
    if(csvDataTableColumn26==null){

      csvDataTableColumn26 = new ACTableColumn();

      csvDataTableColumn26.setHeaderValue("<html>73<br>��<br>��<br><br>�@</html>");

      csvDataTableColumn26.setColumnName("73");

      csvDataTableColumn26.setEditable(false);

      csvDataTableColumn26.setColumns(3);

      csvDataTableColumn26.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn26();
    }
    return csvDataTableColumn26;

  }

  /**
   * ���K�͑��@�\�Z�J�������擾���܂��B
   * @return ���K�͑��@�\�Z�J����
   */
  public ACTableColumn getCsvDataTableColumn51(){
    if(csvDataTableColumn51==null){

      csvDataTableColumn51 = new ACTableColumn();

      csvDataTableColumn51.setHeaderValue("<html>68<br>��<br>�Z<br><br>�@</html>");

      csvDataTableColumn51.setColumnName("68");

      csvDataTableColumn51.setEditable(false);

      csvDataTableColumn51.setColumns(3);

      csvDataTableColumn51.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn51();
    }
    return csvDataTableColumn51;

  }

  /**
   * �n�ʉ�J�������擾���܂��B
   * @return �n�ʉ�J����
   */
  public ACTableColumn getCsvDataTableColumn53(){
    if(csvDataTableColumn53==null){

      csvDataTableColumn53 = new ACTableColumn();

      csvDataTableColumn53.setHeaderValue("<html>78<br>�n<br>��<br>��<br>�@</html>");

      csvDataTableColumn53.setColumnName("78");

      csvDataTableColumn53.setEditable(false);

      csvDataTableColumn53.setColumns(3);

      csvDataTableColumn53.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn53();
    }
    return csvDataTableColumn53;

  }

  /**
   * �v�����J�������擾���܂��B
   * @return �v�����J����
   */
  public ACTableColumn getCsvDataTableColumn27(){
    if(csvDataTableColumn27==null){

      csvDataTableColumn27 = new ACTableColumn();

      csvDataTableColumn27.setHeaderValue("<html>43<br>�v<br>��<br>��<br>�@</html>");

      csvDataTableColumn27.setColumnName("43");

      csvDataTableColumn27.setEditable(false);

      csvDataTableColumn27.setColumns(3);

      csvDataTableColumn27.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn27();
    }
    return csvDataTableColumn27;

  }

  /**
   * �\�h��J�������擾���܂��B
   * @return �\�h��J����
   */
  public ACTableColumn getCsvDataTableColumn28(){
    if(csvDataTableColumn28==null){

      csvDataTableColumn28 = new ACTableColumn();

      csvDataTableColumn28.setHeaderValue("<html>61<br>�\<br>�h<br>��<br>�@</html>");

      csvDataTableColumn28.setColumnName("61");

      csvDataTableColumn28.setEditable(false);

      csvDataTableColumn28.setColumns(3);

      csvDataTableColumn28.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn28();
    }
    return csvDataTableColumn28;

  }

  /**
   * �\�����J�������擾���܂��B
   * @return �\�����J����
   */
  public ACTableColumn getCsvDataTableColumn29(){
    if(csvDataTableColumn29==null){

      csvDataTableColumn29 = new ACTableColumn();

      csvDataTableColumn29.setHeaderValue("<html>62<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn29.setColumnName("62");

      csvDataTableColumn29.setEditable(false);

      csvDataTableColumn29.setColumns(3);

      csvDataTableColumn29.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn29();
    }
    return csvDataTableColumn29;

  }

  /**
   * �\�ŉ�J�������擾���܂��B
   * @return �\�ŉ�J����
   */
  public ACTableColumn getCsvDataTableColumn30(){
    if(csvDataTableColumn30==null){

      csvDataTableColumn30 = new ACTableColumn();

      csvDataTableColumn30.setHeaderValue("<html>63<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn30.setColumnName("63");

      csvDataTableColumn30.setEditable(false);

      csvDataTableColumn30.setColumns(3);

      csvDataTableColumn30.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn30();
    }
    return csvDataTableColumn30;

  }

  /**
   * �\�K���J�������擾���܂��B
   * @return �\�K���J����
   */
  public ACTableColumn getCsvDataTableColumn31(){
    if(csvDataTableColumn31==null){

      csvDataTableColumn31 = new ACTableColumn();

      csvDataTableColumn31.setHeaderValue("<html>64<br>�\<br>�K<br>��<br>�@</html>");

      csvDataTableColumn31.setColumnName("64");

      csvDataTableColumn31.setEditable(false);

      csvDataTableColumn31.setColumns(3);

      csvDataTableColumn31.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn31();
    }
    return csvDataTableColumn31;

  }

  /**
   * �\�ʉ�J�������擾���܂��B
   * @return �\�ʉ�J����
   */
  public ACTableColumn getCsvDataTableColumn32(){
    if(csvDataTableColumn32==null){

      csvDataTableColumn32 = new ACTableColumn();

      csvDataTableColumn32.setHeaderValue("<html>65<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn32.setColumnName("65");

      csvDataTableColumn32.setEditable(false);

      csvDataTableColumn32.setColumns(3);

      csvDataTableColumn32.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn32();
    }
    return csvDataTableColumn32;

  }

  /**
   * �\�ʃ��J�������擾���܂��B
   * @return �\�ʃ��J����
   */
  public ACTableColumn getCsvDataTableColumn33(){
    if(csvDataTableColumn33==null){

      csvDataTableColumn33 = new ACTableColumn();

      csvDataTableColumn33.setHeaderValue("<html>66<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn33.setColumnName("66");

      csvDataTableColumn33.setEditable(false);

      csvDataTableColumn33.setColumns(3);

      csvDataTableColumn33.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn33();
    }
    return csvDataTableColumn33;

  }

  /**
   * �\�p��J�������擾���܂��B
   * @return �\�p��J����
   */
  public ACTableColumn getCsvDataTableColumn34(){
    if(csvDataTableColumn34==null){

      csvDataTableColumn34 = new ACTableColumn();

      csvDataTableColumn34.setHeaderValue("<html>67<br>�\<br>�p<br>��<br>�@</html>");

      csvDataTableColumn34.setColumnName("67");

      csvDataTableColumn34.setEditable(false);

      csvDataTableColumn34.setColumns(3);

      csvDataTableColumn34.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn34();
    }
    return csvDataTableColumn34;

  }

  /**
   * �\�Z���J�������擾���܂��B
   * @return �\�Z���J����
   */
  public ACTableColumn getCsvDataTableColumn35(){
    if(csvDataTableColumn35==null){

      csvDataTableColumn35 = new ACTableColumn();

      csvDataTableColumn35.setHeaderValue("<html>24<br>�\<br>�Z<br>��<br>�@</html>");

      csvDataTableColumn35.setColumnName("24");

      csvDataTableColumn35.setEditable(false);

      csvDataTableColumn35.setColumns(3);

      csvDataTableColumn35.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn35();
    }
    return csvDataTableColumn35;

  }

  /**
   * �\�V���J�������擾���܂��B
   * @return �\�V���J����
   */
  public ACTableColumn getCsvDataTableColumn36(){
    if(csvDataTableColumn36==null){

      csvDataTableColumn36 = new ACTableColumn();

      csvDataTableColumn36.setHeaderValue("<html>25<br>�\<br>�V<br>��<br>�@</html>");

      csvDataTableColumn36.setColumnName("25");

      csvDataTableColumn36.setEditable(false);

      csvDataTableColumn36.setColumns(3);

      csvDataTableColumn36.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn36();
    }
    return csvDataTableColumn36;

  }

  /**
   * �\�×{�J�������擾���܂��B
   * @return �\�×{�J����
   */
  public ACTableColumn getCsvDataTableColumn37(){
    if(csvDataTableColumn37==null){

      csvDataTableColumn37 = new ACTableColumn();

      csvDataTableColumn37.setHeaderValue("<html>26<br>�\<br>��<br>�{<br>�@</html>");

      csvDataTableColumn37.setColumnName("26");

      csvDataTableColumn37.setEditable(false);

      csvDataTableColumn37.setColumns(3);

      csvDataTableColumn37.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn37();
    }
    return csvDataTableColumn37;

  }

  /**
   * �\���J�������擾���܂��B
   * @return �\���J����
   */
  public ACTableColumn getCsvDataTableColumn71(){
    if(csvDataTableColumn71==null){

      csvDataTableColumn71 = new ACTableColumn();

      csvDataTableColumn71.setHeaderValue("<html>2B<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn71.setColumnName("2B");

      csvDataTableColumn71.setEditable(false);

      csvDataTableColumn71.setColumns(3);

      csvDataTableColumn71.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn71();
    }
    return csvDataTableColumn71;

  }

  /**
   * �\����J�������擾���܂��B
   * @return �\����J����
   */
  public ACTableColumn getCsvDataTableColumn38(){
    if(csvDataTableColumn38==null){

      csvDataTableColumn38 = new ACTableColumn();

      csvDataTableColumn38.setHeaderValue("<html>34<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn38.setColumnName("34");

      csvDataTableColumn38.setEditable(false);

      csvDataTableColumn38.setColumns(3);

      csvDataTableColumn38.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn38();
    }
    return csvDataTableColumn38;

  }

  /**
   * �\����J�������擾���܂��B
   * @return �\����J����
   */
  public ACTableColumn getCsvDataTableColumn39(){
    if(csvDataTableColumn39==null){

      csvDataTableColumn39 = new ACTableColumn();

      csvDataTableColumn39.setHeaderValue("<html>35<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn39.setColumnName("35");

      csvDataTableColumn39.setEditable(false);

      csvDataTableColumn39.setColumns(3);

      csvDataTableColumn39.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn39();
    }
    return csvDataTableColumn39;

  }

  /**
   * �\�v�����J�������擾���܂��B
   * @return �\�v�����J����
   */
  public ACTableColumn getCsvDataTableColumn40(){
    if(csvDataTableColumn40==null){

      csvDataTableColumn40 = new ACTableColumn();

      csvDataTableColumn40.setHeaderValue("<html>46<br>�\<br>�v<br>��<br>��</html>");

      csvDataTableColumn40.setColumnName("46");

      csvDataTableColumn40.setEditable(false);

      csvDataTableColumn40.setColumns(3);

      csvDataTableColumn40.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn40();
    }
    return csvDataTableColumn40;

  }

  /**
   * �\�F�ʃJ�������擾���܂��B
   * @return �\�F�ʃJ����
   */
  public ACTableColumn getCsvDataTableColumn41(){
    if(csvDataTableColumn41==null){

      csvDataTableColumn41 = new ACTableColumn();

      csvDataTableColumn41.setHeaderValue("<html>74<br>�\<br>�F<br>��<br>�@</html>");

      csvDataTableColumn41.setColumnName("74");

      csvDataTableColumn41.setEditable(false);

      csvDataTableColumn41.setColumns(3);

      csvDataTableColumn41.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn41();
    }
    return csvDataTableColumn41;

  }

  /**
   * �\���K�̓J�������擾���܂��B
   * @return �\���K�̓J����
   */
  public ACTableColumn getCsvDataTableColumn42(){
    if(csvDataTableColumn42==null){

      csvDataTableColumn42 = new ACTableColumn();

      csvDataTableColumn42.setHeaderValue("<html>75<br>�\<br>��<br>��<br>�@</html>");

      csvDataTableColumn42.setColumnName("75");

      csvDataTableColumn42.setEditable(false);

      csvDataTableColumn42.setColumns(3);

      csvDataTableColumn42.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn42();
    }
    return csvDataTableColumn42;

  }

  /**
   * �\���K�͒Z�J�������擾���܂��B
   * @return �\���K�͒Z�J����
   */
  public ACTableColumn getCsvDataTableColumn52(){
    if(csvDataTableColumn52==null){

      csvDataTableColumn52 = new ACTableColumn();

      csvDataTableColumn52.setHeaderValue("<html>69<br>�\<br>��<br>�Z<br>�@</html>");

      csvDataTableColumn52.setColumnName("69");

      csvDataTableColumn52.setEditable(false);

      csvDataTableColumn52.setColumns(3);

      csvDataTableColumn52.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn52();
    }
    return csvDataTableColumn52;

  }

  /**
   * �\�F�m�J�������擾���܂��B
   * @return �\�F�m�J����
   */
  public ACTableColumn getCsvDataTableColumn43(){
    if(csvDataTableColumn43==null){

      csvDataTableColumn43 = new ACTableColumn();

      csvDataTableColumn43.setHeaderValue("<html>37<br>�\<br>�F<br>�m<br>�@</html>");

      csvDataTableColumn43.setColumnName("37");

      csvDataTableColumn43.setEditable(false);

      csvDataTableColumn43.setColumns(3);

      csvDataTableColumn43.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn43();
    }
    return csvDataTableColumn43;

  }

  /**
   * �\�F�Z�J�������擾���܂��B
   * @return �\�F�Z�J����
   */
  public ACTableColumn getCsvDataTableColumn44(){
    if(csvDataTableColumn44==null){

      csvDataTableColumn44 = new ACTableColumn();

      csvDataTableColumn44.setHeaderValue("<html>39<br>�\<br>�F<br>�Z<br>�@</html>");

      csvDataTableColumn44.setColumnName("39");

      csvDataTableColumn44.setEditable(false);

      csvDataTableColumn44.setColumns(3);

      csvDataTableColumn44.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn44();
    }
    return csvDataTableColumn44;

  }

  /**
   * ���K�݃J�������擾���܂��B
   * @return ���K�݃J����
   */
  public ACTableColumn getCsvDataTableColumn54(){
    if(csvDataTableColumn54==null){

      csvDataTableColumn54 = new ACTableColumn();

      csvDataTableColumn54.setHeaderValue("<html>A1<br>��<br>�K<br>��<br>�@</html>");

      csvDataTableColumn54.setColumnName("A1");

      csvDataTableColumn54.setEditable(false);

      csvDataTableColumn54.setColumns(3);

      csvDataTableColumn54.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn54();
    }
    return csvDataTableColumn54;

  }

  /**
   * ���K�ƃJ�������擾���܂��B
   * @return ���K�ƃJ����
   */
  public ACTableColumn getCsvDataTableColumn55(){
    if(csvDataTableColumn55==null){

      csvDataTableColumn55 = new ACTableColumn();

      csvDataTableColumn55.setHeaderValue("<html>A2<br>��<br>�K<br>��<br>�@</html>");

      csvDataTableColumn55.setColumnName("A2");

      csvDataTableColumn55.setEditable(false);

      csvDataTableColumn55.setColumns(3);

      csvDataTableColumn55.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn55();
    }
    return csvDataTableColumn55;

  }

  /**
   * ���K���J�������擾���܂��B
   * @return ���K���J����
   */
  public ACTableColumn getCsvDataTableColumn56(){
    if(csvDataTableColumn56==null){

      csvDataTableColumn56 = new ACTableColumn();

      csvDataTableColumn56.setHeaderValue("<html>A3<br>��<br>�K<br>��<br>�@</html>");

      csvDataTableColumn56.setColumnName("A3");

      csvDataTableColumn56.setEditable(false);

      csvDataTableColumn56.setColumns(3);

      csvDataTableColumn56.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn56();
    }
    return csvDataTableColumn56;

  }

  /**
   * ���K�z�J�������擾���܂��B
   * @return ���K�z�J����
   */
  public ACTableColumn getCsvDataTableColumn57(){
    if(csvDataTableColumn57==null){

      csvDataTableColumn57 = new ACTableColumn();

      csvDataTableColumn57.setHeaderValue("<html>A4<br>��<br>�K<br>�z<br>�@</html>");

      csvDataTableColumn57.setColumnName("A4");

      csvDataTableColumn57.setEditable(false);

      csvDataTableColumn57.setColumns(3);

      csvDataTableColumn57.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn57();
    }
    return csvDataTableColumn57;

  }

  /**
   * ���ʂ݃J�������擾���܂��B
   * @return ���ʂ݃J����
   */
  public ACTableColumn getCsvDataTableColumn58(){
    if(csvDataTableColumn58==null){

      csvDataTableColumn58 = new ACTableColumn();

      csvDataTableColumn58.setHeaderValue("<html>A5<br>��<br>��<br>��<br>�@</html>");

      csvDataTableColumn58.setColumnName("A5");

      csvDataTableColumn58.setEditable(false);

      csvDataTableColumn58.setColumns(3);

      csvDataTableColumn58.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn58();
    }
    return csvDataTableColumn58;

  }

  /**
   * ���ʓƃJ�������擾���܂��B
   * @return ���ʓƃJ����
   */
  public ACTableColumn getCsvDataTableColumn59(){
    if(csvDataTableColumn59==null){

      csvDataTableColumn59 = new ACTableColumn();

      csvDataTableColumn59.setHeaderValue("<html>A6<br>��<br>��<br>��<br>�@</html>");

      csvDataTableColumn59.setColumnName("A6");

      csvDataTableColumn59.setEditable(false);

      csvDataTableColumn59.setColumns(3);

      csvDataTableColumn59.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn59();
    }
    return csvDataTableColumn59;

  }

  /**
   * ���ʗ��J�������擾���܂��B
   * @return ���ʗ��J����
   */
  public ACTableColumn getCsvDataTableColumn60(){
    if(csvDataTableColumn60==null){

      csvDataTableColumn60 = new ACTableColumn();

      csvDataTableColumn60.setHeaderValue("<html>A7<br>��<br>��<br>��<br>�@</html>");

      csvDataTableColumn60.setColumnName("A7");

      csvDataTableColumn60.setEditable(false);

      csvDataTableColumn60.setColumns(3);

      csvDataTableColumn60.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn60();
    }
    return csvDataTableColumn60;

  }

  /**
   * ���ʊz�J�������擾���܂��B
   * @return ���ʊz�J����
   */
  public ACTableColumn getCsvDataTableColumn61(){
    if(csvDataTableColumn61==null){

      csvDataTableColumn61 = new ACTableColumn();

      csvDataTableColumn61.setHeaderValue("<html>A8<br>��<br>��<br>�z<br>�@</html>");

      csvDataTableColumn61.setColumnName("A8");

      csvDataTableColumn61.setEditable(false);

      csvDataTableColumn61.setColumns(3);

      csvDataTableColumn61.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn61();
    }
    return csvDataTableColumn61;

  }

  /**
   * ���H���J�������擾���܂��B
   * @return ���H���J����
   */
  public ACTableColumn getCsvDataTableColumn62(){
    if(csvDataTableColumn62==null){

      csvDataTableColumn62 = new ACTableColumn();

      csvDataTableColumn62.setHeaderValue("<html>A9<br>��<br>�H<br>��<br>�@</html>");

      csvDataTableColumn62.setColumnName("A9");

      csvDataTableColumn62.setEditable(false);

      csvDataTableColumn62.setColumns(3);

      csvDataTableColumn62.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn62();
    }
    return csvDataTableColumn62;

  }

  /**
   * ���H�z�J�������擾���܂��B
   * @return ���H�z�J����
   */
  public ACTableColumn getCsvDataTableColumn63(){
    if(csvDataTableColumn63==null){

      csvDataTableColumn63 = new ACTableColumn();

      csvDataTableColumn63.setHeaderValue("<html>AA<br>��<br>�H<br>�z<br>�@</html>");

      csvDataTableColumn63.setColumnName("AA");

      csvDataTableColumn63.setEditable(false);

      csvDataTableColumn63.setColumns(3);

      csvDataTableColumn63.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn63();
    }
    return csvDataTableColumn63;

  }

  /**
   * ���痦�J�������擾���܂��B
   * @return ���痦�J����
   */
  public ACTableColumn getCsvDataTableColumn64(){
    if(csvDataTableColumn64==null){

      csvDataTableColumn64 = new ACTableColumn();

      csvDataTableColumn64.setHeaderValue("<html>AB<br>��<br>��<br>��<br>�@</html>");

      csvDataTableColumn64.setColumnName("AB");

      csvDataTableColumn64.setEditable(false);

      csvDataTableColumn64.setColumns(3);

      csvDataTableColumn64.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn64();
    }
    return csvDataTableColumn64;

  }

  /**
   * ����z�J�������擾���܂��B
   * @return ����z�J����
   */
  public ACTableColumn getCsvDataTableColumn65(){
    if(csvDataTableColumn65==null){

      csvDataTableColumn65 = new ACTableColumn();

      csvDataTableColumn65.setHeaderValue("<html>AC<br>��<br>��<br>�z<br>�@</html>");

      csvDataTableColumn65.setColumnName("AC");

      csvDataTableColumn65.setEditable(false);

      csvDataTableColumn65.setColumns(3);

      csvDataTableColumn65.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn65();
    }
    return csvDataTableColumn65;

  }

  /**
   * �������J�������擾���܂��B
   * @return �������J����
   */
  public ACTableColumn getCsvDataTableColumn66(){
    if(csvDataTableColumn66==null){

      csvDataTableColumn66 = new ACTableColumn();

      csvDataTableColumn66.setHeaderValue("<html>AD<br>��<br>��<br>��<br>�@</html>");

      csvDataTableColumn66.setColumnName("AD");

      csvDataTableColumn66.setEditable(false);

      csvDataTableColumn66.setColumns(3);

      csvDataTableColumn66.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn66();
    }
    return csvDataTableColumn66;

  }

  /**
   * �����z�J�������擾���܂��B
   * @return �����z�J����
   */
  public ACTableColumn getCsvDataTableColumn67(){
    if(csvDataTableColumn67==null){

      csvDataTableColumn67 = new ACTableColumn();

      csvDataTableColumn67.setHeaderValue("<html>AE<br>��<br>��<br>�z<br>�@</html>");

      csvDataTableColumn67.setColumnName("AE");

      csvDataTableColumn67.setEditable(false);

      csvDataTableColumn67.setColumns(3);

      csvDataTableColumn67.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn67();
    }
    return csvDataTableColumn67;

  }

  /**
   * ���\�P�A�J�������擾���܂��B
   * @return ���\�P�A�J����
   */
  public ACTableColumn getCsvDataTableColumn68(){
    if(csvDataTableColumn68==null){

      csvDataTableColumn68 = new ACTableColumn();

      csvDataTableColumn68.setHeaderValue("<html>AF<br>��<br>�\<br>�P<br>�A</html>");

      csvDataTableColumn68.setColumnName("AF");

      csvDataTableColumn68.setEditable(false);

      csvDataTableColumn68.setColumns(3);

      csvDataTableColumn68.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn68();
    }
    return csvDataTableColumn68;

  }

  /**
   * �P�ʐ��J�������擾���܂��B
   * @return �P�ʐ��J����
   */
  public ACTableColumn getCsvDataTableColumn45(){
    if(csvDataTableColumn45==null){

      csvDataTableColumn45 = new ACTableColumn();

      csvDataTableColumn45.setHeaderValue("�P�ʐ�");

      csvDataTableColumn45.setColumnName("UNIT_TOTAL");

      csvDataTableColumn45.setEditable(false);

      csvDataTableColumn45.setColumns(6);

      csvDataTableColumn45.setHorizontalAlignment(SwingConstants.RIGHT);

      csvDataTableColumn45.setRendererType(VRTableCellViewer.RENDERER_TYPE_LABEL);

      addCsvDataTableColumn45();
    }
    return csvDataTableColumn45;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO012Design() {

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
   * �Ɩ��{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getUnitingButton(), VRLayout.EAST);
    buttons.add(getOpenButton(), VRLayout.EAST);
  }

  /**
   * �J���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOpenButton(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitingButton(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getFileInfoPanel(), VRLayout.NORTH);

    contents.add(getTotalInfoTable(), VRLayout.NORTH);

    contents.add(getCsvDataTable(), VRLayout.CLIENT);

  }

  /**
   * ���ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileInfoPanel(){

    fileInfoPanel.add(getFileInfoGroup(), VRLayout.NORTH);

  }

  /**
   * �t�@�C�����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileInfoGroup(){

    fileInfoGroup.add(getFileTypeLabel(), null);

    fileInfoGroup.add(getFileType(), null);

    fileInfoGroup.add(getMediaTypeLabel(), null);

    fileInfoGroup.add(getMediaType(), VRLayout.FLOW_INSETLINE_RETURN);

    fileInfoGroup.add(getTargetYearAndMonthLabel(), null);

    fileInfoGroup.add(getTargetYearAndMonth(), null);

    fileInfoGroup.add(getProviderLabel(), null);

    fileInfoGroup.add(getProviderId(), null);

    fileInfoGroup.add(getProviderName(), null);

  }

  /**
   * ��ރ��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFileTypeLabel(){

  }

  /**
   * ��ނɓ������ڂ�ǉ����܂��B
   */
  protected void addFileType(){

  }

  /**
   * �}�̃��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediaTypeLabel(){

  }

  /**
   * �}�̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediaType(){

  }

  /**
   * �����Ώ۔N�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetYearAndMonthLabel(){

  }

  /**
   * �����Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetYearAndMonth(){

  }

  /**
   * ���Ə����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderLabel(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderId(){

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderName(){

  }

  /**
   * �W�v���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTable(){

  }

  /**
   * �W�v���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumnModel(){

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn1());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn2());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn3());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn4());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn5());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTableColumn6());

  }

  /**
   * ���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumn1(){

  }

  /**
   * �l���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumn2(){

  }

  /**
   * �T�[�r�X�����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumn3(){

  }

  /**
   * �P�A�v���������J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumn4(){

  }

  /**
   * �P�ʐ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumn5(){

  }

  /**
   * �ی������z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumn6(){

  }

  /**
   * CSV�f�[�^�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTable(){

  }

  /**
   * CSV�f�[�^�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumnModel(){

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn1());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn2());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn3());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn4());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn5());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn6());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn7());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn8());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn9());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn10());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn11());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn12());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn13());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn14());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn69());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn15());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn16());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn17());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn46());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn18());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn47());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn19());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn20());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn21());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn22());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn23());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn70());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn24());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn25());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn48());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn49());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn50());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn26());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn51());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn53());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn27());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn28());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn29());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn30());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn31());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn32());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn33());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn34());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn35());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn36());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn37());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn71());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn38());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn39());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn40());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn41());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn42());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn52());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn43());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn44());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn54());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn55());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn56());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn57());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn58());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn59());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn60());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn61());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn62());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn63());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn64());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn65());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn66());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn67());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn68());

    getCsvDataTableColumnModel().addColumn(getCsvDataTableColumn45());

  }

  /**
   * �N���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn1(){

  }

  /**
   * ��ی��Ҕԍ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn2(){

  }

  /**
   * �����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn3(){

  }

  /**
   * �v���x�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn4(){

  }

  /**
   * �K��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn5(){

  }

  /**
   * �����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn6(){

  }

  /**
   * �ŉ�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn7(){

  }

  /**
   * �K���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn8(){

  }

  /**
   * �ʉ�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn9(){

  }

  /**
   * �ʃ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn10(){

  }

  /**
   * �p��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn11(){

  }

  /**
   * �Z���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn12(){

  }

  /**
   * �Z�V�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn13(){

  }

  /**
   * �Z��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn14(){

  }

  /**
   * �Z���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn69(){

  }

  /**
   * ����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn15(){

  }

  /**
   * �F�m�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn16(){

  }

  /**
   * ����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn17(){

  }

  /**
   * ����Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn46(){

  }

  /**
   * �n���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn18(){

  }

  /**
   * �n���Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn47(){

  }

  /**
   * �F�Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn19(){

  }

  /**
   * ���{�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn20(){

  }

  /**
   * �V���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn21(){

  }

  /**
   * �×{�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn22(){

  }

  /**
   * �n�{�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn23(){

  }

  /**
   * ���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn70(){

  }

  /**
   * ���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn24(){

  }

  /**
   * �F�ʃJ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn25(){

  }

  /**
   * ��K�ŃJ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn48(){

  }

  /**
   * �����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn49(){

  }

  /**
   * �����Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn50(){

  }

  /**
   * ���K�͑��@�\�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn26(){

  }

  /**
   * ���K�͑��@�\�Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn51(){

  }

  /**
   * �n�ʉ�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn53(){

  }

  /**
   * �v�����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn27(){

  }

  /**
   * �\�h��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn28(){

  }

  /**
   * �\�����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn29(){

  }

  /**
   * �\�ŉ�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn30(){

  }

  /**
   * �\�K���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn31(){

  }

  /**
   * �\�ʉ�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn32(){

  }

  /**
   * �\�ʃ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn33(){

  }

  /**
   * �\�p��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn34(){

  }

  /**
   * �\�Z���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn35(){

  }

  /**
   * �\�V���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn36(){

  }

  /**
   * �\�×{�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn37(){

  }

  /**
   * �\���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn71(){

  }

  /**
   * �\����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn38(){

  }

  /**
   * �\����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn39(){

  }

  /**
   * �\�v�����J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn40(){

  }

  /**
   * �\�F�ʃJ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn41(){

  }

  /**
   * �\���K�̓J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn42(){

  }

  /**
   * �\���K�͒Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn52(){

  }

  /**
   * �\�F�m�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn43(){

  }

  /**
   * �\�F�Z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn44(){

  }

  /**
   * ���K�݃J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn54(){

  }

  /**
   * ���K�ƃJ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn55(){

  }

  /**
   * ���K���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn56(){

  }

  /**
   * ���K�z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn57(){

  }

  /**
   * ���ʂ݃J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn58(){

  }

  /**
   * ���ʓƃJ�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn59(){

  }

  /**
   * ���ʗ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn60(){

  }

  /**
   * ���ʊz�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn61(){

  }

  /**
   * ���H���J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn62(){

  }

  /**
   * ���H�z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn63(){

  }

  /**
   * ���痦�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn64(){

  }

  /**
   * ����z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn65(){

  }

  /**
   * �������J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn66(){

  }

  /**
   * �����z�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn67(){

  }

  /**
   * ���\�P�A�J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn68(){

  }

  /**
   * �P�ʐ��J�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCsvDataTableColumn45(){

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
      ACFrame.debugStart(new ACAffairInfo(QO012Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO012Design getThis() {
    return this;
  }
}
