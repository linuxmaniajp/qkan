
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K����� (QO004002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * �K�������ʍ��ڃf�U�C��(QO004002) 
 */
public class QO004002Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox homonnyuyokukaigoGroup;

  private ACLabelContainer homonnyuyokukaigoDiscountContena;

  private ACTextField homonnyuyokukaigoDiscountRate;

  private ACLabel percentSign;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getHomonnyuyokukaigoGroup(){
    if(homonnyuyokukaigoGroup==null){

      homonnyuyokukaigoGroup = new ACGroupBox();

      homonnyuyokukaigoGroup.setText("�K��������");

      homonnyuyokukaigoGroup.setFollowChildEnabled(true);

      addHomonnyuyokukaigoGroup();
    }
    return homonnyuyokukaigoGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getHomonnyuyokukaigoDiscountContena(){
    if(homonnyuyokukaigoDiscountContena==null){

      homonnyuyokukaigoDiscountContena = new ACLabelContainer();

      homonnyuyokukaigoDiscountContena.setText("������");

      homonnyuyokukaigoDiscountContena.setFollowChildEnabled(true);

      addHomonnyuyokukaigoDiscountContena();
    }
    return homonnyuyokukaigoDiscountContena;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getHomonnyuyokukaigoDiscountRate(){
    if(homonnyuyokukaigoDiscountRate==null){

      homonnyuyokukaigoDiscountRate = new ACTextField();

      homonnyuyokukaigoDiscountRate.setBindPath("REDUCT_RATE");

      homonnyuyokukaigoDiscountRate.setColumns(3);

      homonnyuyokukaigoDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      homonnyuyokukaigoDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      homonnyuyokukaigoDiscountRate.setIMEMode(InputSubset.LATIN);

      homonnyuyokukaigoDiscountRate.setMaxLength(3);

      addHomonnyuyokukaigoDiscountRate();
    }
    return homonnyuyokukaigoDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004002Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getHomonnyuyokukaigoGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonnyuyokukaigoGroup(){

    homonnyuyokukaigoGroup.add(getHomonnyuyokukaigoDiscountContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonnyuyokukaigoDiscountContena(){

    homonnyuyokukaigoDiscountContena.add(getHomonnyuyokukaigoDiscountRate(), VRLayout.FLOW);

    homonnyuyokukaigoDiscountContena.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonnyuyokukaigoDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.getInstance().getContentPane().add(new QO004002Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004002Design getThis() {
    return this;
  }
}
