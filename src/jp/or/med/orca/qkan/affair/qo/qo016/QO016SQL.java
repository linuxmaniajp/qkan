
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
 * �J����: �������ƃT�[�r�X�R�[�h�Ǘ�
 * �쐬��: 2016/09/14  ���{�R���s���[�^�[������� �������ƃT�[�r�X�R�[�h�Ǘ� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X �������ƃT�[�r�X�R�[�h�Ǘ� (016)
 * �v���O���� �������ƃT�[�r�X�R�[�h���ꗗ (QO016)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo016;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.io.*;
import java.sql.SQLException;
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

/**
 * �������ƃT�[�r�X�R�[�h���ꗗSQL��`(QO016) 
 */
public class QO016SQL extends QO016State {
  private ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO016SQL() {
  }

  /**
   * �uTABLE�ɓo�^����Ă��鑍�����ƃT�[�r�X�R�[�h�����擾����B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_M_SJ_SERVICE_CODE_INFO(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(",SERVICE_CODE_KIND");

    sb.append(",SERVICE_CODE_ITEM");

    sb.append(",TEKIYO_ST_DATE");

    sb.append(",TEKIYO_ED_DATE");

    sb.append(",SERVICE_NAME");

    sb.append(",SERVICE_UNIT");

    sb.append(",SAKUSEI_DATE");

    sb.append(",LAST_TIME");

    sb.append(" FROM");

    sb.append(" M_SJ_SERVICE_CODE");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" INSURER_ID");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("INSURER_ID", sqlParam)));

    sb.append(")");

    if (!ACTextUtilities.isNullText(VRBindPathParser.get("TARGET_DATE", sqlParam))) {
        sb.append("AND");

        sb.append("(");

        sb.append("     (TEKIYO_ST_DATE<=" + dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd") + ")");

        sb.append(" AND (TEKIYO_ED_DATE>=" + dateFormat.format(VRBindPathParser.get("TARGET_DATE", sqlParam), "yyyy-MM-dd") + ")");

        sb.append(")");
    }

    if (!ACTextUtilities.isNullText(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam))) {
        sb.append("AND");

        sb.append("(");

        sb.append(" SERVICE_CODE_KIND");

        sb.append(" =");

        sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SERVICE_CODE_KIND", sqlParam)));

        sb.append(")");
    }

    
    sb.append("AND");

    sb.append("(");

    sb.append(" DELETE_FLG");

    sb.append(" =");

    sb.append(" 0");

    sb.append(")");

    sb.append(" ORDER BY");

    sb.append(" TEKIYO_ST_DATE");

    sb.append(" DESC");

    sb.append(",SERVICE_CODE_KIND");

    sb.append(" ASC");

    sb.append(",SERVICE_CODE_ITEM");

    sb.append(" ASC");

    return sb.toString();
  }

  /**
   * �u�������ƃT�[�r�X�R�[�h�����폜��Ԃɂ���B�v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_UPDATE_TO_DELETE_M_SJ_SERVICE_CODE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("UPDATE");

    sb.append(" M_SJ_SERVICE_CODE");

    sb.append(" SET");

    sb.append(" DELETE_FLG");

    sb.append(" =");

    sb.append(" 1");

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SYSTEM_SERVICE_CODE_ITEM");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" TEKIYO_ST_DATE");

    sb.append(" =");

    sb.append(dateFormat.format(VRBindPathParser.get("TEKIYO_ST_DATE", sqlParam), "yyyy-MM-dd"));

    sb.append(")");

    return sb.toString();
  }

  /**
   * �u�������ƃT�[�r�X�R�[�h���g�p����Ă��邩�`�F�b�N����v�̂��߂�SQL��Ԃ��܂��B
   * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
   * @throws Exception ������O
   * @return SQL��
   */
  public String getSQL_GET_M_SJ_SERVICE_CODE_INFO_IN_USE(VRMap sqlParam) throws Exception{
    StringBuilder sb = new StringBuilder();
    Object[] inValues;
    Stack conditionStack = new Stack(), conditionStackOfFrom = new Stack();
    boolean firstCondition = true, firstConditionOfFrom = true;
    Object obj;

    sb.append("SELECT");

    sb.append(" COUNT(*) AS CNT");

    sb.append(" FROM");

    sb.append(" SERVICE_DETAIL_TEXT_");

    sb.append(ACCastUtilities.toString(sqlParam.get("YEAR")));

    sb.append(" WHERE");

    sb.append("(");

    sb.append(" SYSTEM_BIND_PATH");

    sb.append(" BETWEEN ");

    sb.append(ACCastUtilities.toString(sqlParam.get("SJ_SERVICE_CODE_BIND_PATH_ST")));

    sb.append(" AND ");

    sb.append(ACCastUtilities.toString(sqlParam.get("SJ_SERVICE_CODE_BIND_PATH_ED")));
    
    sb.append(")");

    sb.append("AND");

    sb.append("(");

    sb.append(" DETAIL_VALUE");

    sb.append(" =");

    sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", sqlParam)));

    sb.append(")");

    return sb.toString();
  }

}
