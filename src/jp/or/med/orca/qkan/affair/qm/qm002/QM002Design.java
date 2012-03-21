
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
 * �쐬��: 2008/03/05  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���C�����j���[ (002)
 * �v���O���� ���C�����j���[ (QM002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm002;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACEditorPane;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTree;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanelFactory;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeRenderer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * ���C�����j���[��ʍ��ڃf�U�C��(QM002) 
 */
public class QM002Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel picts;

  private ACLabel pict;

  private ACPanel menus;

  private ACPanel menuMains;

  private ACFilterableMainMenuTree menuTree;

  private ACMainMenuTreeNodePanelFactory menuList;

  private ACGroupBox infomations;

  private ACLabel informationTitle;

  private ACLabel information;

  private ACPanel versionContents;

  private ACEditorPane editor;

  private ACPanel buttons;

  private ACButton showVersion;

  private ACButton logout;

  //getter

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
   * �摜�̈���擾���܂��B
   * @return �摜�̈�
   */
  public ACPanel getPicts(){
    if(picts==null){

      picts = new ACPanel();

      picts.setBackground(Color.blue);

      addPicts();
    }
    return picts;

  }

  /**
   * �^�C�g���摜���擾���܂��B
   * @return �^�C�g���摜
   */
  public ACLabel getPict(){
    if(pict==null){

      pict = new ACLabel();

      pict.setOpaque(true);
      pict.setBackground(Color.blue);

      addPict();
    }
    return pict;

  }

  /**
   * ���j���[�̈���擾���܂��B
   * @return ���j���[�̈�
   */
  public ACPanel getMenus(){
    if(menus==null){

      menus = new ACPanel();

      addMenus();
    }
    return menus;

  }

  /**
   * ���j���[���C���̈���擾���܂��B
   * @return ���j���[���C���̈�
   */
  public ACPanel getMenuMains(){
    if(menuMains==null){

      menuMains = new ACPanel();

      addMenuMains();
    }
    return menuMains;

  }

  /**
   * ���j���[�c���[���擾���܂��B
   * @return ���j���[�c���[
   */
  public ACFilterableMainMenuTree getMenuTree(){
    if(menuTree==null){

      menuTree = new ACFilterableMainMenuTree();

      menuTree.setPreferredSize(new Dimension(200,560));

      menuTree.setCellRenderer(new ACMainMenuTreeRenderer());

      addMenuTree();
    }
    return menuTree;

  }

  /**
   * ���j���[���X�g���擾���܂��B
   * @return ���j���[���X�g
   */
  public ACMainMenuTreeNodePanelFactory getMenuList(){
    if(menuList==null){

      menuList = new ACMainMenuTreeNodePanelFactory();

      addMenuList();
    }
    return menuList;

  }

  /**
   * �����̈���擾���܂��B
   * @return �����̈�
   */
  public ACGroupBox getInfomations(){
    if(infomations==null){

      infomations = new ACGroupBox();

      infomations.setText("����̎����");

      addInfomations();
    }
    return infomations;

  }

  /**
   * �����^�C�g�����擾���܂��B
   * @return �����^�C�g��
   */
  public ACLabel getInformationTitle(){
    if(informationTitle==null){

      informationTitle = new ACLabel();

      informationTitle.setText("���j���[��ʂ̎g����");

      informationTitle.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addInformationTitle();
    }
    return informationTitle;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACLabel getInformation(){
    if(information==null){

      information = new ACLabel();

      information.setText("(1)��ʍ����̃A�C�R����I������ƉE���ɏڍׂȃ��j���[���\������܂��B" + ACConstants.LINE_SEPARATOR + "(2)������́u�ی��ҁv�ƃT�[�r�X��񋟂���u���Ə��v�́A�u���̑��@�\�v����o�^���ĉ������B" + ACConstants.LINE_SEPARATOR + "(3)�T�[�r�X���󂯂闘�p�҂́u���p�ҊǗ��v����o�^���ĉ������B");

      information.setAutoWrap(true);

      addInformation();
    }
    return information;

  }

  /**
   * �o�[�W�����A�b�v�̈���擾���܂��B
   * @return �o�[�W�����A�b�v�̈�
   */
  public ACPanel getVersionContents(){
    if(versionContents==null){

      versionContents = new ACPanel();

      versionContents.setVisible(true);

      versionContents.setAutoWrap(false);

      addVersionContents();
    }
    return versionContents;

  }

  /**
   * �o�[�W�����A�b�v���m�点�̈���擾���܂��B
   * @return �o�[�W�����A�b�v���m�点�̈�
   */
  public ACEditorPane getEditor(){
    if(editor==null){

      editor = new ACEditorPane();

      editor.setVisible(true);

      editor.setEnabled(false);

      editor.setEditable(false);

      editor.setPreferredSize(new Dimension(0,180));

      addEditor();
    }
    return editor;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      buttons.setAutoWrap(false);

      addButtons();
    }
    return buttons;

  }

  /**
   * �o�[�W���������擾���܂��B
   * @return �o�[�W�������
   */
  public ACButton getShowVersion(){
    if(showVersion==null){

      showVersion = new ACButton();

      showVersion.setText("�o�[�W�������(V)");

      showVersion.setToolTipText("�o�[�W��������\�����܂��B");

      showVersion.setMnemonic('V');

      showVersion.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addShowVersion();
    }
    return showVersion;

  }

  /**
   * ���O�A�E�g���擾���܂��B
   * @return ���O�A�E�g
   */
  public ACButton getLogout(){
    if(logout==null){

      logout = new ACButton();

      logout.setText("���O�A�E�g(E)");

      logout.setToolTipText("���O�C����ʂɖ߂�܂��B");

      logout.setMnemonic('E');

      logout.setIconPath(ACConstants.ICON_PATH_BACK_16);

      addLogout();
    }
    return logout;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QM002Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getPicts(), VRLayout.WEST);

    contents.add(getMenus(), VRLayout.CLIENT);

    contents.add(getVersionContents(), VRLayout.SOUTH);
  }

  /**
   * �摜�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPicts(){

    picts.add(getPict(), VRLayout.NORTH);

  }

  /**
   * �^�C�g���摜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPict(){

  }

  /**
   * ���j���[�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMenus(){

    menus.add(getMenuMains(), VRLayout.CLIENT);

    menus.add(getInfomations(), VRLayout.SOUTH);
  }

  /**
   * ���j���[���C���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMenuMains(){

    menuMains.add(getMenuTree(), VRLayout.WEST);

    menuMains.add(getMenuList(), VRLayout.CLIENT);

  }

  /**
   * ���j���[�c���[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMenuTree(){

  }

  /**
   * ���j���[���X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMenuList(){

  }

  /**
   * �����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfomations(){

    infomations.add(getInformationTitle(), VRLayout.NORTH);

    infomations.add(getInformation(), VRLayout.CLIENT);

  }

  /**
   * �����^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInformationTitle(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInformation(){

  }

  /**
   * �o�[�W�����A�b�v�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVersionContents(){

    versionContents.add(getEditor(), VRLayout.CLIENT);

    versionContents.add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * �o�[�W�����A�b�v���m�点�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEditor(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getLogout(), VRLayout.EAST);
    buttons.add(getShowVersion(), VRLayout.EAST);
  }

  /**
   * �o�[�W�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addShowVersion(){

  }

  /**
   * ���O�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLogout(){

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

    return getMenuTree();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QM002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QM002Design getThis() {
    return this;
  }
}
