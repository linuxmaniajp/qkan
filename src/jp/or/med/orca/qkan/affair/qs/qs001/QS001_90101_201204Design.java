
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
 * �쐬��: 2011/11/16  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����̑����e�ڍ� (QS001_90101_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[�����̑����e�ڍ׉�ʍ��ڃf�U�C��(QS001_90101_201204) 
 */
@SuppressWarnings("serial")
public class QS001_90101_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel dailyLifeActivityPatterns;

  private ACPanel dailyLifeActivityDetail;

  private ACBackLabelContainer dailyLifeActivityTimeContena;

  private ACTimeComboBox dailyLifeActivityBeginTime;

  private ACLabelContainer dailyLifeActivityBeginTimeContainer;

  private ACComboBoxModelAdapter dailyLifeActivityBeginTimeModel;

  private ACTimeComboBox dailyLifeActivityTimeContenaEndTime;

  private ACLabelContainer dailyLifeActivityTimeContenaEndTimeContainer;

  private ACComboBoxModelAdapter dailyLifeActivityTimeContenaEndTimeModel;

  private QS001OtherItemListBox dailyLifeActivitList;

  private ACLabelContainer dailyLifeActivitListContainer;

  private ACListModelAdapter dailyLifeActivitListModel;

  private ACTextField dailyLifeActivitySelect;

  private ACLabelContainer dailyLifeActivitySelectContainer;

  private ACButton dailyLifeActivitInsertButton;

  private ACButton dailyLifeActivitFindButton;

  private ACButton dailyLifeActivitDeleteButton;

  //getter

  /**
   * ��ȓ��퐶����̊����p�^�[���̈���擾���܂��B
   * @return ��ȓ��퐶����̊����p�^�[���̈�
   */
  public ACPanel getDailyLifeActivityPatterns(){
    if(dailyLifeActivityPatterns==null){

      dailyLifeActivityPatterns = new ACPanel();

      dailyLifeActivityPatterns.setAutoWrap(false);

      addDailyLifeActivityPatterns();
    }
    return dailyLifeActivityPatterns;

  }

  /**
   * ���e�p�l�����擾���܂��B
   * @return ���e�p�l��
   */
  public ACPanel getDailyLifeActivityDetail(){
    if(dailyLifeActivityDetail==null){

      dailyLifeActivityDetail = new ACPanel();

      dailyLifeActivityDetail.setHgrid(200);

      addDailyLifeActivityDetail();
    }
    return dailyLifeActivityDetail;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getDailyLifeActivityTimeContena(){
    if(dailyLifeActivityTimeContena==null){

      dailyLifeActivityTimeContena = new ACBackLabelContainer();

      addDailyLifeActivityTimeContena();
    }
    return dailyLifeActivityTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getDailyLifeActivityBeginTime(){
    if(dailyLifeActivityBeginTime==null){

      dailyLifeActivityBeginTime = new ACTimeComboBox();

      getDailyLifeActivityBeginTimeContainer().setText("�J�n����");

      dailyLifeActivityBeginTime.setBindPath("3");

      dailyLifeActivityBeginTime.setModelBindPath("3");

      dailyLifeActivityBeginTime.setRenderBindPath("CONTENT");

      dailyLifeActivityBeginTime.setModel(getDailyLifeActivityBeginTimeModel());

      addDailyLifeActivityBeginTime();
    }
    return dailyLifeActivityBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getDailyLifeActivityBeginTimeContainer(){
    if(dailyLifeActivityBeginTimeContainer==null){
      dailyLifeActivityBeginTimeContainer = new ACLabelContainer();
      dailyLifeActivityBeginTimeContainer.setFollowChildEnabled(true);
      dailyLifeActivityBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivityBeginTimeContainer.add(getDailyLifeActivityBeginTime(), null);
    }
    return dailyLifeActivityBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getDailyLifeActivityBeginTimeModel(){
    if(dailyLifeActivityBeginTimeModel==null){
      dailyLifeActivityBeginTimeModel = new ACComboBoxModelAdapter();
      addDailyLifeActivityBeginTimeModel();
    }
    return dailyLifeActivityBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getDailyLifeActivityTimeContenaEndTime(){
    if(dailyLifeActivityTimeContenaEndTime==null){

      dailyLifeActivityTimeContenaEndTime = new ACTimeComboBox();

      getDailyLifeActivityTimeContenaEndTimeContainer().setText("�I������");

      dailyLifeActivityTimeContenaEndTime.setBindPath("4");

      dailyLifeActivityTimeContenaEndTime.setModelBindPath("4");

      dailyLifeActivityTimeContenaEndTime.setRenderBindPath("CONTENT");

      dailyLifeActivityTimeContenaEndTime.setModel(getDailyLifeActivityTimeContenaEndTimeModel());

      addDailyLifeActivityTimeContenaEndTime();
    }
    return dailyLifeActivityTimeContenaEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getDailyLifeActivityTimeContenaEndTimeContainer(){
    if(dailyLifeActivityTimeContenaEndTimeContainer==null){
      dailyLifeActivityTimeContenaEndTimeContainer = new ACLabelContainer();
      dailyLifeActivityTimeContenaEndTimeContainer.setFollowChildEnabled(true);
      dailyLifeActivityTimeContenaEndTimeContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivityTimeContenaEndTimeContainer.add(getDailyLifeActivityTimeContenaEndTime(), null);
    }
    return dailyLifeActivityTimeContenaEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getDailyLifeActivityTimeContenaEndTimeModel(){
    if(dailyLifeActivityTimeContenaEndTimeModel==null){
      dailyLifeActivityTimeContenaEndTimeModel = new ACComboBoxModelAdapter();
      addDailyLifeActivityTimeContenaEndTimeModel();
    }
    return dailyLifeActivityTimeContenaEndTimeModel;
  }

  /**
   * ��ȓ��퐶�����X�g���擾���܂��B
   * @return ��ȓ��퐶�����X�g
   */
  public QS001OtherItemListBox getDailyLifeActivitList(){
    if(dailyLifeActivitList==null){

      dailyLifeActivitList = new QS001OtherItemListBox();

      getDailyLifeActivitListContainer().setText("���͌��");

      dailyLifeActivitList.setBindPath("dummy");

      dailyLifeActivitList.setColumns(12);

      dailyLifeActivitList.setModel(getDailyLifeActivitListModel());

      dailyLifeActivitList.setVisibleRowCount(11);

      addDailyLifeActivitList();
    }
    return dailyLifeActivitList;

  }

  /**
   * ��ȓ��퐶�����X�g�R���e�i���擾���܂��B
   * @return ��ȓ��퐶�����X�g�R���e�i
   */
  protected ACLabelContainer getDailyLifeActivitListContainer(){
    if(dailyLifeActivitListContainer==null){
      dailyLifeActivitListContainer = new ACLabelContainer();
      dailyLifeActivitListContainer.setFollowChildEnabled(true);
      dailyLifeActivitListContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivitListContainer.add(getDailyLifeActivitList(), null);
    }
    return dailyLifeActivitListContainer;
  }

  /**
   * ��ȓ��퐶�����X�g���f�����擾���܂��B
   * @return ��ȓ��퐶�����X�g���f��
   */
  protected ACListModelAdapter getDailyLifeActivitListModel(){
    if(dailyLifeActivitListModel==null){
      dailyLifeActivitListModel = new ACListModelAdapter();
      addDailyLifeActivitListModel();
    }
    return dailyLifeActivitListModel;
  }

  /**
   * ���e�ڍ׃e�L�X�g���擾���܂��B
   * @return ���e�ڍ׃e�L�X�g
   */
  public ACTextField getDailyLifeActivitySelect(){
    if(dailyLifeActivitySelect==null){

      dailyLifeActivitySelect = new ACTextField();

      getDailyLifeActivitySelectContainer().setText("���e�ڍ�");

      dailyLifeActivitySelect.setBindPath("9010101");

      dailyLifeActivitySelect.setColumns(11);

      dailyLifeActivitySelect.setIMEMode(InputSubset.KANJI);

      dailyLifeActivitySelect.setMaxLength(10);

      addDailyLifeActivitySelect();
    }
    return dailyLifeActivitySelect;

  }

  /**
   * ���e�ڍ׃e�L�X�g�R���e�i���擾���܂��B
   * @return ���e�ڍ׃e�L�X�g�R���e�i
   */
  protected ACLabelContainer getDailyLifeActivitySelectContainer(){
    if(dailyLifeActivitySelectContainer==null){
      dailyLifeActivitySelectContainer = new ACLabelContainer();
      dailyLifeActivitySelectContainer.setFollowChildEnabled(true);
      dailyLifeActivitySelectContainer.setVAlignment(VRLayout.CENTER);
      dailyLifeActivitySelectContainer.add(getDailyLifeActivitySelect(), null);
    }
    return dailyLifeActivitySelectContainer;
  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getDailyLifeActivitInsertButton(){
    if(dailyLifeActivitInsertButton==null){

      dailyLifeActivitInsertButton = new ACButton();

      dailyLifeActivitInsertButton.setText("�ǉ�");

      addDailyLifeActivitInsertButton();
    }
    return dailyLifeActivitInsertButton;

  }

  /**
   * �ҏW���擾���܂��B
   * @return �ҏW
   */
  public ACButton getDailyLifeActivitFindButton(){
    if(dailyLifeActivitFindButton==null){

      dailyLifeActivitFindButton = new ACButton();

      dailyLifeActivitFindButton.setText("�ҏW");

      addDailyLifeActivitFindButton();
    }
    return dailyLifeActivitFindButton;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getDailyLifeActivitDeleteButton(){
    if(dailyLifeActivitDeleteButton==null){

      dailyLifeActivitDeleteButton = new ACButton();

      dailyLifeActivitDeleteButton.setText("�폜");

      addDailyLifeActivitDeleteButton();
    }
    return dailyLifeActivitDeleteButton;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_90101_201204Design() {

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

    this.add(getDailyLifeActivityPatterns(), VRLayout.WEST);

  }

  /**
   * ��ȓ��퐶����̊����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityPatterns(){

    dailyLifeActivityPatterns.add(getDailyLifeActivityDetail(), VRLayout.NORTH);

  }

  /**
   * ���e�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityDetail(){

    dailyLifeActivityDetail.add(getDailyLifeActivityTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    dailyLifeActivityDetail.add(getDailyLifeActivitListContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dailyLifeActivityDetail.add(getDailyLifeActivitySelectContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    dailyLifeActivityDetail.add(getDailyLifeActivitInsertButton(), VRLayout.FLOW);

    dailyLifeActivityDetail.add(getDailyLifeActivitFindButton(), VRLayout.FLOW);

    dailyLifeActivityDetail.add(getDailyLifeActivitDeleteButton(), VRLayout.FLOW);

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityTimeContena(){

    dailyLifeActivityTimeContena.add(getDailyLifeActivityBeginTimeContainer(), VRLayout.FLOW);

    dailyLifeActivityTimeContena.add(getDailyLifeActivityTimeContenaEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityTimeContenaEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivityTimeContenaEndTimeModel(){

  }

  /**
   * ��ȓ��퐶�����X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivitList(){

  }

  /**
   * ��ȓ��퐶�����X�g���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivitListModel(){

  }

  /**
   * ���e�ڍ׃e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivitySelect(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivitInsertButton(){

  }

  /**
   * �ҏW�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivitFindButton(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDailyLifeActivitDeleteButton(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_90101_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_90101_201204Design getThis() {
    return this;
  }
}
