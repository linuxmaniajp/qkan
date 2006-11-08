
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
 * �J����: ���{�@�K��
 * �쐬��: 2006/05/18  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�����p��ݗ^ (QS001144)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
 * �T�[�r�X�p�^�[�����\�h�����p��ݗ^��ʍ��ڃf�U�C��(QS001144) 
 */
public class QS001144Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel welfareToolPatterns;

  private ACPanel welfareToolDetails;

  private ACComboBox welfareTools;

  private ACLabelContainer welfareToolsContainer;

  private ACComboBoxModelAdapter welfareToolsModel;

  private ACTextField welfarePoint;

  private ACLabelContainer welfarePointContainer;

  private ACTextField welfareTokuchiPoint;

  private ACLabelContainer welfareTokuchiPointContainer;

  private ACTextField welfareTekiyo;

  private ACLabelContainer welfareTekiyoContainer;

  //getter

  /**
   * �����p��p�^�[���̈���擾���܂��B
   * @return �����p��p�^�[���̈�
   */
  public ACPanel getWelfareToolPatterns(){
    if(welfareToolPatterns==null){

      welfareToolPatterns = new ACPanel();

      addWelfareToolPatterns();
    }
    return welfareToolPatterns;

  }

  /**
   * �����p����e�p�l�����擾���܂��B
   * @return �����p����e�p�l��
   */
  public ACPanel getWelfareToolDetails(){
    if(welfareToolDetails==null){

      welfareToolDetails = new ACPanel();

      welfareToolDetails.setAutoWrap(false);

      welfareToolDetails.setHgrid(200);

      addWelfareToolDetails();
    }
    return welfareToolDetails;

  }

  /**
   * �p��R���{���擾���܂��B
   * @return �p��R���{
   */
  public ACComboBox getWelfareTools(){
    if(welfareTools==null){

      welfareTools = new ACComboBox();

      getWelfareToolsContainer().setText("�p��");

      welfareTools.setBindPath("1670101");

      welfareTools.setEditable(false);

      welfareTools.setModelBindPath("1670101");

      welfareTools.setRenderBindPath("CONTENT");

      welfareTools.setModel(getWelfareToolsModel());

      addWelfareTools();
    }
    return welfareTools;

  }

  /**
   * �p��R���{�R���e�i���擾���܂��B
   * @return �p��R���{�R���e�i
   */
  protected ACLabelContainer getWelfareToolsContainer(){
    if(welfareToolsContainer==null){
      welfareToolsContainer = new ACLabelContainer();
      welfareToolsContainer.setFollowChildEnabled(true);
      welfareToolsContainer.setVAlignment(VRLayout.CENTER);
      welfareToolsContainer.add(getWelfareTools(), null);
    }
    return welfareToolsContainer;
  }

  /**
   * �p��R���{���f�����擾���܂��B
   * @return �p��R���{���f��
   */
  protected ACComboBoxModelAdapter getWelfareToolsModel(){
    if(welfareToolsModel==null){
      welfareToolsModel = new ACComboBoxModelAdapter();
      addWelfareToolsModel();
    }
    return welfareToolsModel;
  }

  /**
   * �P�ʐ��e�L�X�g���擾���܂��B
   * @return �P�ʐ��e�L�X�g
   */
  public ACTextField getWelfarePoint(){
    if(welfarePoint==null){

      welfarePoint = new ACTextField();

      getWelfarePointContainer().setText("�P�ʐ�");

      welfarePoint.setBindPath("1670102");

      welfarePoint.setColumns(4);

      welfarePoint.setCharType(VRCharType.ONLY_DIGIT);

      welfarePoint.setHorizontalAlignment(SwingConstants.RIGHT);

      welfarePoint.setIMEMode(InputSubset.LATIN);

      welfarePoint.setMaxLength(6);

      addWelfarePoint();
    }
    return welfarePoint;

  }

  /**
   * �P�ʐ��e�L�X�g�R���e�i���擾���܂��B
   * @return �P�ʐ��e�L�X�g�R���e�i
   */
  protected ACLabelContainer getWelfarePointContainer(){
    if(welfarePointContainer==null){
      welfarePointContainer = new ACLabelContainer();
      welfarePointContainer.setFollowChildEnabled(true);
      welfarePointContainer.setVAlignment(VRLayout.CENTER);
      welfarePointContainer.add(getWelfarePoint(), null);
    }
    return welfarePointContainer;
  }

  /**
   * ���n���Z�e�L�X�g���擾���܂��B
   * @return ���n���Z�e�L�X�g
   */
  public ACTextField getWelfareTokuchiPoint(){
    if(welfareTokuchiPoint==null){

      welfareTokuchiPoint = new ACTextField();

      getWelfareTokuchiPointContainer().setText("���n���Z");

      welfareTokuchiPoint.setBindPath("1670103");

      welfareTokuchiPoint.setColumns(4);

      welfareTokuchiPoint.setCharType(VRCharType.ONLY_DIGIT);

      welfareTokuchiPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      welfareTokuchiPoint.setIMEMode(InputSubset.LATIN);

      welfareTokuchiPoint.setMaxLength(6);

      addWelfareTokuchiPoint();
    }
    return welfareTokuchiPoint;

  }

  /**
   * ���n���Z�e�L�X�g�R���e�i���擾���܂��B
   * @return ���n���Z�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getWelfareTokuchiPointContainer(){
    if(welfareTokuchiPointContainer==null){
      welfareTokuchiPointContainer = new ACLabelContainer();
      welfareTokuchiPointContainer.setFollowChildEnabled(true);
      welfareTokuchiPointContainer.setVAlignment(VRLayout.CENTER);
      welfareTokuchiPointContainer.add(getWelfareTokuchiPoint(), null);
    }
    return welfareTokuchiPointContainer;
  }

  /**
   * �E�v���擾���܂��B
   * @return �E�v
   */
  public ACTextField getWelfareTekiyo(){
    if(welfareTekiyo==null){

      welfareTekiyo = new ACTextField();

      getWelfareTekiyoContainer().setText("�E�v");

      welfareTekiyo.setBindPath("1170104");

      welfareTekiyo.setColumns(15);

      welfareTekiyo.setCharType(VRCharType.ONLY_HALF_CHAR);

      welfareTekiyo.setHorizontalAlignment(SwingConstants.LEFT);

      welfareTekiyo.setIMEMode(InputSubset.LATIN);

      welfareTekiyo.setMaxLength(20);

      addWelfareTekiyo();
    }
    return welfareTekiyo;

  }

  /**
   * �E�v�R���e�i���擾���܂��B
   * @return �E�v�R���e�i
   */
  protected ACLabelContainer getWelfareTekiyoContainer(){
    if(welfareTekiyoContainer==null){
      welfareTekiyoContainer = new ACLabelContainer();
      welfareTekiyoContainer.setFollowChildEnabled(true);
      welfareTekiyoContainer.setVAlignment(VRLayout.CENTER);
      welfareTekiyoContainer.add(getWelfareTekiyo(), null);
    }
    return welfareTekiyoContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001144Design() {

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

    this.add(getWelfareToolPatterns(), VRLayout.CLIENT);

  }

  /**
   * �����p��p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareToolPatterns(){

    welfareToolPatterns.add(getWelfareToolDetails(), VRLayout.NORTH);

  }

  /**
   * �����p����e�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareToolDetails(){

    welfareToolDetails.add(getWelfareToolsContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    welfareToolDetails.add(getWelfarePointContainer(), VRLayout.FLOW_INSETLINE);

    welfareToolDetails.add(getWelfareTokuchiPointContainer(), VRLayout.FLOW_RETURN);

    welfareToolDetails.add(getWelfareTekiyoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �p��R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareTools(){

  }

  /**
   * �p��R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareToolsModel(){

  }

  /**
   * �P�ʐ��e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfarePoint(){

  }

  /**
   * ���n���Z�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareTokuchiPoint(){

  }

  /**
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareTekiyo(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001144Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001144Design getThis() {
    return this;
  }
}
