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
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���C�����j���[ (002)
 * �v���O���� ���C�����j���[ (QM002)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qm.qm002;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTree;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTreeNode;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.calculation.QP001;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qo.qo008.QO008;
import jp.or.med.orca.qkan.affair.qv.qv001.QV001;

/**
 * ���C�����j���[(QM002)
 */
public class QM002 extends QM002Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QM002() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * �������������s�Ȃ��܂��B
     * 
     * @param affair
     *            �Ɩ����
     * @throws Exception
     *             ������O
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // �����g�̑J�ڃp�����[�^���`�F�b�N���A�����W�J���̏������s��
        // ������
        // ���g�̑J�ڃp�����[�^�i�[�p�̃��R�[�h params �𐶐�����B
        VRMap params = new VRHashMap();
        // params �Ɏ��g�̑J�ڃp�����[�^��ݒ肷��B
        params = affair.getParameters();

        getMenuTree().setTransfer(this);
        // TODO ���j���[�̗L�����ڂ𐧌�����ꍇ�A�R�����g�A�E�g���O��
        // getMenuList().setFactoryAssistant(this);

        // 2008/01/07 [Masahiko Higuchi] add - begin �o�[�W�����A�b�v���m�点�@�\
        QM002HtmlPageReader reader = new QM002HtmlPageReader();
        // �ʃX���b�h�œǍ��݊J�n
        reader.start(getEditor());
        // 2008/01/07 [Masahiko Higuchi] add - end

        // �����j���[�̓W�J
        // �V�X�e���́u���j���[�c���[�v���擾����B
        if (QkanSystemInformation.getInstance().getMenuTree() != null) {
            // �f�[�^���擾�ł����ꍇ (null�łȂ��ꍇ)
            // ��ʂ́u���j���[�c���[(menuTree)�v�ɁA�擾�����u���j���[�c���[�v�f�[�^��ݒ肷��B(���j���[���\������B)
            getMenuTree().setModel(
                    QkanSystemInformation.getInstance().getMenuTree());
            // �c���[�̃��[�h��ݒ�
            getMenuTree().setTreeMode(
                    ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY);
            // �ڍו\���p�l����ݒ�
            getMenuTree().setNodeViewer(getMenuList());
            // ���[�g��I����Ԃɐݒ�
            getMenuTree().setSelectionRow(0);

        } else {
            // �擾�ł��Ȃ������ꍇ (null�̏ꍇ)
            // ���O�C�����Ə��́u���j���[�c���[�v�f�[�^�擾�p��SQL�����擾����B
            // �擾����SQL���𔭍s����B
            VRMap loginProviderMap = new VRHashMap();

            loginProviderMap.setData("LOGIN_PROVIDER_ID", QkanSystemInformation
                    .getInstance().getLoginProviderID());

            VRList menuTreeList = null;
            menuTreeList = getDBManager().executeQuery(getSQL_GET_MENU_TREE(loginProviderMap));
            // ��Ìn��\���Ή� fujihara.shin 2009.1.15 edit end

            // �擾������0����葽���ꍇ
            if (menuTreeList.size() > 0) {
                // �擾�����f�[�^���A��ʂ́u���j���[�c���[(menuTree)�v�i�[�p�ɕϊ�����B

                // ��ʂ́u���j���[�c���[(menuTree)�v�ɁA�擾�����u���j���[�c���[�v�f�[�^��ݒ肷��B(���j���[���\������B)
                getMenuTree().setModel(menuTreeList);
                // �c���[�̃��[�h��ݒ�
                getMenuTree().setTreeMode(
                        ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY);
                // �V�X�e���́u���j���[�c���[�v�ɁA�擾�����u���j���[�c���[�v�f�[�^��ݒ肷��B
                // setMenuTree((�擾�������j���[���));
                QkanSystemInformation.getInstance().setMenuTree(menuTreeList);

                getMenuTree().setNodeViewer(getMenuList());
                // ���[�g��I����Ԃ�
                getMenuTree().setSelectionRow(0);
            } else {
                // �\�����ʃf�[�^�p�̃g���b�v
                // �擾������0���ł���ꍇ
                VRList list = getDBManager().executeQuery(
                        getSQL_GET_M_MENU(null));

                // ��ʂ́u���j���[�c���[(menuTree)�v�ɁA�擾�����u���j���[�c���[�v�f�[�^��ݒ肷��B(���j���[���\������B)
                if (list != null) {
                    getMenuTree().setModel(list);
                } else {
                    getMenuTree().setModel(new ArrayList());
                }
                // �c���[�̃��[�h��ݒ�
                getMenuTree().setTreeMode(
                        ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY);

                getMenuTree().setNodeViewer(getMenuList());
                // ���[�g��I����Ԃ�
                getMenuTree().setSelectionRow(0);

            }
            // �������Ȃ��B
        }

        // ���E�B���h�E�^�C�g���E�Ɩ��{�^���o�[�̐ݒ�
        // �Ɩ���񃌃R�[�h���擾����B
        // �E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
        // �Ɩ��{�^���o�[�̃e�L�X�g�ɁA�擾���R�[�h��KEY : AFFAIR_TITLE��VALUE��ݒ肷��B
        setAffairTitle("QM002");

        // �������̗L�����`�F�b�N
        if (VRBindPathParser.has("TREE_HISTORY", params)) {

            // �m�[�h����p�X����肵��ʂɓW�J
            TreePath path = null;
            TreePath selectPath = null;
            switch (getMenuTree().getTreeMode()) {
            case ACFilterableMainMenuTree.TREE_MODE_NODE_AND_SINGLE_LEAF:
                // TODO �l��
                break;

            case ACFilterableMainMenuTree.TREE_MODE_NODE_ONLY:
                // �c���[�őI������Ă���m�[�h�p�X���擾
                path = new TreePath(
                        ((DefaultMutableTreeNode) params
                                .getData("TREE_HISTORY")).getParent());
                selectPath = new TreePath(
                        (DefaultMutableTreeNode) params.getData("TREE_HISTORY"));
                break;

            case ACFilterableMainMenuTree.TREE_MODE_NODE_AND_ALL_LEAF:
                // TODO �S�Ẵm�[�h��\������ꍇ�̋����W�J�����i�m�[�h�p�X�͖��Ȃ��j
                getMenuTree().expandPath(path);
                break;
            default:
                // �c���[�őI������Ă���m�[�h�̐e�m�[�h�̃p�X���擾
                // TreeNode parent =
                // ((DefaultMutableTreeNode)params.getData("TREE_HISTORY")).getParent();
                // TreePath paths = new
                // TreePath(((DefaultMutableTreeNode)params.getData("TREE_HISTORY")));
                path = new TreePath(
                        ((DefaultMutableTreeNode) params
                                .getData("TREE_HISTORY")).getParent());

                break;
            }

            // ��ʑJ�ڑO�ɑI����Ԃ�����node��I������B
            getMenuTree().setSelectionPath(path);
            ACFrame.getInstance().removeNowAffairParameter("TREE_HISTORY");
        }

        ACAffairInfo nowAffair = ACFrame.getInstance().getNowAffair();
        if (nowAffair != null) {
            // ����N�������̓X�v���b�V����\�������邽�߁A�������g�̃X�v���b�V����؂�
            nowAffair.setSplashed(false);
        }

        // Mac�̏ꍇ�̓c���[�̍����𒼐ڎw�肷��
        final String osName = String.valueOf(System.getProperty("os.name"))
                .toLowerCase();
        if (osName.indexOf("mac") >= 0) {
            getMenuTree().setRowHeight(0);
            // getMenuTree().setRowHeight(48);
        }

        if (!getEditor().isVisible()) {
            getMenuTree().setPreferredSize(null);
        }

        getContents().revalidate();
        getContents().repaint();
        getContents().paintImmediately(getContents().getX(),
                getContents().getY(), getContents().getWidth(),
                getContents().getHeight());

    }

    /**
     * �u���O�A�E�g�v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void logoutActionPerformed(ActionEvent e) throws Exception {
        // �V�X�e���́A���O�C�����Ə����j���[�����N���A����B
        QkanSystemInformation.getInstance().setMenuTree(null);

        ACAffairInfo info = ACFrame.getInstance().getBackAffair();
        if (info != null) {
            VRMap param = ACFrame.getInstance().getBackAffair().getParameters();
            if (param == null) {
                param = new VRHashMap();
                ACFrame.getInstance().getBackAffair().setParameters(param);
            }
            param.setData("STOP_AUTO_LOGIN", Boolean.TRUE);
        }

        ACFrame.getInstance().back();
    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QM002.class.getName(), param));
    }

    // �����֐�

    /**      
     * 
     */
    public void goAffair(TreeNode node) throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        String nextAffair = "";
        String affairDistinctionItem = "";

        if (((DefaultMutableTreeNode) node).getUserObject() instanceof VRMap) {

            VRMap userObjectMap = (VRMap) ((DefaultMutableTreeNode) node)
                    .getUserObject();
            // �m�[�h����Ղɑޔ�
            ACFrame.getInstance().addNowAffairParameter("TREE_HISTORY", node);

            // �Ɩ��J�ڗp�̃p�����[�^�[���i�[����ϐ�
            VRMap transferParameter = new VRHashMap();

            // ����ʂ̃N���X���擾����B
            if (VRBindPathParser.has("NEXT_CLASS", userObjectMap)) {

                if (userObjectMap.getData("NEXT_CLASS") == null) {
                    ACMessageBox.show("�@�\�����ł̂��߁A�I�����ꂽ�Ɩ��͎��s�ł��܂���B",
                            ACMessageBox.BUTTON_OK, ACMessageBox.ICON_STOP,
                            ACMessageBox.FOCUS_OK);
                    getMenuTree().setSelectionPath(
                            new TreePath((DefaultMutableTreeNode) node
                                    .getParent()));
                    return;
                }

                nextAffair = String
                        .valueOf(userObjectMap.getData("NEXT_CLASS"));

            } else {
                System.out.println("�t�B�[���h�����݂��܂���ł����B");
                return;

            }

            // �J�ڃp�����[�^�[���擾
            if (VRBindPathParser.has("PARAMETER_VALUE", userObjectMap)) {
                affairDistinctionItem = String.valueOf(userObjectMap
                        .getData("PARAMETER_VALUE"));

            } else {
                System.out.println("�J�ڐ�p�����[�^�[�̎擾�ł��܂���ł����B");

            }

            // ����ʂɑJ�ڂ��邽�߂̏����i�[����B
            transferParameter.setData("NEXT_AFFAIR", affairDistinctionItem);

            ACAffairInfo affair = null;
            affair = new ACAffairInfo(nextAffair, transferParameter);
            ACFrame.getInstance().next(affair);
        }
    }

    /**
     * �u�o�[�W�������v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void showVersionActionPerformed(ActionEvent e) throws Exception {
        new QV001().setVisible(true);
    }

    public void assistCreateMainMenuPanel(ACMainMenuTreeNodePanel panel,
            ACFilterableMainMenuTree tree, ACFilterableMainMenuTreeNode child,
            Object parameter) throws Exception {
        if (parameter instanceof VRMap) {
            VRMap childMap = (VRMap) parameter;
            // ����ʂ̃N���X����ݒ�
            // �����n�̋Ɩ��ł���ꍇ�̓{�^���𐧌䂵����s�\�ɂ���
            String next = String.valueOf(VRBindPathParser.get("NEXT_CLASS",
                    childMap));
            if (QP001.class.getName().equals(next)
                    || QO008.class.getName().equals(next)) {
                panel.setFollowChildEnabled(true);
                panel.setEnabled(false);
            }
        }
    }

}
