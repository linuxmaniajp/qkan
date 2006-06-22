
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
 * �J����: �� ����
 * �쐬��: 2005/12/15  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�[�ʕ\ (003)
 * �v���O���� ���p�[�ʕ\ (QS00302)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs003;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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

/**
 * ���p�[�ʕ\�C�x���g��`(QS00302) 
 * ���[��`�̃t�@�C���� �F QS00302.xml
 */
public abstract class QS003P02Event  {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS003P02Event(){
  }
  /**
   * ������܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //�ϐ���`

  private VRList printList = new VRArrayList();
  private VRMap footerMap = new VRHashMap();
  //getter/setter

  /**
   * printList��Ԃ��܂��B
   * @return printList
   */
  protected VRList getPrintList(){
    return printList;
  }
  /**
   * printList��ݒ肵�܂��B
   * @param printList printList
   */
  protected void setPrintList(VRList printList){
    this.printList = printList;
  }

  /**
   * footerMap��Ԃ��܂��B
   * @return footerMap
   */
  protected VRMap getFooterMap(){
    return footerMap;
  }
  /**
   * footerMap��ݒ肵�܂��B
   * @param footerMap footerMap
   */
  protected void setFooterMap(VRMap footerMap){
    this.footerMap = footerMap;
  }

  //�����֐�

  /**
   * �u�\���f�[�^�W�v�֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param serviceData VRList
   * @param printList VRList
   * @param footerMap VRMap
   * @throws Exception ������O
   * @return VRList
   */
  public abstract VRList tabulation(VRList serviceData, VRList printList, VRMap footerMap) throws Exception;

  /**
   * �u���R�[�h�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param rec VRMap
   * @throws Exception ������O
   *
   */
  public abstract void initializeRecord(VRMap rec) throws Exception;

  /**
   * �u���v�����l�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param subTotal VRMap
   * @param recNow VRMap
   * @param masterService VRList
   * @throws Exception ������O
   *
   */
  public abstract void setInitValueToSubTotal(VRMap subTotal, VRMap recNow, VRList masterService) throws Exception;

  /**
   * �u���v���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param subTotal VRMap
   * @param recNow VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addRecordValueToSubTotal(VRMap subTotal, VRMap recNow) throws Exception;

  /**
   * �u�t�b�^�[���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param footerMap VRMap
   * @param rec VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addRecordValueToFooter(VRMap footerMap, VRMap rec) throws Exception;

  /**
   * �u�t�b�^�[���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param footerMap VRMap
   * @param list VRList
   * @throws Exception ������O
   *
   */
  public abstract void addExcludeValueToFooter(VRMap footerMap, VRList list) throws Exception;

  /**
   * �u���v���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printList VRList
   * @param footerMap VRMap
   * @param subTotal VRMap
   * @param recNow VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addSubTotalToPrintList(VRList printList, VRMap footerMap, VRMap subTotal, VRMap recNow) throws Exception;

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addRecordToPrintListPatternA(VRList printList, VRMap rec) throws Exception;

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addRecordToPrintListPatternB(VRList printList, VRMap rec) throws Exception;

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addRecordToPrintListPatternC(VRList printList, VRMap rec) throws Exception;

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printList VRList
   * @param rec VRMap
   * @throws Exception ������O
   *
   */
  public abstract void addRecordToPrintListPatternD(VRList printList, VRMap rec) throws Exception;

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param printList VRList
   * @param recList VRList
   * @throws Exception ������O
   *
   */
  public abstract void addRecordToPrintListPatternE(VRList printList, VRList recList) throws Exception;

  /**
   * �u�T�[�r�X��ޖ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param masterService VRList
   * @param kindCode String
   * @throws Exception ������O
   * @return String
   */
  public abstract String getServiceKindName(VRList masterService, String kindCode) throws Exception;

}
