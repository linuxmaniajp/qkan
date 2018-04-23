
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
 * �쐬��: 2012/01/31  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�����p��ݗ^ (QS001_16711_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[�����\�h�����p��ݗ^��ʍ��ڃf�U�C��(QS001_16711_201804) 
 */
public class QS001_16711_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel welfareToolPatterns;

  private ACPanel welfareToolDetails;

  private ACComboBox welfareTools;

  private ACLabelContainer welfareToolsContainer;

  private ACComboBoxModelAdapter welfareToolsModel;

  private ACTextField welfarePoint;

  private ACLabelContainer welfarePointContainer;

  private ACTextField welfareTekiyo;

  private ACLabelContainer welfareTekiyoContainer;

  private ACTextField welfareTokuchiPoint;

  private ACLabelContainer welfareTokuchiPointContainer;

  private ACTextField providerAddMountainousAreaScalePoint;

  private ACLabelContainer providerAddMountainousAreaScalePointContainer;

  private ACTextField providerAddMountainousAreaRafioPoint;

  private ACLabelContainer providerAddMountainousAreaRafioPointContainer;

  //getter

  /**
   * �����p��p�^�[���̈���擾���܂��B
   * @return �����p��p�^�[���̈�
   */
  public ACPanel getWelfareToolPatterns(){
    if(welfareToolPatterns==null){

      welfareToolPatterns = new ACPanel();

      welfareToolPatterns.setFollowChildEnabled(true);

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

      welfareToolDetails.setFollowChildEnabled(true);

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
   * ���R�Ԓn�擙���K�͎��Ə����Z���擾���܂��B
   * @return ���R�Ԓn�擙���K�͎��Ə����Z
   */
  public ACTextField getProviderAddMountainousAreaScalePoint(){
    if(providerAddMountainousAreaScalePoint==null){

      providerAddMountainousAreaScalePoint = new ACTextField();

      getProviderAddMountainousAreaScalePointContainer().setText("���R�Ԓn�擙���K�͎��Ə����Z");

      providerAddMountainousAreaScalePoint.setBindPath("1670104");

      providerAddMountainousAreaScalePoint.setColumns(4);

      providerAddMountainousAreaScalePoint.setCharType(VRCharType.ONLY_DIGIT);

      providerAddMountainousAreaScalePoint.setHorizontalAlignment(SwingConstants.RIGHT);

      providerAddMountainousAreaScalePoint.setIMEMode(InputSubset.LATIN);

      providerAddMountainousAreaScalePoint.setMaxLength(6);

      addProviderAddMountainousAreaScalePoint();
    }
    return providerAddMountainousAreaScalePoint;

  }

  /**
   * ���R�Ԓn�擙���K�͎��Ə����Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙���K�͎��Ə����Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaScalePointContainer(){
    if(providerAddMountainousAreaScalePointContainer==null){
      providerAddMountainousAreaScalePointContainer = new ACLabelContainer();
      providerAddMountainousAreaScalePointContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaScalePointContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaScalePointContainer.add(getProviderAddMountainousAreaScalePoint(), null);
    }
    return providerAddMountainousAreaScalePointContainer;
  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
   */
  public ACTextField getProviderAddMountainousAreaRafioPoint(){
    if(providerAddMountainousAreaRafioPoint==null){

      providerAddMountainousAreaRafioPoint = new ACTextField();

      getProviderAddMountainousAreaRafioPointContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z");

      providerAddMountainousAreaRafioPoint.setBindPath("1670105");

      providerAddMountainousAreaRafioPoint.setColumns(4);

      providerAddMountainousAreaRafioPoint.setCharType(VRCharType.ONLY_DIGIT);

      providerAddMountainousAreaRafioPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      providerAddMountainousAreaRafioPoint.setIMEMode(InputSubset.LATIN);

      providerAddMountainousAreaRafioPoint.setMaxLength(6);

      addProviderAddMountainousAreaRafioPoint();
    }
    return providerAddMountainousAreaRafioPoint;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaRafioPointContainer(){
    if(providerAddMountainousAreaRafioPointContainer==null){
      providerAddMountainousAreaRafioPointContainer = new ACLabelContainer();
      providerAddMountainousAreaRafioPointContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRafioPointContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRafioPointContainer.add(getProviderAddMountainousAreaRafioPoint(), null);
    }
    return providerAddMountainousAreaRafioPointContainer;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_16711_201804Design() {

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

    welfareToolDetails.add(getWelfarePointContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    welfareToolDetails.add(getWelfareTekiyoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    welfareToolDetails.add(getWelfareTokuchiPointContainer(), VRLayout.FLOW_RETURN);

    welfareToolDetails.add(getProviderAddMountainousAreaScalePointContainer(), VRLayout.FLOW_RETURN);

    welfareToolDetails.add(getProviderAddMountainousAreaRafioPointContainer(), VRLayout.FLOW_RETURN);

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
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareTekiyo(){

  }

  /**
   * ���n���Z�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWelfareTokuchiPoint(){

  }

  /**
   * ���R�Ԓn�擙���K�͎��Ə����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaScalePoint(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioPoint(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_16711_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_16711_201804Design getThis() {
    return this;
  }
}
